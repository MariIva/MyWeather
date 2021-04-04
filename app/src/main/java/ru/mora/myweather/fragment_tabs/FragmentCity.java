package ru.mora.myweather.fragment_tabs;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import ru.mora.myweather.R;
import ru.mora.myweather.adapters.CityListAdapter;
import ru.mora.myweather.classes.City;

public class FragmentCity extends Fragment {

    private static final String FILE_NAME = "city.list.json";
    RecyclerView recyclerView;
    ArrayList<City> cities;

    public FragmentCity() {
        // Required empty public constructor
    }

    public static FragmentCity newInstance(String param1, String param2) {
        FragmentCity fragment = new FragmentCity();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        String json_str = getJsonFromAssets(getContext());

        Type itemsListType = new TypeToken<List<City>>() {}.getType();
        Gson gson = new Gson();
        cities =  gson.fromJson(json_str, itemsListType);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment__city, container, false);

        recyclerView = rootView.findViewById(R.id.list_city);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        // создаем адаптер заполняющий список
        CityListAdapter adapter = new CityListAdapter(getContext(), this.cities);
        // устанавливаем адаптер
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    // чтение json из файла
    String getJsonFromAssets(Context context) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }
}