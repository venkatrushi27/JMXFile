package JMeterScripts;
import java.util.Random;
import java.util.*;
import java.io.*;

public class UserCreation {

	public static void main(String[] args) {

		String names=" ";
		String values=" ";
				for(int i=1;i<3;i++)
				{
				    int name = new Random().nextInt(26)+65;
				    names+= String.valueOf((char)name);
				    
					int value = new Random().nextInt(10)+49;
				   values+= String.valueOf((char)value);
				   
				}
				
//		System.out.println(names);
//		System.out.println(values);
		try{
			if(!(names.contains("Nodata"))){
		String csvfile ="F:\\rishi\\apache-jmeter-5.6.3\\ScriptsExecuted\\PetStore\\CreatedUser.txt";
				File file = new File(csvfile);
				FileWriter f = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(f);
				bw.write(names+values+"\n");
				//System.out.println("Kowndinya");
				bw.flush();
				bw.close();
			}	
		}
		catch(Exception e){		
			}	
	}

}
