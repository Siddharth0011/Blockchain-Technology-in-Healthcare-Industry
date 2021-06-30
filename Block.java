//importing required things


//The class Date represents a specific instant in time, with millisecond precision.
import java.util.Date;

//Resizable-array implementation of the List interface.
 //Implements all optional list operations, and permits all elements, including null.
  //In addition to implementing the List interface, this class provides methods to 
  //manipulate the size of the array that is used internally to store the list.
// (This class is roughly equivalent to Vector, except that it is unsynchronized.)
import java.util.ArrayList;

import java.io.*;



public class Block implements Serializable{

    
    // int temp8=100;
    
    // private String hash1;

    private String value_of_prev_hash;

    public long value_of_timeStamp;
    
    private ArrayList<Record> object_of_record;

    // int temp9=100;
    
    // private int sum1=0;

    // private int curr_sum=0;

    private String block_of_hash;
    
    // private ArrayList<Record> object1;

    // int temp10=100;

    public int val_of_nonce;

    private Record current_medical_data;

    public int nonce_val1;

    public String hash_of_DES;

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
		
    
    public String name_of_doctor()
    {

        // int temp17=10;

        // temp17--;

        // fun_testing();


    	return this.current_medical_data.doctor;
    }
    
    public String fun_getting_block_hash() 
    {
        // int temp15=10;

        // temp15--;

        // fun_testing();

        return block_of_hash;

    }

    public void fun_mining_block(int val_difficulty) 
    {

        // int temp12=val_difficulty;


        String str_a = StringUtil.fun_get_diff_str(val_difficulty); //Create a string with difficulty * "0"

       // fun_testing();

        if(!block_of_hash.substring( 0, val_difficulty).equals(str_a)) 
        {
            val_of_nonce ++;

            // temp12--;

            block_of_hash = fun_calc_hash();

            // fun_testing();

            String s1=new String(block_of_hash);

            // String s2=s1;

            // temp12--;

            hash_of_DES=DES.DES_calculate(s1);
        }

        char arr[]=hash_of_DES.toCharArray();

        int i=0;

       // fun_testing();

        while(i<hash_of_DES.length())
        {
            if(arr[i]<='z' && arr[i]>='a')
            {
                Character.toUpperCase(arr[i]);
            }

            i++;
        }
      

        System.out.println("Mining Block....");

        // temp12--;

        hash_of_DES = String.valueOf(arr);

        System.out.println("Block Mined!!! : " + hash_of_DES.toUpperCase());

    }

    public String fun_getting_prev_hash()
    {
         
        // int temp13=10;

        // temp13--;

        // fun_testing();

        return value_of_prev_hash;

    }



    
    public void printData()
    {

        // int temp19=10;

        // temp19--;

    	current_medical_data.fun_data_print();
    }

    public Block(ArrayList<Record> list_of_record, String val_prev_h,Record medical_data_curr)
    {

        // int temp10=10;
        
        this.value_of_prev_hash=val_prev_h;
        
        this.block_of_hash=fun_calc_hash();

        this.hash_of_DES=DES.DES_calculate(block_of_hash);

        // int temp11=temp10;

    	this.current_medical_data = medical_data_curr;

        // temp10--;

        this.value_of_timeStamp = new Date().getTime();

        object_of_record=list_of_record;
        
        // temp10--;

        

    }

    public void fun_setting_block_hash(String str_hash_block) 
    {
        // int temp16=10;


        this.block_of_hash = str_hash_block;

        // temp16--;

        this.hash_of_DES=DES.DES_calculate(block_of_hash);

    }

    public String name_of_patient()
    {

        // int temp18=10;

        // temp18--;

    	return this.current_medical_data.patient;
    }

    //Calculate new hash based on blocks contents

    public String fun_calc_hash() 
    {
        
        //int temp11=10;

        String hash_val_cal = StringUtil.applySha256(value_of_prev_hash +Integer.toString(val_of_nonce));

        // temp11--;

        return hash_val_cal;

    }

    // public int lengthget(String a)
    // {
    //     return a.length();
    // }

    public void fun_set_prev_hash(String previousHash) 
    {
        // int temp14=10;

        // temp14--;


        this.value_of_prev_hash = previousHash;

    }

    //Increases nonce value until hash target is reached.

    

    


   



    

}