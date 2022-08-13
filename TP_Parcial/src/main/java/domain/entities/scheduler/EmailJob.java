package domain.entities.scheduler;

import domain.entities.BaseDatos;
import domain.entities.api.Compra_API;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;
    public  class EmailJob implements Job {
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

