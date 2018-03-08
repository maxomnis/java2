/*
* 使用字符时，我们通常使用的是内置数据类型char。
*
* 然而，在实际开发过程中，我们经常会遇到需要使用对象，而不是内置数据类型的情况。为了解决这个问题，Java语言为内置数据类型char提供了包装类Character类。
Character类提供了一系列方法来操纵字符。你可以使用Character的构造方法创建一个Character类对象，例如：
Character ch = new Character('a');
在某些情况下，Java编译器会自动创建一个Character对象。
例如，将一个char类型的参数传递给需要一个Character类型参数时，那么编译器会自动地将char类型参数转换为Character对象。 这种特征称为装箱，反过来称为拆箱。

* */
public class TestCharacter {
    public static void main(String[] args)
    {
        Character ch = new Character('a');
    }
}
