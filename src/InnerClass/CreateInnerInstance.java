package InnerClass;

/**
 * 在外部类以外的地方调用内部类
 */
class  Out
{

    //定义一个内部类，不使用访问控制符
    //即同一个保重的其他类访问内部类
    class In
    {
        public In(String msg)
        {
            System.out.println(msg);
        }
    }
}

public class CreateInnerInstance {

        public static void main(String[] args)
        {
            Out.In  in = new Out().new In("测试信息");

        }
}
