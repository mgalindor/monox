package com.mk.mnx.fnNationalities.repository.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import com.mk.mnx.fnNationalities.repository.PersonRepositoryCustom;
import com.mk.mnx.infr.repository.BaseCustomRepository;
import com.mk.mnx.model.domain.Item;
import com.mk.mnx.model.domain.Person;

@Repository
public class PersonRepositoryCustomImpl extends BaseCustomRepository implements PersonRepositoryCustom {

	public List<Item> obtenerEstadisticaNacionalidades() {
		Aggregation agg = newAggregation( group("nat").count().as("value"),
				project("value").and("key").previousOperation(), sort(Sort.Direction.ASC, "value")
		).withOptions(Aggregation.newAggregationOptions(). allowDiskUse(true).build());
		
		// Convert the aggregation result into a List
		AggregationResults<Item> groupResults = getTemplate().aggregate(agg, Person.class, Item.class);
		List<Item> result = groupResults.getMappedResults();

		return result;
	}

}
