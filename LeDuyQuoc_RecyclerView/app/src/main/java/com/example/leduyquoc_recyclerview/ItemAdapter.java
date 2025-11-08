package com.example.leduyquoc_recyclerview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> mItems;
    private Context mContext;

    public ItemAdapter(Context context, List<Item> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = mItems.get(position);
        holder.textViewTitle.setText(item.getTitle());

        // Xử lý sự kiện click cho item view (toàn bộ item)
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(mContext, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        });

        // Xử lý sự kiện click riêng cho button trong item
        holder.buttonAction.setOnClickListener(v -> {
            Toast.makeText(mContext, "Action on: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewIcon;
        TextView textViewTitle;
        Button buttonAction;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            buttonAction = itemView.findViewById(R.id.buttonAction);
        }
    }
}
