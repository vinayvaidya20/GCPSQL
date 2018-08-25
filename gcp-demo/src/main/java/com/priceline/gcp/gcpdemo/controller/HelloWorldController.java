package com.priceline.gcp.gcpdemo.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.priceline.gcp.gcpdemo.GcpDemoApplication;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public String getGreeting(@PathVariable String name) throws SQLException {
		String lastNAME= "";
	    try (Statement statement = GcpDemoApplication.getConnection().createStatement()) {
		      ResultSet resultSet = statement.executeQuery("select * from Persons");
		      while (resultSet.next()) {
		        System.out.println(resultSet.getInt(1));
		        lastNAME = resultSet.getString(2);
		        System.out.println(resultSet.getString(2));
		        System.out.println(resultSet.getString(3));
		      }
		    }
		return "Hello, "+name+" "+lastNAME;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getResult(){
	
		return "SUCCESS"+GcpDemoApplication.getConnection();
	}

}
