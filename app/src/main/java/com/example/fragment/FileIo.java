package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.databinding.ActivityFileIoBinding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileIo extends AppCompatActivity {
    ActivityFileIoBinding activityFileIoBinding;
    TextView datasave;
    EditText information;
    final String FILENAME = "itemfile.txt";
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFileIoBinding = ActivityFileIoBinding.inflate(getLayoutInflater());
        setContentView(activityFileIoBinding.getRoot());
        datasave = findViewById(R.id.fo_tv_readdata);
        information = findViewById(R.id.fi_et_data);
        activityFileIoBinding.fiBtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    /*
                    // كوود الكتابه في الذاكره الداخليه
                    FileOutputStream sp = openFileOutput(FILENAME, MODE_PRIVATE);
                    sp.write(information.getText().toString().getBytes());
                    sp.close();
                    Toast.makeText(FileIo.this, "Data is writting", Toast.LENGTH_SHORT).show();
 */
                    String informat = information.getText().toString();
                    FileOutputStream sp = openFileOutput(FILENAME, MODE_PRIVATE);
                    PrintWriter printWriter = new PrintWriter(sp); // يستخدم لتحويل البايت الي استرنج
                    printWriter.println(informat);
                    printWriter.close();
                    sp.close();


                    // لاجل قراءه الداتا التى تم تسجيلها
                    readfromfile();
                } catch (
                        FileNotFoundException e) {
                    e.printStackTrace();
                } catch (
                        IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        readfromfile();
    }

    private void readfromfile() {
        // لقراءه الذاكره الداخليه
        try {
            /*
            FileInputStream op = openFileInput(FILENAME);
            byte[] buffer = new byte[op.available()];
            op.read(buffer);
            datasave.setText(new String(buffer));
            op.close();
*/

            FileInputStream op = openFileInput(FILENAME);
            InputStreamReader ir = new InputStreamReader(op); // استخدمناه لصلاحيه التعامل مع التحته
            BufferedReader ko = new BufferedReader(ir); // للتخزين الجزئي و هي اسرع من تحويل من بيتات الي استرنج

            StringBuilder Alltext = new StringBuilder();
            String team = "";
            while ((team = ko.readLine()) != null) {
                Alltext.append(team);
            }

            ko.close();
            ir.close();
            op.close();
            Toast.makeText(getApplicationContext(), Alltext.toString(), Toast.LENGTH_LONG).show();


            //op.delete() ; في حاله حذف الملف
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Dont found", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}