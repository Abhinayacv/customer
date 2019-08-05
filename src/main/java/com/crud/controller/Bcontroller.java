package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Bmodel;
import com.crud.service.Bservice;

@RestController
public class Bcontroller {
	@Autowired
	Bservice aservice;
	@RequestMapping(value= "/Badd", method= RequestMethod.POST)
    public Bmodel createEmployee(@RequestBody Bmodel newemp) {
        
        return aservice.addNewEmployee(newemp);
    }
	@RequestMapping(value= "/Baddorupdate", method= RequestMethod.POST)
    public Bmodel create(@RequestBody Bmodel newemp) throws Exception {
        
        return aservice.addNew(newemp);
    }
	@RequestMapping(value= "/Baddifexists", method= RequestMethod.POST)
    public Bmodel creat(@RequestBody Bmodel newemp) throws Exception {
        
        return aservice.addif(newemp);
    }
	@RequestMapping(value="/BgetAll",method=RequestMethod.GET)
	public List<Bmodel> getall(){
		 return aservice.getall();
		
	}
	@RequestMapping(value="/BgetbyId/{bid}",method=RequestMethod.GET)
	public Bmodel getbyid(@PathVariable int bid) throws Exception{
		Optional<Bmodel> model=aservice.getbyid(bid);
		if(!model.isPresent()) throw new Exception("could not find employee with id"+bid);
	return model.get();
	}
	@RequestMapping(value="/BdeletebyId/{bid}",method=RequestMethod.DELETE)
	public void deleteByid(@PathVariable int bid)throws Exception{
		Optional<Bmodel> model=aservice.getbyid(bid);
		if(!model.isPresent()) throw new Exception("could not find employee with id"+bid);
		 aservice.deleteByid(bid);
	}
	@RequestMapping(value="/BdeleteAll",method=RequestMethod.DELETE)
	public void deleteAll() {
		aservice.deleteAll();
		
	}
	/*@RequestMapping(value="/update/{bid}",method=RequestMethod.PUT)
	public Bmodel update(@RequestBody Bmodel amodel,@PathVariable int bid) throws Exception{
		Optional<Bmodel> newmodel=aservice.getbybid(bid);
		if(!newmodel.isPresent()) throw new Exception("could not find employee with id"+id);
		if(amodel.getEmail()==null || amodel.getEmail().isEmpty());
		amodel.setEmail(newmodel.get().getEmail());
		if(amodel.getUsername()==null || amodel.getUsername().isEmpty());
		amodel.setUsername(newmodel.get().getUsername());
		amodel.setId(id);
		return aservice.update(amodel);
		
	}*/
}
