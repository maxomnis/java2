import classandobject.TestFinal;

class Name
{
    private String firstName;
    private  String lastName;
    public  Name() {};
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public  Name(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
public class TestFinal2 {
    /**
     * 试图定义一个不可变的类TestFinal2的，但是这里的Name虽然是final的，所以Name的值依然是可以改变的；因为，
     * 当使用final修饰引用变量时，仅表示这个引用类型的变量不可被重新赋值（引用变量的值是这个变量的内存地址），
     * 但引用类型变量所指向的对象依然可以改变。
     * 但是这里是想定义已不可改变的TestFinal2对象，但是这里的private final Name name； 依然是可以改变的
     *
     */
    private final Name name;

/*
    public TestFinal2(Name name)
    {
        this.name = name;
    }

    public Name getName()
    {
        return name;
    }
*/


    /**
     * 为了保证TestFinal2的不可变性，必须保护好TestFinal2对象的引用类型的成员变量：name,让程序无法访问到TestFinal2对象
     * 成员变量，就无法利用name成员的可变性来改变TestFinal2了,下面是上面的改版，正确的做法，这样就无法改变了
     * @param
     */

    public TestFinal2(Name name)
    {
        this.name = new Name(name.getFirstName(), name.getFirstName());
    }

    public Name getName()
    {
        return new Name(name.getFirstName(), name.getLastName());
    }


    public static void main(String[] args)
    {
        Name n = new Name("悟空","孙");
        TestFinal2 p = new TestFinal2(n);

        System.out.println(p.getName().getFirstName());

        n.setFirstName("八戒");
        System.out.println(p.getName().getFirstName());

        Integer a = Integer.valueOf(10);
    }

}
