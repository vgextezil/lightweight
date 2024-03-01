package edu.extezil.spbbase.service;

import edu.extezil.spbbase.model.Airplane;
import edu.extezil.spbbase.repository.AirplaneRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirplaneService {

    private final AirplaneRepository repository;
    private List<Airplane> airplanes = List.of(
            new Airplane("1", "Name1", "000001","descriprtion1"),
            new Airplane("2", "Name2", "000002","descriprtion2"),
            new Airplane("3", "Name3", "000003","descriprtion3")
    );

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(airplanes);
    }

    //CRUD

    @Cacheable("airplanes")
    public List<Airplane> getAll(){
        log.info("---------- GET ALL --------------");
        return repository.findAll();
    }

    @Cacheable("airplanes")
    public Airplane getById(String id){
        log.info("---------- GET BY ID " + id + "-----------------");
        return repository.findById(id).orElse(null);
    }

    @CachePut(value = "airplanes", key = "#airplane.id")
    public Airplane create(Airplane airplane){
        log.info("------- PUT " + airplane+"--------");
        return repository.save(airplane);
    }

    public void delete(String id){
        log.info("Delete id = " + id);
        repository.deleteById(id);
    }
}
