package com.example.viewpager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpager2.databinding.FragmentProductsBinding;

import java.util.ArrayList;


public class ProductsFragment extends Fragment {


    private static final String CATEGORY = "category";


    // TODO: Rename and change types of parameters
    private String category;


    public ProductsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ProductsFragment newInstance(String category) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putString(CATEGORY, category);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getString(CATEGORY);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         FragmentProductsBinding binding =FragmentProductsBinding.
                 inflate(getLayoutInflater(),container,false);

               ArrayList<Product> products = Utils.GetProductsByCategory(category);
               ProductsAdapter adapter = new ProductsAdapter(products);
               binding.fragRv.setAdapter(adapter);
               binding.fragRv.setHasFixedSize(true);
               binding.fragRv.setLayoutManager(new LinearLayoutManager(requireContext()));


        return binding.getRoot();
    }
}