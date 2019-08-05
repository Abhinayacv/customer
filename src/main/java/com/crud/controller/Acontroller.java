package com.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Amodel;
import com.crud.service.Aservice;

@RestController
public class Acontroller {
	@Autowired
	Aservice aservice;
	@RequestMapping(value= "/add", method= RequestMethod.POST)
    public Amodel createEmployee(@RequestBody Amodel newemp) {
        
        return aservice.addNewEmployee(newemp);
    }
	@RequestMapping(value= "/addorupdate", method= RequestMethod.POST)
    public Amodel create(@RequestBody Amodel newemp) throws Exception {
        
        return aservice.addNew(newemp);
    }
	@RequestMapping(value= "/addifexists", method= RequestMethod.POST)
    public Amodel creat(@RequestBody Amodel newemp) throws Exception {
        
        return aservice.addif(newemp);
    }
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Amodel> getall(){
		 return aservice.getall();
		
	}
	@RequestMapping(value="/getbyId/{id}",method=RequestMethod.GET)
	public Amodel getbyid(@PathVariable int id) throws Exception{
		Optional<Amodel> model=aservice.getbyid(id);
		if(!model.isPresent()) throw new Exception("could not find employee with id"+id);
	return model.get();
	}
	@RequestMapping(value="/deletebyId/{id}",method=RequestMethod.DELETE)
	public void deleteByid(@PathVariable int id)throws Exception{
		Optional<Amodel> model=aservice.getbyid(id);
		if(!model.isPresent()) throw new Exception("could not find employee with id"+id);
		 aservice.deleteByid(id);
	}
	@RequestMapping(value="/deleteAll",method=RequestMethod.DELETE)
	public void deleteAll() {
		aservice.deleteAll();
		
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public Amodel update(@RequestBody Amodel amodel,@PathVariable int id) throws Exception{
		Optional<Amodel> newmodel=aservice.getbyid(id);
		if(!newmodel.isPresent()) throw new Exception("could not find employee with id"+id);
		if(amodel.getEmail()==null || amodel.getEmail().isEmpty());
		amodel.setEmail(newmodel.get().getEmail());
		if(amodel.getUsername()==null || amodel.getUsername().isEmpty());
		amodel.setUsername(newmodel.get().getUsername());
		amodel.setId(id);
		return aservice.update(amodel);
		
	}
	//--------------------------------------------------------------------------------------
	
}