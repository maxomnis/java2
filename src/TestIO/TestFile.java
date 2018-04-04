package TestIO;
import  java.io.File;

public class TestFile {

    public static void main(String[] args)
    {
        File file = new File(".");
        System.out.println(file.getName());

        System.out.println(file.getParent());

        System.out.println(file.getAbsoluteFile());
    }
}
