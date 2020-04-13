package co.hadwen.web.exception.dto;

import co.hadwen.web.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ValidationErrorDTO extends Dto {
    @Singular("invalidValues")
    private List<InvalidValueDTO> invalidValues;
}
