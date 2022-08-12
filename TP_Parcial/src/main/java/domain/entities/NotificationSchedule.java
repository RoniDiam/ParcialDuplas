package domain.entities;


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

    public static class EmailJob implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            BaseDatos base = new BaseDatos();
            Compra_API api = new Compra_API();

            try {
                List cryptos = base.traerTop10();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}