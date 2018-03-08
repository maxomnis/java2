public class operation {

    public static void main(String[] args)
    {
        int x = 10;

        while(x<20)
        {
            System.out.println("value of "+x);
            x++;
            System.out.println("value of "+x);
        }

        //for循环
        for(int y=0; y<20; y++)
        {
            System.out.print(y);
            System.out.print(',');
        }

        //java5开始加入的循环
        int[] numbers = {10,20,30,40,50};
        for(int a: numbers)
        {
            System.out.print(a);
            System.out.print(',');
        }
    }
}
