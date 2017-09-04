package com.mk.mnx.fnGender.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.mnx.fnGender.repository.PersonRepositoryCustom;
import com.mk.mnx.infr.service.BaseService;
import com.mk.mnx.model.domain.Item;

@Service
public class GeneroService extends BaseService{
	
	@Autowired
	private PersonRepositoryCustom personRepository;

	public List<Item> obtenerEstadisticaGeneros() {
		List<Item> n= personRepository.obtenerEstadisticaGeneros();
		return n;
	}
	
	
	
}
