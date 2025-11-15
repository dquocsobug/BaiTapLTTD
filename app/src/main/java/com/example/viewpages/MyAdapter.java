package com.example.viewpages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    ArrayList<Product> list;

    // Định nghĩa các loại layout
    public static final int LINEAR_VIEW = 0;
    public static final int GRID_VIEW = 1;
    public static final int STAGGERED_VIEW = 2;

    private int currentLayoutType = LINEAR_VIEW;

    public MyAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return currentLayoutType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = list.get(position);

        holder.image.setImageResource(p.image);
        holder.title.setText(p.title);
        holder.price.setText(p.price);
        holder.discount.setText(p.discount);
        holder.quantity.setText(String.valueOf(p.quantity));

        // Cập nhật tổng tiền nếu có
        updateTotal(holder, p);

        holder.plus.setOnClickListener(v -> {
            p.quantity++;
            holder.quantity.setText(String.valueOf(p.quantity));
            updateTotal(holder, p);
        });

        holder.minus.setOnClickListener(v -> {
            if (p.quantity > 1) {
                p.quantity--;
                holder.quantity.setText(String.valueOf(p.quantity));
                updateTotal(holder, p);
            }
        });

        holder.buttonBuy.setOnClickListener(v -> {
            // Xử lý nút mua
        });

        // Ẩn/hiện các view tùy theo layout type
        if (currentLayoutType == GRID_VIEW) {
            // Ở chế độ Grid: có thể ẩn một số view
            holder.buttonBuy.setVisibility(View.VISIBLE);
            holder.textViewTotal.setVisibility(View.GONE);
        } else if (currentLayoutType == STAGGERED_VIEW) {
            // Ở chế độ Staggered: hiển thị đầy đủ
            holder.buttonBuy.setVisibility(View.VISIBLE);
            holder.textViewTotal.setVisibility(View.VISIBLE);
        } else {
            // Ở chế độ Linear: hiển thị đầy đủ
            holder.buttonBuy.setVisibility(View.VISIBLE);
            holder.textViewTotal.setVisibility(View.VISIBLE);
        }
    }

    private void updateTotal(ViewHolder holder, Product p) {
        if (holder.textViewTotal != null) {
            // Giả sử giá là số (cần parse từ string nếu cần)
            holder.textViewTotal.setText("Tổng: ₫" + (p.quantity * 149000));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Phương thức để thay đổi layout
    public void setLayoutType(int layoutType) {
        this.currentLayoutType = layoutType;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image, plus, minus;
        TextView title, price, discount, quantity, textViewTotal;
        Button buttonBuy;
        int viewType;

        public ViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;

            image = itemView.findViewById(R.id.imageViewIcon);
            plus = itemView.findViewById(R.id.buttonPlus);
            minus = itemView.findViewById(R.id.buttonMinus);
            title = itemView.findViewById(R.id.textViewTitle);
            price = itemView.findViewById(R.id.textViewPrice);
            discount = itemView.findViewById(R.id.textViewDiscount);
            quantity = itemView.findViewById(R.id.textViewQuantity);
            buttonBuy = itemView.findViewById(R.id.buttonBuy);
            textViewTotal = itemView.findViewById(R.id.textViewTotal);
        }
    }
}