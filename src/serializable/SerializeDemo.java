package serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {

    public static void main(String[] args)
    {
        Employee e = new Employee();
        e.name = "aaaa";
        e.address = "hubei";
        e.SSN = 123333;
        e.number = 101;

        try
        {
            FileOutputStream fileOut = new FileOutputStream("a.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("serialized data is saved in a.txt");
        }catch(IOException i)
        {
            i.printStackTrace();;
        }
    }



}
