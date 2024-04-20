package com.zooshop.service;

import com.zooshop.entity.UserDTO;
import com.zooshop.entity.User;
import com.zooshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EntryService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public boolean addUser(UserDTO newUser)
    {
        if (!userRepository.existsByName(newUser.getName()))
        {
            var user = new User();
            user.setName(newUser.getName());
            user.setPassword(encoder.encode(newUser.getPassword()));
            userRepository.save(user);

            return true;
        }

        return false;
    }

    public Optional<User> findUserByName(String username)
    {
        return userRepository.findUserByName(username);
    }
}
