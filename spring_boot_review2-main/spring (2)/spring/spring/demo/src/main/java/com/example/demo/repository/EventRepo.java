package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Event;

public interface EventRepo extends JpaRepository<Event,Integer>{
    
} 