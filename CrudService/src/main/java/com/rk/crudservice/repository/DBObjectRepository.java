package com.rk.crudservice.repository;

import com.rk.crudservice.entity.DBObject;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DBObjectRepository extends CrudRepository<DBObject, Long> {

	@Query(value = "SELECT DBOBJECT.* FROM DBOBJECT WHERE CAST(start_date as date)>=cast(:startDate as date) and cast(start_date as date)<=cast(:endDate as date) order by DBOBJECT.start_date desc", nativeQuery = true)
	public Iterable<DBObject> getFilterRecords(Date startDate, Date endDate);
	
}