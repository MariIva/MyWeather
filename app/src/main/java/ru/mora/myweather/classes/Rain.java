package ru.mora.myweather.classes;

import com.google.gson.annotations.SerializedName;

public class Rain { // todo rain.1h
    @SerializedName("1h")
    public double _1h; //  Объем дождя за последний час, мм
    @SerializedName("3h")
    public double _3h; // Объем дождя за последние 3 часа, мм

    @Override
    public String toString() {
        return "Rain{" +
                "_1h=" + _1h +
                ", _3h=" + _3h +
                '}';
    }
}
