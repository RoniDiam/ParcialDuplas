package domain.entities;


import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class NotificationSchedule {
    public void jobEmail() {
        new EmailSender().sendNotification("zirofernandez39@gmail.com");
    }

    private CountDownLatch contadorSincronico = new CountDownLatch(1);

    public void comenzar() throws SchedulerException, InterruptedException {

    }



}
