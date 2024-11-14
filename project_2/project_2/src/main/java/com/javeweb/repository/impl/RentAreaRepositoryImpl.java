package com.javeweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javeweb.repository.RentAreaRepository;
import com.javeweb.repository.entity.RentAreaEntity;

public class RentAreaRepositoryImpl implements RentAreaRepository {
	 static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	    static final String USER = "root";
	    static final String PASS = "123456";
	@Override
	public List<RentAreaEntity> findAll(Long buildingId) {
	String sql = "SELECT *FROM rentarea WHERE 1=1 AND buildingid ="+buildingId;
	List<RentAreaEntity> results = new ArrayList<RentAreaEntity>();
	try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		     Statement stm = conn.createStatement();
		     ResultSet rs = stm.executeQuery(sql.toString())) {
		while(rs.next()) {
			RentAreaEntity  areaEntity = new RentAreaEntity();
			areaEntity.setId(rs.getLong("id"));
			areaEntity.setValue(rs.getLong("value"));
			results.add(areaEntity);
		}
	
			
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	return results;
	
	}
}
