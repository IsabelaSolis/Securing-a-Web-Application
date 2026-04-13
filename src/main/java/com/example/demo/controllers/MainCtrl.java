package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.Bounce;
import com.example.demo.models.Orden;
import com.example.demo.models.UserR;
import com.example.demo.models.Visitors;

@Controller
public class MainCtrl {
	@GetMapping("/")
	
   public String raiz(Model model) {
		ArrayList<Orden>lista =new ArrayList<>();
		lista.add(new Orden("Bolsas"));
		lista.add(new Orden("Tazas"));
		lista.add(new Orden("Camisetas"));
		lista.add(new Orden("Carpetas"));
		
		ArrayList<Bounce>lista1 =new ArrayList<>();
		lista1.add(new Bounce("Salio"));
		lista1.add(new Bounce("Salio"));
		lista1.add(new Bounce("Entro"));
		lista1.add(new Bounce("Entro"));
		lista1.add(new Bounce("Salio"));
		
		int total=lista1.size();
		int salieron=0;
		for (Bounce i : lista1) {
			if (i.getVisitante().equals("Salio")) {
				salieron++;
			}
		}
		double bounceRate=((double) salieron/total)* 100;
		
		
		ArrayList<UserR>lista2 =new ArrayList<>();
		lista2.add(new UserR("Maria Gonzales"));
		
		ArrayList<Visitors>lista3 =new ArrayList<>();
		lista3.add(new Visitors("Jack Ross"));
		lista3.add(new Visitors("Nick Russo"));
		
		
	    String Usuario = ("Tom Brady");
		
		model.addAttribute("ordenes", lista);
		model.addAttribute("bounce", bounceRate);
		model.addAttribute("porcentajes", lista1);
		model.addAttribute("registro", lista2);
		model.addAttribute("visitores", lista3);
		model.addAttribute("msg", "Hola");
		model.addAttribute("usuario", Usuario);

		
	   return "index";   }
	
	@GetMapping("/login")
	public String login() {
	    return "login";
	}
}
