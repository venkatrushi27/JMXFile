package Helloworld;
import java.util.*;
import java.io.*;
import java.nio.file.*;
public class SPLITNEW{

	public static void main(String args[])
	{ 
		try {
	     Scanner x =new Scanner(System.in);
         System.out.println("Enter the File Path: ");
         String path = x.nextLine();
         Path file_path = Paths.get(path);
	    String result_path = path.substring(0,path.lastIndexOf("."));
         //System.out.println(result path)
         File f1 = new File(result_path);
	     boolean bool =  f1.mkdir();
        if(bool) {
        	long count = Files.lines(file_path).count();
            System.out.println("No of lines in the provided File :" +count);
            System.out.println("Enter the number of files required [For ex, if the ims count in 5 then enter the value the value as 5]");
            int file_count = x.nextInt();
            System.out.println("Enter the number split required for each file [For ex, if a single jmx require 2 login files than enter value as 2]");
	       int split = x.nextInt();
           int arr[]= new int[split];
           int sum = 0;
            String line="\n";
            String arr_name[] = new String[file_count];
            System.out.println("Enter the LG IPS [Please drag and paste ] : ");
            for(int k1=0;k1<file_count;k1++) {
                     arr_name[k1]=x.next();
                     }
            for(int i=0;i<split;i++) {
                      int m=i+1; 
                      System.out.println("Enter the number of lines required for Split " +m+" :");
                      arr[i] =x.nextInt();
            		  sum+= arr[i];
            }
            		if(sum*file_count <=count) {
                       FileInputStream fstream = new FileInputStream(path);
                       DataInputStream in = new DataInputStream(fstream);
                       BufferedReader br = new BufferedReader(new InputStreamReader(in));
                       String Line_data ="";
            		   for(int k=0; k<file_count; k++) {
                              for(int i=0;i<split;i++){
                                  int p=i+1;
                                   String File_name = result_path+ "\\" +arr_name[k]+ "_LoginFlow_" +p+".csv";
                                   //System.out.println(result_path+"_"+p+"_LG_"+k+".csv);
                                   File file = new File(File_name);
            		               FileWriter f= new FileWriter(file.getAbsoluteFile(),true); 
            		               BufferedWriter bw = new BufferedWriter(f);
                                  for(int j=1; j<arr[i]; j++){
                                  Line_data = br.readLine();
                                  line="\n";
                                  if(Line_data!=null){ 
                                	  if(j==arr[i]){ 
                                		  line ="";
                                	  }
                                	  bw.write(Line_data+line);
                                  }
                              }
                                    bw.flush();
                                    bw.close();
                        } 
                    }
            		System.out.println("Result Location: "+ result_path);
            	}
                   else{
                           System.out.println("!! Line count exceeds number of available Lines ! !");
                   }
        }
        else { 
        	   System.out.println("Folder already Found "+result_path);
        	   System.out.println("Delete the old folder or rename the old older");
        }
	}catch(Exception e){
                    System.out.println(e);
    }
	}
}
