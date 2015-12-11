package com.test.service.config;

import java.io.FileInputStream;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

public class OperacoesTestCaseDB extends DBTestCase{

	private static final String PROPERTY_NAME_DATABASE_DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private static final String PROPERTY_NAME_DATABASE_LOCAL_URL_MYSQL = "jdbc:mysql://localhost:3306/restaurantedb";
	private static final String PROPERTY_NAME_DATABASE_USERNAME_MYSQL = "root";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD_MYSQL = "sa";
	
	private FlatXmlDataSet banco;
	
	/**
	 * Cria a instancia do banco de dados na aplicacao test
	 * @param name
	 */
	public OperacoesTestCaseDB(String name) {
		super.setName(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, PROPERTY_NAME_DATABASE_DRIVER_MYSQL);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, PROPERTY_NAME_DATABASE_LOCAL_URL_MYSQL);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, PROPERTY_NAME_DATABASE_USERNAME_MYSQL);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, PROPERTY_NAME_DATABASE_PASSWORD_MYSQL);
	}
	
	/**
	 * Carrega os dados para o banco de dados
	 */
	@Override
	protected IDataSet getDataSet() throws Exception {
		banco = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/xml/dataset.xml"));
		return banco;
	}
	
	/**
	 * O que ira fazer antes de realizar os testes
	 */
	protected DatabaseOperation getSetUpOperation() throws Exception{
		return DatabaseOperation.REFRESH;
	}
	
	/**
	 * O que ira fazer apos realizar os testes
	 */
	protected DatabaseOperation getTearDownOperation() throws Exception{
		return DatabaseOperation.NONE;
	}
	
	/**
	 * Setando algumas configuracoes do banco de dados HSQLDB para evitar warning
	 */
	@Override
	protected void setUpDatabaseConfig(DatabaseConfig config){
		
		/*Configuracao para HSQLDB*/
		//config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
		
		/*Configuracao para MYSQL*/
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
	}
	
	/**
	 * Copia os dados do banco-dataset.xml e copia para o banco dataget.xml 
	 * @throws Exception
	 */
	public void testRegistrosBanco() throws Exception{
		IDataSet dadosSetBanco = getConnection().createDataSet();
		ITable dadosNoBanco = dadosSetBanco.getTable("restaurante");
		
		IDataSet dadosSetEsperado = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/dataget.xml"));
		ITable dadosGetEsperado = dadosSetEsperado.getTable("restaurante");
		
		Assertion.assertEquals(dadosGetEsperado,dadosNoBanco);
	}
	
	/**
	 * Realiza um teste para contar a quantiade de linhas registradas no banco
	 * @throws Exception
	 */
	public void testQtdeRegistroTabela() throws Exception{
		IDataSet dadosSetBanco = getConnection().createDataSet();
		int rowCount = dadosSetBanco.getTable("restaurante").getRowCount();
		assertEquals(5, rowCount);
	}
	
	/**
	 * Realiza um test de select para encontrar um nome a partir de um id
	 * @throws Exception
	 * @throws SQLException
	 * @throws Throwable
	 */
	public void testNomeEspecifico() throws Exception, SQLException, Throwable{
		ITable actualJoinData = getConnection().createQueryTable("s", "SELECT nome FROM restaurante WHERE id='2'");
		assertEquals("McDonald's",actualJoinData.getValue(0, "nome"));
	}

}
