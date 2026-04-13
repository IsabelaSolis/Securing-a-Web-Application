package com.example.demo.models;

public class Bounce {
	
	private String visitante;
	
	public Bounce() {
		
	}
	public Bounce(String visitante) {
		this.visitante=visitante;
		}
	
	public String getVisitante() {
		return visitante;
	}
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
}
