package ru.mora.myweather.classes;

public class Wind {
    public double speed; // Скорость ветра. Единица измерения по умолчанию: метр / сек
    public int deg; // Направление ветра, градусы (метеорологические)
    public double gust; // Порыв ветра.

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                '}';
    }
}
