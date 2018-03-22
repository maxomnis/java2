package InnerClass;

/**
 * 内部类提供了更好的封装，可以把内部类隐藏在外部类之内，不允许同一个包中的其他类访问该类。
 * 内部类可以直接访问外部类的私有数据，因为内部类被当成其外部类的成员。
 * 内部类适用于创建那些仅需要一次使用的类
 *
 * 内部类与外部类的区别：
 * 1. 内部类比外部类可以多使用private,protected,static，外部类不可以使用这三个修饰符
 * 2. 非静态内部类不能拥有静态成员
 */
public class Cow {

    String prop="外部类的实例变量";
    private double weight;

    public Cow(){}

    public Cow(double weight)
    {
        this.weight = weight;
    }

    //定义一个非静态内部类，private权限
    private  class  CowLeg
    {

        String prop="内部类变量";

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        //非静态内部类的两个实例变量
        private  double length;
        private  String color;

        //非静态内部类的两个重载的构造器
        public  CowLeg() {}
        public  CowLeg(double length, String color)
        {
            this.length = length;
            this.color = color;
        }

        //非静态内部类的实例方法
        public void info()
        {
            String prop="局部变量";

            System.out.println("当前牛腿颜色是"+color+", 高:"+length);

            //直接访问外部类的private修饰的成员变量
            System.out.println("本牛腿所在奶牛重"+weight);


            System.out.println(Cow.this.prop); //外部类实例变量
            System.out.println(this.prop);    //内部类实例变量
            System.out.println(prop);         //局部变量
        }
    }


    public void test()
    {
        CowLeg c1 = new CowLeg(1.12, "黑白相间");
        c1.info();
    }

    public static void  main(String[] args)
    {
        Cow cow = new Cow(378.9);
        cow.test();
    }
}
