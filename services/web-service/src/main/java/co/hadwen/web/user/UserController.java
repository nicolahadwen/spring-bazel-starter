package co.hadwen.web.user;

import co.hadwen.web.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@AllArgsConstructor
@RequestMapping("v1")
@RestController
public class UserController {
    private static String CREATED_USER_URL = "user/%s";
    @GetMapping("/user/{id}")
    ResponseEntity<String> get(@PathVariable String id) throws Exception {
        return ResponseEntity.ok("response");
    }

    @PostMapping("/user/{id}")
    ResponseEntity<String> create(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println(userDTO);
        URI uri = new URI(String.format(CREATED_USER_URL, "user-id"));
        return ResponseEntity.created(uri).build();
    }
}
