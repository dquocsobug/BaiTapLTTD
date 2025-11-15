package com.example.viewpages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentOne extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        recyclerView = view.findViewById(R.id.recyclerOne);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        ArrayList<Product> list = createData();
        MyAdapter adapter = new MyAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private ArrayList<Product> createData() {
        ArrayList<Product> list = new ArrayList<>();

        list.add(new Product(R.drawable.smartphone, "Điện thoại A1", "₫199.000", "₫149.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại B2", "₫299.000", "₫249.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại C3", "₫399.000", "₫349.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại D4", "₫499.000", "₫399.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại E5", "₫599.000", "₫499.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại F6", "₫699.000", "₫599.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại G7", "₫799.000", "₫699.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại H8", "₫899.000", "₫799.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại I9", "₫999.000", "₫899.000", 1));
        list.add(new Product(R.drawable.smartphone, "Điện thoại J10", "₫1.099.000", "₫999.000", 1));

        return list;
    }

}
