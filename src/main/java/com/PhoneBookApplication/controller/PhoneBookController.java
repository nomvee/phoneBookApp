package com.PhoneBookApplication.controller;


import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

 
import com.PhoneBookApplication.dto.PhoneBook;
import com.PhoneBookApplication.service.PhoneBookService;

@Slf4j
@RequiredArgsConstructor
@RestController
@Api(value = "Phone book  Application", description = "Operations pertaining to entry in Phone book  Application")
public class PhoneBookController {

	@Autowired
	private PhoneBookService phoneBookService;

	@ApiOperation(value = "Add phone Book")
	@PostMapping
	public PhoneBook createEntry(
			@ApiParam(value = "Phone Book object store in database table", required = true) @Valid @RequestBody PhoneBook phoneBook) {
		//log.info("Adding Phone Book");
		return phoneBookService.save(phoneBook);
	}
	
	/*
	 * @ApiOperation(value = "Find all Entries in the database")
	 * 
	 * @GetMapping public List<PhoneBook> findEntries() {
	 * log.info("finding Entries"); return phoneBookService.findAll(); }
	 */
	
	@ApiOperation(value = "Find phone Book")
	@GetMapping
	public PhoneBook getEntryById(
			@ApiParam(value = "Phone Book object find in database table", required = true) @RequestBody Long id) {
		return phoneBookService.findById(id);
	}
	
	@ApiOperation(value = "Find phone Book")
	@DeleteMapping
	public void deleteEntry(
			@ApiParam(value = "Phone Book object delete in database table", required = true) @RequestBody Long id) {
		phoneBookService.deleteById(id);
	}
}
