package co.hadwen.web.exception;

import co.hadwen.web.exception.dto.ValidationErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ValidationException extends RuntimeException {
    private static final String FIELD_DELIMITER = ", ";
    private static final String FIELD_MESSAGE_FORMAT = "%s: %s";
    private final ValidationErrorDTO errorDTO;

    @Override
    public String getMessage() {
        return errorDTO.getInvalidValues().stream()
                .map(e -> String.format(FIELD_MESSAGE_FORMAT, e.getField(), e.getType().name()))
                .collect(Collectors.joining(FIELD_DELIMITER));
    }
}
