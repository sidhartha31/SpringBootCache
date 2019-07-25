package com.sidharth.caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	@Cacheable("conversionrate")
	public int getConversionRate(String from, String to) {
		
		System.out.println("In Service Method.. Returning Conversion Rate for "+from+" to "+to);
		return 10;
	}
	
	@CacheEvict(value = "conversionrate", allEntries = true)
	@Scheduled(fixedDelay = 10000)
	public void clearCache() {
		System.out.println("Clearing 'conversionrate' Cache..");
	}
}
