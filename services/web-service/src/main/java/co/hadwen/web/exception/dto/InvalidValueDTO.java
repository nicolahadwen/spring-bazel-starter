package co.hadwen.web.exception.dto;

import co.hadwen.web.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InvalidValueDTO extends Dto {
    private static final String PATH_STRING_DELIMITER = ",";
    @Singular("path")
    private List<String> path;
    private ErrorType type;

    public enum ErrorType {
        INVALID
    }

    public String getPathAsString() {
        return String.join(PATH_STRING_DELIMITER, path);
    }
}
