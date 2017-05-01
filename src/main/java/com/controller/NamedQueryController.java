/**
 * 
 *//*
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.NamedQueryTest;
import com.repository.NamedQueryBase;
import com.repository.custom.NamedQuery;

*//**
 * @author MD AZAR
 *
 *//*
@RestController
public class NamedQueryController {
	
	@Autowired
	private NamedQuery namedQuery;
	
	@Autowired
	private NamedQueryBase namedQueryBase;
	
	@RequestMapping(value="/saveData/{movie}",method=RequestMethod.POST)
	public ResponseEntity<?> saveData(@PathVariable("movie") String movie,@PathVariable("id")String userId)
	
	{
		NamedQueryTest namedQueryTest = new NamedQueryTest();
		namedQueryTest.setMovie(movie);
		namedQueryTest.setUserId(userId);
		namedQueryBase.save(namedQueryTest);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
				
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Object[]> getAll(@PathVariable("movie") String movie,@PathVariable("id")String userId)
	
	{
		return namedQuery.findallData();
	
				
	}

}
*/