package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.service.*;

public class VoterMain {

	public static void main(String[] args) {
		IEclectionBooth electricBooth=new ElectionBoothImpl();
		System.out.println("WELCOME TO VOTERBOOTH");
		Scanner sc=new Scanner(System.in); 
		
		System.out.print("Enter your Age:");
		int age=sc.nextInt();
		
		System.out.print("Enter your Locality:");
		String locality=sc.next();
		
		System.out.print("Enter your 4 digit Voter_id:");
		int voterId=sc.nextInt();
		try {
			if(electricBooth.checkEligibility(age, locality, voterId)) {
				System.out.println("You are Eligible to vote");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
