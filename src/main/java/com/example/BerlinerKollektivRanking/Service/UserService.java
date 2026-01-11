package com.example.BerlinerKollektivRanking.Service;

import com.example.BerlinerKollektivRanking.Model.User;
import com.example.BerlinerKollektivRanking.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
