package ru.mora.myweather.classes;

public class Weather {
    public int id;
    public String main; // Дождь, Снег, Экстрим и др.
    public String description;
    public String icon; // Идентификатор значка погоды

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
