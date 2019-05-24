package com.java.restful.RESTfulwebservices.helloworld;

public class HelloWorldBean {

	private String output;
	
	public String getOutput() {
		return output;
	}
//	public void setOutput(String output) {
//		this.output = output;
//	}
	public HelloWorldBean(String message) {
		this.output =  message;
	}
	
//	@Override
//	public String toString() {
//		return "HelloWorldBean [output=" + output + "]";
//	}
}
