package com.madness.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Request {
    private String location;
    private String destination;
}
