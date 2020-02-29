package co.hadwen.web;

import co.hadwen.web.user.UserController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(UserController.class)
@Configuration
public class ControllerConfig {

}
