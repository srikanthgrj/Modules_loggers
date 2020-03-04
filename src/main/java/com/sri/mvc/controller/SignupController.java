package com.sri.mvc.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.mvc.DTO.ForgetPasswordDTO;
import com.sri.mvc.DTO.SignupDTO;
import com.sri.mvc.SignINDTO.SigninDTO;
import com.sri.mvc.service.SignupServiceIMPL;

@Component
@RequestMapping("/")
public class SignupController {
	private static  Logger logger = Logger.getLogger(SignupController.class);
			
			
			
	@Autowired
	private SignupServiceIMPL signupservice;
	
	public SignupController() {
		System.out.println("created "+this.getClass().getSimpleName());
	}
	@RequestMapping("/mess.do")
	public String log4mess() {
		logger.trace("getWelcome is executed!");
		logger.debug("getWelcome is executed!");
		logger.info("getWelcome is executed!");
		logger.warn("getWelcome is executed!");
		logger.error("getWelcome is executed!");
		logger.fatal("getWelcome is executed!");
		System.out.println("inside mess-------------");
		return "loggers";
	}
	@RequestMapping("/Signup.do")
	public String tosave(SignupDTO dtocontroller,ModelMap map) {
		try {
			System.out.println("invoked awardee save method in sign up");
			System.out.println(dtocontroller);
			logger.info(dtocontroller);
			map.addAttribute("name_name",dtocontroller.getUsername());
			map.addAttribute("email",dtocontroller.getEmail());
			map.addAttribute("mobil_num",dtocontroller.getMobnum());
			map.addAttribute("password",dtocontroller.getPwd());
			map.addAttribute("confirm_password",dtocontroller.getConpwd());
			
			boolean valid=this.signupservice.validateandsave(dtocontroller);
			if(valid) {
				ModelMap success=map.addAttribute("successmessage", "it is success to save");
			}else {
				ModelMap failure =map.addAttribute("failuremessage", "it is failed to save");
			}
			}catch(Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		
		return "Signup";
		
		
	}
	@RequestMapping("/Signin.do")
	public String tosignin(SigninDTO singindtocontroller ,ModelMap map) {
		try {
			System.out.println("invoked awardee save method in sign up");
			System.out.println(singindtocontroller);
			logger.info(singindtocontroller);
			
			
			boolean valid=this.signupservice.validateandsignin(singindtocontroller);
			if(valid) {
				ModelMap success=map.addAttribute("successmessage", "it is success to save");
				return "Aftersignin";
			}else {
				ModelMap failure =map.addAttribute("failuremessage", "it is failed to save");
				return"Signin.do";
			}
			}catch(Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		
		
		
		return "Signin.do";
		
		
	}
	@RequestMapping("/Forgotpwd.do")
	public String forgetpasswordupdate(ForgetPasswordDTO singindtocontroller ,ModelMap map) {
		try {
			System.out.println("invoked awardee save method in sign up");
			System.out.println(singindtocontroller);
			logger.info(singindtocontroller);
			
			
			boolean valid=this.signupservice.validateandchangepwd(singindtocontroller);
			if(valid) {
				ModelMap success=map.addAttribute("successmessage", "your password is : asdfghjkl");
				return "Aftersignin";
			}else {
				ModelMap failure =map.addAttribute("failuremessage", "process failed");
				return"Signin.do";
			}
			}catch(Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		
		
		
		
		return null;
		
		
		
	}
}
