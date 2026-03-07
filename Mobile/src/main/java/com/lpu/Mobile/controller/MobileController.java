package com.lpu.Mobile.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.Mobile.dto.MobileDTO;
import com.lpu.Mobile.entity.Mobile;
import com.lpu.Mobile.service.MobileService;


import jakarta.validation.Valid;

@RestController
public class MobileController {
	@Autowired
	private MobileService service;
	
	@PostMapping("/mobile")
	public ResponseEntity<MobileDTO> addMobile(@Valid @RequestBody MobileDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMobile(dto));
	}

	@GetMapping("/mobile/{id}")
	public Mobile fetchMobile(@PathVariable int id) {
		return service.findMobileById(id);
	}
	
	@GetMapping("/page/{pageNumber}/{size}/sortby/{field}")
	public List<Mobile> mobilePageSorted(@PathVariable int  pageNumber, @PathVariable int  size , @PathVariable String field){
		return service.mobilePaginationSorted(pageNumber, size, field);
	}
	
	
	@GetMapping("/sortby/{field}")
	public List<Mobile> sortmobileDesc(@PathVariable String field){
		return service.sortMobileByFielddDesc(field);
	}
	
	@GetMapping("/sort/{field}")
	public List<Mobile> sortMobileAsce(@PathVariable String field){
		return service.sortMobileByFielddAsce(field);
	}
}
