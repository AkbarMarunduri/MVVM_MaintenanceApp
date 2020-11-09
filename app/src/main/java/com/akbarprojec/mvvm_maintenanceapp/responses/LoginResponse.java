package com.akbarprojec.mvvm_maintenanceapp.responses;

import java.util.List;

import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.squareup.moshi.Json;

public class LoginResponse{

	@Json(name = "resultUser")
	private List<User> resultUser;

	@Json(name = "message")
	private String message;

	@Json(name = "value")
	private int value;

	public List<User> getResultUser(){
		return resultUser;
	}

	public String getMessage(){
		return message;
	}

	public int getValue(){
		return value;
	}
}