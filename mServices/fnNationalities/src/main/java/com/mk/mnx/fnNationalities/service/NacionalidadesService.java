package com.mk.mnx.fnNationalities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.mnx.fnNationalities.repository.PersonRepositoryCustom;
import com.mk.mnx.infr.service.BaseService;
import com.mk.mnx.model.domain.Item;

@Service
public class NacionalidadesService extends BaseService{
	
	@Autowired
	private PersonRepositoryCustom personRepository;

	public List<Item> buscaEstadisticaNacionalidades() {
		List<Item> n= personRepository.obtenerEstadisticaNacionalidades();
		return n;
	}
	
	
	
}
