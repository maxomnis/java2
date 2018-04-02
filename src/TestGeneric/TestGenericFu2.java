package TestGeneric;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符( ? )使用，设定类型通配符的上限
 */

class Animal
{
    private String name;
    public Animal() {}
    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Cat extends Animal
{
    private String name;
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
public class TestGenericFu2 {

    static void test(List<? extends Animal> list)   //List只能是存放Animal的子类
    {
        for (Animal s: list)
        {
            System.out.println(s);
        }
    }

    public static void main(String[] args)
    {
        List<Animal> cats = new ArrayList<>();
        cats.add(new Cat("blue"));
        cats.add(new Cat("red"));
        test(cats);
    }
}
