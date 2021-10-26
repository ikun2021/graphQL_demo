package com.example.l3e7.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.l3e7.entity.Dog;
import com.example.l3e7.exception.DogNotFoundException;
import com.example.l3e7.respository.DogRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    private DogRepository dogRepository;

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
