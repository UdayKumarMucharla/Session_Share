package com.kgfsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserService userService;
	
	@Autowired
	public void setService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/fetchById/{id}",method = RequestMethod.GET)
	public UserModel getuserById(@PathVariable(value = "id") int id) {

		UserModel user = userService.fetchByuserId(id);

		return user;
	}
	
	@RequestMapping(value = "/fetchByEmail/{Email}/email",method = RequestMethod.GET)
	public UserModel getuserByEmail(@PathVariable(value = "Email") String Email) {

		UserModel user = userService.fetchByuserEmail(Email);

		return user;
	}
	
	
	@RequestMapping(value = "/Login/{Email}/{password}",method = RequestMethod.GET)
	public boolean Login(@PathVariable(value = "Email") String Email,@PathVariable(value = "password") String Password) {

		UserModel user = userService.fetchByuserEmail(Email);
		
		if(user.getPassword().matches(Password)){
			
			return true;
		}
		else{

			return false;
		}
	}
	
	@RequestMapping(value = "/delete/{Id}",method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "Id") int Id) {

	 userService.deleteById(Id);

	
	}
	
	@RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
	public List<UserModel> getAllUsers() {

		List<UserModel> list = userService.fetchAll();

		return list;

	}
	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String getSample() {

	

		return "redirect:/UserModel.html";

	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody UserModel user) {
	UserModel isUser = userService.fetchByuserEmail(user.getEmail());
		if(isUser == null){
		userService.save(user);
		return "Success";
		}
		else{
			return "Failed";
		}

	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody UserModel user) {
	
		if(user.getId() > 0)	 
		userService.updateUser(user);
	}
	@RequestMapping(value= "/updateTable/{column}/{dataType}")
	public void updateTable(@PathVariable(value="column") String column,@PathVariable(value="dataType") String dataType){
		userService.updateTable(column,dataType);
	}
	
}
