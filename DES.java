//importing important things 

//importing important things
//import java.util.*;

class DES {
	
		// CONSTANTS

		// int temp1=0;

		// int temp2=0;

		// S-box Table
		int[][][] sub_box = {
			{ { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
			{ 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
			{ 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
			{ 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } },
			{ { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
			{ 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
			{ 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
			{ 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } },
			{ { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
			{ 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
			{ 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
			{ 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } },
			{ { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
			{ 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
			{ 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
			{ 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } },
			{ { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
			{ 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
			{ 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
			{ 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } },
			{ { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
			{ 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
			{ 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
			{ 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } },
			{ { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
			{ 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
			{ 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
			{ 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } },
			{ { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
			{ 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
			{ 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
			{ 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } }
		};
		
        // Expansion D-box Table
		int[] EP = { 32, 1, 2, 3, 4, 5, 4,
			5, 6, 7, 8, 9, 8, 9, 10,
			11, 12, 13, 12, 13, 14, 15,
			16, 17, 16, 17, 18, 19, 20,
			21, 20, 21, 22, 23, 24, 25,
			24, 25, 26, 27, 28, 29, 28,
			29, 30, 31, 32, 1 };
			
		// Inverse Initial Permutation Table
		int[] IP1 = { 40, 8, 48, 16, 56, 24, 64,
					32, 39, 7, 47, 15, 55,
					23, 63, 31, 38, 6, 46,
					14, 54, 22, 62, 30, 37,
					5, 45, 13, 53, 21, 61,
					29, 36, 4, 44, 12, 52,
					20, 60, 28, 35, 3, 43,
					11, 51, 19, 59, 27, 34,
					2, 42, 10, 50, 18, 58,
					26, 33, 1, 41, 9, 49,
					17, 57, 25 };
		
			// Straight Permutation Table
			int[] P = { 16, 7, 20, 21, 29, 12, 28,
				17, 1, 15, 23, 26, 5, 18,
				31, 10, 2, 8, 24, 14, 32,
				27, 3, 9, 19, 13, 30, 6,
				22, 11, 4, 25 };			

		// second key-Permutation Table
		int[] PC2 = { 14, 17, 11, 24, 1, 5, 3,
			28, 15, 6, 21, 10, 23, 19, 12,
			4, 26, 8, 16, 7, 27, 20, 13, 2,
			41, 52, 31, 37, 47, 55, 30, 40,
			51, 45, 33, 48, 44, 49, 39, 56,
			34, 53, 46, 42, 50, 36, 29, 32 };		
		
			int[] shiftBits = { 1, 1, 2, 2, 2, 2, 2, 2,
				1, 2, 2, 2, 2, 2, 2, 1 };	
		
		// S-box Table
		int[][][] substitution_box = {
			{ { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
			{ 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
			{ 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
			{ 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } },
			{ { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
			{ 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
			{ 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
			{ 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } },
			{ { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
			{ 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
			{ 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
			{ 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } },
			{ { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
			{ 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
			{ 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
			{ 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } },
			{ { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
			{ 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
			{ 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
			{ 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } },
			{ { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
			{ 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
			{ 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
			{ 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } },
			{ { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
			{ 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
			{ 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
			{ 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } },
			{ { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
			{ 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
			{ 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
			{ 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } }
		};		
		
		// first key-hePermutation Table
		int[] PC1 = { 57, 49, 41, 33, 25,
			17, 9, 1, 58, 50, 42, 34, 26,
			18, 10, 2, 59, 51, 43, 35, 27,
			19, 11, 3, 60, 52, 44, 36, 63,
			55, 47, 39, 31, 23, 15, 7, 62,
			54, 46, 38, 30, 22, 14, 6, 61,
			53, 45, 37, 29, 21, 13, 5, 28,
			20, 12, 4 };
	
		
		// Initial Permutation Table
		int[] IP = { 58, 50, 42, 34, 26, 18,
			10, 2, 60, 52, 44, 36, 28, 20,
			12, 4, 62, 54, 46, 38,
			30, 22, 14, 6, 64, 56,
			48, 40, 32, 24, 16, 8,
			57, 49, 41, 33, 25, 17,
			9, 1, 59, 51, 43, 35, 27,
			19, 11, 3, 61, 53, 45,
			37, 29, 21, 13, 5, 63, 55,
			47, 39, 31, 23, 15, 7 };			
           
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

			// public int lengthget(String a)
			// {
			// 	return a.length();
			// }	
		

			public static String DES_calculate(String pt)
			{
		
				// int temp1=0;
		
				String a,b,c,d;
		
				DES des_cipher = new DES();
		
				// temp1++;
				
				d=pt.substring(48,64);
		
				c=pt.substring(32,48);
		
				b=pt.substring(16,32);
		
				a=pt.substring(0,16);
		
				// temp1++;
				
				// fun_testing();
		
				String str_key = "133457799BBCDFF1";
				
				String s4 = des_cipher.fun_encryption(d, str_key);
		
				String s3 = des_cipher.fun_encryption(c, str_key);
		
				String s2 = des_cipher.fun_encryption(b, str_key);
		
				String s1 = des_cipher.fun_encryption(a, str_key);
		
				// temp1++;
		
			   
				return s1+s2+s3+s4;
		
			}
		
		
		// left Circular Shifting bits
		String fun_leftCircularShift(String str_inp, int number_of_bits)
		{

			//int temp1=0;

			int len = str_inp.length();

			int req_len=len*4;

			int perm[] = new int[req_len];

			//temp1++;

			int i=0;

			while(i<req_len-1)
			{
				perm[i] = (i + 2);

				//temp1++;

				i++;
			}
				
			perm[req_len - 1] = 1;

			// fun_testing();

			// temp1++;

			while (number_of_bits-- > 0)
			{
				// temp1++;
				str_inp = fun_perm(perm, str_inp);
			}

			// temp1++;
				
			return str_inp;
		}

			// per-mutate input hexadecimal
		// according to specified sequence
		String fun_perm(int[] seq_arr, String str_inp)
		{
			// int temp1=0;

			str_inp = fun_hextoBin(str_inp);

			String output = "";

			// temp1++;

			int i=0;

			while(i<seq_arr.length)
			{

				output += str_inp.charAt(seq_arr[i] - 1);

				// temp1++;

				i++;
			}

			// fun_testing();
			
			output = fun_binToHex(output);

			// temp1++;

			return output;
		}
	

	

		// binary to hexadecimal conversion
		String fun_binToHex(String str_inp)
		{
			// int temp1=0;

			int len= (int)str_inp.length();

			int req_l = (int)len / 4;

			// temp1++;

			str_inp = Long.toHexString(Long.parseUnsignedLong(str_inp, 2));

			// fun_testing();

			while (str_inp.length() < req_l)
			{
				// temp1++;
				str_inp = "0" + str_inp;
			}

			// temp1++;
				
			return str_inp;
		}

		String fun_round(String str_in, String key, int number)
		{
            //int temp1=0;

			// fk

			String temp = str_in.substring(8, 16);

			String left = str_in.substring(0, 8);
			
			String right = temp;

			//temp1++;

			// Expansion permutation
			temp = fun_perm(EP, temp);

			// xor temp and round key
			temp = fun_xor(temp, key);

			//temp1++;

			//fun_testing();

			// lookup in s-box table
			temp = fun_sBox(temp);
			// Straight D-box
			temp = fun_perm(P, temp);

			//temp1++;

			// xor
			left = fun_xor(left, temp);

			//temp1++;
			
			// swapper
			return right + left;
		}


	

		

		// preparing 16 keys for 16 rounds
		String[] fun_getKeys(String str_key)
		{

			//int temp1=0;

			String keys[] = new String[16];
			// first key permutation
			str_key = fun_perm(PC1, str_key);

			//fun_testing();

			//temp1++;

			int i=0;

			while(i<16)
			{
				str_key = fun_leftCircularShift(str_key.substring(0, 7), shiftBits[i])+ 
				          fun_leftCircularShift(str_key.substring(7, 14),shiftBits[i]);

				//fun_testing();

				//temp1++;		  
				// second key permutation
				keys[i] = fun_perm(PC2, str_key);

				i++;
			}

			//temp1++;
			
			return keys;
		}


		String fun_encryption(String pt, String key)
		{
			//int temp1=0;

			// initial permutation
			pt = fun_perm(IP, pt);
			
			// get round keys
			String keys[] = fun_getKeys(key);

			//temp1++;
			
            int i=0;
			// 16 rounds

			while(i<16)
			{
				pt = fun_round(pt, keys[i], i);
				i++;
			}

			//fun_testing();

			// 32-bit swap
			pt = pt.substring(8, 16) + pt.substring(0, 8);

			
			//temp1++;

			// final permutation
			pt = fun_perm(IP1, pt);


			return pt;
		}

		
		// xor 2 hexadecimal strings
		String fun_xor(String s1, String s2)
		{
			//int temp1=0;
			
			// hexadecimal to decimal(base 10)
			long t_b = Long.parseUnsignedLong(s2, 16);

			// hexadecimal to decimal(base 10)
			long t_a = Long.parseUnsignedLong(s1, 16);

			//temp1++;

			// xor
			t_a = t_a ^ t_b;

			//fun_testing();

			// decimal to hexadecimal
			s1 = Long.toHexString(t_a);

			//temp1++;

			// prepend 0's to maintain length
			while (s1.length() < s2.length())
			{
				//temp1++;
				s1 = "0" + s1;
			}

			//temp1++;
				
			return s1;
		}

		
		// s-box lookup
		String fun_sBox(String in_str)
		{
			//int temp1=0;

			in_str = fun_hextoBin(in_str);

			String str_out = "";

			int i=0;

			while(i<48)
			{

				int num = i / 6;

				String temp = in_str.substring(i, i + 6);

				//temp1++;

				int col = Integer.parseInt(temp.substring(1, 5), 2);

				int row = Integer.parseInt(temp.charAt(0) + "" + temp.charAt(5), 2);
				
				//temp1++;

				//fun_testing();
				
				str_out += Integer.toHexString(sub_box[num][row][col]);

				i += 6;

			}

			// temp1++;

			// fun_testing();
			
			return str_out;
		}

			// hexadecimal to binary conversion
			String fun_hextoBin(String str_inp)
			{
	
				//int temp1=0;
	
				int len= str_inp.length();
	
				int req_l = len * 4;
	
				//temp1++;
	
				str_inp = Long.toBinaryString(Long.parseUnsignedLong(str_inp, 16));

				//fun_testing();
	
				while (str_inp.length() < req_l)
				{
					//temp1++;
					str_inp = "0" + str_inp;
				}

				//fun_testing();
	
				//temp1++;
					
				return str_inp;
			}

		
	
    
	
}

