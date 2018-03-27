package TestList;

import  java.util.List;
import  java.util.ArrayList;

class  A
{
    /**
     * Object obj 是被用来比较的参数
     * @param obj
     * @return
     */
    public boolean equals(Object obj)
    {
        System.out.println("in A.equals...."+obj);
        return false;
    }
}
public class TestList2 {

    public static void main(String[] args)
    {
            List books = new ArrayList();

            books.add(new String("轻量级javaee企业级"));
            books.add(new String("疯狂java讲义"));
            books.add(new String("疯狂android讲义"));

            System.out.println(books);

            /*
                程序试图删除一个A对象，List将会调用该A对象的equals方法依次与集合元素进行比较，
                如果该equals方法以某个集合元素作为参数时返回true，list将会删除该元素，A类重写了
                equals方法，该方法总是返回true,所以每次从list集合中删除A对象，总是删除第一个元素
             */
            //删除集合中的A对象，将导致第一个元素被删除
            books.remove(new A());

            //删除集合中A对象，再次删除集合中的第一个元素
            //books.remove(new A());
           System.out.println(books);
    }
}
