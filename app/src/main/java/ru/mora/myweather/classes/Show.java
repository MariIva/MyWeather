package ru.mora.myweather.classes;

import com.google.gson.annotations.SerializedName;

public class Show { // todo show.1h
    @SerializedName("1h")
    public double _1h; // Объем снега за 1 час, мм
    @SerializedName("3h")
    public double _3h; // Объем снега за последние 3 часа, мм

    @Override
    public String toString() {
        return "Show{" +
                "_1h=" + _1h +
                ", _3h=" + _3h +
                '}';
    }
}
