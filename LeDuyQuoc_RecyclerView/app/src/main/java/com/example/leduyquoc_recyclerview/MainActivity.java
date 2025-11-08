package com.example.leduyquoc_recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter;
    List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // ✅ Danh sách 30 hãng điện thoại phổ biến
        String[] phoneBrands = {
                "Apple", "Samsung", "Xiaomi", "Oppo", "Vivo", "Realme",
                "Huawei", "Honor", "Nokia", "Sony", "Asus", "OnePlus",
                "Google Pixel", "HTC", "Motorola", "Infinix", "Tecno",
                "ZTE", "Lenovo", "LG", "Meizu", "Micromax", "Lava",
                "BlackBerry", "Nothing", "Panasonic", "Sharp", "Alcatel",
                "Coolpad", "Itel"
        };

        itemList = new ArrayList<>();
        for (String brand : phoneBrands) {
            itemList.add(new Item(brand, R.mipmap.ic_launcher)); // icon tạm
        }

        adapter = new ItemAdapter(this, itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Tối ưu cuộn
        recyclerView.setHasFixedSize(true);
    }
}
