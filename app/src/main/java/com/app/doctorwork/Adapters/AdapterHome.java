package com.app.doctorwork.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
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

import static com.app.doctorwork.Util.AppUtil.getDrawableFromText;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    Context context;
    Activity activity;
    ArrayList<POJOPatientsData> items;

    public AdapterHome(Context context, Activity activity, ArrayList<POJOPatientsData> items) {
        this.context = context;
        this.activity = activity;
        this.items = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_home, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int pos) {
        POJOPatientsData data = getItem(pos);
        holder.Name.setText(data.getName());
        Log.d("abhi_check", "getName->" + data.getName());
        holder.lastVisited.setText(data.getLastVisited());
        Log.d("abhi_check", "getLastVisitedTime->" + data.getLastVisited());
        holder.imageView.setImageDrawable(getDrawableFromText(pos, data.getName(), context));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public POJOPatientsData getItem(int i) {
        return items.get(i);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Name;
        TextView lastVisited;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.circle);
            Name= itemView.findViewById(R.id.nameText);
            lastVisited = itemView.findViewById(R.id.lastVisitedText);
        }
    }
}
