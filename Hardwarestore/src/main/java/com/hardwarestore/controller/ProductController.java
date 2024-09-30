package com.hardwarestore.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hardwarestore.dao.HProductDao;
import com.hardwarestore.dao.ProductunitDao;
import com.hardwarestore.entity.HProduct;
import com.hardwarestore.entity.ProductUnit;

@CrossOrigin (origins="*",allowedHeaders="*")
@RestController
public class ProductController {

	@Autowired HProductDao productdao;
	@Autowired ProductunitDao productunitdao;
	
	
	
	
	
	
	
	
	
	//Add Product
	@PostMapping("/addproduct")
	public String addProduct(@RequestParam String pName,
							 @RequestParam String pImage,
							 @RequestParam List<String> pTag,
							 @RequestParam long pQuantity,
							 @RequestParam long pActualQuantity,
							 @RequestParam long pPrice,
							 @RequestParam long pBasePrice,
							 @RequestParam long pUnit,
							 @RequestParam long pCategoryUniqueId) {
							
		
		HProduct hp = productdao.getBypname(pName);
		if(hp!=null) {
			/// Unit Add
		    ProductUnit pu = new ProductUnit();
		    pu.setpUniqueId(hp.getpUniqueId());
		    pu.setpPrice(pPrice);
		    pu.setpBasePrice(pBasePrice);
		    pu.setpQuantity(pQuantity);
		    pu.setpUnit(pUnit);
		    pu.setpActualQuantity(pActualQuantity);
		    productunitdao.save(pu);
		}else {
		
		
		HProduct p = new HProduct();
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    String uniqueID= String.format("%06d", number);
	    
	    p.setpName(pName);
	    p.setpUniqueId(uniqueID);
	    p.setpTag(pTag);
	    p.setpImage(pImage);
	    p.setpCategoryUniqueId(pCategoryUniqueId);
	    
	    
	    /// Unit Add
	    ProductUnit pu = new ProductUnit();
	    pu.setpUniqueId(uniqueID);
	    pu.setpPrice(pPrice);
	    pu.setpBasePrice(pBasePrice);
	    pu.setpQuantity(pQuantity);
	    pu.setpUnit(pUnit);
	    pu.setpActualQuantity(pActualQuantity);
	    productunitdao.save(pu);
	    productdao.save(p);
		}
		return "Product Added Successfully";
		
		
	}
	
	
	
	
	// Get All Product
	@GetMapping("/getallproduct")
	public List<HProduct> getall(){
		
		return productdao.getAll();
		
	}
	
	
	// Get Product by Unique ID
	@GetMapping("/getproductbyid")
	public HProduct getProductByid(@RequestParam String pUniqueId) {
		
		
		return productdao.getByPuniqueId(pUniqueId);
	
	}
	
	//Get Product unit and quantity and price
	@GetMapping("/getproductunit")
	public List<ProductUnit> getProductunit(@RequestParam String pUniqueId) {
		
		List<ProductUnit> p = productunitdao.getByPuniqueIds(pUniqueId);
		return p;
	
	}
	
	// Update product quantity
	@PostMapping("/updateproductquantity")
	 public String updateQuantity(@RequestParam String pUniqueId,
			 					  @RequestParam long Quantity,
			 					 @RequestParam long unit) {
//		ProductUnit pu = productunitdao.getByPuniqueId(pUniqueId);
		ProductUnit p = productunitdao.getByPuniqueIdsUnit(pUniqueId,unit);
	
		long newquantity = p.getpQuantity()+Quantity;
		p.setpQuantity(newquantity);
		
		productunitdao.save(p);
		
		return "Quantity added successfully";
	}
	
	
	
	//Test
	@GetMapping("/test")
	public String test() {
		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		cal.add(Calendar.DAY_OF_MONTH, -365);
		Date today30 = cal.getTime();
		System.out.println(today30);
	    
	    return "Okay";
		
		
	}
	
	
	
	
}
