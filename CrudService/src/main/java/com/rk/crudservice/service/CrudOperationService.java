package com.rk.crudservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rk.crudservice.entity.DBObject;
import com.rk.crudservice.repository.DBObjectRepository;

@Service(value = "crudOperationService")
public class CrudOperationService {
	private DBObjectRepository dBObjectRepository;

	public CrudOperationService(DBObjectRepository dBObjectRepository) {
		this.dBObjectRepository = dBObjectRepository;
	}

	public Iterable<DBObject> list() {
		return dBObjectRepository.findAll();
	}

	public Iterable<DBObject> save(List<DBObject> dbObjects) {
		return dBObjectRepository.saveAll(dbObjects);
	}

	public Iterable<DBObject> getFilterRecords(Date startDate, Date endDate) {
		return dBObjectRepository.getFilterRecords(startDate, endDate);
	}

}
