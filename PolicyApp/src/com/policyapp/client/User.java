package com.policyapp.client;

import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.service.*;;

public class User {

	public static void main(String[] args) throws IdNotFoundException {
		IPolicyService policyService=new PolicyServiceImpl();
		System.out.println("Get all");
		policyService.getAll().forEach(System.out::println);
		try {
			System.out.println("By type");
			policyService.getByType("term").forEach(System.out::println);

			System.out.println("By category");
			policyService.getByCategory("general").forEach(System.out::println);
			
			System.out.println("By SumAssured");
			policyService.getByHighSumAssured(20000.0).forEach(System.out::println);
			
			System.out.println("By Coverage");
			policyService.getByCoverage("Marrauge").forEach(System.out::println);
			
			

			System.out.println("By Premium");
			policyService.getByLessPremium(2000).forEach(System.out::println);
			
			
			System.out.println("By Id");
			System.out.println(policyService.getById(1001));
			
			
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
