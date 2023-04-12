package com.dkhomyk.restapitest.Service;

import com.dkhomyk.restapitest.Model.Api;
import com.dkhomyk.restapitest.Model.Positions;
import com.dkhomyk.restapitest.Model.Response;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApiService {

    List<Date> date = new ArrayList<>();
    List<Double> lat_list = new ArrayList<>();
    List<Double> lng_list = new ArrayList<>();
    TreeMap<Date, Double> map1 = new TreeMap<>();
    TreeMap<Date, Double> map2 = new TreeMap<>();
    int duration = 0;
    double distance = 0;
    double speed = 0;


    public Response calculation(Api api, Response response) {
        int i = 0;

        for (Positions k : api.getPositions()) {
            date.add(k.getTime());
            lat_list.add(k.getLat());
            lng_list.add(k.getLng());
            map1.put(date.get(i), lat_list.get(i));
            map2.put(date.get(i), lng_list.get(i));
            i = i + 1;
        }
        Collections.sort(date);
        duration = (int) (date.get(date.size() - 1).getTime() - date.get(0).getTime()) / 1000;
        response.setDuration(duration);

        for (int p = 0; p < date.size(); p++) {
            if (p + 1 == date.size()) {
                break;
            } else {
                double lat1 = Math.toRadians(map1.get(date.get(p)));
                double lat2 = Math.toRadians(map1.get(date.get(p + 1)));
                double lon1 = Math.toRadians(map2.get(date.get(p)));
                double lon2 = Math.toRadians(map2.get(date.get(p + 1)));
                distance += (float) Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * 6371 * 1000;
                System.out.println(Precision.round(distance, 1));
            }
        }
        speed = distance / duration;
        Response response1 = new Response(api.getUuid(), distance, duration, speed);
        return response1;

    }
}
