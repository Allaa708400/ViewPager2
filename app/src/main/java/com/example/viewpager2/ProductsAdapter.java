package com.example.viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2.databinding.ProductItemBinding;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductHolder>{
    ArrayList<Product> products;

    public ProductsAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
           Product product = products.get(position);
           holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder{
        ProductItemBinding binding;
        private Product product;


        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            binding = ProductItemBinding.bind(itemView);
        }



        public void bind(Product product){
            this.product = product;
            binding.itemIv.setImageResource(product.getImage());
            binding.itemName.setText(product.getName());
            binding.itemPrice.setText(String.valueOf(product.getPrice()));
        }
    }
}
