package com.mk.mnx.crUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.mnx.crUser.service.CrearUsuarioService;
import com.mk.mnx.infr.controller.BaseRestController;
import com.mk.mnx.model.domain.Name;
import com.mk.mnx.model.domain.Person;

@RestController
public class CreaUsuarioRestController extends BaseRestController {

	@Autowired
	CrearUsuarioService crearUsuarioService;

	@GetMapping("user")
	public Person createUser() {
		logger.debug("Start to download");
		Person p = null;
		p = crearUsuarioService.creaPersona();
		return p;
	}

	@PostMapping(path = "userTest")
	public Person getUser(@RequestBody Person in) {
		return crearUsuarioService.getUser(in);
	}

	@GetMapping("test")
	public Name getName() {
		return crearUsuarioService.getName();
	}

}
