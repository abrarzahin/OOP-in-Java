import java.lang.*;
import java.util.*;
public class Date212{

	private int year,day,month;
	
	private String original;
	// function to check date validation
	private boolean validateString(String s){
		//to check if it is null
		if(s==null) return false; 
		if(s.length()!=8) return false;
		for(int i=0; i<s.length();i++){
			char c = s.charAt(i);
			// to check if it is not number
			if(!('0' <= c && c <= '9')){
				return false; 
			}
		}
		month = Integer.parseInt(s.substring(4,6));
		day = Integer.parseInt(s.substring(6,s.length()));
		// // these months can't have more then 31 days.
		if(month==1 || month == 3 
			|| month == 5 || month == 7 
			|| month == 8 || month == 10
			|| month == 12){
			if(day>31){
				return false;
			}			
		}
		//february can not have more then 28 days
		else if(month == 2){
			if(day>28){
				return false;
			}
		}
		// others months can not have more then 30 days 
		else{
			if(day>30){
				return false;
			}
		}
		return true;
	}
	// constractor to initialize
	public Date212(String s) throws Date212Exception{
		if(!validateString(s)){
			throw new Date212Exception("Invalid date:"+s);
		}
		original = s;
		/* Divide the strings into substring so that year,
         month and dates can be sepharated from the whole string 
            */
		year = Integer.parseInt(s.substring(0,4));
		month = Integer.parseInt(s.substring(4,6));
		day = Integer.parseInt(s.substring(6,s.length()));

	}

	public String getOriginal(){
		// returns original string 
		return original;
	}

	public String toString()// tostring method to return in a string formet
    {
    return year + "/" + String.format("%02d", month) + "/" + String.format("%02d", day);
    }

	public int compareTo(Date212 d){
		// compare to method  to compare between two values 
		return this.original.compareTo(d.original);
	}
	public boolean equals(Date212 d){
		// to check if they are equals
		return this.original.equals(d.original);
	}
	
}