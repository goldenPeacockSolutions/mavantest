package com.society.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.society.model.BillHead;
import com.society.model.Society;
import com.society.service.BillHeadService;
import com.society.service.SocietyService;

@Controller
public class LoginController {
	
	@Autowired
	private SocietyService societyService;
	
	@Autowired
	private BillHeadService billHeadService;

	/*@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}*/
	
	
	@RequestMapping(value= {"/","/registration"}, method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Society society = new Society();
		modelAndView.addObject("society", society);
		List<Society> societies = societyService.listAllSocieties();
		modelAndView.addObject("societies", societies);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Society society, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Society societyExists =societyService.findSocietyByName(society.getName());
		if (societyExists != null) {
			bindingResult
					.rejectValue("name", "error.society",
							"There is already a society registered with the name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			societyService.saveSociety(society);
			modelAndView.addObject("successMessage", "Society has been registered successfully");
			modelAndView.addObject("society", new Society());
			List<Society> societies = societyService.listAllSocieties();
			modelAndView.addObject("societies", societies);
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam("name") String name){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//User user = userService.findUserByEmail(auth.getName());
		//modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		/*Society society = societyService.findSocietyByName(auth.getName());*/
		Society society = societyService.findSocietyByName(name);
		modelAndView.addObject("name", "Welcome " + society.getName());
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addbillhead", method = RequestMethod.GET)
	public ModelAndView addbillhead(){
		ModelAndView modelAndView = new ModelAndView();
		BillHead billHead = new BillHead();
		modelAndView.addObject("billHead", billHead);
		List<BillHead> billHeads = billHeadService.listAllBillHeads();
		modelAndView.addObject("billHeads", billHeads);
		modelAndView.setViewName("billHeadView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addbillhead", method = RequestMethod.POST)
	public ModelAndView viewbillhead(@Valid BillHead billHead, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		BillHead billHeadExists =billHeadService.findBillHead(billHead.getName());
		if (billHeadExists != null) {
			bindingResult
					.rejectValue("name", "error.billHead",
							"There is already a bill head registered with the name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("billHeadView");
		} else {
			billHeadService.saveBillHead(billHead);
			modelAndView.addObject("successMessage", "BillHead has been registered successfully");
			modelAndView.addObject("billHead", new BillHead());
			List<BillHead> billHeads = billHeadService.listAllBillHeads();
			modelAndView.addObject("billHeads", billHeads);
			modelAndView.setViewName("billHeadView");
			
		}
		return modelAndView;
	}
	

}
