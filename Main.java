//importing required things

//A simple text scanner which can parse primitive types and strings using regular expressions.
//A Scanner breaks its input into tokens using a delimiter pattern, which by default matches whitespace.
//The resulting tokens may then be converted into values of different types using the various next methods.
import java.util.Scanner;

//An instance of this class is used to generate a stream of pseudorandom numbers.
//The class uses a 48-bit seed, which is modified using a linear congruential formula. 
import java.util.Random;


//Resizable-array implementation of the List interface.
// Implements all optional list operations, and permits all elements, including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally to store the list.
// (This class is roughly equivalent tonon Vector, except that it is unsynchronized.)
import java.util.ArrayList;

import java.io.*;


//creating main class
public class Main implements Serializable
{
	
    public static int a=2;

    public static int b=11;
    
	// int temp1=2;

	// int temp2=11;

	//creating a arraylist of users
	public static ArrayList<users> list_of_users = new ArrayList<users>();
    
	//creating an arraylist named blockchain
    public static ArrayList<Block> list_of_blockchain = new ArrayList<Block>();
    
    public static ArrayList<Block> list_of_blocks = new ArrayList<Block>();

	//defining difficulty
	public static int value_difficulty = 4;
    
	//creating an array list of doctors
    public static ArrayList<users> list_of_doctors = new ArrayList<users>();

	//creating an arraylist of records
	public static ArrayList<Record> list_of_records = new ArrayList<Record>();
    
	//defining previous hash value
	public static String value_previousHash ="0";

	public static ArrayList<Block> list_of_blocks1 = new ArrayList<Block>();

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
    //     return a.length();
    // }

    public static Boolean fun_discretelog_zkp(int p1)
    {
        //int temp7=100;

        Random rand = new Random();

        Scanner sc=new Scanner(System.in);

		System.out.println("Verifying...");

        System.out.println("\nKindly verify yourself as a user");

        System.out.println("Zero Knowledge Proof");

		System.out.println("Follow below steps to verify as a user");

        System.out.println("Choose a random number between 0 and 9(This number is r): ");

		System.out.println("Do below compuation...");
        System.out.println("Please compute h=(2^r)(mod 11) and Enter h: ");

		//fun_testing();

		//taking input
        int h=sc.nextInt();
        System.out.println("h is "+ h );

        int b=rand.nextInt(2);
        System.out.println("Random bit(b) is: "+b);

		System.out.println("Do below compuation...");
        System.out.println("Please compute s=(r+b*x)mod(10).Here x is the number you are proving you know(ie the password): ");
        int s=sc.nextInt();
        
        int val2=(h*fun_exponential(p1,b,11))%11;

        int val1=fun_exponential(2,s,11);
        
        //int val3=(h*fun_exponential(p1,b,11))%11;

		//fun_testing();

        if(val1!=val2)
        {
			System.out.println("Zero Knowledge Proof Failed.Please try again\n");
            return false;
        }
        else
        {
			System.out.println("Zero Knowledge Proof Successful.You are verified as registered user\n");
			return true;
        }
    }    


    public static Boolean fun_ZKP(int x)
    {

		//int temp6=10;

    	Random num_random = new Random();
    	
    	int val_expo=fun_exponential(a,x,b);

		//int o=val_expo;
  
		//temp6--;

    	int val_ran=num_random.nextInt(b-1);

    	int val_ex=fun_exponential(a,val_ran,b);

        //int c=val_ex;

		//temp6--;
	
    	int val_r=num_random.nextInt(2);

		//fun_testing();


    	int calc_num=(val_ran+val_r*x)%(val_r-1);

		//temp6--;
    	
		int n2=(val_ex*fun_exponential(val_expo,val_r,val_r))%val_r;

		int n1=fun_exponential(a,calc_num,val_r);

		//fun_testing();

    	if(n1==n2)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

	public static int fun_exponential(int d,int e,int f)
    {
    	int res=1;

		//int ans1=1;

		int i=0;

		while(i<e)
		{
			res=((res%f)*(d%f))%f;

			i++;
		}

		//fun_testing();
    	
		//ans1--;
		
    	return res;
    	
    }

public static void main(String[] args) 
{
	File f=new File("CHAIN.txt");
        if(f.exists())
        database.receiveData();


    //temporary variable for testing
	//int temp3=1000;

    //fun_testing();

    //int doc_1=10;

	//doctor details
    
	users doctor_No_1 =  new users();
	
	list_of_users.add(doctor_No_1);

	doctor_No_1.fun_name_setter("Shaan");

	list_of_doctors.add(doctor_No_1);

	doctor_No_1.fun_pwd_setter("111");
	
    //doc_1=doc_1-1;

    //doc2
	//int doc_2=10;

	users doctor_No_2 =  new users();

	list_of_doctors.add(doctor_No_2);

	doctor_No_2.fun_name_setter("Shivam");
	
	list_of_users.add(doctor_No_2);

	doctor_No_2.fun_pwd_setter("112");

    //doc_2=doc_2-1;
    
    //doc3
    //int doc_3=10;

	users doctor_No_3 =  new users();

	doctor_No_3.fun_pwd_setter("113");
	
	list_of_doctors.add(doctor_No_3);

	doctor_No_3.fun_name_setter("Suraj");

	list_of_users.add(doctor_No_3);

    //doc_3=doc_3-1;
   
    //doc4
	//int doc_4=10;

	users doctor_No_4 =  new users();
    
    list_of_users.add(doctor_No_4);

	doctor_No_4.fun_pwd_setter("114");
	
	list_of_doctors.add(doctor_No_4);

	doctor_No_4.fun_name_setter("Sam");
	
	//doc_4=doc_4-1;
	


	String stri="";

	//String stri1="";
	
	do{
    	
    	try{	
			    System.out.println("Please choose the type of work you want to do");

    			System.out.println("add/view/register");

    			Scanner sc = new Scanner(System.in); 

				//taking input
        		String str_i = sc.nextLine();

				//temp3--;
    
		        //int val_s=0;

				//int curr_s=0;
				
                //Code to view transactions (patient details)
				if(str_i.equals("view"))
				{
					System.out.println("d-doctor and p-patient");

					System.out.println("Are you a doctor or patient?(d/p)");

					sc = new Scanner(System.in);

					//taking input
					String str_v = sc.nextLine();
                    
					if(str_v.equals("p"))
					{

						sc = new Scanner(System.in);

						System.out.println("Please enter your details below");
						System.out.println("Enter your name:");

						//taking input
						String str_pat = sc.nextLine();

						int g=0;

						//fun_testing();

						int j=0;

						while(j<list_of_users.size())
						{
                            //temp3--;

                            if(list_of_users.get(j).fun_name_getter().equals(str_pat))
							{
								int w=Integer.parseInt(list_of_users.get(j).fun_pwd_getter());

								//temp3--;

								g=fun_exponential(a,w,b);
							}	

							j++;
						}

						if(fun_discretelog_zkp(g) == false)
						{
							continue;
						}

                        //int m1=0;

						int m2=0;

						int i=0;

						while(i<list_of_users.size())
						{
							if(list_of_users.get(i).fun_name_getter().equals(str_pat))
							{
								int k=0;

								while(k<list_of_blockchain.size())
								{

									if(list_of_blockchain.get(k).name_of_patient().equals(str_pat))
									{
										System.out.println("Showing details");

										System.out.println("Time:"+list_of_blockchain.get(k).value_of_timeStamp);

                                        System.out.println("Doctor details");

										System.out.println("Doctor name:"+list_of_blockchain.get(k).name_of_doctor());
                                        
										//temp3--;


										System.out.println("Patient details");

										System.out.println("Patient name:"+list_of_blockchain.get(k).name_of_patient());

										System.out.println("Patient's Medical Data:");

										list_of_blockchain.get(k).printData();
										System.out.println();

										//temp3--;

										//m1=1;
										m2=1;
									}

									k++;
								}

								//temp3--;

								if(m2==1)
								{
									break;
								}

								//temp3--;

							}

							i++;

						}

						//temp3--;

						if(m2==0)
						{
                            System.out.println("Patient Could Not Be Found");
						}

						//temp3--;
							
					}

					else if(str_v.equals("d"))
					{

						sc = new Scanner(System.in);

						System.out.println("Name is case sensitive, so please enter your name with appropriate upper and lower case letters");
						
						System.out.println("Enter your name:");

                        //taking input
						String str_doctor = sc.nextLine();

						//temp3--;

						System.out.println("Enter your assigned password");

						System.out.println("Enter your pass:");

						//taking input
						String str_pwd = sc.nextLine();
                        
                        //temp3--;

						int mrk1=0;

						//int mrk2=0;

						//fun_testing();
                        
						int i=0;

						while(i<list_of_doctors.size())
						{
                            if(list_of_doctors.get(i).fun_name_getter().equals(str_doctor)&&list_of_doctors.get(i).fun_pwd_getter().equals(str_pwd))
							{

								int k=0;

								while(k<list_of_blockchain.size())
								{
                                    if(list_of_blockchain.get(k).name_of_doctor().equals(str_doctor))
									{
                                        System.out.println("Showing details");

										System.out.println("TimeStamp at which data  was recorded:"+list_of_blockchain.get(k).value_of_timeStamp);
										
										System.out.println("Doctor details");

										System.out.println("Doctor name:"+str_doctor);
                                        
                                        //temp3--;

										System.out.println("Patient details");
										
										System.out.println("Patient name:"+list_of_blockchain.get(k).name_of_patient());

										System.out.println("Medical Data of this patient:");

										list_of_blockchain.get(k).printData();	

										System.out.println();
                                        
										//temp3--;

										mrk1=1;
                                        //mrk2=1;

									}

									k++;

								}

								if(mrk1==1)
								{
                                    break;
								}
									
							}	
 
							i++;
						}

						if(mrk1==0)
						{
                            System.out.println("Doctor Not Found");
						}
							
					}
				
					else
					{
						System.out.println("Input Invalid");
                        System.out.println("Please provide a valid input next time");
					}
				}
                
                //Code to add patient details under a particular doctor
				else if(str_i.equals("add"))
				{
					System.out.println("Enter Details below");

					System.out.println("Enter doctor's name:");

					sc = new Scanner(System.in); 

					//taking input
					String str_doctor_name = sc.nextLine();

					//temp3=temp3-1;
                    
					System.out.println("Enter the assigned password");

					System.out.println("Enter doctor password:");

					sc = new Scanner(System.in); 

					//taking input
					String str_doctor_pass = sc.nextLine();

					//temp3=temp3-1;
                    
					System.out.println("Enter the details of patient");

					System.out.println("Enter patient name:");

					sc = new Scanner(System.in); 
                    
					//taking input
					String str_patient_name = sc.nextLine();

					//temp3=temp3-1;

					int nu1=0;

					int nu2=0;

					//fun_testing();
					
                    
					int k=0;

					while(k<list_of_users.size())
					{
						if(list_of_users.get(k).fun_name_getter().equals(str_patient_name))
						{
							int x=Integer.parseInt(list_of_users.get(k).fun_pwd_getter());
							nu1=nu1+1;
							nu2=fun_exponential(a,x,b);
							nu1=nu1+1;
						}	

						k++;
					}

					if(fun_discretelog_zkp(nu2) == false)
					{
						continue;
					}
					
					//int mark1=0;

					int mark =0;
					
                  
					Record record_new = new Record();
                    
					//mark1++;

					record_new.fun_users_add(str_doctor_name, str_patient_name);
					
                    int i=0;

					while(i<list_of_users.size())
					{
						if(list_of_doctors.get(i).fun_name_getter().equals(str_doctor_name)&&list_of_doctors.get(i).fun_pwd_getter().equals(str_doctor_pass))
						{
                            int q=0;

							while(q<list_of_users.size())
							{
								if(list_of_users.get(q).fun_name_getter().equals(str_patient_name))
								{
									while(true)
									{
										System.out.println(" y-yes and n-no");

										System.out.println("Enter data: y/n");

										sc = new Scanner(System.in);
                                        
										//taking input
										String str_inp = sc.nextLine();
                                        
                                        if(str_inp.equals("n"))
										{
											list_of_records.add(record_new);

											value_previousHash = addRecordToBlock(list_of_records,value_previousHash,record_new);

											//mark1=1;

											mark =1;

											//temp3--;

											break;
										}

										if(str_inp.equals("y"))
										{
											sc = new Scanner(System.in);
                                            
											//taking input
											String new_data = sc.nextLine();
                                            
                                            //temp3--;

											record_new.fun_data_add(new_data);
			                                
										}
										
									}
									
								}

								if(mark ==1)
								{
                                    break;
								}

								q++;

							}
							
						}

						//temp3--;

						if(mark ==1)
						{
                            break;
						}

						i++;
					}
                    
                    //temp3--;

					if (mark == 0)
					{
						System.out.println("something wrong");
					}
					
				}

				//Code to register new patients for a single transaction
				else if(str_i.equals("register"))
				{
					//creating new patient
					users pat_new = new users();

					System.out.println("Please enter your details");

					System.out.println("Enter name:");

					sc = new Scanner(System.in); 
                    //taking input
					String str_name = sc.nextLine();

					//fun_testing();

					pat_new.fun_name_setter(str_name);

					//temp3=temp3-1;
                    
					System.out.println("Password needs to be integer");

					System.out.println("Enter password:");

					sc = new Scanner(System.in); 
                    
					//taking input
					String str_paswd = sc.nextLine();

					pat_new.fun_pwd_setter(str_paswd);

					//temp3=temp3-1;
                    
					System.out.println("Verifying password");

					System.out.println("Re-enter password:");

					sc = new Scanner(System.in); 
                    
					//taking input
					String vpass = sc.nextLine();

					pat_new.fun_validation(str_paswd,vpass);

					list_of_users.add(pat_new);
                    
					//temp3=temp3-1;
				}

			}
		catch(Exception e)
		{
			System.out.println("Details  entered are Invalid");
		}
    	
    	Scanner scanner1 = new Scanner(System.in);


		System.out.println("Enter yes or no below");

		System.out.println("Do you want to continue?(yes/no)");

		//taking input
    	stri=scanner1.nextLine();

	}while(stri.equals("yes"));

	database.sendData();
}

//Function to verify chain
public static boolean verifyChain(Block block)
{
    //int temp5=10;

	int i=1;

	while(i<list_of_blockchain.size())
	{
		if(!(list_of_blockchain.get(i).fun_getting_prev_hash()==list_of_blockchain.get(i-1).fun_getting_block_hash()))
		{
			return false;
		}

		i++;

	}

	//temp5--;

    if(list_of_blockchain.size()>0) 
    {

		//temp5--;

        if (!(list_of_blockchain.get(list_of_blockchain.size()-1).fun_getting_block_hash() == block.fun_getting_prev_hash())) 
        {
			return false;
		}

    }

	//fun_testing();

	//temp5--;


	return true;
}

//Function to create block and add it to blockchain
public static String addRecordToBlock(ArrayList<Record> record,String previousHash,Record data)
{

	//int temp4=10;

	System.out.println("PLease wait...");

	System.out.println("Trying To mineBlock...");
			
	Block block = new Block(record, previousHash,data);

	//temp4--;
			
	block.fun_mining_block(value_difficulty);

	//fun_testing();

	if (verifyChain(block)); 
		list_of_blockchain.add(block);

	//temp4--;

    return block.fun_getting_block_hash();

	//return

}
	

       
}