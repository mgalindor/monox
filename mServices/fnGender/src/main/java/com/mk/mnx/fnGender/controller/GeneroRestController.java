package com.mk.mnx.fnGender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.mnx.fnGender.service.GeneroService;
import com.mk.mnx.infr.controller.BaseRestController;
import com.mk.mnx.model.domain.Item;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class GeneroRestController extends BaseRestController {
	
	@Autowired 
	GeneroService generoService;
	
	@PostMapping("generos")
	@HystrixCommand
	public List<Item> buscaGeneros() {
		List<Item> n = generoService.obtenerEstadisticaGeneros();
		return n;
	}
	
	@GetMapping("hola")
	@HystrixCommand
	public String hola() {return "hola";}

}
