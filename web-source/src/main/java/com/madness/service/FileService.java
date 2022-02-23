package com.madness.service;

import com.madness.demo.dto.TextDataWrapper;
import com.madness.demo.model.enums.Destination;
import com.madness.demo.utility.FileUtility;
import com.madness.demo.utility.LoggingService;
import com.madness.dto.Request;
import com.madness.dto.Response;
import com.madness.task.ItemProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class FileService implements LoggingService {

	@Value("${destination:database}")
	private String defaultDestination;

	private final ItemProcessor itemProcessor;

	public Response execute(Request request) {
		String destination = request.getDestination();
		if (destination == null) {
			destination = defaultDestination;
		}
		String fileLocation = request.getLocation();

		StringBuilder stringBuilder = new StringBuilder();
			log.info("::: Request data from disk {}", fileLocation);
			try (Stream<String> stream = Files.lines(Paths.get(fileLocation))) {
				stream.forEach(str -> stringBuilder.append(str).append("\r "));
			} catch (Exception exception) {
				log.info("::: File not found on disk {}", fileLocation);
				return new Response()
						.setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
						.setMessage("File not found on disk");
			}

			try {
				TextDataWrapper item = new TextDataWrapper()
						.setDestination(Destination.valueOf(destination.toUpperCase()))
						.setData(stringBuilder.toString())
						.setFileName(FileUtility.getFileName(Paths.get(fileLocation)));

				itemProcessor.pushPayload(item);
				return new Response()
						.setStatus(HttpStatus.OK)
						.setMessage("Success");
			} catch (Exception e) {
				return new Response()
						.setStatus(HttpStatus.BAD_REQUEST)
						.setMessage(e.getMessage());
			}
	}
}
