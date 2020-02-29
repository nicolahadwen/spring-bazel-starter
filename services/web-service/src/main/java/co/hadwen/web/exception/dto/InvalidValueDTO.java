package co.hadwen.web.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvalidValueDTO {
    private String field;
    private ErrorType type;

    public enum ErrorType {
        INVALID
    }
}
