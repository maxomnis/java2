package serializable;

public class Employee implements java.io.Serializable {
    public String name;
    public  String address;
    public  transient  int SSN;  //transient 说明其是不可序列话的，因为一个类里面，总有属性是不一定要序列化的，比如银行卡密码之类的
    public  int number;

    public void mailCheck()
    {
        System.out.println("mailing a check to "+name+" "+address);
    }
}
