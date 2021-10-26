package com.example.l3e7.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.l3e7.entity.Dog;
import com.example.l3e7.exception.BreedNotFoundException;
import com.example.l3e7.exception.DogNotFoundException;
import com.example.l3e7.respository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class MutationResolver implements GraphQLMutationResolver {
    @Autowired
    private DogRepository dogRepository;

    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }else{
            throw new DogNotFoundException("dog not found",id);
        }
    }
    public boolean deleteDogBreed(String breed){
        Boolean deleted= false;
        Iterable<Dog> dogs = dogRepository.findAll();
        for(Dog d:dogs){
            if(d.getBreed().equals(breed)){
                dogRepository.delete(d);
                deleted=true;
            }
        }
        if(!deleted){
            throw new BreedNotFoundException("breed not found",breed);
        }
        return deleted;
    }
}
