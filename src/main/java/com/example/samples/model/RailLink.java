/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.model;

import javax.persistence.*;

@Entity
@Table(name = "raillink")
public class RailLink {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    private City startCity;

    @ManyToOne
    private City destinationCity;

    @Column(name = "soldticket")
    private int soldTicket;

    @Column(name = "price")
    private int price;

    public RailLink() {
        this.soldTicket = 0;
    }

    public RailLink(City startCity, City destinationCity, int price) {
        this.setStartCity(startCity);
        this.setDestinationCity(destinationCity);
        this.setPrice(price);
        this.setSoldTicket(0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getSoldTicket() {
        return soldTicket;
    }

    public void setSoldTicket(int soldTicket) {
        this.soldTicket = soldTicket;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
