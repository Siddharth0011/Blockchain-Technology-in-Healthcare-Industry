import java.io.*;
import java.util.*;

public class database {

	public static void sendData() {
        try{
            FileOutputStream fos;
            ObjectOutputStream oos;

            fos = new FileOutputStream("CHAIN.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.list_of_blockchain);

            fos = new FileOutputStream("DOC_NAME.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.list_of_doctors);

            fos = new FileOutputStream("prev_hash.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.value_previousHash);

            /*fos = new FileOutputStream("PASSWORD.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.passwords);*/

            /*fos = new FileOutputStream("Records.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.record_list);*/

            fos = new FileOutputStream("Pat.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.list_of_users);
            
            

            fos.close();
            oos.close();
        }
        catch(Exception e){
            System.out.println("Exception while send data to files: "+e);
        }
    }

    public static void receiveData(){
        try{
            FileInputStream fis;
            ObjectInputStream ois;

            fis = new FileInputStream("CHAIN.txt");
            ois = new ObjectInputStream(fis);

            if(new File("CHAIN.txt").length() != 0)
                Main.list_of_blockchain = (ArrayList<Block>)ois.readObject();

            fis = new FileInputStream("DOC_NAME.txt");
            ois = new ObjectInputStream(fis);

            if(new File("DOC_NAME.txt").length() != 0)
               Main.list_of_doctors = (ArrayList<users>)ois.readObject();

            /*fis = new FileInputStream("PASSWORD.txt");
            ois = new ObjectInputStream(fis);

            if(new File("PASSWORD.txt").length() != 0)
                Main.passwords = (List<String>)ois.readObject();*/

            fis = new FileInputStream("Pat.txt");
            ois = new ObjectInputStream(fis);

            if(new File("Pat.txt").length() != 0)
                Main.list_of_users = (ArrayList<users>)ois.readObject();
            
            fis = new FileInputStream("prev_hash.txt");
            ois = new ObjectInputStream(fis);

            if(new File("prev_hash.txt").length() != 0)
                Main.value_previousHash = (String)ois.readObject();

            fis.close(); ois.close();
        }
        catch(Exception e){
            System.out.println("Exception while receving data to files: "+e);
        }
    }

}
