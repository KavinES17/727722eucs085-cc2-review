package com.example.demo.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepo;

@Service
public class EventService {
    private EventRepo productRepo;

    public EventService(EventRepo productRepo) {
        this.productRepo = productRepo;
    }
    
    public boolean postall(Event event)
    {
            productRepo.save(event);
            return true;
    }

    public List<Event> getall()
    {
        Pageable page=PageRequest.of(0, 13);
        return productRepo.findAll(page).getContent();
    }

    public Event getallId(int product_id)
    {
        return productRepo.findById(product_id).orElse(null);
    }

    public List<Event> getSortedList(String field) {
        System.out.println(field);
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

     public List<Event> getPageList(int offset, int pagesize) {
        Page<Event> k = productRepo.findAll(PageRequest.of(offset, pagesize));
        return k.getContent();
    }
}

