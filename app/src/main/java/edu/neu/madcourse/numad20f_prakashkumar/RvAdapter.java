package edu.neu.madcourse.numad20f_prakashkumar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RviewHolder> {
    private ArrayList<LinkCard> linkCards;


    public static class RviewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public TextView itemDesc;

        public RviewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemDesc = itemView.findViewById(R.id.item_link);
        }
    }

    public RvAdapter(ArrayList<LinkCard> itemList) {
        this.linkCards = itemList;
    }

    @NonNull
    @Override
    public RviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linkcards, parent, false);
        return new RviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RviewHolder holder, int position) {
        LinkCard currentItem = linkCards.get(position);
        holder.itemName.setText(currentItem.getItemName());
        holder.itemDesc.setText(currentItem.getItemURL());
    }

    @Override
    public int getItemCount() {
        return linkCards.size();
    }


}
