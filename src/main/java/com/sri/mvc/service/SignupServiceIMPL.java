package com.sri.mvc.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.mvc.DAO.SignupDAO;
import com.sri.mvc.DTO.ForgetPasswordDTO;
import com.sri.mvc.DTO.SignupDTO;
import com.sri.mvc.Entity.SignuEntity;
import com.sri.mvc.SignINDTO.SigninDTO;

@Service
public class SignupServiceIMPL implements SignUPServic {
	private static  Logger logger = Logger.getLogger(SignupServiceIMPL.class);
	@Autowired
	private SignupDAO signupDAO;

	public SignupServiceIMPL() {
		System.out.println("created " + this.getClass().getSimpleName());
		logger.info("created"+this.getClass().getSimpleName());
	}

	public boolean validateandsave(SignupDTO dtoservice) {

		boolean valid = false;
		try {
			System.out.println("invoked validate & save  " + dtoservice);
			
			if (Objects.nonNull(dtoservice)) {
				System.out.println("its true saving");
				logger.info("its true saving");
				System.out.println("started service with validation");
				logger.info("started service with validation");
				String email = dtoservice.getEmail();
				if (email != null && !email.isEmpty() && email.length() >= 5 && email.contains(".com")) {
					System.out.println("email is valid");
					logger.info("email is valid");
					valid = true;
				} else {
					System.out.println("email is invalid");
					logger.info("email is invalidvalid");
					if (email == null) {
						System.out.println("email is null");
						logger.info("email is null");
					}
					if (email != null && email.length() >= 5) {
						System.out.println("email length is less than 5");
						logger.info("email is less than 5");
					}

					if (email != null && email.contains(".com")) {
						System.out.println("not valid mail id");
						logger.info("not valid mail id");
					}
					valid = false;
				}
				String password = dtoservice.getPwd();
				String conformpassword = dtoservice.getConpwd();
				if (valid && password != null && !password.isEmpty() && password.length() >= 8
						&& conformpassword.equals(password)) {
					System.out.println("password is valid");
					logger.info("password is valid");
					valid = true;
				} else {
					System.out.println("password name is invalid");
					logger.info("password is invalid");
					if (password == null) {
						System.out.println("password name is null");
						logger.info("password is null");
					}
					if (password != null && password.length() < 8) {
						System.out.println("password length is less than 8");
						logger.info("password length is not valid");
					}
					if (password != null && !password.equals(conformpassword)) {
						System.out.println("password is not matching");
						logger.info("password is not matching");
					}
					valid = false;
				}

				long mobilnum = dtoservice.getMobnum();
				String mobnum = Long.toString(mobilnum);
				if (valid && mobnum != null && !mobnum.isEmpty() && mobnum.length()==10) {
					System.out.println("mobil number is is valid");
					logger.info("mobil number  is valid");
					valid = true;
				} else {
					System.out.println("mobil number  is invalid");
					logger.info("mobil number is invalid");
					if (password == null) {
						System.out.println("mobil number  is null");
						logger.info("mobil number is null");
					}
					if (password.length() != 10) {
						System.out.println("mobil number  is not equals 10");
						logger.info("mobil number is not equals to 10");
					}
					valid = false;

				}
			}
			if (valid) {
				System.out.println("data is valid can continue");
				logger.info("data is valid can continue");
				SignuEntity signuEntity = new SignuEntity();
				BeanUtils.copyProperties(dtoservice, signuEntity);
				SignuEntity serviceentity = signupDAO.fetch(dtoservice.getEmail());
				if (serviceentity == null) {
					System.out.println("entity is " + signuEntity);
					logger.info("entity is "+ signuEntity);
					signupDAO.save(signuEntity);
					
					System.out.println("data saved");
					logger.info("data saved");
				} else {
					System.out.println("mail id already exist");
					logger.info("mail already exist");
					valid = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		return false;
	}

	public boolean validateandsignin(SigninDTO signinDTO) {
		boolean valid = false;
		try {
			System.out.println("data is valid can continue");
			logger.info("data is valid can continue");
			SignuEntity serviceentity = signupDAO.fetchbymailandpassword(signinDTO.getSigninemail(),
					signinDTO.getSinginpwd());
			if (serviceentity != null) {
				System.out.println("user available");
				logger.info("user is available");
				//GENERATE 
				//update of password
				valid= true;
			} else {
				System.out.println("no user found");
				logger.info("no user found");
				valid= false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return valid;
	}

	

	public boolean validateandchangepwd(ForgetPasswordDTO forgetpwddto) {
		try {
			System.out.println("data is valid can continue");
			logger.info("data is alid can continue");
			SignuEntity signuEntity = new SignuEntity();
			//BeanUtils.copyProperties(forgetpwddto, signuEntity);
			if(forgetpwddto.getEmail()!=null) {
				String serviceentity = signupDAO.updatepassword(forgetpwddto.getEmail(),signuEntity.getPwd() );
			
				signuEntity.setPwd("asdfghjkl");
				System.out.println("new password is "+signuEntity.getPwd());
				logger.info("new password is "+signuEntity.getPwd());
				System.out.println("password changed");
				logger.info("password changed");
				return true;
			}else {
				System.out.println("insert mail id ");
				logger.info("insert mail id");
				return false;
			}
			
			
		}catch(Exception e) {e.printStackTrace();logger.error(e);}
		return false;
		
	}

}
