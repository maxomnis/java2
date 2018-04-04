package TestSerializable;

/**
 * 实现序列化
 */

import java.io.*;

class Person implements Serializable
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
}

public class TestSerializable  {

    public static void main(String[] args)
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/java2/src/TestSerializable/serializable.txt"));
            Person per = new Person("孙悟空", 500);
            //将per对象写入流
            oos.writeObject(per);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/java2/src/TestSerializable/serializable.txt"));

            //从输入流中读取一个java对象，并将其强制转化为为Person对象
            Person p = (Person) ois.readObject();
            System.out.println("name="+p.getName()+", age="+p.getAge());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
