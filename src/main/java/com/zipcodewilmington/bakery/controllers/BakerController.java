package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("bakers")
public class BakerController {
    private BakerService service;

    @Autowired
    public BakerController(BakerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/index")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{bakerId}", method = RequestMethod.GET)
    public ResponseEntity<Baker> show(@PathVariable(value = "bakerId") Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{bakerId}")
    public ResponseEntity<Baker> update(@PathVariable("bakerId") Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @RequestMapping(value = "/destroy/{bakerId}")
    public ResponseEntity<Boolean> destroy(@PathVariable("bakerId") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
