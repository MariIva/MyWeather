package ru.mora.myweather.classes;

public class Coordinates {
    public  double lon; // долгота
    public  double lat; // широта

    @Override
    public String toString() {
        return "Coordinates{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
