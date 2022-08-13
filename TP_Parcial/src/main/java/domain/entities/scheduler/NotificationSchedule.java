package domain.entities.scheduler;


import domain.entities.BaseDatos;
import domain.entities.api.Compra_API;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class NotificationSchedule {


    public void comenzar() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail job = newJob(EmailJob.class).withIdentity("emailJob").build();
        SimpleTrigger trigger = newTrigger().withIdentity("executeEmail").startNow().withSchedule(simpleSchedule().withIntervalInSeconds(20).repeatForever()).build();
        scheduler.scheduleJob(job, trigger);
    }


}