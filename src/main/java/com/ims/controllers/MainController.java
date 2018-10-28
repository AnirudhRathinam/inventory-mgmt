package com.ims.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ims.models.Item;
import com.ims.services.ImsService;

@Controller
public class MainController {
	
	@Autowired
	private ImsService imsService;
	
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("items", imsService.findAllItems());
		req.setAttribute("mode", "ITEM_VIEW");
		return "index";
	}
	
	@GetMapping("/updateItem")
	public String init(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("item", imsService.findItem(id));
		req.setAttribute("mode", "ITEM_EDIT");
		return "index";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	
	@PostMapping("/save")
	public void save(@ModelAttribute Item item, HttpServletRequest req, HttpServletResponse res) throws IOException {
		imsService.save(item);
		req.setAttribute("items", imsService.findAllItems());
		req.setAttribute("mode", "ITEM_VIEW");
		res.sendRedirect("/");
	}
	
	@GetMapping("/addItem")
	public String newItem(HttpServletRequest req) {
		req.setAttribute("mode", "ITEM_NEW");
		return "index";
	}
	
	@GetMapping("/deleteItem")
	public void deleteItem(@RequestParam long id, HttpServletRequest req, HttpServletResponse res) throws IOException {
		imsService.delete(id);
		req.setAttribute("items", imsService.findAllItems());
		req.setAttribute("mode", "ITEM_VIEW");
		res.sendRedirect("/");
	}
	
}
