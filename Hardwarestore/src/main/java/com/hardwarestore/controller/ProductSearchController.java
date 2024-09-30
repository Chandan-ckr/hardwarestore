package com.hardwarestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hardwarestore.dao.HProductDao;
import com.hardwarestore.dao.ProductunitDao;
import com.hardwarestore.entity.HProduct;

@CrossOrigin (origins="*",allowedHeaders="*")
@RestController
public class ProductSearchController {

	
	
	@Autowired HProductDao productdao;
	@Autowired ProductunitDao productunitdao;
	
	@GetMapping("/searchproduct")
	public List<HProduct> searchProduct(@RequestParam String keyword){
		
		List<HProduct> p = productdao.getALlProductBykeyword(keyword);
		List<HProduct> getall = productdao.getAll();
		for(int i=0;i<getall.size();i++)
		{
			List<String> tags = getall.get(i).getpTag();
			for(int j=0;j<tags.size();j++) {
			if(tags.get(j).contains(keyword)) {
				p.add(getall.get(i));
			}
			}
		}
		
		
		return p;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
