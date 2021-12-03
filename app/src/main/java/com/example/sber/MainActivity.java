package com.example.sber;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn;
    private SeekBar scroll_1, scroll_2, scroll_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);
        scroll_1 = findViewById(R.id.seekBar);
        scroll_2 = findViewById(R.id.seekBar2);
        scroll_3 = findViewById(R.id.seekBar3);

    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == InfoActivity.INFOACTIVITY_CODE) {
                        // ed.setText(result.getData().getStringExtra("ppp"));
                        int a;
                    }
                }
            });

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){
            Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
            intent.putExtra("sc_1", scroll_1.getProgress());
            intent.putExtra("sc_2", scroll_2.getProgress());
            intent.putExtra("sc_3", scroll_3.getProgress());
            someActivityResultLauncher.launch(intent);
        }
    }
}