package dynamic.proxy;

/**
 * 摘自廖雪峰的博客
 * @author zhangjun
 * 
 * 最原始的静态代理的实现方式
我们来比较Java的class和interface的区别：

可以实例化class（非abstract）；
不能实例化interface。
所有interface类型的变量总是通过向上转型并指向某个实例的：

CharSequence cs = new StringBuilder();
有没有可能不编写实现类，直接在运行期创建某个interface的实例呢？

这是可能的，因为Java标准库提供了一种动态代理（Dynamic Proxy）的机制：可以在运行期动态创建某个interface的实例。

什么叫运行期动态创建？听起来好像很复杂。所谓动态代理，是和静态相对应的。我们来看静态代码怎么写：
 *
 */
public class TestProxy {
	public static void main(String[] args) {
		Hello hello = new HelloWorld();
		hello.morning("Bob");
	}
}

/**
 * 类或者接口没有修饰夫，默认的修饰符就是同一个包的都可以访问
 * @author zhangjun
 *
 */
interface Hello {
	void morning(String name);
}

class HelloWorld implements Hello {
	public void morning(String name) {
		System.out.println("Good morning, " + name);
	}
}