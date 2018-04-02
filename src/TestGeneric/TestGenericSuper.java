package TestGeneric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 通配符的下线
 */
public class TestGenericSuper {

    //下面dest集合的类型必须与src集合元素的类型相同，或是其父类

    public static <T> T copy(Collection<? super T> dest, Collection<T> src)
    {
        T last =null;
        for(T ele: src)
        {
            last = ele;
            dest.add(ele);
        }
        return last;
    }

    public static void main(String[] args)
    {
        List<Number> in = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(5);

        //此处可以准确地知道最后一个被复制的元素是Integer类型
        //与src集合元素的类型相同
        Integer last = copy(in, li);
        System.out.println(in);
    }
}
