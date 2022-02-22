package com.madness.controller;

import com.madness.demo.utility.LoggingService;
import com.madness.dto.Request;
import com.madness.dto.Response;
import com.madness.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo-web-source")
@RequiredArgsConstructor
public class DemoController implements LoggingService {

	private final FileService service;

	@PostMapping("/request")
	public ResponseEntity<String> postMethod(@RequestBody Request request) {

		log.info("::: Request {} to {} start.", request.getLocation(), request.getDestination());
		Response result = service.execute(request);
		log.info("::: Request {} to {} end.", request.getLocation(), request.getDestination());
		return new ResponseEntity<>(result.getMessage(), result.getStatus());
	}
}
