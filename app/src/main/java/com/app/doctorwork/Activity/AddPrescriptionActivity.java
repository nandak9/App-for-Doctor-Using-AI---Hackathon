package com.app.doctorwork.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.doctorwork.Adapters.AdapterMedicineName;
import com.app.doctorwork.Common.AppConstants;
import com.app.doctorwork.Common.RecyclerItemClickListener;
import com.app.doctorwork.Common.SharedPreferenceEditor;
import com.app.doctorwork.Main.ApplicationSingleton;
import com.app.doctorwork.POJO.POJOPatientsData;
import com.app.doctorwork.R;
import com.app.doctorwork.Util.Log;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.app.doctorwork.Util.AppUtil.containsName;

public class AddPrescriptionActivity extends AppCompatActivity {

    Context context;
    ArrayList<POJOPatientsData> dataList = new ArrayList<>();
    ArrayList<POJOPatientsData> dataListNew = new ArrayList<>();
    AdapterMedicineName adapterMedicineName;
    RecyclerView recyclerViewMedicineList;
    com.github.clans.fab.FloatingActionButton floatingActionButton;
    Button headAcheButton,feverButton,bodyPainButton,skinAllergyButton;

    boolean isFlag1=false,isFlag2=false,isFlag3=false,isFlag4=false;
    Button sendPrescriptionButton;
    JSONObject medicineDetailsJson;
    int clickCount=0;
    AlertDialog alertDialog;

    EditText editText_patientName,editText_PatientAge,editText_PatientGender,editText_PatientMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prescription);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        medicineDetailsJson = new JSONObject();

        setSupportActionBar(toolbar);
        context = AddPrescriptionActivity.this;
        getSupportActionBar().setTitle(R.string.add_prescription);
        toolbar.setTitleTextColor(getResources().getColor(R.color.defaultwhite));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_left_white_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.defaultwhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        floatingActionButton = findViewById(R.id.fabMedAdd);
        editText_patientName = findViewById(R.id.editText_patientName);
        editText_PatientAge = findViewById(R.id.editText_patientAge);
        editText_PatientGender = findViewById(R.id.editText_patientGender);
        editText_PatientMobile = findViewById(R.id.editText_patientMobile);


        headAcheButton = findViewById(R.id.headacheButton);
        feverButton = findViewById(R.id.feverButton);
        bodyPainButton = findViewById(R.id.bodyPainButton);
        skinAllergyButton = findViewById(R.id.skinAllergyButton);
        sendPrescriptionButton = findViewById(R.id.sendPrescriptioButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMedPopup();
            }
        });

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.brand_color));
            getWindow().setStatusBarColor(getResources().getColor(R.color.brand_color));
        }

        JSONObject diagnosisJson = new JSONObject();

        headAcheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                if(isFlag1){
                    changeToEmptyButton(headAcheButton);
                        diagnosisJson.put("headache","false");
                        isFlag1=false;
                }else{
                    changeToFilledButton(headAcheButton);
                    diagnosisJson.put("headache","true");
                    isFlag1=true;
                }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });



        feverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(isFlag2){
                        changeToEmptyButton(feverButton);
                        diagnosisJson.put("fever","false");
                        isFlag2=false;
                    }else{
                        changeToFilledButton(feverButton);
                        diagnosisJson.put("fever","true");
                        isFlag2=true;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        bodyPainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(isFlag3){
                        changeToEmptyButton(bodyPainButton);
                        diagnosisJson.put("bodyPain","false");
                        isFlag3=false;
                    }else{
                        changeToFilledButton(bodyPainButton);
                        diagnosisJson.put("bodyPain","true");
                        isFlag3=true;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        skinAllergyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(isFlag4){
                        changeToEmptyButton(skinAllergyButton);
                        diagnosisJson.put("skinAllergy","false");
                        isFlag4=false;
                    }else{
                        changeToFilledButton(skinAllergyButton);
                        diagnosisJson.put("skinAllergy","true");
                        isFlag4=true;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


        sendPrescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    medicineDetailsJson.put("diagnosis", diagnosisJson);
                    medicineDetailsJson.put("patient_name",editText_patientName.getText().toString());
                    medicineDetailsJson.put("patient_mobile",editText_PatientMobile.getText().toString());
                    medicineDetailsJson.put("patient_age",editText_PatientAge.getText().toString());
                    medicineDetailsJson.put("patient_gender",editText_PatientGender.getText().toString());


                    postPrescriptionData(medicineDetailsJson);
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    private void addMedPopup() {
        clickCount=clickCount+1;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogLayout = LayoutInflater.from(this).inflate(R.layout.add_medicine_dialog, null, false);
        builder.setView(dialogLayout);
        builder.setIcon(android.R.drawable.ic_input_add);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddPrescriptionActivity.this);
        CheckBox morningCheckBox,eveningCheckBox,afternoonCheckbox,nightCheckbox;
        EditText searchEditText,editText_medDays;
        ImageButton imageButtonCLearSearch;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        alertDialog = builder.create();
        EditText medDaysText = dialogLayout.findViewById(R.id.editText_medDays);
        Button doneButton = dialogLayout.findViewById(R.id.doneButton);
        alertDialog.show();



        for(int i=0; i<AppConstants.medicineList.length;i++){
            POJOPatientsData pojoPatientsData = new POJOPatientsData();
            pojoPatientsData.setName(AppConstants.medicineList[i]);
            dataList.add(pojoPatientsData);
        }


        morningCheckBox = dialogLayout.findViewById(R.id.morningCheckBox);
        afternoonCheckbox = dialogLayout.findViewById(R.id.afternoonCheckbox);
        eveningCheckBox = dialogLayout.findViewById(R.id.eveningCheckBox);
        editText_medDays = dialogLayout.findViewById(R.id.editText_medDays);
        nightCheckbox = dialogLayout.findViewById(R.id.nightCheckbox);
        searchEditText = dialogLayout.findViewById(R.id.searchEditText);
        imageButtonCLearSearch = dialogLayout.findViewById(R.id.imageButtonClearSearch);
        recyclerViewMedicineList = dialogLayout.findViewById(R.id.recyclerViewMedicineList);

        recyclerViewMedicineList.setLayoutManager(linearLayoutManager);
        recyclerViewMedicineList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMedicineList.setHasFixedSize(true);



        searchEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().isEmpty()) {
                    imageButtonCLearSearch.setVisibility(View.GONE);
                } else {
                    imageButtonCLearSearch.setVisibility(View.VISIBLE);
                }
                String name = editable.toString();
                Log.e(this.getClass().getName(), name);
                swapList(name,recyclerViewMedicineList);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {

            }
        });



        recyclerViewMedicineList.addOnItemTouchListener(new RecyclerItemClickListener(context, recyclerViewMedicineList, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position)  {
                if(TextUtils.isEmpty(searchEditText.getText().toString())) {
                    Toast.makeText(context, dataList.get(position).getName(), Toast.LENGTH_SHORT).show();
                    try {
                        medicineDetailsJson.put("medicine"+clickCount,dataList.get(position).getName());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(context, dataListNew.get(position).getName(), Toast.LENGTH_SHORT).show();
                    try {
                        medicineDetailsJson.put("medicine"+clickCount,dataListNew.get(position).getName());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }

        }));





        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (!AddPrescriptionActivity.this.isFinishing() && alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        };

        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject durationMedJson = new JSONObject();

                try {
                if(morningCheckBox.isChecked()){
                        durationMedJson.put("morning","true");
                    } else{
                    durationMedJson.put("morning","true");
                }


                    if(afternoonCheckbox.isChecked()){
                        durationMedJson.put("afternoon","true");
                    }else{
                        durationMedJson.put("afternoon","false");
                    }

                    if(eveningCheckBox.isChecked()){
                        durationMedJson.put("evening","true");
                    }else{
                        durationMedJson.put("evening","false");
                    }

                    if(afternoonCheckbox.isChecked()){
                        durationMedJson.put("night","true");
                    }else{
                        durationMedJson.put("night","false");
                    }


                    medicineDetailsJson.put("days",editText_medDays.getText().toString());
                    alertDialog.dismiss();
                    alertDialog.cancel();
                }



                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


        handler.postDelayed(runnable, 100000);
    }



    private void swapList(String name,RecyclerView recyclerView) {

        ArrayList<Boolean> isNumber = new ArrayList<>();
        if (!name.trim().isEmpty() && name.length() > 0) {
            for (int i = 0; i < name.length(); i++) {
                if (Character.isLetter(name.charAt(i))) {
                    isNumber.add(false);
                } else {
                    isNumber.add(true);
                }
            }
        }


        if (name.trim().isEmpty()) {
            //this.contactList=contactListoriginal;

            adapterMedicineName = new AdapterMedicineName(context, AddPrescriptionActivity.this, dataList);
            recyclerView.setAdapter(adapterMedicineName);
            adapterMedicineName.notifyDataSetChanged();

        } else{
            for( POJOPatientsData c: dataList){
                if(containsName(name, c.getName())){
                    dataListNew.add(c);
                }
            }

            adapterMedicineName = new AdapterMedicineName(context, AddPrescriptionActivity.this, dataListNew);
            recyclerView.setAdapter(adapterMedicineName);
            adapterMedicineName.notifyDataSetChanged();

        }
    }


    private void changeToEmptyButton(Button btn){
        btn.setBackground(getResources().getDrawable(R.drawable.outline_background));
        btn.setTextColor(getResources().getColor(R.color.brand_color_dark));
    }


    private void changeToFilledButton(Button btn){
        btn.setBackgroundColor(getResources().getColor(R.color.brand_color_dark));
        btn.setTextColor(getResources().getColor(R.color.white));
    }


    private void postPrescriptionData(JSONObject medicineDetailsJson) {

        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = AppConstants.BASE_URL_MAIN + "prescription";
            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("patient_mobile", "8130179770");
            jsonBody.put("doctor_mobile", SharedPreferenceEditor.getPreferences(context,AppConstants.PREFERENCES_USER,AppConstants.PREFRENCES_MOBILE));
            //jsonBody.put("fcmToken", FirebaseInstanceId.getInstance().getId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("key", medicineDetailsJson);// Here in Value I can put a Json object
            jsonBody.put("prescription", jsonObject);
            Log.d("VOLLEY", jsonBody.toString());

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    if (jsonBody != null) {
                        Log.d("VOLLEY", jsonBody.toString());
                        //return encodeParameters(jsonBody, getParamsEncoding());
                        return jsonBody.toString().getBytes();
                    }
                    return null;

                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);

//                        Toast.makeText(AddPrescriptionActivity.this, "SuccessFully Sent to the Patient", Toast.LENGTH_SHORT).show();
                        finish();

                       // Intent intent = new Intent(AddPrescriptionActivity.this,HomeActivity.class);
                       // startActivity(intent);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
