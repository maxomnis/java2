package test.timer;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MyTaskH extends TimerTask {
    @Override
    public void run()
    {
        DateFormat dateFormat = TimeUtil.df.get();
        System.out.println("我的任务运行了" + dateFormat.format(new Date()));
    }
}