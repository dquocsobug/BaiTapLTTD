package com.example.viewpages;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentTwo extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        recyclerView = view.findViewById(R.id.recyclerTwo);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));


        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.giay, "Giày Sneaker 1", "₫250.000", "₫199.000", 1));
        list.add(new Product(R.drawable.giay, "Giày Sneaker 2", "₫280.000", "₫220.000", 1));
        list.add(new Product(R.drawable.giay, "Giày Sneaker 3", "₫320.000", "₫250.000", 1));
        list.add(new Product(R.drawable.giay, "Áo Hoodie 1", "₫199.000", "₫159.000", 1));
        list.add(new Product(R.drawable.giay, "Áo Hoodie 2", "₫229.000", "₫189.000", 1));
        list.add(new Product(R.drawable.giay, "Áo Hoodie 3", "₫249.000", "₫199.000", 1));
        list.add(new Product(R.drawable.giay, "Nón Lưỡi Trai", "₫99.000", "₫79.000", 1));
        list.add(new Product(R.drawable.giay, "Balo Học Sinh", "₫159.000", "₫129.000", 1));

        recyclerView.setAdapter(new MyAdapter(getContext(), list));


        return view;
    }
}
