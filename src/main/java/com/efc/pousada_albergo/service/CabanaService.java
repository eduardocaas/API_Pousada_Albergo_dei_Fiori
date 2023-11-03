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
            }
        }
    }

    @Scheduled(cron = "0 * * * * *")
    private void atualizaCabana2()
    {
        String icsUrl = "https://ical.booking.com/v1/export?t=642c91f5-2659-4965-a8ac-0990d98baa47";
        Calendar calendar = connector.getCalendar(icsUrl);

        ComponentList components = calendar.getComponents();

        for (Object obj : components) {
            if (obj instanceof VEvent) {
                VEvent event = (VEvent) obj;
                String summary = event.getSummary().getValue();
                Date startDate = event.getStartDate().getDate();
                Date endDate = event.getEndDate().getDate();
            }
        }
    }

    @Scheduled(cron = "0 * * * * *")
    private void atualizaCabana3()
    {
        String icsUrl = "https://ical.booking.com/v1/export?t=df888a62-5a48-4be8-8330-9d2ba3accf9c";
        Calendar calendar = connector.getCalendar(icsUrl);

        ComponentList components = calendar.getComponents();

        for (Object obj : components) {
            if (obj instanceof VEvent) {
                VEvent event = (VEvent) obj;
                String summary = event.getSummary().getValue();
                Date startDate = event.getStartDate().getDate();
                Date endDate = event.getEndDate().getDate();
            }
        }
    }

    @Scheduled(cron = "0 * * * * *")
    private void atualizaCabana4()
    {
        String icsUrl = "https://ical.booking.com/v1/export?t=4effcd71-229d-4097-8755-e28538c834b9";
        Calendar calendar = connector.getCalendar(icsUrl);

        ComponentList components = calendar.getComponents();

        for (Object obj : components) {
            if (obj instanceof VEvent) {
                VEvent event = (VEvent) obj;
                String summary = event.getSummary().getValue();
                Date startDate = event.getStartDate().getDate();
                Date endDate = event.getEndDate().getDate();
            }
        }
    }

}
