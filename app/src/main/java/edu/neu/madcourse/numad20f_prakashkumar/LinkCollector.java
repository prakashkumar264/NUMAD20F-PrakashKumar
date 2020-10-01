package edu.neu.madcourse.numad20f_prakashkumar;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LinkCollector extends AppCompatActivity {
    private ArrayList<LinkCard> linkCards;
    private RvAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);
        FloatingActionButton addButton = findViewById(R.id.fab_linkadd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(0, v);
            }
        });
        createItemList();
        createRecyclerView();
    }

    public void addItem(int position, View view) {
        EditText name = findViewById(R.id.input_name);
        EditText url = findViewById(R.id.input_link);
        String validName = name.getText().toString();
        String validURL = url.getText().toString();
        if(URLUtil.isValidUrl(validURL)){
            linkCards.add(new LinkCard(validName, validURL));
            Snackbar.make(view, "Link Added SuccessFully", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            name.getText().clear();
            url.getText().clear();
            rAdapter.notifyDataSetChanged();
        }else{
            Snackbar.make(view, "Add Proper Link in http://yourwebsite.com Format", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void createItemList() {
        linkCards = new ArrayList<>();
    }

    public void createRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager rLayoutManger = new LinearLayoutManager(this);
        rAdapter = new RvAdapter(linkCards);
        recyclerView.setAdapter(rAdapter);
        recyclerView.setLayoutManager(rLayoutManger);
    }
}
