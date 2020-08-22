package com.example.android11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private TextView textView;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter();
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        savedInstanceState.getInt("Count");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("Count", count);
    }

    private void counter(){
        editText1 = findViewById(R.id.edtText1);
        editText2 = findViewById(R.id.edtText2);
        textView = findViewById(R.id.txtView);
        Button button = findViewById(R.id.btn_counter);
        button.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int s = Integer.parseInt(editText1.getText().toString()) + Integer.parseInt(editText2.getText().toString());
                textView.setText(Integer.toString(s));

                Toast.makeText(getApplicationContext(), "Count = " + ++count , Toast.LENGTH_LONG).show();

            }


        });
    }
}