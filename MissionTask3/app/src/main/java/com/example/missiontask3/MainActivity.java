package com.example.missiontask3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button sendButton,moveTask5;
    EditText smsInput;
    TextView byteView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = (Button)findViewById(R.id.sendButton);
        smsInput = (EditText)findViewById(R.id.smsInput);
        byteView = (TextView)findViewById(R.id.byteView);
        moveTask5=(Button)findViewById(R.id.closeButton);
        smsInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bytesCounter(s);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
    }

    public void onSendButtonClicked(View v){
        String message = smsInput.getText().toString();
        showToast(message);
    }

    public void showToast(String str){
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }

    public void bytesCounter(CharSequence s){
        byteView.setText(""+ s.toString().getBytes().length + " / 80 바이트");
    }
}