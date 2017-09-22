package com.mk.mnx.fnLocation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.mnx.fnLocation.service.LocationService;
import com.mk.mnx.infr.controller.BaseRestController;
import com.mk.mnx.model.domain.Location;

@RestController
public class LocationRestController extends BaseRestController {
	
	@Autowired 
	LocationService locationService;
	
	@PostMapping("location")
	
	public Location createUser() {
		String user = getUser();
		logger.debug("The user is {}",user);
		return locationService.buscaLocationByUser(user);
	}
	
	@GetMapping("hola")
	
	public String hola() {return "hola";}

}
