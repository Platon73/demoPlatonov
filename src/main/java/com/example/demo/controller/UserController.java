package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistExceptoin;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity getOneUser (@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity registration (@RequestBody User user){
        try{
            userService.registretion(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (UserAlreadyExistExceptoin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошда ошибка");
        }
    }

}