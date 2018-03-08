package generics;

/*
* 泛型的使用
* */
public class TestGenerics {

    /*
    ava 泛型

如果我们只写一个排序方法，就能够对整形数组、字符串数组甚至支持排序的任何类型的数组进行排序，这该多好啊。
Java泛型方法和泛型类支持程序员使用一个方法指定一组相关方法，或者使用一个类指定一组相关的类型。
Java泛型（generics）是JDK 5中引入的一个新特性,泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
使用Java泛型的概念，我们可以写一个泛型方法来对一个对象数组排序。然后，调用该泛型方法来对整型数组、浮点数数组、字符串数组等进行排序。
泛型方法

你可以写一个泛型方法，该方法在调用时可以接收不同类型的参数。根据传递给泛型方法的参数类型，编译器适当地处理每一个方法调用。
下面是定义泛型方法的规则：
所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）。
每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
泛型方法方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
     */
    public static <E> void printArray(E[] inputArray)
    {
        for( E element:inputArray)
        {
            System.out.printf("%s,", element);
        }

        System.out.println();
    }


    public static void main(String[] args)
    {
        //创建不同类型的数组
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};

        Character[] charArray  = {'h','e','l', 'l','o'};

        System.out.println("array interArray contains:");
        printArray(intArray); //传递一个整形数组

        System.out.println("\narray doublearray contains:");
        printArray(doubleArray); //传递一个双精度类型数组

        System.out.println("\narray characterarray contains");
        printArray(charArray);
    }
}
