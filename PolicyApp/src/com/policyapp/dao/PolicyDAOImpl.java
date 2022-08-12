package com.policyapp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.policyapp.exception.*;
import com.policyapp.model.*;

public class PolicyDAOImpl  implements IPolicyDAO{

	@Override
	public List<Policy> findAll() {
		// TODO Auto-generated method stub
		return showAllPolicies() ;
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		
		
		
		return showAllPolicies().stream().filter(policies->policies.getType().equalsIgnoreCase(type)).collect(Collectors.toList()) ; 
	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllPolicies().stream().filter(policies->policies.getCateogry().equalsIgnoreCase(category)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		
		return showAllPolicies().stream().filter(policies->policies.getSumAssured()==sumAssured).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllPolicies().stream().filter(policies->policies.getCoverage().equalsIgnoreCase(coverage)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws  PolicyNotFoundException{
		
		return showAllPolicies().stream().filter(policies->policies.getPremium()==premium).collect(Collectors.toList());
	}

	@Override
	public Policy findById(int policyId) {
		Optional<Policy>policy =showAllPolicies().stream().filter((p)->p.getPolicyNumber()==(policyId)).findFirst();
		if(policy.isPresent()) {
		return policy.get();
		}
	return null;
}
private List<Policy> showAllPolicies(){
		
		return Arrays.asList(new Policy("JeevanAnand",1001,2000,"endownment",10,"life","general",20000),
				new Policy("Life saral",1002,2000,"single",40,"pension","retirement",29000),
				new Policy("Jeevan Sathi",1003,8000,"term",10,"Marrauge","general",120000),
				new Policy("Bajaj Allianz",1004,2000,"endownment",20,"accidents","motor",320000),
				new Policy("TataAlliannz",1005,9000,"term",40,"Sickness","health",260000),
				new Policy("ClickToProtect",1006,6000,"ultp",60,"Sickness","health",67000)
				);
	}


}
