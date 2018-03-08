import java.util.Scanner;


/*
java.util.Scanner是Java5的新特征，我们可以通过 Scanner 类来获取用户的输入。
下面是创建 Scanner 对象的基本语法：
 Scanner s = new Scanner(System.in);
接下来我们演示一个最简单的的数据输入，并通过 Scanner 类的 next() 与 nextLine() 方法获取输入的字符串，在读取前我们一般需要 使用 hasNext 与 haxNextLine 判断是否还有输入的数据：
 */
public class TestScanner {

    public static void main(String[] args)
    {

        //从键盘接收数据
        Scanner scan = new Scanner(System.in);

        System.out.println("next方式接收");

        //判断是否有输入
        if(scan.hasNext())
        {
            String str1 = scan.next();
            System.out.println("输入的数据为"+str1);
        }
    }
}
