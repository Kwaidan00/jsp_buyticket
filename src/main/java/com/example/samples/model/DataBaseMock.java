/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.model;

import java.util.ArrayList;
import java.util.List;

public class DataBaseMock {

    private static final String WROCLAW = "Wrocław";
    private static final String KATOWICE = "Katowice";
    private static final String WARSZAWA = "Warszawa";
    private static final String POZNAN = "Poznań";
    private static final String JELENIA_GORA = "Jelenia Góra";

    private static final City wroclaw = new City(WROCLAW);
    private static final City katowice = new City(KATOWICE);
    private static final City warszawa = new City(WARSZAWA);
    private static final City poznan = new City(POZNAN);
    private static final City jelenia = new City(JELENIA_GORA);

    private static City[] cities = new City[]{
            wroclaw,
            katowice,
            warszawa,
            poznan,
            jelenia
    };

    private static RailLink[] links = new RailLink[]{
            new RailLink(wroclaw, katowice, 32),
            new RailLink(wroclaw, warszawa, 52),
            new RailLink(wroclaw, poznan, 36),
            new RailLink(wroclaw, jelenia, 40),
            new RailLink(warszawa, katowice, 60),
            new RailLink(warszawa, poznan, 50),
            new RailLink(jelenia, warszawa, 70),
            new RailLink(poznan, katowice, 55)
    };

    public static City[] getAllCities() {
        return cities;
    }

    public static RailLink[] getAllLinks() {
        return links;
    }

    public static List<City> findCityByExactString(String pattern) {
        List<City> founded = new ArrayList<>();
        for (City city : cities) {
            if (city.getName().equals(pattern)) {
                founded.add(city);
            }
        }
        return founded;
    }

    public static List<City> findCityByPartialString(String pattern) {
        List<City> founded = new ArrayList<>();
        for (City city : cities) {
            if (city.getName().contains(pattern)) {
                founded.add(city);
            }
        }
        return founded;
    }

    public static List<RailLink> findRailLinkByStartCityName(String pattern) {
        List<RailLink> founded = new ArrayList<>();
        for (RailLink link : links) {
            if (link.getStartCity().getName().contains(pattern)) {
                founded.add(link);
            }
        }
        return founded;
    }

}
