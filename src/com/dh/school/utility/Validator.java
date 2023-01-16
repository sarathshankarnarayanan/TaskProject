package com.dh.school.utility;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validator {

	private static final Logger logger = LoggerFactory.getLogger(Validator.class);
	
	public int validInt() {
		logger.debug("Inside validInt method");
		Scanner scan = new Scanner(System.in);
		boolean isTrue=false;
		int value =0;
		while(isTrue == false)
		{
			String	stringInput = scan.nextLine();
			try {
					value = Integer.parseInt(stringInput);
					isTrue = true;
				}
					catch (Exception e)
					{	
						System.out.print("Please enter Number only:");
						logger.error(e.getMessage());
						
					}
		}
			return value ;
			
			
			
		
	}
}
