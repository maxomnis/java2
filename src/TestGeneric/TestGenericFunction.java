package TestGeneric;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型通配符在方法中的使用
 */

public class TestGenericFunction {

    //声明一个泛型方法,该泛型方法中带一个T类型参数
    static <T> void fromArrayToCollection(T[] a, Collection<T> c)
    {
        for( T o :a)
        {
            c.add(o);
        }
    }

    public static void main(String[] args)
    {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<>();

        //下面代码中T代表Object类型
        fromArrayToCollection(oa, co);

        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<>();

        //下面代码T代表String类型
        fromArrayToCollection(sa, cs);

        //下面代码中T代表Object类型
        fromArrayToCollection(sa,co);

    }
}
