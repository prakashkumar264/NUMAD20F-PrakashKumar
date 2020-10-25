package edu.neu.madcourse.numad20f_prakashkumar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class activity_web_service extends AppCompatActivity {

    private EditText editText_search;
    private TextView textView_pronunciation;
    private TextView textView_meaning;
    private TextView textView_synonyms;
    private TextView textView_example;
    private TextView textView_word;
    private RequestQueue mQueue;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        editText_search = findViewById(R.id.edittext_dic_name);
        textView_pronunciation = findViewById(R.id.txtview_ponun_answer);
        textView_meaning = findViewById(R.id.txtview_meaning_answer);
        textView_synonyms = findViewById(R.id.txtview_synonyms_answer);
        textView_example = findViewById(R.id.txtview_example_answer);
        Button btn_search = findViewById(R.id.btn_get_meaning);
        textView_word = findViewById(R.id.txtView_word_answer);
        mQueue = Volley.newRequestQueue(this);
        imageView = findViewById(R.id.imgView);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                jsonParse(v);
            }
        });
    }

    private void jsonParse(final View view) {
        String urlOld = "https://my-json-server.typicode.com/prakashkumar264/cs5520/words/";
        String urlNew = urlOld+editText_search.getText();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlNew, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.toJSONArray(response.names());
                            assert jsonArray != null;
                            textView_word.setText(editText_search.getText());
                            textView_pronunciation.setText(jsonArray.getString(1));
                            textView_meaning.setText(jsonArray.getString(2));
                            textView_synonyms.setText(jsonArray.getString(3));
                            textView_example.setText(jsonArray.getString(4));
                            String url = jsonArray.getString(5);
                            Picasso.get().load(url).into(imageView);
                            editText_search.getText().clear();
                            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                            inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);
                Snackbar.make(view, editText_search.getText()+":  Word not found", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                editText_search.getText().clear();
            }
        });
        mQueue.add(request);
    }

}