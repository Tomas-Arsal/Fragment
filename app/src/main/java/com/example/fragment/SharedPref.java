package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.fragment.databinding.ActivitySharedPrefBinding;

public class SharedPref extends AppCompatActivity {
    ActivitySharedPrefBinding activitySharedPrefBinding;
    EditText email;
    EditText password;
    CheckBox remmeber;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String edemail;
    String edpassword;
    public final String USERNAME = "username";
    public final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySharedPrefBinding = ActivitySharedPrefBinding.inflate(getLayoutInflater());
        setContentView(activitySharedPrefBinding.getRoot());
        remmeber = findViewById(R.id.sh_cb_remember) ;
        email = findViewById(R.id.sh_et_name) ;
        password = findViewById(R.id.sh_et_password) ;
        // ههنا قمنا باستخدام ال sharereferance  باستخدام الملف الجاهز

        sharedPreferences = getSharedPreferences("email", 0);
        if (sharedPreferences.getBoolean("x", false) == true) {
            String emaill = sharedPreferences.getString(USERNAME, "");
            email.setText(emaill);
            String passwordt = sharedPreferences.getString(PASSWORD, "");
            password.setText(passwordt);
            remmeber.setChecked(true);
        }
        // عند الضغط يتم الحفظ
        activitySharedPrefBinding.shCbRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences("email", 0);
                editor = sharedPreferences.edit();
                if (remmeber.isChecked() == true) {
                    edemail = email.getText().toString();
                    edpassword = password.getText().toString();
                    editor.putString(USERNAME, edemail);
                    editor.putString(PASSWORD, edpassword);
                    editor.putBoolean("x", true);
                    editor.commit();
                }

            }
        });


    }
}