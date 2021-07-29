package com.example.demo.service;

import com.example.demo.entity.Release;
import com.example.demo.entity.User;
import com.example.demo.exception.ReleaseAlreadyExistExceptoin;
import com.example.demo.exception.ReleaseNotFoundException;
import com.example.demo.exception.UserAlreadyExistExceptoin;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.ReleaseRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ReleaseService {
    private ReleaseRepository releaseRepository;

    public Release registretion(Release release) throws ReleaseAlreadyExistExceptoin {
        if (releaseRepository.findById(release.getId()) != null){
            throw new ReleaseAlreadyExistExceptoin("Релиз с таким именем существует");
        }
        return releaseRepository.save(release);
    }

    public Release getOne(Long id) throws ReleaseNotFoundException {
        Release release = releaseRepository.findById(id).get();
        if (release == null){
            throw new ReleaseNotFoundException("Релиз не найден");
        }
        return release;
    }
}
