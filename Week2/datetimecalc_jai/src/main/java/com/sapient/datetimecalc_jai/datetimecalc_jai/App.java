package com.sapient.datetimecalc_jai.datetimecalc_jai;
import java.io.*;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.time.*;
import java.time.temporal.WeekFields;

@SpringBootApplication(proxyBeanMethods = false)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        int cc=1;
        boolean flag=true;
        Map<Integer, String> m = new LinkedHashMap<>();
        while(flag) {
        System.out.println("Date Time Calculator");

		System.out.println("1 - Difference between 2 dates");
		System.out.println("2 - Add, Subtract 'n' Days, Months, Weeks to the given date and derive the final date");
		System.out.println("3 - Determine the Day of the Week for a given date");
		System.out.println("4 - Determine the Week number for a given a date");
		System.out.println("5 - See the History of all operations performed/NLP phrase");
		System.out.println("6 - END");
		System.out.println("Please enter your option...");
		Scanner sc= new Scanner(System.in);
		int opt=sc.nextInt();

		
			
        switch (opt) {
		case 1:
			m.put(cc, "Difference between 2 dates");
			cc+=1;
			System.out.println("Please enter date1 in DD/MM/YYYY format");
			String date = sc.next();
	        String[] values = date.split("/");
	        int day1 = Integer.parseInt(values[0]);
	        int month1 = Integer.parseInt(values[1]);
	        int year1 = Integer.parseInt(values[2]);
			LocalDate date1  = LocalDate.of(year1, month1,day1);
			
			System.out.println("Please enter date2 in DD/MM/YYYY format");
			 date = sc.next();
	        String[] values2 = date.split("/");
	        int day2 = Integer.parseInt(values2[0]);
	        int month2 = Integer.parseInt(values2[1]);
	        int year2 = Integer.parseInt(values2[2]);
			LocalDate date2  = LocalDate.of(year2, month2,day2);
			
			Period diff = Period .between(date1,date2); 
			System.out.print( "Diff between  dates is: "+diff.getYears()+" yrs"+ 
		            diff.getMonths()+" months" 
		           + diff.getDays()+ " days"); 
			break;
		case 2:
			m.put(cc, "Add, Subtract 'n' Days, Months, Weeks to the given date and derive the final date");
			cc+=1;
			System.out.println("Please enter date in DD/MM/YYYY format");
			date = sc.next();
	        values = date.split("/");
	         day1 = Integer.parseInt(values[0]);
	         month1 = Integer.parseInt(values[1]);
	         year1 = Integer.parseInt(values[2]);
			 date1  = LocalDate.of(year1, month1,day1);
			System.out.println("option 1- add/sub days");
			System.out.println("option 2- add/sub months");
			System.out.println("option 3- add/sub weeks");
			System.out.println("ENTER OPTION");
			int option=sc.nextInt();
			switch (option) {
			case 1:
			System.out.println("enter days to add or subtract");
int aa=sc.nextInt();
			System.out.println("enter 1 for adding and 2 for subtracting");
			int a=sc.nextInt();
			if (a==1) {
				date1=date1.minusDays(-aa);

			}
			else {
				date1=date1.minusDays(aa);

			}
			System.out.println(date1);
			break;
			case 2:
				System.out.println("enter months to add or subtract");
				 aa=sc.nextInt();
							System.out.println("enter 1 for adding and 2 for subtracting");
							 a=sc.nextInt();
							if (a==1) {
								date1=date1.minusMonths(-aa);

							}
							else {
								date1=date1.minusMonths(aa);

							}
							System.out.println(date1);
				break;
			case 3:
				
				System.out.println("enter weeks to add or subtract");
				 aa=sc.nextInt();
							System.out.println("enter 1 for adding and 2 for subtracting");
							 a=sc.nextInt();
							if (a==1) {
								date1=date1.minusWeeks(-aa);

							}
							else {
								date1=date1.minusWeeks(aa);

							}
							System.out.println(date1);
			break;
			default:
				break;
			}

			break;
		case 3:
			m.put(cc, "Determine the Day of the Week for a given date");
			cc+=1;
			System.out.println("Please enter date in DD/MM/YYYY format");
			date = sc.next();
	        values = date.split("/");
	         day1 = Integer.parseInt(values[0]);
	         month1 = Integer.parseInt(values[1]);
	         year1 = Integer.parseInt(values[2]);
			 date1  = LocalDate.of(year1, month1,day1);
			java.time.DayOfWeek dayOfWeek = date1.getDayOfWeek();
		    System.out.println(dayOfWeek);
		    break;
		case 4:
			m.put(cc, "Determine the Day of the Week for a given date");
			cc+=1;
			System.out.println("Please enter date in DD/MM/YYYY format");
			date = sc.next();
	        values = date.split("/");
	         day1 = Integer.parseInt(values[0]);
	         month1 = Integer.parseInt(values[1]);
	         year1 = Integer.parseInt(values[2]);
			 date1  = LocalDate.of(year1, month1,day1);
			WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
			int weekNumber = date1.get(weekFields.weekOfWeekBasedYear());
		    System.out.println(weekNumber);

			break;
		case 5:
			m.put(cc, "Print History");
			cc+=1;
			for (Map.Entry<Integer, String> entry : m.entrySet()) {
			    Integer key = entry.getKey();
			    String value = entry.getValue();
			    System.out.println(key+"-"+value);
			    // now work with key and value...
			}
			break;
		case 6:
			m.put(cc, "END");
			cc+=1;
			flag=false;
			break;
			
		
		default:
			break;
		}
		}
        
    }
}
