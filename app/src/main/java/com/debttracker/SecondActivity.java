package com.debttracker;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SecondActivity extends AppCompatActivity {
    // GUI controls
    EditText names, amount , notes;
    Button submit;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // bind GUI elements with local controls
        names = (EditText) findViewById(R.id.editText3);
        amount = (EditText) findViewById(R.id.editText2);
        notes = (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.button3);


        submit.setOnClickListener(new OnClickListener() {


                                      @Override
                                      public void onClick(View v) {

                                          File mydir = context.getDir("mydir", Context.MODE_PRIVATE); //Creating an internal dir;
                                          File file = new File(mydir, "fileOut.txt"); //Getting a file within the dir.

                                          try {

                                               //   File file = new File(context.getFilesDir() , "fileOut.txt");

                                              BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
//for loop here to store each input in one line then making a mark


                                              writer.write(names.getText().toString());
                                              writer.newLine();
                                              writer.write(amount.getText().toString()) ;
                                              writer.newLine();
                                              writer.write(notes.getText().toString());
                                              writer.newLine();

                                              writer.flush();
                                              writer.close();
                                          }

                                          catch (IOException e) {
                                              e.printStackTrace();
                                          }

                                      }



                                  }

        );
    }
}
