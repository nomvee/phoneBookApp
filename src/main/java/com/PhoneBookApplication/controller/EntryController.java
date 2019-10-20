package com.PhoneBookApplication.controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.PhoneBookApplication.dto.Entry;
import com.PhoneBookApplication.exceptions.ContactNotFoundException;
import com.PhoneBookApplication.service.EntryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/entry")
@Api(value = "Phone book  Application", description = "Operations pertaining to entry in Phone book  Application")
public class EntryController {

	private final EntryService entryService;

	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public List<Entry> getEntrie() {
		return entryService.findAll();
	}

	@ApiOperation(value = "Get an entry by Id")
	@GetMapping("/{id}")
	public ResponseEntity<Entry> getEntryById(
			@ApiParam(value = "Entry id from which entry object will retrieve", required = true) @PathVariable(value = "id") Long entryId)
			throws ContactNotFoundException {
		Entry entry = entryService.findById(entryId);
		if (entry == null) {
			log.error("error when retriving entry");
			throw new ContactNotFoundException(entryId);
		}

		return ResponseEntity.ok().body(entry);
	}

	@ApiOperation(value = "Add an Entry")
	@PostMapping
	public Entry createEntry(
			@ApiParam(value = "Entry object store in database table", required = true) @Valid @RequestBody Entry entry) {
		log.info("Adding entry");
		return entryService.save(entry);
	}

	@ApiOperation("Delete a contact from the phone book using its id.")
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteContact(@ApiParam(value = "The id of the contact to be deleted") @PathVariable Long id) {
		log.error("deleting entry");
		entryService.deleteById(id);
	}

}
