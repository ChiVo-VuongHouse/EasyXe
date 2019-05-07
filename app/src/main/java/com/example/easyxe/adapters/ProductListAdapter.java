package com.example.easyxe.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easyxe.R;
import com.example.easyxe.models.Products;

import org.w3c.dom.Text;

import java.util.List;


public class ProductListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Products> mProductList;

    // Constructor
    public ProductListAdapter(Context mContext, List<Products> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.list_item_product, null);

        ImageView imageView_Product = (ImageView)v.findViewById(R.id.avatarProduct);
        TextView textView_ProductName = (TextView)v.findViewById(R.id.productName);
        TextView textView_Price = (TextView)v.findViewById(R.id.productPrice);

        // Set text for TextView
        textView_ProductName.setText(mProductList.get(position).getNameProduct());

        // Set resource for ImageView
        imageView_Product.setImageResource(mProductList.get(position).getImageProduct());

        textView_Price.setText(String.valueOf(mProductList.get(position).getPrice()+ " đ"));

        return v;
    }
}
