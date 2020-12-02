package test.thead;

import java.time.LocalTime;

/**
 * 守护线程
 * 在Java中有两类线程：用户线程 (User Thread)、守护线程 (Daemon Thread)。

所谓守护 线程，是指在程序运行的时候在后台提供一种通用服务的线程，比如垃圾回收线程就是一个很称职的守护者，
并且这种线程并不属于程序中不可或缺的部分。因 此，当所有的非守护线程结束时，程序也就终止了，
同时会杀死进程中的所有守护线程。反过来说，只要任何非守护线程还在运行，程序就不会终止。

用户线程和守护线程两者几乎没有区别，唯一的不同之处就在于虚拟机的离开：如果用户线程已经全部退出运行了，
只剩下守护线程存在了，虚拟机也就退出了。 因为没有了被守护者，守护线程也就没有工作可做了，也就没有继续运行程序的必要了。

将线程转换为守护线程可以通过调用Thread对象的setDaemon(true)方法来实现。在使用守护线程时需要注意一下几点：

(1) thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常
。你不能把正在运行的常规线程设置为守护线程。 

(2) 在Daemon线程中产生的新线程也是Daemon的。

(3) 守护线程应该永远不去访问固有资源，如文件、数据库，因为它会在任何时候甚至在一个操作的中间发生中断。
 * @author zhangjun
 *
 */
public class TestDeamonThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start....."+LocalTime.now());
		TimerThread t = new TimerThread();
		t.setDaemon(true);
		t.start();
		System.out.println("main end....."+LocalTime.now());

	}

}


class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
