package com.example.demo.controller;

import com.example.demo.entity.Release;
import com.example.demo.entity.User;
import com.example.demo.exception.ReleaseAlreadyExistExceptoin;
import com.example.demo.exception.ReleaseNotFoundException;
import com.example.demo.exception.UserAlreadyExistExceptoin;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.ReleaseService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @GetMapping("/{id}")
    public ResponseEntity getOneUser (@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok(releaseService.getOne(id));
        } catch (ReleaseNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity registration (@RequestBody Release release){
        try{
            releaseService.registretion(release);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (ReleaseAlreadyExistExceptoin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошда ошибка");
        }
    }
}
