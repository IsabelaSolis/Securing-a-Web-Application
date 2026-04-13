package com.example.demo.models;

public class Orden {
	
     private String Nombre;
     
     public Orden() {
    	 
     }
     public Orden(String Nombre) {
         this.Nombre = Nombre;
     }

	 public String getNombre() {
		 return Nombre;
	 }

	 public void setNombre(String Nombre) {
		 this.Nombre = Nombre;
	 }
     
}
