package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final     EditText a = (EditText)findViewById(R.id.uemail);
        final     EditText b = (EditText)findViewById(R.id.upass);
        Button btn =(Button) findViewById(R.id.button);
        final TextView msg = (TextView)findViewById(R.id.textView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uemail = a.getText().toString();
                String upass = b.getText().toString();

                if(uemail.equals("") || upass.equals("")) {
                    if (uemail.equals("") && (!upass.equals(""))) {
                        Toast.makeText(getApplicationContext(), "email ID Required", Toast.LENGTH_LONG).show();
                    }
                    else if ((!uemail.equals("")) && upass.equals("")) {
                            Toast.makeText(getApplicationContext(), "password is required", Toast.LENGTH_LONG).show();
                        }
                    else{
                        Toast.makeText(getApplicationContext(),"Both required",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    if(uemail.equals("a@b.com")&&upass.equals("abc123")){
                        Intent next = new Intent(MainActivity.this,MainActivity3.class);
                        startActivity(next);
                        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                        msg.setText("Successful");
                        msg.setTextColor(Color.GREEN);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Invalid email or password",Toast.LENGTH_LONG).show();
                        msg.setText("Not Successful");
                        msg.setTextColor(Color.RED);
                    }
                }
            }
        });
    }
}
