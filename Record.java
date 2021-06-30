//Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements,
//including null. In addition to implementing the List interface, this class provides methods to manipulate the size of the array
//that is used internally to store the list. (This class is roughly equivalent to Vector, except that it is unsynchronized.)
import java.util.ArrayList;

//import java.util.ArrayList;

//Serializability of a class is enabled by the class implementing the java.io.Serializable interface.
import java.io.Serializable;




public class Record implements Serializable

{

    String doctor;
    // String tem;
    String patient;
    // String tem2;

    // int temp1=0;
    
    private ArrayList<String> data = new ArrayList<String>();

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
    
    void fun_data_add(String medData)
    {
        // temp1++;
		// //System.out.println("temp1");

        // fun_testing();

    	this.data.add(medData);
    }
    
    void fun_data_print()
    {
        int i=0;

        while(i<data.size())
        {
            System.out.println(data.get(i));
            i++;
        }

        // fun_testing();
    
    }

    void fun_users_add(String doctor,String patient)
    {
        // temp1++;
		// //System.out.println("temp1");

        // fun_testing();

    	this.doctor = doctor;
    	this.patient = patient;
    }

    
}