package JMeterScripts;

public class Checking {

	public static void main(String[] args) {
		
		String x= "Rushi" ;                                   //"${__base64Decode(cnVzaGk=,result)}";
		System.out.println(x);    //Decode String

		String z ="Rushi";
		String y="${__base64Encode(Rushi,encode)}";
		System.out.println(y);  //Encode String
		
		if(x.equals(z))
		{
			System.out.println("The Valueis true");
		}
		else{
			System.out.println("The Value is Not Equal");
		}

	}

}
