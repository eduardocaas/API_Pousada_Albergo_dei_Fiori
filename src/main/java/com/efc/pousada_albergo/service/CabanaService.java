package com.efc.pousada_albergo.service;

import com.efc.pousada_albergo.http.HttpConnector;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CabanaService {

    HttpConnector connector = new HttpConnector();

    @Scheduled(cron = "0 * * * * *")
    private void atualizaCabana1()
    {
        String icsUrl = "https://ical.booking.com/v1/export?t=004ab151-4832-475c-bb13-f9c73f5bb251";
        Calendar calendar = connector.getCalendar(icsUrl);

        ComponentList components = calendar.getComponents();

        for (Object obj : components) {
            if (obj instanceof VEvent) {
                VEvent event = (VEvent) obj;
                String summary = event.getSummary().getValue();
                Date startDate = event.getStartDate().getDate();
                Date endDate = event.getEndDate().getDate();
                System.out.println(startDate);
                System.out.println(endDate);
            }
        }
    }

}
