package com.example.demo.models;

public class UserR {
	
	public UserR () {
		
	}
	
    public UserR (String nuevoNombre) {
		this.nuevoNombre=nuevoNombre;
	}
    
	private String nuevoNombre;
	
	public String getNuevoNombre() {
		return nuevoNombre;
	}
	public void setNuevoNombre(String nuevoNombre) {
		this.nuevoNombre = nuevoNombre;
	}
	
	

}
