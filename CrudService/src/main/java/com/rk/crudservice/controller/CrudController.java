package com.rk.crudservice.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.crudservice.entity.DBObject;
import com.rk.crudservice.service.CrudOperationService;

@CrossOrigin
@RestController
public class CrudController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CrudController.class);

	@Autowired
	@Qualifier(value = "crudOperationService")
	CrudOperationService service;

	@GetMapping(value = "/list")
	public Iterable<DBObject> list() {
		LOGGER.info("Inside list");
		return service.list();
	}

	@GetMapping(value = "/allFilterRecords")
	public Iterable<DBObject> getFilterRecords(@RequestParam String startDate, @RequestParam String endDate) {
		LOGGER.info("Inside getFilterRecords");
		return service.getFilterRecords(new Date(startDate), new Date(endDate));
	}

	@GetMapping(value = "/welcome")
	public String welcome() {
		LOGGER.info("Inside welcome");
		return "Welcome Home!";
	}

}
