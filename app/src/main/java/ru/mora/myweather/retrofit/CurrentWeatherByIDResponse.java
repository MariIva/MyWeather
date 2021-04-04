package ru.mora.myweather.retrofit;

import java.util.Arrays;

import ru.mora.myweather.classes.Coordinates;
import ru.mora.myweather.classes.Main;
import ru.mora.myweather.classes.Rain;
import ru.mora.myweather.classes.Show;
import ru.mora.myweather.classes.Sys;
import ru.mora.myweather.classes.Weather;
import ru.mora.myweather.classes.Wind;

public class CurrentWeatherByIDResponse {
    public Coordinates coord;
    public Weather [] weather;
    public String base; // Внутренний параметр
    public Main main;
    public int visibility;
    public Wind wind;
    public Rain rain;
    public Show show;
    public long dt; // Время расчета данных, unix, UTC
    public Sys sys;
    public int timezone; // Сдвиг в секундах от UTC
    public long id; // ID города
    public String name; // Название города
    public int cod; // Внутренний параметр

    @Override
    public String toString() {
        return "CurrentWeatherResponse{" +
                "coord=" + coord +
                ", weather=" + Arrays.toString(weather) +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", rain=" + rain +
                ", show=" + show +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }

}
