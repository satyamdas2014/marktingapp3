package com.markting.services;

import java.util.List;

import com.markting.entities.Lead;



public interface LeadService {
 public void saveLeadInfo(Lead lead);

public List<Lead> getLeads();

public void deleteLead(long id);

public Lead getOneLead(long id);
	
	
}
