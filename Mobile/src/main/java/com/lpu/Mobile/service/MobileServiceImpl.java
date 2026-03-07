package com.lpu.Mobile.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lpu.Mobile.dto.ImageDTO;
import com.lpu.Mobile.dto.MobileDTO;
import com.lpu.Mobile.entity.Mobile;
import com.lpu.Mobile.exception.ResourceNotFoundException;
import com.lpu.Mobile.repository.MobileRepository;


@Service
public class MobileServiceImpl implements MobileService{

	@Autowired
	private MobileRepository repository;
	
	//@Cacheable(value="mobiles", key="#id")
	public Mobile findMobileById(int id) {
		System.err.println("fetching from db");
		return repository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("mobile with id " + id +" does not exist")
				);
	}
	
	
	
	public MobileDTO entityToDto(Mobile mobile) {
		MobileDTO dto=new MobileDTO();
		dto.setId(mobile.getId());
		dto.setBrandName(mobile.getBrandName());
		dto.setPrice(mobile.getPrice());
		dto.setColor(mobile.getColor());
		dto.setRam(mobile.getRam());
		dto.setStorage(mobile.getStorage());
		
		  
		
		return dto;
	}
	
	
	
	public Mobile DtoToEntity(MobileDTO dto) {
		Mobile mobile=new Mobile();
		mobile.setBrandName((dto.getBrandName()));
		mobile.setColor(dto.getColor());
		mobile.setId(dto.getId());
		mobile.setPrice(dto.getPrice());
		mobile.setRam(dto.getRam());
		mobile.setStorage(dto.getStorage());
		return mobile;
	}
	
	
	//@CachePut(value="mobiles", key="#result.id")
	public MobileDTO saveMobile(MobileDTO dto) {
		Mobile mobile= DtoToEntity(dto);
		Mobile m=repository.save(mobile);
		
		return entityToDto(m);
	}
	
	public List<Mobile> mobilePaginationSorted(int pageNumber, int size, String field){
		Pageable  pageable=PageRequest.of(pageNumber, size, Sort.by(field).descending());
		return repository.findAll(pageable).getContent();  
	}
	
	public List<Mobile> sortMobileByFielddDesc(String field){ 
		return repository.findAll(Sort.by(field).descending());
	}
	
	public List<Mobile> sortMobileByFielddAsce(String field){ 
		return repository.findAll(Sort.by(field));
	}
}
