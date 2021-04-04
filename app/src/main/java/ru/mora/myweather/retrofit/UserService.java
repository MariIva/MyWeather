package ru.mora.myweather.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    // запрос на текущую погоду в гоороде
    @GET("/data/2.5/weather")
    Call<CurrentWeatherByIDResponse> getCurrentWeatherCall(@Query("id") String id,
                                                           @Query("appid") String key,
                                                           @Query("mode") String mode,
                                                           @Query("units") String units,
                                                           @Query("lang") String lang);
}
