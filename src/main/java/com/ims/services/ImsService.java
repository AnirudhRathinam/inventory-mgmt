package com.ims.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.dao.ImsRepo;
import com.ims.models.Item;

@Service
public class ImsService {

	@Autowired
	private ImsRepo imsRepo;
	
	public Collection<Item> findAllItems(){
		
		List<Item> items = new ArrayList<Item>();
		
		for(Item item : imsRepo.findAll()) {
			items.add(item);
		}
		
		return items;
	}
	
	public Item findItem(long id) {
		Optional<Item> iOpt = imsRepo.findById(id);
		Item i = null;
		if(iOpt.isPresent()) {
			i = iOpt.get();
		}
		return i;
	}
	
	public void save(Item item) {
		imsRepo.save(item);
	}
	
	public void delete(long id) {
		imsRepo.deleteById(id); 
	}
}
