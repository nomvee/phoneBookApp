package com.PhoneBookApplication.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "All details about the Phone Book. ")
public class PhoneBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(notes = "The database generated entry ID")
	private Long id;
	@ApiModelProperty(notes = "The phone book name")
	private String name;
	@ApiModelProperty(notes = "The List of entries")
	private List<Entry> dtoEntries = new ArrayList<>();

}
