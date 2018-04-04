package TestException;

/**
 * 抛出异常
 */
public class TestThrow {

    public static void main(String[] args)
    {
            //调用声明抛出Checked异常的方法，要么显示的捕获异常
            //要么在main方法中再次声明抛出
            try{
                throwCheckd(-1);
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            /*
                调用声明抛出Runtime异常的方法既可以显示捕获异常，也可以不理会该异常,如果不理会这个异常，
                程序执行到这里就终止了，后面就不会输出“hello”了，如果用try....catch捕获了异常，后面会
                输出hello
             */
            throwRuntime(10) ;
          /*  try
            {
                throwRuntime(10) ;
            }catch (RuntimeException e)
            {

            }
            */
            System.out.println("hello");
    }

    public static void throwCheckd(int a) throws Exception
    {
        if(a>0)
        {
            //自行抛出Exception异常
            //该代码必须处于try块，或者是后面带throws声明的方法中
            throw new Exception("a的值大于0，不符合要求");
        }
    }

    public static void throwRuntime(int a)
    {
        if(a>0)
        {
            /*
                自行抛出RuntimeException异常，既可以显示捕获该异常
                也可以完全不理会该异常，把该异常交给该方法的调用者处理
             */
            throw new RuntimeException("a的值大于0，不符合要求");
        }
    }
}
