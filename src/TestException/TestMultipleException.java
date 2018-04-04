package TestException;

/**
 * 只捕获一次的异常
 */
public class TestMultipleException {

    public static void main(String[] args)
    {
        try{
             int a=0;
             int b=10;
             int c = 0;
             c = b/a;
        }catch (ArithmeticException e){
            System.out.println("in ArithmeticException");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("in Exception");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
