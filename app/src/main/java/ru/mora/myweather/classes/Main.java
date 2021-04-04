package ru.mora.myweather.classes;

public class Main {
    public double temp; // Температура. Единица измерения по умолчанию: Кельвин
    public double feels_like; // Температура. Этот температурный параметр объясняет человеческое восприятие погоды
    public double temp_min; // Минимальная температура на данный момент.
    public double temp_max; // Максимальная температура на данный момент
    public double pressure; // Атмосферное давление
    public double sea_level; // Атмосферное давление на уровне моря, гПа
    public double grnd_level; // Атмосферное давление на уровне земли, гПа
    public double humidity; // Влажность, %

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", pressure=" + pressure +
                ", sea_level=" + sea_level +
                ", grnd_level=" + grnd_level +
                ", humidity=" + humidity +
                '}';
    }
}
