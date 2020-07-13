package com.firstWebService.rest.services.restfulwebservices.test;

public class HellowWorldBean {
public String message;


@Override
public String toString() {
	return "HellowWorldBean [message=" + message + "]";
}

public HellowWorldBean(String message) {
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
}
