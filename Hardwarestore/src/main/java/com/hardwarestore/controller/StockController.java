package com.hardwarestore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardwarestore.dao.HProductDao;
import com.hardwarestore.dao.ProductSellDao;
import com.hardwarestore.dao.ProductunitDao;
import com.hardwarestore.entity.HProduct;
import com.hardwarestore.entity.ProductUnit;
import com.hardwarestore.entity.Stock;
import com.hardwarestore.entity.StockUnit;

@CrossOrigin (origins="*",allowedHeaders="*")
@RestController
public class StockController {
	
	@Autowired HProductDao productdao;
	@Autowired ProductunitDao productunitdao;
	@Autowired ProductSellDao productselldao;
	
	@GetMapping("/getstocks")
	public List<Stock> getallstock()
	{
		List<Stock> st = new ArrayList<Stock>();
		
		List<HProduct> allp = productdao.getAll();
		for(int i=0;i<allp.size();i++) {
			
			List<ProductUnit> pu = productunitdao.getByPuniqueIds(allp.get(i).getpUniqueId());
			for(int j=0;j<pu.size();j++)
			{
				Stock s = new Stock();
				s.setpUniqueId(pu.get(j).getpUniqueId());
				s.setpName(allp.get(i).getpName());
				s.setpCategory(allp.get(i).getpCategory());
			
				StockUnit su = new StockUnit();
				su.setpBaseQuantity(pu.get(j).getpActualQuantity());
				su.setpQuantity(pu.get(j).getpQuantity());
				su.setpUnit(pu.get(j).getpUnit());
				/// Percentage calculator
				
				long p = pu.get(j).getpQuantity()*100/pu.get(j).getpActualQuantity();
				String percentage= Long.toString(p);
				su.setPercentage(percentage);
				
				List<StockUnit> ss = new ArrayList<StockUnit>();
				ss.add(su);
				s.setStockunit(ss);
				st.add(s);
			}
		}
		
		
		return st;
		
		
	}

}
