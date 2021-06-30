//importing important things

//An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each 
//element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.
//import java.util.List;

//Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements,
// including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array 
// that is used internally to store the list.(This class is roughly equivalent to Vector, except that it is unsynchronized.)
///import java.util.ArrayList;

import java.security.*;

import java.io.*;

public class StringUtil implements Serializable
{

	int val=100;

	int len=0;

	// int temp=100;

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

	//Returns difficulty string target, to compare to hash. eg difficulty of 5 will return "00000"  

	public static String fun_get_diff_str(int diff) 
	{

		// int temp3=10;

		// temp3--;

		// fun_testing();

		return new String(new char[diff]).replace('\0', '0');

	}
    

	//Applies Sha256 to a string and returns the result. 

	public static String applySha256(String str_inp)
	{

		// int temp1=10;



		try {

			//String ipt=str_inp;

			// int temp2=10;

			MessageDigest msg_digest = MessageDigest.getInstance("SHA-256");

			// fun_testing();

	        
            // temp1--;
			//Applies sha256 to our input, 

			byte[] hash_byte = msg_digest.digest(str_inp.getBytes("UTF-8"));

			// temp2--;

	        

			StringBuffer str_hexa = new StringBuffer(); // This will contain hash as hexidecimal
            
			int i=0;

			while(i<hash_byte.length)
			{

				// temp1--;

				String hex = Integer.toHexString(0xff & hash_byte[i]);

				// temp2--;

				if(hex.length() == 1) str_hexa.append('0');

				// temp1--;

				str_hexa.append(hex);

				i++;

			}

			return str_hexa.toString();

		}

		catch(Exception e) 
		{
			// fun_testing();

			// temp1--;

			throw new RuntimeException(e);

		}

	}

	

	//Applies ECDSA Signature and returns the result ( as bytes ).

	public static byte[] applyECDSASig(PrivateKey key_private, String inp) 
	{
		// int temp7=100;

		Signature d_s_a;

		byte[] out = new byte[0];

		try {

			// int temp8=10;

			d_s_a = Signature.getInstance("ECDSA", "BC");

			// temp8--;

			d_s_a.initSign(key_private);

			// temp7--;

			byte[] byte_string = inp.getBytes();

			// fun_testing();

			// temp8--;

			d_s_a.update(byte_string);

			// temp7--;

			byte[] signature_real = d_s_a.sign();
			

			// temp8--;
			// temp7--;

			out = signature_real;

		} 
		catch (Exception e) 
		{
			// int temp6=5;

			// temp6--;

			// fun_testing();

			throw new RuntimeException(e);

		}

		return out;

	}

	public int lengthget(String a)
    {
        return a.length();
    }

	

	//Verifies a String signature 

	public static boolean verifyECDSASig(PublicKey key_pub, String data, byte[] sign) {

		try {

			// int temp4=10;

			Signature verify_ecdsa = Signature.getInstance("ECDSA", "BC");

			// temp4--;

			verify_ecdsa.initVerify(key_pub);

			// fun_testing();


			// temp4--;

			verify_ecdsa.update(data.getBytes());

			// temp4--;

			return verify_ecdsa.verify(sign);

		}
		catch(Exception e) 
		{

			// int temp5=5;

			// temp5--;

			// fun_testing();

			throw new RuntimeException(e);

		}

	}

	

}