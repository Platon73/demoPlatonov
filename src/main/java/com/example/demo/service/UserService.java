package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistExceptoin;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public User registretion(User user) throws UserAlreadyExistExceptoin {
        if (userRepository.findByFirstName(user.getFirstName()) != null){
            throw new UserAlreadyExistExceptoin("Пользователь с таким именем существует");
        }
        return userRepository.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).get();
        if (user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return user;
    }
}
