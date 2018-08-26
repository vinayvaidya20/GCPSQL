package com.priceline.gcp.gcpdemo.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
		  String instanceConnectionName = "gcp-example-demo:us-central1:demo-sql-instance";

	    // TODO: fill this in
	    // The database from which to list tables.
	    String databaseName = "TestDatabase";

	    String username = "proxyuser";

	    // TODO: fill this in
	    // This is the password that was set via the Cloud Console or empty if never set
	    // (not recommended).
	    String password = "password";

	    if (instanceConnectionName.equals("<insert_connection_name>")) {
	      System.err.println("Please update the sample to specify the instance connection name.");
	      System.exit(1);
	    }

	    if (password.equals("<insert_password>")) {
	      System.err.println("Please update the sample to specify the mysql password.");
	      System.exit(1);
	    }

	    //[START doc-example]
	    
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TestDatabase";
		Connection connection1 = DriverManager.getConnection(jdbcUrl, username, password);
	   //[END doc-example]

	    try (Statement statement = connection1.createStatement()) {
	      ResultSet resultSet = statement.executeQuery("SHOW TABLES");
	      while (resultSet.next()) {
	        System.out.println(resultSet.getString(1));
	      }
	    }
	  
		
		
	    try (Statement statement = connection1.createStatement()) {
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
	public String getResult() throws SQLException {
	
		return "SUCCESS";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/con")
	public String getResult1() throws SQLException {
		String lastNAME= "";
		  String instanceConnectionName = "gcp-example-demo:us-central1:demo-sql-instance";

	    // TODO: fill this in
	    // The database from which to list tables.
	    String databaseName = "TestDatabase";

	    String username = "proxyuser";

	    // TODO: fill this in
	    // This is the password that was set via the Cloud Console or empty if never set
	    // (not recommended).
	    String password = "password";

	    if (instanceConnectionName.equals("<insert_connection_name>")) {
	      System.err.println("Please update the sample to specify the instance connection name.");
	      System.exit(1);
	    }

	    if (password.equals("<insert_password>")) {
	      System.err.println("Please update the sample to specify the mysql password.");
	      System.exit(1);
	    }

	    //[START doc-example]
	    
	    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TestDatabase";
		Connection connection2 = DriverManager.getConnection(jdbcUrl, username, password);
	   //[END doc-example]

		return "Hello, "+" "+connection2;
	}

}
