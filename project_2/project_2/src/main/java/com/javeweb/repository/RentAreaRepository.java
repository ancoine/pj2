package com.javeweb.repository;

import java.util.List;

import com.javeweb.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
	List<RentAreaEntity> findAll(Long buildingId);
}
