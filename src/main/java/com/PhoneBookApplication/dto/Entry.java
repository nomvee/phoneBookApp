package com.PhoneBookApplication.dto;

import java.io.Serializable;

import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@ApiModel(description = "All details about the Entry. ")
public class Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "The database generated entry ID")
	private Long id;
	@ApiModelProperty(notes = "The entry name")
	private String name;
	@ApiModelProperty(notes = "The phone number")
	private String phoneNumber;
	private Long phoneBookId;

}
