package com.sapient;
import java.io.*;
import java.util.*;



//Jai Mahajan

public class FeeCalc {
	
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<transact> transactionlist=new ArrayList<transact>();
		transactionlist=read("C:\\Users\\jaima\\Desktop\\JAVA\\FeeCalculator_JaiMahajan_Assign2\\src\\com\\sapient\\transactions.csv","csv"); // file type can be changed to csv,xml,excel
		System.out.println(transactionlist.size());
		transactionlist=intraday(transactionlist);

		transactionlist=fee(transactionlist);
		
		transactionlist.sort(Comparator.comparing(transact::getClientid).thenComparing(transact::getType).thenComparing(transact::getDate).thenComparing(transact::getFlag));
        System.out.println("");

		System.out.println("OUTPUT SUMMARY");
        System.out.println("");
        System.out.println("------------------------------------------------------------");

        System.out.println("Client Id | Transaction  | Transaction  | Priority |Processing |");
        System.out.println("          | Type         |  Date        | Priority |Fee        |");

        for (transact transaction : transactionlist) {
            System.out.println("------------------------------------------------------------");
            System.out.println(transaction.getClientid() + "  \t  \t|" + transaction.getType() + (transaction.getType().equals("DEPOSIT") || transaction.getType().equals("WITHDRAW") ? "|" : "\t|")+
                    transaction.getDate() + "|\t " + (transaction.getFlag().equals("Y") ? "High" : "Low") + "\t| " +
                    transaction.getFees() + "\t|");
        }
	}
	public static ArrayList<transact> intraday(ArrayList<transact> transactionlist) {
		for (transact t:transactionlist) {
			t.setIntraday("N");
			for (transact o:transactionlist) {
				if (t.getClientid().equals(o.getClientid()) &&
                        t.getSecurityid().equals(o.getSecurityid()) &&
                        t.getDate().equals(o.getDate())) {
					//System.out.println("yes1");
					//System.out.println(t.getType().equals("BUY"));
                    if ((t.getType().equals("SELL") && o.getType().equals("BUY") )
                    		|| (t.getType().equals("BUY") &&    o.getType().equals("SELL"))) {
                    	t.setIntraday("Y");
                        System.out.println("yes2");
                        break;
                    }
                } 
			}
		}
		
		return transactionlist;

		
	}

	public static ArrayList<transact> fee(ArrayList<transact> transactionlist) {
		for (transact t:transactionlist) {
			//System.out.println(t.getIntraday()+t.getFees()+t.getClientid()+t.getFlag());
			if (t.getIntraday().equals("Y")) {
				t.setFees(10.0);
				System.out.println("intraday fee");
	        } else {
	            if (t.getFlag().equals("Y")) {
	                t.setFees(500.0);
					System.out.println("500 fee");

	            } else {
	                if (t.getType().equals("SELL") ||
	                        t.getType().equals("WITHDRAW")) {
	                    t.setFees(100.0);
						System.out.println("100 fee");

	                } else if (t.getType().equals("BUY") ||
	                        t.getType().equals("DEPOSIT")) {
	                    t.setFees(50.0);
						System.out.println("50 fee");

	                }
	            }
	        }
		}
		
		return transactionlist;
		
	}
	public static ArrayList<transact> read(String path,String typ) throws FileNotFoundException, IOException { 
		if (typ.equals("csv")){
			ArrayList<transact> trans=new ArrayList<transact>();

            File file = new File(path);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                System.out.println("Reading data");
                String nxtline="";
                reader.readLine();
            	while ((nxtline = reader.readLine()) != null) {
                	//System.out.println(nxtline);
                    String[] params = nxtline.split(",");
                   
                    trans.add(new transact(params[0],params[1],params[2],params[3],params[4],Double.parseDouble(params[5]),params[6]));
                    
                }
                return trans;
            }
		}
		else if (typ.equals("txt")){
			ArrayList<transact> trans=new ArrayList<transact>();

            File file = new File(path);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                System.out.println("Reading data");
                String nxtline="";
                reader.readLine();
            	while ((nxtline = reader.readLine()) != null) {
                	//System.out.println(nxtline);
                    String[] params = nxtline.split(",");
                   
                    trans.add(new transact(params[0],params[1],params[2],params[3],params[4],Double.parseDouble(params[5]),params[6]));
                    
                }
                return trans;
            }
		}
		else if (typ.equals("excel")){
			//Can be implemented if needed 

			;
		}
		else if (typ.equals("xml")){
			//Can be implemented if needed 

			;
		}
		
		
		return null;
	}
}
