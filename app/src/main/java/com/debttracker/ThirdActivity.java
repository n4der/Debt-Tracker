package com.debttracker;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ThirdActivity extends AppCompatActivity {
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);


        File mydir = context.getDir("mydir", Context.MODE_PRIVATE); //Creating an internal dir;
        File file = new File(mydir, "fileOut.txt"); //Getting a file within the dir.

        StringBuilder text = new StringBuilder();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> amount = new ArrayList<String>();
        ArrayList<String> notes = new ArrayList<String>();
        ListView viewNames = (ListView) findViewById(R.id.listView);
        ListView viewAmount = (ListView) findViewById(R.id.listView3);
        ListView viewNotes = (ListView) findViewById(R.id.listView2);


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line,l;
            int lineNumber = 0;
            int counter =  3;
            while ((line = br.readLine()) != null) {

                if(( counter - lineNumber) == 3 ) {
                names.add(line);
                }
                else if (( counter - lineNumber) == 2 ) {
                    amount.add(line);
                }

                else if (( counter - lineNumber) == 1 ){
                    notes.add(line);

                }
               if (lineNumber == counter){
                   counter = counter+3;
               }
                else {
                   lineNumber++;
               }
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
        }
        ArrayAdapter<String> adapterNames = new ArrayAdapter<String>(this,R.layout.result,names );
        ArrayAdapter<String> adapterAmount = new ArrayAdapter<String>(this,R.layout.result,amount );
        ArrayAdapter<String> adapterNotes = new ArrayAdapter<String>(this,R.layout.result,notes );
        viewNames.setAdapter(adapterNames);
        viewAmount.setAdapter(adapterAmount);
        viewNotes.setAdapter(adapterNotes);
    }
}
