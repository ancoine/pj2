package com.javeweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javeweb.repository.DistrictIdRepository;
import com.javeweb.repository.entity.DistrictIDEntity;

public class DistrictIdRepositoryImpl implements DistrictIdRepository {

	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "123456";
	@Override
	public DistrictIDEntity findById(Long districId) {
		String sql = "SELECT * FROM district WHERE id = ?";
	    DistrictIDEntity district = null;
	    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setLong(1,districId);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            district = new DistrictIDEntity();
	            district.setId(rs.getLong("id"));
	            district.setCode(rs.getString("code"));
	            district.setName(rs.getString("name"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return  district;
	}


}
