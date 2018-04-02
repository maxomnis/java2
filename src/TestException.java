import java.io.*;
import java.io.FileOutputStream;

public class TestException {
    public static void main(String args[]){
        try{
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception Message  :" + e.getMessage());
            System.out.println("Exception throw  :" + e.getStackTrace());
            FileWriter errorFile = null;
            try
            {
                errorFile = new FileWriter("error.txt");

            }catch (IOException ef)
            {
                System.out.println(ef.getStackTrace());
                ef.printStackTrace();
            }


            //java7开始支持catch多种异常类型，用 “|”隔开
        }catch (IndexOutOfBoundsException | NumberFormatException|ArithmeticException ie)
        {
            System.out.println("Exception throw :"+ie);
        }
        System.out.println("Out of the block");
    }
}

