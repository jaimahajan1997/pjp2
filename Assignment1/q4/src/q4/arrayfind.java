package q4;

import java.util.Scanner;

public class arrayfind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner s=new Scanner(System.in);

	        System.out.println("Enter array size");

	        int n=s.nextInt();

	        int array[]=new int[n];

	        System.out.println("Please enter the elements one by one");

	        for(int element=0;element<n;element++){
	            array[element]=s.nextInt();

	        }
	        System.out.println("What do you want to find now?");
	        try {
	        int find=s.nextInt();
	        for(int element=0;element<n;element++){
	            if(array[element]==find) {
	            	System.out.println("Found "+find+" at postion "+element);
	            }

	        } 
	        }
	        catch (Exception e){
	        	System.out.println("wrong input");
	        }

	}

}
