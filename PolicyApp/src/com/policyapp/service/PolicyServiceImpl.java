 package com.policyapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {
	IPolicyDAO policyDAO= new PolicyDAOImpl();
	@Override
	public List<Policy> getAll() {
			List<Policy>  policies=policyDAO.findAll();
			List<Policy> policyList=policies
					.stream().sorted((Policy p1,Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
					.collect(Collectors.toList());
			return policyList;
			
		 
	}
	
	

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		
		List<Policy>  policies=policyDAO.findByType(type);
		List<Policy> policyList=policies
				.stream()
				
				.sorted((Policy p1,Policy p2)->p1.getType().compareTo(p2.getType()))
				.collect(Collectors.toList());
		
		if(policyList!=null) {
		return policyList;	
		
	}
		
			throw new PolicyNotFoundException("Policy Not FoundException");

	}
	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		
		List<Policy>  policies=policyDAO.findByCategory(category);
		List<Policy> policyList=policies
				.stream()
				
				.sorted((Policy p1,Policy p2)->p1.getCateogry().compareTo(p2.getCateogry()))
				.collect(Collectors.toList());
		
		if(policyList!=null) {
		return policyList;	
		
	}
		
			throw new PolicyNotFoundException("Policy Not FoundException");

	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		
		List<Policy>  policies=policyDAO.findByHighSumAssured(sumAssured);
		List<Policy> policyList=policies
				.stream()
				.sorted((Policy p1,Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))

				.collect(Collectors.toList());
		
		if(policyList!=null) {
		return policyList;	
		
	}
		
			throw new PolicyNotFoundException("Policy Not FoundException");
		
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy>  policies=policyDAO.findByCoverage(coverage);
		List<Policy> policyList=policies
		.stream()
		.sorted((Policy p1,Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))

		.collect(Collectors.toList());

		if(policyList!=null) {
			return policyList;	

}

	throw new PolicyNotFoundException("Policy Not FoundException");

		
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws  PolicyNotFoundException {
		List<Policy>  policies=policyDAO.findByLessPremium(premium);
		List<Policy> policyList=policies
				.stream()
				
				.sorted((Policy p1,Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		
		if(policyList!=null) {
		return policyList;	
		
	}
		
			throw new PolicyNotFoundException("Policy Not FoundException");

	}
	







	public Policy getById(int policyId) throws IdNotFoundException{
		Policy policy=policyDAO.findById(policyId);
		if(policy==null) {
		 throw new IdNotFoundException("id not foun exception");	
		
	}
		
		return policy;	
	}



	
	
	
}
