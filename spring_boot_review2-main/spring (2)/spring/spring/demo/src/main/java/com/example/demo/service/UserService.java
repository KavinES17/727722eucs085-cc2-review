package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@SuppressWarnings("unused")
@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean post(User user)
    {
        try{
            userRepo.save(user);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public List<User> page(int offSet,int pageSize)
    {
        return userRepo.findAll(PageRequest.of(offSet, pageSize)).getContent();
    }

    public List<User> sort(String field)
    {
        return userRepo.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    public List<User> getAll()
    {
        return userRepo.findAll();
    }
}
