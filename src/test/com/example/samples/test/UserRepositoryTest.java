package com.example.samples.test;
/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */


import com.example.samples.model.*;
import org.junit.Test;

import java.util.List;

public class UserRepositoryTest {

//    @Test
//    public void UserTest() {
//        Role role = new Role("admin");
//        User user = new User("ja", "password", role);
//        RoleRepository.getInstance().save(role);
//        UserRepository.getInstance().save(user);
//    }

//    @Test
//    public void RailTest() {
//        City city1 = new City();
//        city1.setName("Wrocław");
//        City city2 = new City();
//        city2.setName("Katowice");
//        RailRepository.getInstance().save(city1);
//        RailRepository.getInstance().save(city2);
//
//        RailLink link1 = new RailLink();
//        link1.setStartCity(city1);
//        link1.setDestinationCity(city2);
//        RailRepository.getInstance().save(link1);
//    }

    @Test
    public void RailTest2() {
        List<City> list = RailRepository.getInstance().findCityByExactString("Wrocław");
        System.out.println("Full: ");
        for (City c : list) {
            System.out.println(c.getName());
        }
        list = RailRepository.getInstance().findCityByPartialString("Wro");
        System.out.println("Part: ");
        for (City c : list) {
            System.out.println(c.getName());
        }
        System.out.println("Links: ");
        List<RailLink> list2 = RailRepository.getInstance().findRailLinkByStartCity("Wrocław");
        for (RailLink r : list2) {
            System.out.println(r.getStartCity().getName() + " -> " + r.getDestinationCity().getName());
        }
        System.out.println("All:");
        list = RailRepository.getInstance().getAllCities();
        for (City c : list) {
            System.out.println(c.getName());
        }
    }


}
