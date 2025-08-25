package com.example.demo.service;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private long seq = 1;

    public List<User> all() { return new ArrayList<>(users.values()); }
    public User get(Long id) { return users.get(id); }
    public User create(User u) { u.setId(seq++); users.put(u.getId(), u); return u; }
    public User update(Long id, User u) {
        if (!users.containsKey(id)) return null;
        u.setId(id); users.put(id, u); return u;
    }
    public boolean delete(Long id) { return users.remove(id) != null; }
}
