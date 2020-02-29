package co.hadwen.web.user.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserDTO {
    private String email;
    private String password;
}
