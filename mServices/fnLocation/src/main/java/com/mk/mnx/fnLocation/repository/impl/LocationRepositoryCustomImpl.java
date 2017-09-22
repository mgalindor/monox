package com.mk.mnx.fnLocation.repository.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mk.mnx.fnLocation.repository.LocationRepositoryCustom;
import com.mk.mnx.infr.repository.BaseCustomRepository;
import com.mk.mnx.model.domain.Location;
import com.mk.mnx.model.domain.Person;

@Repository
public class LocationRepositoryCustomImpl extends BaseCustomRepository implements LocationRepositoryCustom {

	public Location obtenerLocationByUserName(String userName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("login.username").is(userName)).fields().include("location").exclude("id");
		Person p = getTemplate().findOne(query, Person.class);
		return p.getLocation();
	}



}
