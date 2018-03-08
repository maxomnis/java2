public class TestType {

    public String name = "dog";
    public void pupAge()
    {
        int age=0;
        age = age+7;
        System.out.println("puppy age is:"+age);
    }

    public static void main(String[] args)
    {
        TestType test = new TestType();
        test.pupAge();
        System.out.println(test.name);
    }
}
