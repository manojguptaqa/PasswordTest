package PasswordMethods;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.text.similarity.JaccardDistance;
public class PasswordImpl {

	
	public static final int MIN_PASSWORD_LENGTH = 18;
	public static final List<Character> VALID_CHAR= Arrays.asList('!','@','#','$','&','*');
	public static final int SPECIAL_CHAR_MIN_RANGE= 1;
	public static final int UPPEARCASE_CHAR_MIN_RANGE= 1;
	public static final int LOWERCASE_CHAR_MIN_RANGE= 1;
	public static final int NUMBER_MIN_RANGE= 1;
	public static final int VALID_REPEAT_CHAR= 4;
	public static final int SPECIAL_CHAR_MAX_RANGE= 4;

//	1.	At least 18 alphanumeric characters and list of special chars !@#$&*
//	2.	At least 1 Upper case, 1 lower case ,least 1 numeric, 1 special character
//	3.	No duplicate repeat characters more than 4
//	4.	No more than 4 special characters
//	5.	50 % of password should not be a number
	
	
	public static boolean is_Valid_Password(String password) {

        if (password.length() < MIN_PASSWORD_LENGTH) 
        {
        	ExtentManager.getCurrentTest().get().info("Password length is less than 18");
        	return false;
        }
        int UpperCasecharCount = 0;
        int LowerCasecharCount = 0;
        int numCount = 0;
        int specialCharCount = 0;
        int max_Numeric_length=(password.length())/2;
        
       int counter=0;
        char nextChar=' ';
        
		for (int i = 0; i < password.length(); i++) {

			char ch = password.charAt(i);
//			Agoda@aaaa1MF12acssad!
			
			if (i < password.length() - 1) {
				nextChar = password.charAt(i + 1);
				if(counter>VALID_REPEAT_CHAR)
				{
					ExtentManager.getCurrentTest().get().info("Same character repaeted more than 4 times.");
					return false;	
				}
				else if (ch == nextChar) {
					counter++;
				} else if (ch != nextChar && counter<VALID_REPEAT_CHAR) {
					counter = 0;

				}
			}
			
			if (is_Numeric(ch)) numCount++;
			else if (is_UpperCaseChar(ch)) UpperCasecharCount++;
			else if (is_LowerCaseChar(ch)) LowerCasecharCount++;
			else if (is_SpecialCharCountChar(ch)) specialCharCount++;
			else return false;
		}

	//	System.out.println(counter);

        return (UpperCasecharCount >= UPPEARCASE_CHAR_MIN_RANGE 
        		&& LowerCasecharCount >= LOWERCASE_CHAR_MIN_RANGE
        		&& numCount>=NUMBER_MIN_RANGE 
        		&& specialCharCount>=SPECIAL_CHAR_MIN_RANGE
        		&& specialCharCount<=SPECIAL_CHAR_MAX_RANGE 
        		&& numCount<max_Numeric_length
                && counter<VALID_REPEAT_CHAR-1); // Agoddddda  valid_occurrence-1;
    }
	
	private static boolean passwordPercentageMatch(String old_password,String new_password)
	{
		double jaccardDistance = new JaccardDistance().apply(old_password, new_password);
		
		//System.out.println((int)(1 - jaccardDistance) * 100);
		
		if((int)(1 - jaccardDistance) * 100<80)
		{
			ExtentManager.getCurrentTest().get().info("Old and new password match % less than 80%");
			return true;
		}
		else
		{ExtentManager.getCurrentTest().get().info("Old and new password match % more than 80%");
			return false;
		}
		
	}
	
	public static boolean changePassword(String old_password,String new_password,boolean oldPasswordMatched)
	{
		if(old_password.length()<1 || new_password.length()<1)
			return false;
		else if(!oldPasswordMatched)
		{
			ExtentManager.getCurrentTest().get().info("Old password did not match");
			return false;
		}
		else
			return is_Valid_Password(new_password) && passwordPercentageMatch(old_password, new_password);
		
		
	}

    private static boolean is_SpecialCharCountChar(char ch) {
    	
    	boolean result=VALID_CHAR.contains(ch);
    	ExtentManager.getCurrentTest().get().info("Special characters count acceptable: "+result);
    	return result;
	}

  

    private static boolean is_LowerCaseChar(char ch) {
		 return (ch >= 'a' && ch <= 'z');
	}


	private static boolean is_UpperCaseChar(char ch) {
		 return (ch >= 'A' && ch <= 'Z');
	}





    private static boolean is_Numeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }
    


}

