package com.madness.demo.dto;

import com.madness.demo.model.enums.Destination;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TextDataWrapper {

	private Destination destination;

	private String data;
}
