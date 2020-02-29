package co.hadwen.web.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@AllArgsConstructor
@RequestMapping("v1")
@RestController
public class UserController {
    @GetMapping("/user/{id}")
    ResponseEntity<String> get(@PathVariable String id) throws Exception {
        return ResponseEntity.ok("response");
    }
}
