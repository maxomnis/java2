package TestGeneric;

import java.util.*;

/**
 * 泛型使用
 */
public class GenericList {

    public static void main(String[] args)
    {
        //创建一个只保存字符的list集合
        List<String> strList = new ArrayList<String>();
        strList.add("疯狂java讲义");
        strList.add("疯狂android讲义");

        //下面代码引起编译错误
        //strList.add(5);

        //输出每个字符串的长度
        strList.forEach(str->System.out.println(str.length()));

        /*
        * 在java7以前，使用泛型的接口，类定义变量，可那么调用构造器创建对象时候，构造器的后面也要必须带上泛型类型，这显得
        * 有点多余比如，  List<String> strList = new ArrayList<String>();，在java7以前必须的，从java7开始，运行构造器
        * 后不需要带上完整的泛型信息，只要给一个尖括号即可，java可以推断尖括号应该是什么泛型信息
        * List<String> strList = new ArrayList<>()
        *
        */

        //java自动推断出ArrayList的<>应该是String
        List<String> books = new ArrayList<>();
        books.add("疯狂的java讲义");
        books.add("疯狂android讲义");

        //遍历books集合，集合元素就是String类型
        books.forEach(ele->System.out.println(ele.length()));

        //java自动推断出HashMap的<>应该是String, List<String>
        Map<String, List<String>> schoolsInfo = new HashMap<>();//居然可以Map里面再套集合

        List<String> schools = new ArrayList<>();
        schools.add("斜月三星洞");
        schools.add("西天取经路");

        schoolsInfo.put("孙悟空", schools);

        schoolsInfo.forEach((k, value)->System.out.println(k+"--->"+value));
    }
}
