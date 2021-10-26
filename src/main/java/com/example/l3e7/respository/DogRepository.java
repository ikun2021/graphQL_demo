package com.example.l3e7.respository;


import com.example.l3e7.entity.Dog;
import org.springframework.data.repository.CrudRepository;

//不需要加repository注解？？ 因为是springboot data jpa 自动生成sql语句
public interface DogRepository extends CrudRepository<Dog,Long> {
}
