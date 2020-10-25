package edu.neu.madcourse.numad20f_prakashkumar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_web_service extends AppCompatActivity {

    private EditText editText_search;
    private TextView textView_pronunciation;
    private TextView textView_meaning;
    private TextView textView_synonyms;
    private TextView textView_example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        editText_search = findViewById(R.id.edittext_dic_name);
        textView_pronunciation = findViewById(R.id.txtview_ponun_answer);
        textView_meaning = findViewById(R.id.txtview_meaning_answer);
        textView_synonyms = findViewById(R.id.txtview_synonyms_answer);
        textView_example = findViewById(R.id.txtview_example_answer);

    }

   
}