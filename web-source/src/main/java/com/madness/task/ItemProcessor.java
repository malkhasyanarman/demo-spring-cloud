package com.madness.task;

import com.madness.demo.dto.TextDataWrapper;
import com.madness.demo.utility.LoggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@EnableBinding(Source.class)
@Service
@RequiredArgsConstructor
public class ItemProcessor implements LoggingService {

    private final Source source;

    public void pushPayload(TextDataWrapper item) {
        log.info("::: Sending payload to the next component of the rule. Destination: {}", item.getDestination());
        log.debug("::: Payload: {}", item);
        source.output()
                .send(new GenericMessage<>(item));
    }
}
