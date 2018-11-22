public class Date212 {
private int day, month, year;
public Date212(String date)
{
     /* Divide the strings into substring so that year,
         month and dates can be sepharated from the whole string 
            */
this(Integer.parseInt(date.substring(0,4)),
Integer.parseInt(date.substring(4,6)), Integer.parseInt(date.substring(6)));

}
// constractor to initialize
public Date212(int y, int m, int d)
{    /* To identify and varify leap year 
        and also validation february month.
            */
    boolean leap = (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    if(leap && d > 29 || !leap && d > 28)
throw new IllegalArgumentException("Invalid value");
    // general validation check for day and month.
if( m < 1 || m > 12 || d < 1 || d > 31)
throw new IllegalArgumentException("Invalid value");
    // these months can't have more then 30 days.
if(m==4 || m == 6 || m == 9 || m == 11 ){
			if(d>30){
				throw new IllegalArgumentException("Invalid value");
			}			
		} 

    year = y;
    month = m;
    day = d;
    }
    public int getDay()//getday method 
    {
    return day;
    }
    public int getMonth()//getmonth method
    {
    return month;
    }
    public int getYear()//getyear method
    {
    return year;
    }
    public String toString()// tostring method to return in a string formet
    {
    return year + "/" + String.format("%02d", month) + "/" + String.format("%02d", day);
    }
}
