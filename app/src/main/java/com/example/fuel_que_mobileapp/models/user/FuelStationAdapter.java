package com.example.fuel_que_mobileapp.models.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fuel_que_mobileapp.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FuelStationAdapter extends RecyclerView.Adapter<FuelStationAdapter.CustomViewHolder>  {

    private final Context context;
    private final ArrayList<StationCardViewModel> cardList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick( int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public FuelStationAdapter(Context context, ArrayList<StationCardViewModel> cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_card_view, parent, false);
        return new CustomViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        StationCardViewModel model = cardList.get(position);
        holder.stationName.setText(model.getFuel_station_name());
        holder.icon.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        private final ImageView icon;
        private final TextView stationName;

        public CustomViewHolder(@NonNull View itemView,final OnItemClickListener listener) {
            super(itemView);
            icon = itemView.findViewById(R.id.idFuelStationImageInConsumer);
            stationName = itemView.findViewById(R.id.idFuelStationNameInConsumer);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
