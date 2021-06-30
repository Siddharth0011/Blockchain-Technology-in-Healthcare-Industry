import java.io.*;

public class users implements Serializable
{
	private String str_pass;
	// private String str1;
	private String str_name;
	// private String str2;
	// int temp1=0;
	// int temp2=0;

	// public static void fun_testing()
	// {
	// 	// System.out.println("Testing...");
	// 	// System.out.println("Testing...");
	// 	// System.out.println("Testing...");
	// 	int temp=0;
	// 	// System.out.println("Testing...");
	// 	// System.out.println("Testing...");
	// 	// System.out.println("Testing...");
	// 	//System.out.println(temp);
	// }
    

	void fun_pwd_setter(String pwd)
	{
		// temp1++;
		//System.out.println("temp1");
		// fun_testing();
		this.str_pass = pwd;
	}

	String fun_name_getter()
	{
		// temp1++;
		//System.out.println("temp1");
		// fun_testing();
		return this.str_name ;
	}

    String fun_pwd_getter()
	{
		// temp1++;
		//System.out.println("temp1");
		// fun_testing();
		return this.str_pass ;
	}

	void fun_name_setter(String str)
	{
		// temp1++;
		// //System.out.println("temp1");
		// fun_testing();
		this.str_name = str;
	}

	boolean fun_validation(String f,String h)
	{
		if(f.equals(h))
		{
			// temp1++;
		    // //System.out.println("temp1");
			// fun_testing();
			return true;
		}
		else
		{
			// temp1++;
		    // //System.out.println("temp1");
			// fun_testing();
			return false;
		}
			
	}
	
	
	
}
