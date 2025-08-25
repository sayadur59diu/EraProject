package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {
    private final UserService svc;
    public UserController(UserService svc) { this.svc = svc; }

    @GetMapping public List<User> all() { return svc.all(); }
    @GetMapping("/{id}") public ResponseEntity<User> get(@PathVariable Long id) {
        User u = svc.get(id); return u != null ? ResponseEntity.ok(u) : ResponseEntity.notFound().build();
    }
    @PostMapping public User create(@RequestBody User u) { return svc.create(u); }
    @PutMapping("/{id}") public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User u) {
        User upd = svc.update(id, u); return upd != null ? ResponseEntity.ok(upd) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}") public ResponseEntity<String> delete(@PathVariable Long id) {
        return svc.delete(id) ? ResponseEntity.ok("Deleted") : ResponseEntity.notFound().build();
    }
}
