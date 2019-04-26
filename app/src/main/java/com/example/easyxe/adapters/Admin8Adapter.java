package com.example.easyxe.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easyxe.models.Product;
import com.example.easyxe.R;

import java.util.List;

public class Admin8Adapter extends RecyclerView.Adapter<Admin8Adapter.myViewHolder>{
    private Context context;
    private List<Product> productList;

    public Admin8Adapter(Context context, List<Product> productList )
    {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_admin_8,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder myViewHolder, final int i) {
        myViewHolder.imageView.setImageResource(productList.get(i).getImage());
        myViewHolder.mName.setText(productList.get(i).getName());
        //String s = context.getString(R.string.item_admin_8_text,productList.get(i).getLocation(),productList.get(i).getPrice());
        //myViewHolder.mLocation.setText(s);
       myViewHolder.mLocation.setText(productList.get(i).toString());

       myViewHolder.mCheck.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(context);
               builder.setMessage("Delete away?");
               builder.setCancelable(true);

               builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       productList.remove(i);
                       notifyDataSetChanged();
                   }
               });

               builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });

               AlertDialog alertDialog = builder.create();
               alertDialog.show();

           }
       });

       myViewHolder.mCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(context, "Do something!", Toast.LENGTH_SHORT).show();
           }
       });




    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView mName;
        private TextView mLocation;
        private ImageButton mCancel;
        private ImageButton mCheck;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivProduct);
            mName = itemView.findViewById(R.id.tvProName);
            mLocation = itemView.findViewById(R.id.tvProLocation);
            mCancel = itemView.findViewById(R.id.ibCancel);
            mCheck = itemView.findViewById(R.id.ibCheck);
        }
    }
}
