package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Button fragmenta;
    Button fragmentb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.acBtFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager(); // تستخدم ياتي ب الفريجمنت
                FragmentTransaction fa = fm.beginTransaction(); // تستخدم لكي يتم تفعيل اكثر من عمليه
                FragmentA fragmentA = new FragmentA();
                fa.replace(R.id.fragment, fragmentA);
                fa.addToBackStack(null);
                fa.commit(); // تستخدم لكى تنفذ العمليات السابقه
            }
        });

        binding.acBtFragmentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager(); // تستخدم ياتي ب الفريجمنت
                FragmentTransaction fb = fm.beginTransaction(); // تستخدم لكي يتم تفعيل اكثر من عمليه
                FragmentB fragmentB = new FragmentB();
                fb.replace(R.id.fragment, fragmentB);
                fb.addToBackStack(null);
                fb.commit(); // تستخدم لكى تنفذ العمليات السابقه
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.firstmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_pref:
                Intent sharedPref = new Intent(MainActivity.this, SharedPref.class);
                startActivity(sharedPref);
                break;
            case R.id.FileIoo:
                Intent fileIo = new Intent(MainActivity.this, FileIo.class);
                startActivity(fileIo);
                break;
            case R.id.SQlite:
                Intent SQlite = new Intent(MainActivity.this, SQlate.class);
                startActivity(SQlite);
                break;
        }
        return true ;
    }

}



      /*
      setContentView(R.layout.activity_main);
        fragmenta = findViewById(R.id.ac_bt_fragmentA);
         fragmentb = findViewById(R.id.ac_bt_fragmentB);

        fragmenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager(); // تستخدم ياتي ب الفريجمنت
                FragmentTransaction fa = fm.beginTransaction(); // تستخدم لكي يتم تفعيل اكثر من عمليه
                FragmentA fragmentA = new FragmentA();
                fa.replace(R.id.fragment, fragmentA);
                fa.addToBackStack(null);
                fa.commit(); // تستخدم لكى تنفذ العمليات السابقه
            }
        });

        fragmentb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager(); // تستخدم ياتي ب الفريجمنت
                FragmentTransaction fb = fm.beginTransaction(); // تستخدم لكي يتم تفعيل اكثر من عمليه
                FragmentB fragmentB = new FragmentB();
                fb.replace(R.id.fragment, fragmentB);
                fb.addToBackStack(null);
                fb.commit(); // تستخدم لكى تنفذ العمليات السابقه


            }
        });
*/
