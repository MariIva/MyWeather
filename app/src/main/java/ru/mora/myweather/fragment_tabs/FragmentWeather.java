package ru.mora.myweather.fragment_tabs;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mora.myweather.R;
import ru.mora.myweather.retrofit.CurrentWeatherByIDResponse;
import ru.mora.myweather.retrofit.UserService;

public class FragmentWeather extends Fragment {

    private CurrentWeatherByIDResponse responseFromServer;
    TextView tv_city, tv_temp, tv_sun_rise, tv_sun_set, tv_temp_min, tv_temp_max,
             tv_wind_speed, tv_wind_nav, tv_humidity, tv_pressure;
    ImageView iv_icon;

    String ic_code, ic_time;

    public FragmentWeather() {
        // Required empty public constructor
    }


    public static FragmentWeather newInstance(String param1, String param2) {
        FragmentWeather fragment = new FragmentWeather();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment__weather, container, false);

        tv_city = (TextView) rootView.findViewById(R.id.tv_city);
        tv_temp = (TextView) rootView.findViewById(R.id.tv_temp);
        tv_sun_rise = (TextView) rootView.findViewById(R.id.tv_sun_rise);
        tv_sun_set = (TextView) rootView.findViewById(R.id.tv_sun_set);
        tv_temp_max = (TextView) rootView.findViewById(R.id.tv_temp_max);
        tv_temp_min = (TextView) rootView.findViewById(R.id.tv_temp_min);;
        tv_wind_speed = (TextView) rootView.findViewById(R.id.tv_wind_speed);
        tv_wind_nav = (TextView) rootView.findViewById(R.id.tv_wind_nav);
        tv_humidity = (TextView) rootView.findViewById(R.id.tv_humidity);
        tv_pressure = (TextView) rootView.findViewById(R.id.tv_pressure);
        iv_icon = (ImageView) rootView.findViewById(R.id.iv_icon);


        new MyAsyncTask().execute();
        return rootView;
    }

    class MyAsyncTask extends AsyncTask<String, String, CurrentWeatherByIDResponse> {

        // параметры доступа к серваку
        private String url = "http://api.openweathermap.org/";
        String id = 500095+""; // Рязань
        String key = "";
        String mode = "json";
        String units = "metric";
        String lang = "ru";

        @Override
        protected CurrentWeatherByIDResponse doInBackground(String... params) {
            // настройка библиотеки
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            // установка методов для доступа к серверу
            UserService service = retrofit.create(UserService.class);
            // настройка запроса
            Call<CurrentWeatherByIDResponse> response = service.getCurrentWeatherCall(id, key,mode,units,lang);
            try {
                // отправка запроса
                Response<CurrentWeatherByIDResponse> userResponse = response.execute();
                // получение тела запроса в вормате объекта класса
                responseFromServer = userResponse.body();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return responseFromServer;
        }

        @Override
        protected void onPostExecute(CurrentWeatherByIDResponse result) {
            super.onPostExecute(result);
            //textView.setText(result.toString());
            tv_city.setText(result.name);
            tv_temp.setText(""+result.main.temp);
            setIconCode(result.weather[0].id);
            setIconTime(result.sys.sunrise, result.sys.sunset);
            Drawable drawable = getResources().getDrawable(getResources()
                    .getIdentifier("ic_" + ic_code+ic_time, "drawable", getContext().getPackageName()));
            iv_icon.setImageDrawable(drawable);

            String hm = String.format("%02d:%02d", ((result.sys.sunrise +result.timezone)/ (60 * 60)) % 24,
                    ((result.sys.sunrise +result.timezone) / 60) % 60);
            tv_sun_rise.setText(hm);

            hm = String.format("%02d:%02d", ((result.sys.sunset +result.timezone)/ (60 * 60)) % 24,
                    ((result.sys.sunset +result.timezone) / 60) % 60);
            tv_sun_set.setText(hm);

            tv_temp_max.setText(""+result.main.temp_max);
            tv_temp_min.setText(""+result.main.temp_min);

            tv_humidity.setText(""+result.main.humidity);
            tv_pressure.setText(""+result.main.pressure);
            tv_wind_speed.setText(""+result.wind.speed);
            tv_wind_nav.setText(setSpeedNav(result.wind.deg));

        }

        void setIconCode(int code){
            switch (code){
                case 200:
                case 201:
                case 202:
                case 210:
                case 211:
                case 212:
                case 221:
                case 230:
                case 231:
                case 232:
                    ic_code = "11";
                    break;
                case 300:
                case 301:
                case 302:
                case 310:
                case 311:
                case 312:
                case 313:
                case 314:
                case 321:
                case 520:
                case 521:
                case 522:
                case 531:
                    ic_code = "09";
                    break;
                case 500:
                case 501:
                case 502:
                case 503:
                case 504:
                    ic_code = "10";
                    break;
                case 511:
                case 600:
                case 601:
                case 602:
                case 611:
                case 612:
                case 613:
                case 615:
                case 616:
                case 620:
                case 621:
                case 622:
                    ic_code = "13";
                    break;
                case 701:
                case 711:
                case 721:
                case 731:
                case 741:
                case 751:
                case 761:
                case 762:
                case 771:
                case 781:
                    ic_code = "50";
                    break;
                case 800:
                    ic_code = "01";
                    break;
                case 801:
                    ic_code = "02";
                    break;
                case 802:
                    ic_code = "03";
                    break;
                case 803:
                case 807:
                    ic_code = "04";
                    break;
            }
        }
        void setIconTime(long sunrise, long sunset){
            long time = System.currentTimeMillis();
            if (time>sunrise && time<sunset)
                ic_time = "d";
            else
                ic_time = "n";
        }
        String setSpeedNav(int degree){
            if (degree>337.5) return "С";
            if (degree>292.5) return "СЗ";
            if(degree>247.5) return "З";
            if(degree>202.5) return "ЮЗ";
            if(degree>157.5) return "Ю";
            if(degree>122.5) return "ЮВ";
            if(degree>67.5) return "В";
            if(degree>22.5){return "СВ";}
            return "Northerly";
        }
    }
}
