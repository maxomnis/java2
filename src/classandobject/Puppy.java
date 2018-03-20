package classandobject;


public class Puppy {
    private int pupyAge;

    /**
     * 构造器不能写返回值类型，void也不行，因为构造函数是隐式返回的
     * @param name 名字
     */
    private Puppy(String name) {
        System.out.println("Puppy name is" + name);
    }

    private void setAge(int age) {
        pupyAge = age;
    }

    private int getAge() {
        System.out.println("puppy's age is:" + pupyAge);
        return pupyAge;
    }

    public static void main(String args[]){
        Puppy myPuppy = new Puppy("tommy");

        myPuppy.setAge(2);

        myPuppy.getAge();

        System.out.println("Variable value:" + myPuppy.pupyAge);
    }
}