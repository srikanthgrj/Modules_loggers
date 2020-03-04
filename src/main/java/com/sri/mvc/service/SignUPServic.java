package com.sri.mvc.service;

import com.sri.mvc.DTO.ForgetPasswordDTO;
import com.sri.mvc.DTO.SignupDTO;
import com.sri.mvc.SignINDTO.SigninDTO;

public interface SignUPServic {
	public boolean validateandsave(SignupDTO dtoservice);
	public boolean validateandsignin(SigninDTO signinservice);
	public boolean validateandchangepwd(ForgetPasswordDTO forgetpwddto);
	
}
