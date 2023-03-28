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
    private int rooms, wantrooms, floor, wantfloor;
    private float area, wantarea;
    private String city, region, wantregion, number;

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

    public int getWantrooms() {
        return wantrooms;
    }

    public void setWantrooms(int wantrooms) {
        this.wantrooms = wantrooms;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getWantfloor() {
        return wantfloor;
    }

    public void setWantfloor(int wantfloor) {
        this.wantfloor = wantfloor;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getWantarea() {
        return wantarea;
    }

    public void setWantarea(float wantarea) {
        this.wantarea = wantarea;
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
            int wantrooms,
            int floor,
            int wantfloor,
            float area,
            float wantarea,
            String city,
            String region,
            String wantregion,
            String number) {
        this.rooms = rooms;
        this.wantrooms = wantrooms;
        this.floor = floor;
        this.wantfloor = wantfloor;
        this.area = area;
        this.wantarea = wantarea;
        this.city = city;
        this.region = region;
        this.wantregion = wantregion;
        this.number = number;
    }
}
