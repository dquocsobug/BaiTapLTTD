package com.example.leduyquoc_recyclerview;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter;
    List<Item> itemList;
    TextView textViewCartTotal;
    DecimalFormat df = new DecimalFormat("#,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        textViewCartTotal = findViewById(R.id.textViewCartTotal);

        String[] phoneBrands = {
                "Apple", "Samsung", "Xiaomi", "Oppo", "Vivo", "Realme",
                "Huawei", "Honor", "Nokia", "Sony", "Asus", "OnePlus",
                "Google Pixel", "HTC", "Motorola", "Infinix", "Tecno",
                "ZTE", "Lenovo", "LG", "Meizu", "Micromax", "Lava",
                "BlackBerry", "Nothing", "Panasonic", "Sharp", "Alcatel",
                "Coolpad", "Itel"
        };

        itemList = new ArrayList<>();
        Random random = new Random();

        for (String brand : phoneBrands) {
            double price = 5000000 + random.nextInt(35000000);
            double discount = price * (0.7 + random.nextDouble() * 0.2);
            int quantity = 1 + random.nextInt(3);

            itemList.add(new Item(brand, R.drawable.smartphone, price, discount, quantity));
        }

        adapter = new ItemAdapter(this, itemList, this::updateCartTotal);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        updateCartTotal();
    }

    private void updateCartTotal() {
        double total = 0;
        for (Item item : itemList) {
            total += item.getTotalPrice();
        }
        textViewCartTotal.setText("Tổng giỏ hàng: ₫" + df.format(total));
    }
}
