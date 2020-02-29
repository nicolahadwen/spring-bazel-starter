package co.hadwen.web.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorDTO {
    @Singular("invalidValues")
    private List<InvalidValueDTO> invalidValues;
}
