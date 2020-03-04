package com.sri.mvc.DTO;

import org.apache.log4j.Logger;

import com.sri.mvc.DAO.SignupDAOImpl;

public class ForgetPasswordDTO {
	private static  Logger logger = Logger.getLogger(SignupDAOImpl.class);
	private String email;
	public ForgetPasswordDTO() {
		System.out.println("created password dto");
		logger.info("created password DTO");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ForgetPasswordDTO(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ForgetPassword [email=" + email + "]";
	}
}
