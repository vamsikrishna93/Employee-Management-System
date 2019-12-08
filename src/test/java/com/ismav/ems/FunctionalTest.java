package com.ismav.ems;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FunctionalTest {

    public FunctionalTest() throws JsonProcessingException {
    }

    String EMPLOYEE_ID;
    String jsonString = "{\"employeeFirstName\":\"Krishna\",\"employeeMiddleName\":null,\"employeeLastName\":\"p\",\"employeeCompany\":\"Cognizant\",\"employeeDesignation\":\"Manager Software Engineer\"}";
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonObject = mapper.readTree(jsonString);

    String jsonStringUpdate = "{\"employeeFirstName\":\"Minnie\",\"employeeMiddleName\":null,\"employeeLastName\":\"Varre\",\"employeeCompany\":\"Me\",\"employeeDesignation\":\"My puppy\"}";
    ObjectMapper mapperUpdate = new ObjectMapper();
    JsonNode jsonObjectUpdate = mapperUpdate.readTree(jsonStringUpdate);

    String jsonStringError = "{\"employeeFirstName\":\"Krishna\",\"employeeMiddleName\":null,\"employeeLastName\":null,\"employeeCompany\":\"Cognizant\",\"employeeDesignation\":\"Manager Software Engineer\"}";
    ObjectMapper mapperError = new ObjectMapper();
    JsonNode jsonObjectError = mapperError.readTree(jsonStringError);

    @Test
    public void d_retrieveEmployeeInfoTest() {
        Response response = RestAssured.get("http://localhost:8181/api/ems/employee");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void a_createEmployeeInfoBodyTest() {
        RequestSpecification request = RestAssured.given();
        request.body(jsonObject);
        request.header("Content-type", "application/json");
        Response response = request.post("http://localhost:8181/api/ems/employee");
        JsonPath body = response.jsonPath();
        EMPLOYEE_ID = body.get("employeeId").toString();
        Assert.assertEquals(response.getStatusCode(), 201);

    }

    @Test
    public void c_retrieveEmployeeById() {
        Response response = RestAssured.get("http://localhost:8181/api/ems/employee/"+EMPLOYEE_ID);
        JsonPath body = response.jsonPath();
        System.out.println(body.get("employeeId").toString());
        Assert.assertEquals(Integer.valueOf(body.get("employeeId").toString()), Integer.valueOf(EMPLOYEE_ID));
    }

    @Test
    public void createEmployeeInfoErrorTest() {
        RequestSpecification request = RestAssured.given();
        request.body(jsonObjectError);
        request.header("Content-type", "application/json");
        Response response = request.post("http://localhost:8181/api/ems/employee");
        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void b_updateEmployeeTest() {
        RequestSpecification request = RestAssured.given();
        request.body(jsonObjectUpdate);
        request.header("Content-type", "application/json");
        Response response = request.put("http://localhost:8181/api/ems/employee/"+EMPLOYEE_ID);
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void e_deleteEmployeeInfoTest() {
        Response response = RestAssured.delete("http://localhost:8181/api/ems/employee/" + EMPLOYEE_ID);
        String res = response.getBody().asString();
        Assert.assertEquals(res, "Record Deleted");
        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
