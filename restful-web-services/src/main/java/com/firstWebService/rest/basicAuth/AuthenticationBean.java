package com.firstWebService.rest.basicAuth;

public class AuthenticationBean {
public String message;


@Override
public String toString() {
	return "HellowWorldBean [message=" + message + "]";
}

public AuthenticationBean(String message) {
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
}
