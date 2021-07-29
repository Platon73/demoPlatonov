package com.example.demo.repository;

import com.example.demo.entity.Release;
import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release, Long> {

}
