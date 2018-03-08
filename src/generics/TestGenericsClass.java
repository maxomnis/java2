package generics;

import java.util.Random;

/*
泛型类

泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。
和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，
是用于指定一个泛型类型名称的标识符。因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。
 */
public class TestGenericsClass<T> {

    private  T t;

    public void add(T t)
    {
        this.t = t;
    }

    public T get()
    {
        return t;
    }


    public static void main(String[] args)
    {
        TestGenericsClass<Integer> interBox = new TestGenericsClass<Integer>();
        TestGenericsClass<String> stringBox = new TestGenericsClass<String>();

        interBox.add(new Integer(10));
        stringBox.add(new String("hello world"));

        System.out.printf("integer value %d\n\n", interBox.get());

         System.out.printf("string value %s\n", stringBox.get());


        Contaniner<String, String> c1 = new Contaniner<String, String>("name", "findingsea");

        Contaniner<String,Integer> c2 = new Contaniner<String, Integer>("age", 20);

        System.out.println(c1.getKey()+":"+c1.getValue());
        System.out.println(c2.getKey()+":"+c2.getValue());


        FruitGenerator generator = new FruitGenerator();
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());




    }





}


/*
泛型类的使用
 */
class Contaniner<K, V>
{
    private K key;
    private V value;

    public Contaniner(K k, V v)
    {
        this.key = k;
        this.value =v;
    }

    public K getKey()
    {
        return key;
    }


    public void setKey(K key)
    {
        this.key = key;
    }

    public V getValue()
    {
        return value;
    }


    public void setValue(V value)
    {
        this.value = value;
    }
}

/*
泛型接口的使用
 */

interface Generator<T>
{
    public  T next();
}

class FruitGenerator implements Generator<String>
{
    private String[] fruits = new String[]{"apple", "banana", "pear"};

    public String next()
    {
        Random rand = new Random();
        return fruits[rand.nextInt(3)]; //获取0到2之前的随机数
    }
}



