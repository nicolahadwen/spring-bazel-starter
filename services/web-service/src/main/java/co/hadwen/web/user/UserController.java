package co.hadwen.web.user;

import co.hadwen.web.exception.NotFoundException;
import co.hadwen.web.exception.NotFoundException.Entity;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@AllArgsConstructor
@RequestMapping("v1")
@RestController
public class UserController {
    private static final String CREATED_URI_FORMAT = "user/%s";

    @GetMapping("/user/{id}")
    ResponseEntity<String> get(@PathVariable String id) throws Exception {
        return ResponseEntity.ok("response");
    }
}
