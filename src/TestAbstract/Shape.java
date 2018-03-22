package TestAbstract;

public abstract class Shape {

    {
        System.out.println("执行shape的初始化模块");
    }

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double calPerimeter();

    //
    public abstract String getType();

    public Shape() {}

    public Shape(String color)
    {
        System.out.println("执行shape的构造器");
        this.color = color;
    }


}
