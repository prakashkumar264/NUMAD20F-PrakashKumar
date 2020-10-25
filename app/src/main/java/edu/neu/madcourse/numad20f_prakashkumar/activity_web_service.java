package edu.neu.madcourse.numad20f_prakashkumar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class activity_web_service extends AppCompatActivity {

    private EditText editText_search;
    private TextView textView_pronunciation;
    private TextView textView_meaning;
    private TextView textView_synonyms;
    private TextView textView_example;
    private RequestQueue mQueue;

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
        mQueue = Volley.newRequestQueue(this);

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
                            textView_pronunciation.setText(jsonArray.getString(1));
                            textView_meaning.setText(jsonArray.getString(2));
                            textView_synonyms.setText(jsonArray.getString(3));
                            textView_example.setText(jsonArray.getString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(view, "Word not found", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        mQueue.add(request);
    }

}