package income_jai;

/**
 * Hello world!
 *
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

	public class App {
		private float avg(String currency, int averageIncome,
				float convertavg) {
			if(currency.equals("INR"))
				{
				convertavg=averageIncome/66;
                }
                else if(currency.equals("SGP"))
			{
				convertavg=(float) (averageIncome/1.5);
            }
            else if(currency.equals("HKD"))
			{
				convertavg=averageIncome/8;
			}
			else if(currency.equals("USD"))
			{
				convertavg=averageIncome;
			}
			else if(currency.equals("GBP"))
			{
				convertavg=(float) (averageIncome/0.67);
			}
			
			
			return convertavg;
		}
		
		public boolean averageIncome() throws IOException{
			Map<String,Float> compiled=new HashMap<String,Float>();
			
			try{
				BufferedReader fileReader=new BufferedReader(new FileReader("C:/Users/jaima/Desktop/win2020/sapient/week2/income_jai/jai_incomeassignment/Resources/input.csv"));
				fileReader.readLine();
				int temp = 0;
				String data="";
				while((data=fileReader.readLine()) != null){
                    String[] s = data.split(",");
                    System.out.println(s[0]+s[1]);
					String city=s[0];
					String country=s[1];
					String gender=s[2];
					String currency=s[3];
					int averageIncome=Integer.parseInt(s[4]);
					float convertavg=(float) 0.0;
					convertavg = avg(currency, averageIncome,convertavg);
					
					if(country.equals(" "))
						{
					    	if(compiled.containsKey(city+","+gender))
					    	  {
					    		float avg=compiled.get(city+","+gender);
					    		avg=avg+convertavg;
					    		compiled.put(city+","+gender,avg);
					    	  }
					    	else{
					    		compiled.put(city+","+gender,convertavg);
					    	 }
						}
					else{
						if(compiled.containsKey(country+","+gender))
				    	  {
				    		float avg=compiled.get(country+","+gender);
				    		avg=avg+convertavg;
				    		compiled.put(country+","+gender,avg);
				    	  }
				    	else{
				    		compiled.put(country+","+gender,convertavg);
				    	 }
					}
				
				}
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			FileWriter fw = new FileWriter("C:/Users/jaima/Desktop/win2020/sapient/week2/income_jai/jai_incomeassignment/Resources/output.csv");
			BufferedWriter writer = new BufferedWriter(fw);
			try {
				String msg="City/Country Gender Average Income(in USD)";
				writer.write(msg);
				writer.newLine();
				for(Map.Entry<String,Float> ms:compiled.entrySet())
				   {
					
					outt(writer, ms,",");
				   }
				return true;
				
			} catch (FileNotFoundException e) {			
				e.printStackTrace();
				return false;
			}finally{
				writer.close();    
			}
			
		}

		private void outt(BufferedWriter writer,
				Map.Entry<String, Float> ms,String fileType) throws IOException {
			String key=ms.getKey();
			float value=ms.getValue();
			String countryGen[]=key.split(",");
			String recard=countryGen[0]+" "+countryGen[1]+" "+value;
			
			if(fileType.equals(","))
			{
				writer.write(key+","+value);				
			}
			else{
				writer.write(recard);
			}
			writer.newLine();
		}
		
		public static void main(String... s){
			App aa=new App();
			try {
				aa.averageIncome();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
