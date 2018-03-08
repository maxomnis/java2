package classandobject;


public class Puppy {
    int pupyAge;

    public Puppy(String name) {
        System.out.println("Puppy name is" + name);
    }

    public void setAge(int age) {
        pupyAge = age;
    }

    public int getAge() {
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