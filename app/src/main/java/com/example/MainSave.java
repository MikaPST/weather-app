package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.servicemto.R;

public class MainSave extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_save);

        button.findViewById(R.id.btnReturn);
        textView.findViewById(R.id.textView);

    }

    public void btnReturn(View view) {
        finish();
    }
}
