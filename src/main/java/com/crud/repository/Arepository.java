package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Amodel;

@Repository
public interface Arepository extends JpaRepository <Amodel,Integer>{

}
