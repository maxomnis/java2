package test.timer;

import java.util.Timer;

public class Run {
    private static Timer timer=new Timer();

    public static void main(String[] args) throws Exception
    {
       // timer.schedule(new MyTaskH(), TimeUtil.df.get().parse("2017-09-14 09:19:30"));
        timer.schedule(new MyTaskH(), 0 ,2000);
    }
}