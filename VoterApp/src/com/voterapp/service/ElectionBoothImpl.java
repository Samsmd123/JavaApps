package com.voterapp.service;


import com.voterapp.exception.*;

public class ElectionBoothImpl implements IEclectionBooth{
	
	String[] localities= {"RTNagar","MGRoad","Sadashivnagar","jcNagar","Frezertown","Bensontown"};

	@Override
	public boolean checkEligibility(int age, String locality, int vid) throws InValidVoterException {
		try {
			checkAge(age);
			checkLocality(locality);
			checkVoterId(vid);
		}catch(InValidVoterException e) {
			throw e;}
		
		return true;
	}
	private boolean checkAge(int age)throws UnderAgeException{
		
		if(age<18) {
			throw new UnderAgeException("You are under age to vote");
		}
		return true;
		
	}
	
	private boolean checkLocality(String lo)throws LocalityNotFoundException{
		for(String localati:localities) {
			if(lo.equalsIgnoreCase(localati)) {
				return true;
			}
				
		}throw new LocalityNotFoundException("Locality of voter not found");
			
		
		
	}
	private boolean checkVoterId(int vid)throws NoVoterIDException{
		if(vid<1000 || vid>9999) {
			throw new NoVoterIDException("Invalid voter id");
		}
		return true;
		
	}

}
