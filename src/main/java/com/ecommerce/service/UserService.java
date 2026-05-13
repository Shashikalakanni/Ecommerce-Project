package com.ecommerce.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.model.User;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public User register(User u) { return repo.save(u); }
    public Optional<User> findByEmail(String email) { return repo.findByEmail(email); }
}
