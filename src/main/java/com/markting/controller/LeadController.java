package com.markting.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.markting.dto.LeadData;
import com.markting.entities.Lead;
import com.markting.services.LeadService;
import com.markting.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadservice;

	@Autowired
	private EmailService emailService;

	@RequestMapping("/create")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveoneLead(@ModelAttribute("l") Lead lead, ModelMap model) {
		leadservice.saveLeadInfo(lead);
		emailService.sendEmail(lead.getEmail(), "welcome to psa", "test email from spring boot");
		model.addAttribute("msg", "record id saved!!");
		return "create_lead";
	}

//@RequestMapping("/saveLead")
//public String saveoneLead(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName, @RequestParam("email")String email, @RequestParam("mobile")String mobile, ModelMap model) {
	//Lead lead = new Lead();
	//lead.setFirstName(firstName);
//	lead.setLastName(lastName);
	//lead.setEmail(email);
	//lead.setMobile(mobile);
	
	//leadservice.saveLeadInfo(lead);
	//model.addAttribute("msg", "record id saved!!");
	//return "create_lead";
//}
//	@RequestMapping("/saveLead")
	//public String saveoneLead(LeadData leadData, ModelMap model) {
		//Lead lead = new Lead();
		//lead.setFirstName(leadData.getFirstName());
		//lead.setLastName(leadData.getLastName());
		//lead.setEmail(leadData.getEmail());
		//lead.setMobile(leadData.getMobile());
		//leadservice.saveLeadInfo(lead);
		
		//model.addAttribute("msg", "record id saved!!");
		//return "create_lead";
	//}	
	
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
	List<Lead> leads = leadservice.getLeads();
	model.addAttribute("leads" , leads);
	return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, Model model) {
		leadservice.deleteLead(id);
		List<Lead> leads = leadservice.getLeads();
		model.addAttribute("leads" , leads);
		return "list_leads";
	}
	
	@RequestMapping("/update")
	public String getLeadInfo(@RequestParam("id") long id, Model model) {
		Lead lead = leadservice.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}

	@RequestMapping("/updateLead")
	public String updateLeadInfo(LeadData data, Model model) {
		Lead l = new Lead();
		l.setId(data.getId());
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		
		leadservice.saveLeadInfo(l);
		
		List<Lead> leads = leadservice.getLeads();
		model.addAttribute("lead" , leads);
		return "list_leads";

	}
}