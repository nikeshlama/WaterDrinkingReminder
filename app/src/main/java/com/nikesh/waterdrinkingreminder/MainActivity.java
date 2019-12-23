package com.nikesh.waterdrinkingreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText etusername,etpassword;
    public Button btnlogin,btnnewuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etusername=findViewById(R.id.etusername);
        etpassword=findViewById(R.id.etpassword);
        btnlogin=findViewById(R.id.btnlogin);
        btnnewuser=findViewById(R.id.btnnewuser);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });
    }

    private void SignUp(){
        SharedPreferences sharedPreferences =getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("username",etusername.getText().toString());
        editor.putString("password",etpassword.getText().toString());
        editor.commit();

        Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show();
    }
    private void checkUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");

        if(username.equals(etusername.getText().toString())||
                password.equals(etpassword.getText().toString())){
            Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(MainActivity.this, "Username or password is incorrect!!", Toast.LENGTH_SHORT).show();
        }

    }
}
