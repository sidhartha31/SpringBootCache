package com.sidharth.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

	@Autowired
	private CacheService cacheService;
	
	@GetMapping("/exchangerate/{from}/{to}")
	public String getExchangeRate(@PathVariable("from") String from, @PathVariable("to") String to) {
		
		int rate = cacheService.getConversionRate(from, to);
		return "Exchange Rate: "+rate;
	}
}
