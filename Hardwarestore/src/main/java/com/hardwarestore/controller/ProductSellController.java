package com.hardwarestore.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hardwarestore.dao.HProductDao;
import com.hardwarestore.dao.ProductSellDao;
import com.hardwarestore.dao.ProductunitDao;
import com.hardwarestore.entity.ProductSell;
import com.hardwarestore.entity.ProductUnit;

@CrossOrigin (origins="*",allowedHeaders="*")
@RestController
public class ProductSellController {

	
	
	@Autowired HProductDao productdao;
	@Autowired ProductunitDao productunitdao;
	@Autowired ProductSellDao productselldao;
	
	
	// Product Sell
	@PostMapping("/sellproduct")
	public String sellProduct(@RequestParam String pUniqueId,
			 @RequestParam long pQuantity,
			 @RequestParam long pPrice,
			 @RequestParam long pBasePrice,
			 @RequestParam long pUnit) {
		ProductUnit pu = productunitdao.getByPuniqueIdandunit(pUniqueId,pUnit);
		ProductSell ps = new ProductSell();
		
		ps.setpUniqueId(pUniqueId);
		ps.setpQuantity(pQuantity);
		ps.setpPrice(pPrice);
		ps.setpBasePrice(pBasePrice);
		ps.setpUnit(pUnit);
		LocalDate d = java.time.LocalDate.now();
	    Date dd=	Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
		ps.setSellDateadded(dd);
		
		long totalq=pu.getpQuantity()-pQuantity;
		
		pu.setpQuantity(totalq);
		productunitdao.save(pu);
		productselldao.save(ps);
		
		return "Product Sell Successfully !";
		
		
	}
	
	
	
	/// Get All Order
	
	@GetMapping("/getallsell")
	public List<ProductSell> getAllsell(){
		
		return productselldao.getAll();
	}
	
	
	
	
	// Per Day Sell
	@GetMapping("/todaysell")
	public long getTodaySell(){
		
		long totalprice=0;
		
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDate localDate = localDateTime.toLocalDate();
		System.out.println(localDate);
		List<ProductSell> all = productselldao.getAll();
		
		for(int i=0;i<all.size();i++)
		{
			System.out.println(all.get(i).getpPrice());
			
			
			LocalDate local = all.get(i).getSellDateadded().toInstant() 
	                  .atZone(ZoneId.systemDefault()) 
	                  .toLocalDate(); 
			System.out.println(local);
			
			if(local.equals(localDate)) {
				totalprice+=all.get(i).getpPrice()*all.get(i).getpQuantity();
			}
		}
		
		return totalprice;
	}
	
	
	// Per Week Sell
		@GetMapping("/weeksell")
		public long getWeekSell(){
			
			long totalprice=0;
			
			Date date = new Date();
		    Calendar c = Calendar.getInstance();
		    c.setTime(date);
		    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
		    c.add(Calendar.DATE, -i - 7);
		    Date start = c.getTime();
		    c.add(Calendar.DATE, 6);
		    Date end = c.getTime();
//		    System.out.println(start + " - " + end);
			
			List<ProductSell> all = productselldao.getAllbyweek(start,end);
			
			for(int j=0;j<all.size();j++)
			{
				totalprice+=all.get(j).getpPrice();
			}
			
			return totalprice;
		}
		
		// Per Monthly Sell
				@GetMapping("/monthlysell")
				public long getMonthSell(){
					
					long totalprice=0;
					
					Date today = new Date();
					Calendar cal = new GregorianCalendar();
					cal.setTime(today);
					cal.add(Calendar.DAY_OF_MONTH, -30);
					Date start = cal.getTime();
					LocalDate d = java.time.LocalDate.now();
				    Date end=	Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
					List<ProductSell> all = productselldao.getAllbyweek(start,end);
					
					for(int j=0;j<all.size();j++)
					{
						totalprice+=all.get(j).getpPrice();
					}
					
					return totalprice;
				}
				
				
				// Per Yearly Sell
				@GetMapping("/yearlysell")
				public long getYearlySell(){
					
					long totalprice=0;
					
					Date today = new Date();
					Calendar cal = new GregorianCalendar();
					cal.setTime(today);
					cal.add(Calendar.DAY_OF_MONTH, -365);
					Date start = cal.getTime();
					LocalDate d = java.time.LocalDate.now();
				    Date end=	Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
					List<ProductSell> all = productselldao.getAllbyweek(start,end);
					
					for(int j=0;j<all.size();j++)
					{
						totalprice+=all.get(j).getpPrice();
					}
					
					return totalprice;
				}
	
				
				
				
				
				
	
}
