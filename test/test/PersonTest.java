/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import com.jayway.restassured.parsing.Parser;
import entity.Person;
import static org.hamcrest.Matchers.*;
import utils.JSONConverter;

/**
 *
 * @author Andreas
 */
public class PersonTest {
    
    public PersonTest() {
    }
    


    

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        baseURI = "http://localhost:8080/REST_JAX_RS_Person/";
        Parser defaultParser = Parser.JSON;
        basePath = "api/persons";
    }
    
 
}
