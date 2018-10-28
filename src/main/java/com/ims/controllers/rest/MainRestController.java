package com.ims.controllers.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ims.models.Item;
import com.ims.services.ImsService;

@RestController
public class MainRestController {
	
	@Autowired
	private ImsService imsService;
	
	@GetMapping("/findAllItems")
	public Collection<Item> getAllItems(){
		return imsService.findAllItems();
	}
	
	@GetMapping("/delete")
	public void deleteBook(@RequestParam long id) {
		imsService.delete(id);
	}

}
