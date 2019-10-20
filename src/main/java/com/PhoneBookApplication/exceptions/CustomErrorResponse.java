package com.PhoneBookApplication.exceptions;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomErrorResponse {
	
private LocalDateTime timestamp;
private int status;
private String error;

}
