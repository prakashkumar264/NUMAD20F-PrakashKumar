package edu.neu.madcourse.numad20f_prakashkumar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LinkCollector extends AppCompatActivity {
    private ArrayList<LinkCard> linkCards;
    private RecyclerView recyclerView;
    private RvAdapter rAdapter;
    private RecyclerView.LayoutManager rLayoutManger;
    private FloatingActionButton addButton;
    public boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        addButton = findViewById(R.id.fab_linkadd);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(0);
            }
        });

        createItemList();
        createRecyclerView();

    }

    public void addItem(int position) {
        linkCards.add(position, new LinkCard( "Example item", "Example description"));
        rAdapter.notifyDataSetChanged();
    }

    public void createItemList() {
        linkCards = new ArrayList<>();
        //linkCards.add(new LinkCard("Example item", "Example description"));
        //linkCards.add(new LinkCard( "Example item", "Example description"));
        //linkCards.add(new LinkCard("Example item", "Example description"));
    }

    public void createRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        rLayoutManger = new LinearLayoutManager(this);
        rAdapter = new RvAdapter(linkCards);
        recyclerView.setAdapter(rAdapter);
        recyclerView.setLayoutManager(rLayoutManger);
    }
}
