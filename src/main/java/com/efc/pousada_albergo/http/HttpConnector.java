package com.efc.pousada_albergo.http;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnector {

    public Calendar getCalendar(String icsUrl)
    {
        try {
            URL url = new URL(icsUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            CalendarBuilder builder = new CalendarBuilder();
            Calendar calendar = builder.build(inputStream);
            inputStream.close();
            return calendar;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
