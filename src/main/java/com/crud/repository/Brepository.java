package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Bmodel;



@Repository
public interface Brepository extends JpaRepository <Bmodel,Integer>{

}
