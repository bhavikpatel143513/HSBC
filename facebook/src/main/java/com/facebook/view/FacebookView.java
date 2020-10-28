package com.facebook.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;

public class FacebookView {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		FacebookControllerInterface fc = FacebookController.createObject();
		int inputValue = 0;
		
		do {
			System.out.println();
			System.out.println("******************MAIN MENU*****************");
			System.out.println("Press 1 to Create Profile");
			System.out.println("Press 2 to View Profile");
			System.out.println("Press 3 to Delete Profile");
			System.out.println("Press 4 to View All Profile");
			System.out.println("Press 5 to Search Profile");
			System.out.println("Press 6 to Edit Profile");
			System.out.println("Press 7 to Exit");
			
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String input = br.readLine();
				inputValue = Integer.parseInt(input);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Please enter correct value!!");
				continue;
			}
			
			
			
			switch(inputValue) {
				case 1:
					fc.createProfile();
					break;
				case 2:
					fc.viewProfile();
					break;
				case 3:
					fc.deleteProfile();
					break;
				case 4:
					fc.viewAllProfile();
					break;
				case 5:
					fc.searchProfile();
					break;
				case 6:
					fc.editProfile();
					break;
				case 7:
					System.out.println("Thank You !!");
					break;
				default: System.out.println("Invalid option");
			}
		}while(inputValue != 7);

	}

}
