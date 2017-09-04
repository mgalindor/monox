package com.mk.mnx.fnNationalities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.mnx.fnNationalities.service.NacionalidadesService;
import com.mk.mnx.infr.controller.BaseRestController;
import com.mk.mnx.model.domain.Item;

@RestController
public class NacionalidadesRestController extends BaseRestController {
	
	@Autowired 
	NacionalidadesService nacionalidadesService;
	
	@PostMapping("nacionalidades")
	public List<Item> createUser() {
		List<Item> n = nacionalidadesService.buscaEstadisticaNacionalidades();
		return n;
	}
	
	@GetMapping("hola")
	public String hola() {return "hola";}

}
