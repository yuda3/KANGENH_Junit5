package com.group.db;

import org.checkerframework.checker.units.qual.A;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountDaoTest {

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/books?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String SCHEMA = "books";

    private static IDatabaseTester dbTester;

    @BeforeAll
    public static void beforeAll() throws Exception {
        dbTester = new JdbcDatabaseTester(DRIVER_NAME, CONNECTION_URL, USER, PASSWORD,SCHEMA){
          public IDatabaseConnection getConnection() throws Exception {
              IDatabaseConnection con =super.getConnection();
              con.getConfig().setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
              return con;
          }
        };

        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/data/init.xml"));
        dbTester.setDataSet(dataSet);
        dbTester.setSetUpOperation(DatabaseOperation.REFRESH);
        dbTester.onSetup();
    }

    @AfterAll
    public static void after() throws Exception{
        dbTester.setTearDownOperation(DatabaseOperation.NONE);
        dbTester.onTearDown();
    }

    @Test
    @Order(1)
    public void searchTest(){
        AccountDao dao = new AccountDao();
        Account account = dao.search("1");
        assertNotNull(account);
        String expected = "pass1";
        String actual = account.getId();

        assertEquals(expected, actual);
    }
    @Test
    public void insertTest() throws Exception {
        Account account = new Account("3", "pass3");
        AccountDao dao = new AccountDao();
        dao.insert(account);

        IDataSet dataSet =dbTester.getConnection().createDataSet();
        ITable actualTable = dataSet.getTable("account");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/data/expected.xml"));
        ITable expectedTable = expectedDataSet.getTable("account");

        assertEquals(expectedTable.getRowCount(), actualTable.getRowCount());

    }
}