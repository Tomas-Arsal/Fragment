package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragment.databinding.ActivitySQlateBinding;

import java.util.ArrayList;

public class SQlate extends AppCompatActivity {
    ActivitySQlateBinding activitySQlateBinding;
    Sqlite sq;
    Button save;
    Button add;
    EditText et_name;
    EditText et_age;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySQlateBinding = ActivitySQlateBinding.inflate(getLayoutInflater());
        setContentView(activitySQlateBinding.getRoot());

        et_name = findViewById(R.id.aq_et_name);
        et_age = findViewById(R.id.aq_et_age);
        sq = new Sqlite(this);
        recyclerView = findViewById(R.id.sq_rv_recycleview);
        activitySQlateBinding.sqBtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  تم استقبال الداتا للعربيه الجديده
                String name = et_name.getText().toString();
                String age = et_age.getText().toString();
                // تم تجميع البيانات فى اوبجيكت واحد
                Car car = new Car(name, age);
                // بعد كدا بعتها لهذه الداله
                boolean result = sq.getCar(car);
                if (result)
                    Toast.makeText(SQlate.this, "Successful ", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SQlate.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
        activitySQlateBinding.sqBtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Car> carcount = sq.getAllCar();
                Toast.makeText(SQlate.this, "count is" + carcount, Toast.LENGTH_LONG).show();
            }
        });
    }
}