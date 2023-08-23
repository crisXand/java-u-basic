package com.chr.webapp.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
	List<T> findAll() throws SQLException;
	void save();
	T find(int id) throws SQLException;
}
