public class Date212

{

     int year, month, day;
     public Date212(String date)

     {     /* Divide the strings into substring so that year,
         month and dates can be sepharated from the whole string 
            */
          year = Integer.parseInt(date.substring(0, 4));
          month = Integer.parseInt(date.substring(4, 6));
          day = Integer.parseInt(date.substring(6));

     }
     //Defining  isValid() function 
     public boolean isValid(String date)

     {
          return(validDate(date));
     }
     /* Defining a function valid Date to check all the validation
     for Month and Date.
    */
     private boolean validDate(String date)

     {
         //To check there is lenth of the string
            if(date.length() > 8)
      {
               return false;
       }
        /* To identify and varify leap year 
        and also validation february month.
            */
        boolean leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
            if(leap && day > 29 || !leap && day > 28){
              return false;
             }

         //to check the validation of month
             if(month < 1 || month > 12)
            {
            return false;
            }
          //To check if the date is valid
          if(day < 1 || day > 31)
          {
               return false;
         }
         if(month==4 || month == 6 || month == 9 || month == 11 ){
		  	if(day>30){
				return false;
		  	}			
	    	} 

       //if none of the invalid condition applies then return true.
            
        return true;
            
     }


        // Getter functions for day,month and year.
         public int getDay()
         {
              return day;
        }
         public int getmonthth()
         {
          return month;
        }
      public int getYear()
     {
        return year;
     }
     //ToString methods defined here.
     public String toString()

     {
          return year + "/" + String.format("%02d", month) + "/" + String.format("%02d", day);
     }
     //Here is the Compare To method.

     public int compareTo(Date212 other)
     {
       //To compare both years .
          if(this.year < other.year)
          {
               return -1;
          }
          else if(this.year > other.year)
          {
               return 1;
          }
             //It will compare months if the years are same.
              else
             {
               if(this.month < other.month)
               {
                    return -1;
               }
                   else if(this.month > other.month)
               {
                     return 1;
               }
               //Compare days if year and month both are same.
               else
               {
                     if(this.day < other.day)
                     {
                          return -1;
                     }
                    else if(this.day > other.day)
                     {
                          return 1;
                    }
                 }
             }
          //It will return 0 if all are equal.
          return 0;

     }

}