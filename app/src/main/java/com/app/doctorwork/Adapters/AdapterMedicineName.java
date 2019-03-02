package com.app.doctorwork.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.doctorwork.POJO.POJOPatientsData;
import com.app.doctorwork.R;
import com.app.doctorwork.Util.Log;

import java.util.ArrayList;

public class AdapterMedicineName extends RecyclerView.Adapter<AdapterMedicineName.ViewHolder> {
    Context context;
    Activity activity;
    ArrayList<POJOPatientsData> items;

    public AdapterMedicineName(Context context, Activity activity, ArrayList<POJOPatientsData> items){
        this.context = context;
        this.activity = activity;
        this.items = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_medicine_name,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int pos) {
        POJOPatientsData data = getItem(pos);
        holder.name.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public POJOPatientsData getItem(int i){
        return items.get(i);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name);
        }
    }
}
