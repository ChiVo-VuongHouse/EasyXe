package com.example.easyxe.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.easyxe.ViewHolder.ProductViewHolder;
import com.example.easyxe.activities.ProductDetailsActivity;
import com.example.easyxe.activities.UserCategoryActivity;
import com.example.easyxe.adapters.CustomListAdapter;
import com.example.easyxe.models.Product;
import com.example.easyxe.R;
import com.example.easyxe.new_models.Products;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;


public class HomeFragment extends Fragment {

    private DatabaseReference ProductsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private String type = "";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listProducts;

    String[] strsLoaiXe = {"Xe máy", "Xe hơi", "Xe tải", "Xe motor"};
    String[] strsGia = {"Thấp -> cao", "Cao -> thấp", "Phổ biến"};
    String[] strsDiaDiem = {"Hà Nội", "TP. Hồ Chí Minh"};
    List<String> listLoaiXe = new ArrayList<String>(Arrays.asList(strsLoaiXe));
    Spinner spinLoaiXe, spinDiaDiem, spinGia;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getActivity().setTitle("Home");

//        spinLoaiXe = (Spinner) view.findViewById(R.id.spinLoaiXe);
//        spinDiaDiem = (Spinner) view.findViewById(R.id.spinDiaDiem);
//        spinGia = (Spinner) view.findViewById(R.id.spinGia);
//
//        ArrayAdapter dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, strsLoaiXe);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinLoaiXe.setAdapter(dataAdapter);
//        dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, strsDiaDiem);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinDiaDiem.setAdapter(dataAdapter);
//        dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, strsGia);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinGia.setAdapter(dataAdapter);
//
//        listProducts = (ListView) view.findViewById(R.id.listProducts);
//
//        Product product1 = new Product(1, "Xe 67 zin", 26000000.0, "Hà Nội", "Thắng", R.mipmap.xe_67);
//        Product product2 = new Product(2, "Xe SuperDream", 26000000.0, "Hà Nội", "Thắng", R.mipmap.airblade);
//        Product product3 = new Product(3, "AirBlade", 26000000.0, "TP. Hồ Chí Minh", "Nhựt", R.mipmap.superdream);
//
//        Product[] products = new Product[]{product1, product2, product3};
//
////        ArrayAdapter<Product> arrayAdapter =
////                new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products);
//
//
//        List<Product> arrayList = new ArrayList<>();
//        arrayList.add(product1);
//        arrayList.add(product2);
//        arrayList.add(product3);
//        CustomListAdapter adapter =
//                new CustomListAdapter(getActivity(), arrayList);
//        listProducts.setAdapter(adapter);

        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Products");

        Paper.init(getContext());


        //setSupportActionBar(toolbar);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UserCategoryActivity.class);
                startActivity(intent);
            }
        });



        //userNameTextView.setText(Prevalent.currentOnlineUser.getName());
        //Picasso.get().load(Prevalent.currentOnlineUser.getImage()).placeholder(R.drawable.profile).into(profileImageView);


        recyclerView = view.findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Products> options =
                new FirebaseRecyclerOptions.Builder<Products>()
                        .setQuery(ProductsRef, Products.class)
                        .build();

        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Products model) {
                        holder.txtProductName.setText(model.getPname());
                        holder.txtProductPrice.setText(model.getPrice() + " đ");
                        holder.txtAddress.setText(model.getAddress());
                        //holder.txtPhoneContact.setText(model.getPphonecontact());
                        Picasso.get().load(model.getImage()).into(holder.imageView);

                        holder.imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(getContext(), ProductDetailsActivity.class);
                                intent.putExtra("pid", model.getPid());
                                startActivity(intent);

                            }
                        });
                    }

                    @NonNull
                    @Override
                    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.product_items_layout, parent, false);
                        ProductViewHolder holder = new ProductViewHolder(view);
                        return holder;
                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
