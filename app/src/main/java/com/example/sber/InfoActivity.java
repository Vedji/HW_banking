package com.example.sber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    public static final int INFOACTIVITY_CODE = 300;
    private TextView result_text, tv_1, tv_2, tv_3;
    private Button undo_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tv_1 = findViewById(R.id.textViewSumm);
        tv_2 = findViewById(R.id.textViewSrok);
        tv_3 = findViewById(R.id.textViewPopolnenie);
        result_text = findViewById(R.id.textView7);
        undo_button = findViewById(R.id.button2);
        Bundle bundle = getIntent().getExtras(); // она может быть null
        if(bundle != null) {
            int a = bundle.getInt("sc_1"),
                    b = bundle.getInt("sc_2"),
                    c = bundle.getInt("sc_3");
            tv_1.setText(Integer.toString(a));
            tv_2.setText(Integer.toString(b));
            tv_3.setText(Integer.toString(c));
            int s = (int)StrictMath.pow(0.03, b) * a + a + c;
            result_text.setText(Integer.toString(s));
        }else{
            tv_1.setText("0");
            tv_2.setText("0");
            tv_3.setText("0");
        }
        undo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(INFOACTIVITY_CODE, intent);
                finish();
            }
        });
    }
}