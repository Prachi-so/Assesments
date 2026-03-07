package com.lpu.Mobile.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.lpu.Mobile.dto.MobileDTO;
import com.lpu.Mobile.entity.Mobile;




public interface  MobileService {
	
	
	public  Mobile findMobileById(int id);
	
	public MobileDTO entityToDto(Mobile mobile);
	public  Mobile DtoToEntity(MobileDTO dto);
	public  MobileDTO saveMobile(MobileDTO dto);
	public List<Mobile> mobilePaginationSorted(int pageNumber, int size, String field);
	public List<Mobile> sortMobileByFielddDesc(String field);
	public List<Mobile> sortMobileByFielddAsce(String field);
	

}
