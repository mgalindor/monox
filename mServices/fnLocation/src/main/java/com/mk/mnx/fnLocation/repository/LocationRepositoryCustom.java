package com.mk.mnx.fnLocation.repository;

import com.mk.mnx.model.domain.Location;

public interface LocationRepositoryCustom {
	
	Location obtenerLocationByUserName(String userName);

}
