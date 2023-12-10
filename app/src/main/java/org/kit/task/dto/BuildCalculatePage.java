package org.kit.task.dto;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuildCalculatePage {
    private String input;
    private Map<String, List<ValidationError<Object>>> errors;
}
