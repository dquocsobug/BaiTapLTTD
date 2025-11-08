package com.example.leduyquoc_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context mContext;
    private List<Item> mItems;
    private Runnable onCartChanged;
    private DecimalFormat df = new DecimalFormat("#,###");

    public ItemAdapter(Context context, List<Item> items, Runnable onCartChanged) {
        this.mContext = context;
        this.mItems = items;
        this.onCartChanged = onCartChanged;
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

        holder.imageViewIcon.setImageResource(item.getIconResId());
        holder.textViewTitle.setText(item.getTitle());
        holder.textViewPrice.setText("₫" + df.format(item.getPrice()));
        holder.textViewDiscount.setText("₫" + df.format(item.getDiscountPrice()));
        holder.textViewQuantity.setText(String.valueOf(item.getQuantity()));
        holder.textViewTotal.setText("Tổng: ₫" + df.format(item.getTotalPrice()));

        // Gạch ngang giá gốc
        holder.textViewPrice.setPaintFlags(
                holder.textViewPrice.getPaintFlags() | android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
        );

        // Nút cộng
        holder.buttonPlus.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            holder.textViewQuantity.setText(String.valueOf(item.getQuantity()));
            holder.textViewTotal.setText("Tổng: ₫" + df.format(item.getTotalPrice()));
            onCartChanged.run();
        });

        // Nút trừ
        holder.buttonMinus.setOnClickListener(v -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                holder.textViewQuantity.setText(String.valueOf(item.getQuantity()));
                holder.textViewTotal.setText("Tổng: ₫" + df.format(item.getTotalPrice()));
                onCartChanged.run();
            }
        });

        // Nút mua
        holder.buttonBuy.setOnClickListener(v ->
                Toast.makeText(mContext, "Đã mua: " + item.getTitle(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewIcon, buttonPlus, buttonMinus; // ✅ ImageView thay vì Button
        TextView textViewTitle, textViewPrice, textViewDiscount, textViewQuantity, textViewTotal;
        Button buttonBuy; // nút mua vẫn là Button

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewDiscount = itemView.findViewById(R.id.textViewDiscount);
            textViewQuantity = itemView.findViewById(R.id.textViewQuantity);
            textViewTotal = itemView.findViewById(R.id.textViewTotal);
            buttonPlus = itemView.findViewById(R.id.buttonPlus);
            buttonMinus = itemView.findViewById(R.id.buttonMinus);
            buttonBuy = itemView.findViewById(R.id.buttonBuy);
        }
    }
}
