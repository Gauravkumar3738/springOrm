package com.gaurav.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gaurav.spring.dto.UserDTO;
import com.gaurav.spring.service.RegistrationService;


@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;


	@PostMapping("/reg.do")
	public ModelAndView registerUser(@ModelAttribute UserDTO userDTO) {

		boolean operationStatus = registrationService.register(userDTO);
		String status = null;
		if (operationStatus) {
			status = "save operation for user was successful for user " + userDTO.getUsername();
		}
		else {
			status = "save operation for user was not successful. Please try again";
		}
		return new ModelAndView("success.jsp", "operationStatus", status);
	}
}
