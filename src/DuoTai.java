interface  Vegetarian{
    public void ho();
}

class Animal{
    public void eat()
    {
        System.out.println("eat food");
    }
};

public class DuoTai extends  Animal implements Vegetarian{

    public void ho()
    {
        System.out.println("ho,ho.....");
    }
    public static void main(String[] args)
    {
        DuoTai d = new DuoTai();

        Animal a = d;

        Vegetarian v =d;     //这也行？

        Object o = d;

     /*
        v.eat();   //v是不能调用eat方法的，因为v是Vegetarian接口，他是没有eat方法的
        a.eat();   //a可以调用eat方法，因为DuoTai继承了Animal,这里的a是Animal
        */
    }
}


