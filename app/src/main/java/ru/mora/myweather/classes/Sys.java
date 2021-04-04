package ru.mora.myweather.classes;

public class Sys {
    public int type; //  Внутренний параметр
    public int id;
    public double message; // Внутренний параметр
    public String country; // Код страны (Великобритания, Япония и т. Д.)
    public long sunrise; // Время восхода, unix, UTC
    public long sunset; // Время заката, unix, UTC

    @Override
    public String toString() {
        return "Sys{" +
                "type=" + type +
                ", id=" + id +
                ", message=" + message +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
