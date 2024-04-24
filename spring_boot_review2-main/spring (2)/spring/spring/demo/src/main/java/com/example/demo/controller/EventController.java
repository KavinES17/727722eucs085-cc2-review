package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class EventController {
    private EventService productService;

    public EventController(EventService productService) {
        this.productService = productService;
    }

    @PostMapping("/event")
    public ResponseEntity<Event> postMethodName(@RequestBody Event event) {
        productService.postall(event);
         return new ResponseEntity<>(event,HttpStatus.CREATED);
    }
    
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getMethodName() {
        List<Event> k = productService.getall();
        if(k.size()==0)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(k,HttpStatus.CREATED);
    }
    @GetMapping("/events/{event_id}")
    public ResponseEntity<Event> getMethodNameId(@PathVariable int event_id) {
        Event k = productService.getallId(event_id);
        if(k==null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(k,HttpStatus.CREATED);
    }

    @GetMapping("/sortBy/{field}")
    public List<Event> sortByRate(@PathVariable("field") String field) {
        return productService.getSortedList(field);
    }

    @GetMapping("/pagination/{offset}/{pagesize}")
    public List<Event> getMethodName1(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) {
        return productService.getPageList(offset,pagesize);
    }
    
}


