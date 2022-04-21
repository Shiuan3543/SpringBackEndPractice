package com.example.demo.services.imp;

import com.example.demo.models.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
