package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Amodel;
import com.crud.repository.Arepository;

@Service
public class Aservice {
@Autowired
Arepository arepository;
	
		

	public  Amodel addNewEmployee(Amodel newemp) {
		// TODO Auto-generated method stub
		return arepository.save(newemp);
	}



	public Amodel addNew(Amodel newemp) throws Exception {
		// TODO Auto-generated method stub
		Optional<Amodel> model=arepository.findById(newemp.getId());
		if(model.isPresent()) {
			Amodel newmodel=model.get();
			newmodel.setId(newemp.getId());
			newmodel.setEmail(newemp.getEmail());
			newmodel.setUsername(newemp.getUsername());
			newmodel=arepository.save(newmodel);
			return newmodel;
			
		}
		else {
			newemp=arepository.save(newemp);
			return newemp;
		}
	}



	public Amodel addif(Amodel newemp) throws Exception {
		Optional <Amodel> amodel =arepository.findById(newemp.getId());
		if(amodel.isPresent()) {
			System.out.println("present");
			return null;
		}else {
			newemp=arepository.save(newemp);
			return newemp;
		}
		// TODO Auto-generated method stub
		//return null;
		//return newemp;
	}



	public List<Amodel> getall() {
		// TODO Auto-generated method stub
		return arepository.findAll();
		
	}



	public Optional<Amodel> getbyid(int id) {
		// TODO Auto-generated method stub
		return arepository.findById(id);
	}



	public void deleteByid(int id) {
		// TODO Auto-generated method stub
		arepository.deleteById(id);
	}



	public void deleteAll() {
		// TODO Auto-generated method stub
		arepository.deleteAll();
	}



	public Amodel update(Amodel amodel) {
		// TODO Auto-generated method stub
		 return arepository.save(amodel);
	}

}
