package com.raj.controller;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = { "com.raj.controller" })
public class GlobalControllerAdvice {
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute
	public void globalAttributes(Model model) {
		model.addAttribute("msg", "Welcome to My World!");
	}

	@ExceptionHandler(FileNotFoundException.class)
	public ModelAndView myError(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.setViewName("error");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView myException(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.setViewName("error");
		return mav;
	}
}