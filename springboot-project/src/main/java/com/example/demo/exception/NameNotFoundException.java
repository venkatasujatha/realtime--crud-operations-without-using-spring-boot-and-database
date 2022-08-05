package com.example.demo.exception;

public class NameNotFoundException extends Exception{
	
	public String getMessage()
	{
		return "name is not present";
	}

}
