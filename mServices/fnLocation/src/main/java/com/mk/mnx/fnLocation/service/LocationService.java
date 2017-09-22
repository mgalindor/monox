package com.mk.mnx.fnLocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.mnx.fnLocation.repository.LocationRepositoryCustom;
import com.mk.mnx.infr.service.BaseService;
import com.mk.mnx.model.domain.Location;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class LocationService extends BaseService{
	
	@Autowired
	private LocationRepositoryCustom locationRepositoryCustom;

	@HystrixCommand
	public Location buscaLocationByUser(String userName) {
		return locationRepositoryCustom.obtenerLocationByUserName(userName);
	}
	
}
