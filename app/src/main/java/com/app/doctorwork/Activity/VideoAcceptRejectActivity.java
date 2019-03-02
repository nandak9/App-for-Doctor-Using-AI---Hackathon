package com.app.doctorwork.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import com.app.doctorwork.R;

public class VideoAcceptRejectActivity extends AppCompatActivity {
    Button rejectButton,acceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_video_accept_reject);

        rejectButton = findViewById(R.id.rejectButton);
        acceptButton = findViewById(R.id.acceptButton);



        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoAcceptRejectActivity.this,VideoActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
}
