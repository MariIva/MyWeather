package ru.mora.myweather.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.mora.myweather.R;
import ru.mora.myweather.classes.City;

public class CityListAdapter extends RecyclerView.Adapter<CityListHolder>{

    private final LayoutInflater inflater;
    private final ArrayList<City> cities;
    private Context mContext;

    public CityListAdapter(Context context, ArrayList<City> cities) {
        this.inflater = LayoutInflater.from(context);
        this.cities = cities;
        this.mContext = context;
    }
    @NonNull
    @Override
    public CityListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_city_item, parent, false);
        return new CityListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityListHolder holder, int position) {
        City city = cities.get(position);

        // заполняем View в пункте списка данными
        holder.name.setText(city.name);
        holder.country.setText(city.country);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }
}

class CityListHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public TextView country;

    public CityListHolder(@NonNull View itemView) {
        super(itemView);
        // получение всех элементов
        name = (TextView) itemView.findViewById(R.id.list_name);
        country = (TextView) itemView.findViewById(R.id.list_country);

    }
}