package com.mk.mnx.fnGender.repository.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import com.mk.mnx.fnGender.repository.PersonRepositoryCustom;
import com.mk.mnx.model.domain.Item;
import com.mk.mnx.model.domain.Person;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Item> obtenerEstadisticaGeneros() {
		Aggregation agg = newAggregation( group("gender").count().as("value"),
				project("value").and("key").previousOperation(), sort(Sort.Direction.ASC, "value")
		).withOptions(Aggregation.newAggregationOptions(). allowDiskUse(true).build());

		// Convert the aggregation result into a List
		AggregationResults<Item> groupResults = mongoTemplate.aggregate(agg, Person.class, Item.class);
		List<Item> result = groupResults.getMappedResults();

		return result;
	}

}
