package domain.entities.scheduler;

import db.BaseDatos;
import domain.entities.api.Adapter;
import domain.entities.sender.ContextoSender;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.List;
//Cambiar para que use el strategy
    public  class EmailJob implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            BaseDatos base = new BaseDatos();
            Adapter consulta = new Adapter();

            try {
                List cryptos = base.traerTop10();
                List cryptosPrice = new ArrayList();
                cryptos.stream().forEach(element -> {
                    try {
                        cryptosPrice.add(consulta.getPrice(element.toString()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

                String msg = cryptos.toString() + cryptosPrice.toString();

                ContextoSender.getInstancia().sendNotificacion(msg);





            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

