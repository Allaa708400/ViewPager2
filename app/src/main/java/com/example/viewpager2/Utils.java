package com.example.viewpager2;

import java.util.AbstractList;
import java.util.ArrayList;

public class Utils {

   static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<String> categories = new ArrayList<>();

    public static void FillCategoryData(){

       // for (int i=0;i<5;i++){
       //     categories.add("CAT #"+i);
       // }
        categories.add("Food");
        categories.add("Drinks");
        categories.add("Fast food");
        categories.add("Ice cream");
        categories.add("Deserts");

    }
    public static void FillProductsData(){
        for (int i=0;i<50;i++){
          products.add(new Product(i+1, "Product #"+i,
                  R.drawable.product_1,i*2+5.0, categories.get(i%5)));
        }



    }
    public static void fillData(){

       FillCategoryData();
        FillProductsData();

    }
public static ArrayList<Product> GetProductsByCategory(String category){
        ArrayList<Product> p = new ArrayList<>();
        for (int i=0;i<products.size();i++){
            if (category.equals(products.get(i).getCategory())){
                p.add(products.get(i));
            }
        }
        return p;
}

}
