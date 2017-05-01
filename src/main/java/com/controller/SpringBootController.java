/**
 * 
 */
package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.User;
import com.domain.UserPhones;
import com.domain.UserRole;
import com.model.UserInfo;
import com.service.UserService;

/**
 * @author MD AZAR
 *
 */
@RestController
public class SpringBootController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/health",method=RequestMethod.GET)
	public String test()
	{
		return "I am up and running";
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getUser()
	{
		//System.out.println("Hello World");
		return userService.findAll();
	}
	
	@RequestMapping(value="/createUser",method=RequestMethod.POST)
	public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userInfo)
	{
		User user = new User();
		UserRole userRole= new UserRole();
		UserPhones userPhones = new UserPhones();
		BeanUtils.copyProperties(userInfo, user);
		userPhones.setUserPhoneCompany(userInfo.getUserPhoneCompany());
		userPhones.setUser(user);
		userRole.setUser(user);
		userRole.setRoleName(userInfo.getRole());
		user.setUserRole(userRole);
		//set the Role		
		
		//List of phone
		List<UserPhones>list = new ArrayList<UserPhones>();
		list.add(userPhones);
		user.setUserPhones(list);
		userService.saveUser(user);
		return new ResponseEntity<UserInfo>(HttpStatus.CREATED);
		
		
		
		
		
		

	}
	
	@RequestMapping(value="/deleteUser/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id" )String id)
	{
		userService.deleteUser(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	
	@RequestMapping(value="/addPhone",method=RequestMethod.POST)
	public ResponseEntity<?> addPhone(@RequestBody UserInfo userInfo)
	{
		User user = new User();
		UserPhones userPhones = new UserPhones();
		BeanUtils.copyProperties(userInfo, user);
		userPhones.setUserPhoneCompany(userInfo.getUserPhoneCompany());
		userPhones.setUser(user);
		
		//List of phone
		List<UserPhones>list = new ArrayList<UserPhones>();
		list.add(userPhones);
		user.setUserPhones(list);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	@RequestMapping(value = "/pdf", method = RequestMethod.POST, produces = "application/pdf")
	 public ResponseEntity<InputStreamResource> download() throws IOException {
		String fileName="report.pdf";
	  System.out.println("Calling Download:- " + fileName);
	  ClassPathResource pdfFile = new ClassPathResource("Download/"+fileName);
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.parseMediaType("application/pdf"));
	  //headers.add("Access-Control-Allow-Origin", "*");
	  //headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
	  headers.add("Access-Control-Allow-Headers", "Content-Type");
	  headers.add("Content-Disposition", "filename=" + fileName);
	  headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	  headers.add("Pragma", "no-cache");
	  headers.add("Expires", "0");

	  headers.setContentLength(pdfFile.contentLength());
	  ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
	    new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
	  return response;

	 }

}
