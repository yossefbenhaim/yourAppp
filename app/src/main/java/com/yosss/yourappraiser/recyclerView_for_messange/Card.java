package com.yosss.yourappraiser.recyclerView_for_messange;

public class Card {

    private  String foolName,phone,cite, neighborhood,floor,metrim,rooms,luxuly,on_hone;



    public Card() {
    }

    public Card(String foolName, String phone, String cite, String neighborhood, String floor, String metrim, String rooms, String luxuly, String on_hone) {
        this.foolName = foolName;
        this.phone = phone;
        this.cite = cite;
        this.neighborhood = neighborhood;
        this.floor = floor;
        this.metrim = metrim;
        this.rooms = rooms;
        this.luxuly = luxuly;
        this.on_hone = on_hone;
    }

    public String getFoolName() {
        return foolName;
    }

    public void setFoolName(String foolName) {
        this.foolName = foolName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOn_hone() {
        return on_hone;
    }

    public void setOn_hone(String on_hone) {
        this.on_hone = on_hone;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMetrim() {
        return metrim;
    }

    public void setMetrim(String metrim) {
        this.metrim = metrim;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getLuxuly() {
        return luxuly;
    }

    public void setLuxuly(String luxuly) {
        this.luxuly = luxuly;
    }


    public String getCite() {
        return cite;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
