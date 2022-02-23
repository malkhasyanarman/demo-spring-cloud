package com.madness.task;

import com.madness.demo.dto.TextDataWrapper;
import com.madness.demo.utility.LoggingService;
import com.madness.service.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@EnableBinding(Sink.class)
@Service
@RequiredArgsConstructor
public class DemoFileTask implements LoggingService {

    private final EntityService entityService;


    @StreamListener(Sink.INPUT)
    public void send(TextDataWrapper payload) {
        if (payload.getData() == null || payload.getDestination() == null || payload.getFileName() == null) {
            return;
        }
        log.info("Save data {}", payload.getFileName());

        try {
            entityService.process(payload);
            log.info("Done processing {}", payload.getFileName());
        } catch (Exception e) {
            log.error("Failed to process object: {}", payload.getFileName(), e);
        }
    }
}
