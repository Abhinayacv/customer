package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Bmodel;
import com.crud.repository.Brepository;


@Service
public class Bservice {
	@Autowired
	Brepository arepository;
		
			

		public  Bmodel addNewEmployee(Bmodel newemp) {
			// TODO Auto-generated method stub
			return arepository.save(newemp);
		}



		public Bmodel addNew(Bmodel newemp) throws Exception {
			// TODO Auto-generated method stub
			Optional<Bmodel> model=arepository.findById(newemp.getBid());
			if(model.isPresent()) {
				Bmodel newmodel=model.get();
				newmodel.setBid(newemp.getBid());
				newmodel.setState(newemp.getState());
				//newmodel.setCity(newemp.getCity());
				newmodel=arepository.save(newmodel);
				return newmodel;
				
			}
			else {
				newemp=arepository.save(newemp);
				return newemp;
			}
		}



		public Bmodel addif(Bmodel newemp) throws Exception {
			Optional <Bmodel> amodel =arepository.findById(newemp.getBid());
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



		public List<Bmodel> getall() {
			// TODO Auto-generated method stub
			return arepository.findAll();
			
		}



		public Optional<Bmodel> getbyid(int bid) {
			// TODO Auto-generated method stub
			return arepository.findById(bid);
		}



		public void deleteByid(int bid) {
			// TODO Auto-generated method stub
			arepository.deleteById(bid);
		}



		public void deleteAll() {
			// TODO Auto-generated method stub
			arepository.deleteAll();
		}



		/*public Bmodel update(Bmodel amodel) {
			// TODO Auto-generated method stub
			 return arepository.save(amodel);
		}*/

}
