/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package struts2.test.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lenovo
 */
public class AdminTest {
    
    public AdminTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testRegisterUser() throws Exception {
System.out.println("registerUser");
String userName = "abh";
String password = "123";
String firstName = "abh";
String lastName = "mis";
String email = "abh";
String phoneNumber = "1234567890";
Admin instance = new Admin();
int expResult = 1;
int result = instance.registerUser(userName, password, firstName, lastName, email, phoneNumber);
assertEquals(expResult, result);
}
}
