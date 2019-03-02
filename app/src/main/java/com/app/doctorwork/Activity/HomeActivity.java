package com.app.doctorwork.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.doctorwork.Adapters.AdapterHome;
import com.app.doctorwork.Common.AppConstants;
import com.app.doctorwork.Common.SharedPreferenceEditor;
import com.app.doctorwork.POJO.POJOPatientsData;
import com.app.doctorwork.Util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.app.doctorwork.R;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<POJOPatientsData> dataList = new ArrayList<>();
    AdapterHome adapterHome;
    LinearLayoutManager linearLayoutManager;
    Context context;
    Button videoCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = HomeActivity.this;
        getSupportActionBar().setTitle(R.string.home);
        toolbar.setTitleTextColor(getResources().getColor(R.color.defaultwhite));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_menu_white_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.defaultwhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.brand_color));
            getWindow().setStatusBarColor(getResources().getColor(R.color.brand_color));
        }

        populateData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Snackbar.make(view, "", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent intent = new Intent(HomeActivity.this,AddPrescriptionActivity.class);
                startActivity(intent);
            }
        });

        videoCallButton = findViewById(R.id.videoCallButton);


        videoCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,VideoActivity.class);
                startActivity(intent);
            }
        });

        //prescription?patient_mobile=7418423277
    }



    private void populateData() {
        dataList.clear();
        String mob = SharedPreferenceEditor.getPreferences(context,AppConstants.PREFERENCES_USER,AppConstants.PREFRENCES_MOBILE);
        final String url = AppConstants.BASE_URL_MAIN + "prescription?patient_mobile="+mob;

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, (JSONObject) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());

                        try {
                                POJOPatientsData pojoWeatherDataList = new POJOPatientsData();
                               /* JSONObject itemsArrayJSONObject = itemsArrray.getJSONObject(i);
                                JSONObject idJSONObject = itemsArrayJSONObject.getJSONObject("id");
                                pojoWeatherDataList.setVideoId(idJSONObject.getString("videoId"));
                                pojoWeatherDataList.setVideoUrl("https://www.youtube.com/watch?v="+idJSONObject.getString("videoId"));
                                JSONObject snippetJSONObject = itemsArrayJSONObject.getJSONObject("snippet");
                                pojoWeatherDataList.setVideoDateTimeStamp(snippetJSONObject.getString("publishedAt"));
                                pojoWeatherDataList.setVideoTitle(snippetJSONObject.getString("title"));
                                JSONObject thumbnailJSONObject = snippetJSONObject.getJSONObject("thumbnails");
                                JSONObject highResThumbnailObject = thumbnailJSONObject.getJSONObject("high");
                                pojoWeatherDataList.setVideoThumbnailUrl(highResThumbnailObject.getString("url"));*/
                                dataList.add(pojoWeatherDataList);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }



                        adapterHome = new AdapterHome(context, HomeActivity.this, dataList);
                        recyclerView.setAdapter(adapterHome);
                        adapterHome.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", "");
                    }
                }
        );

// add it to the RequestQueue
        RequestQueue requestQueue = Volley.newRequestQueue(HomeActivity.this);
        requestQueue.add(getRequest);
    }

}
