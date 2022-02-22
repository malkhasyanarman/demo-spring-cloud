package com.madness.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Response implements Serializable {
	private HttpStatus status;
	private String message;
}
