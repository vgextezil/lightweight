package edu.extezil.spbbase.controller;

import edu.extezil.spbbase.model.Airplane;
import edu.extezil.spbbase.service.AirplaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airplanes")
@RequiredArgsConstructor
public class AirplaneController {

    private final AirplaneService service;
    @GetMapping("")
    public List<Airplane> fetchAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Airplane fetchById(@PathVariable String id){
        return service.getById(id);
    }
    @PostMapping
    public Airplane insert(@RequestBody Airplane airplane){
        return service.create(airplane);
    }

    @CacheEvict("airplanes")
    @DeleteMapping("/{id}")
    public void eraseById(@PathVariable String id){
        service.delete(id);
    }

}
