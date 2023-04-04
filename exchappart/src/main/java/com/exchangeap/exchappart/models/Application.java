package com.exchangeap.exchappart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int rooms;
    private float area;
    private String city, floor, region,  wantfloor, wantregion, number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWantfloor() {
        return wantfloor;
    }

    public void setWantfloor(String wantfloor) {
        this.wantfloor = wantfloor;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWantregion() {
        return wantregion;
    }

    public void setWantregion(String wantregion) {
        this.wantregion = wantregion;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Application() {
    }
    public Application(
            int rooms,
            float area,
            String city,
            String floor,
            String wantfloor,
            String region,
            String wantregion,
            String number) {
        this.rooms = rooms;
        this.floor = floor;
        this.wantfloor = wantfloor;
        this.area = area;
        this.city = city;
        this.region = region;
        this.wantregion = wantregion;
        this.number = number;
    }
}
