package com.example.viewpages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class FragmentThree extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        recyclerView = view.findViewById(R.id.recyclerThree);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );

        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.sach, "Sách Kỹ Năng 1", "₫89.000", "₫69.000", 1));
        list.add(new Product(R.drawable.sach, "Sách Kỹ Năng 2", "₫119.000", "₫89.000", 1));
        list.add(new Product(R.drawable.sach, "Sách Kỹ Năng 3", "₫149.000", "₫109.000", 1));
        list.add(new Product(R.drawable.sach, "Balo Laptop 1", "₫350.000", "₫299.000", 1));
        list.add(new Product(R.drawable.sach, "Balo Laptop 2", "₫399.000", "₫329.000", 1));
        list.add(new Product(R.drawable.sach, "Balo Laptop 3", "₫420.000", "₫359.000", 1));
        list.add(new Product(R.drawable.sach, "Bình nước", "₫59.000", "₫49.000", 1));
        list.add(new Product(R.drawable.sach, "Bút viết", "₫19.000", "₫10.000", 1));

        recyclerView.setAdapter(new MyAdapter(getContext(), list));
        StaggeredGridLayoutManager manager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        recyclerView.setLayoutManager(manager);


        return view;
    }
}
