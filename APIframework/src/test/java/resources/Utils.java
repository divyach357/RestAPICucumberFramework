package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification req;
	public RequestSpecification requestBuilder() throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .addQueryParam("key", "qaclick123")
				 .setContentType(ContentType.JSON).build();
	return req;
	}
	
public RequestSpecification wrongRequestBuilder() throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
	return req;
	}
public RequestSpecification bookingRequestBuilder() throws FileNotFoundException {
	PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	return req = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
			    .addFilter(RequestLoggingFilter.logRequestTo(log))
			    .addFilter(ResponseLoggingFilter.logResponseTo(log))
			    .setContentType(ContentType.JSON).setAccept(ContentType.JSON).build();
			 
}
}
