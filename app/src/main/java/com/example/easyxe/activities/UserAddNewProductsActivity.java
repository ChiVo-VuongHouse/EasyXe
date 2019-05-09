package com.example.easyxe.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.easyxe.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class UserAddNewProductsActivity extends AppCompatActivity {

    private String CategoryName, Description, Price, Pname, PhoneContact, Address, saveCurrentDate, saveCurrentTime;
    private Button AddNewProductButton;
    private EditText InputProductName, InputProductDescription, InputProductPrice, InputProductPhoneContact;
    private ImageView InputProductImage;
    private ProgressDialog loadingBar;
    private static final int GalleryPick = 1;
    private Uri ImageUri;
    private String productRandomKey, downloadImageUrl;
    private StorageReference ProductImagesRef;
    private DatabaseReference ProductRef;
    private Spinner ProductAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_new_products);

        ProductAddress = (Spinner) findViewById(R.id.product_address);
        List<String> list = new ArrayList<>();
        list.add("An Giang");
        list.add("Bà Rịa - Vũng Tàu");
        list.add("Bắc Giang");
        list.add("Bắc Kạn");
        list.add("Bạc Liêu");
        list.add("Bắc Ninh");
        list.add("Bến Tre");
        list.add("Bình Định");
        list.add("Bình Dương");
        list.add("Bình Phước");
        list.add("Bình Thuận");
        list.add("Cà Mau");
        list.add("Cao Bằng");
        list.add("Đắk Lắk");
        list.add("Đắk Nông");
        list.add("Điện Biên");
        list.add("Đồng Nai");
        list.add("Đồng Tháp");
        list.add("Gia Lai");
        list.add("Hà Giang");
        list.add("Hà Nam");
        list.add("Hà Tĩnh");
        list.add("Hải Dương");
        list.add("Hậu Giang");
        list.add("Hòa Bình");
        list.add("Hưng Yên");
        list.add("Khánh Hòa");
        list.add("Kiên Giang");
        list.add("Kon Tum");
        list.add("Lai Châu");
        list.add("Lâm Đồng");
        list.add("Lạng Sơn");
        list.add("Lào Cai");
        list.add("Long An");
        list.add("Nam Định");
        list.add("Nghệ An");
        list.add("Ninh Bình");
        list.add("Ninh Thuận");
        list.add("Phú Thọ");
        list.add("Quảng Bình");
        list.add("Quảng Nam");
        list.add("Quảng Ngãi");
        list.add("Quảng Ninh");
        list.add("Quảng Trị");
        list.add("Sóc Trăng");
        list.add("Sơn La");
        list.add("Tây Ninh");
        list.add("Thái Bình");
        list.add("Thái Nguyên");
        list.add("Thanh Hóa");
        list.add("Thừa Thiên Huế");
        list.add("Tiền Giang");
        list.add("Trà Vinh");
        list.add("Tuyên Quang");
        list.add("Vĩnh Long");
        list.add("Vĩnh Phúc");
        list.add("Yên Bái");
        list.add("Phú Yên");
        list.add("Cần Thơ");
        list.add("Đà Nẵng");
        list.add("Hải Phòng");
        list.add("Hà Nội");
        list.add("TP HCM");
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        ProductAddress.setAdapter(adapter);
        ProductAddress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(UserAddNewProductsActivity.this, product_address.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        CategoryName = getIntent().getExtras().get("category").toString();
        ProductImagesRef = FirebaseStorage.getInstance().getReference().child("Product Images");
        ProductRef = FirebaseDatabase.getInstance().getReference().child("Products");

        AddNewProductButton = (Button)findViewById(R.id.add_new_product);
        InputProductImage = (ImageView) findViewById(R.id.select_product_image);
        InputProductName = (EditText) findViewById(R.id.product_name);
        InputProductDescription = (EditText)findViewById(R.id.product_description);
        InputProductPrice = (EditText)findViewById(R.id.product_price);
        InputProductPhoneContact = (EditText) findViewById(R.id.product_phone_contact);

        loadingBar = new ProgressDialog(this);

        InputProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGrallery();
            }
        });

        AddNewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateProductData();
            }
        });
    }

    private void OpenGrallery() {
        Intent galleryIntent =  new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GalleryPick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GalleryPick && resultCode == RESULT_OK && data != null)
        {
            ImageUri = data.getData();
            InputProductImage.setImageURI(ImageUri);
        }
    }

    private void ValidateProductData() {
        Description = InputProductDescription.getText().toString();
        Price = InputProductPrice.getText().toString();
        Pname = InputProductName.getText().toString();
        PhoneContact = InputProductPhoneContact.getText().toString();
        Address = ProductAddress.getSelectedItem().toString();


        if (ImageUri == null)
        {
            Toast.makeText(this, "Cần có hình ảnh sản phẩm...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Description))
        {
            Toast.makeText(this, "Vui lòng thêm mô tả sản phẩm", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Price))
        {
            Toast.makeText(this, "Vui lòng thêm giá sản phẩm", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Pname))
        {
            Toast.makeText(this, "Vui lòng thêm tên sản phẩm", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(PhoneContact))
        {
            Toast.makeText(this, "Vui lòng thêm số điện thoại liên hệ", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Address))
        {
            Toast.makeText(this, "Vui lòng thêm địa chỉ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            StoreProductInformation();
        }
    }

    private void StoreProductInformation() {
        loadingBar.setTitle("Thêm Sản Phẩm Mới");
        loadingBar.setMessage("Gửi Admin, Vui lòng chờ trong khi chúng tôi đang thêm sản phẩm mới.");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime;

        final StorageReference filePath = ProductImagesRef.child(ImageUri.getLastPathSegment() + productRandomKey + ".jpg");

        final UploadTask uploadTask = filePath.putFile(ImageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String message = e.toString();
                Toast.makeText(UserAddNewProductsActivity.this, "Lỗi" +message, Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(UserAddNewProductsActivity.this, "Hình ảnh sản phẩm tải lên thành công...", Toast.LENGTH_SHORT).show();
                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful())
                        {
                            throw task.getException();
                        }

                        downloadImageUrl = filePath.getDownloadUrl().toString();
                        return filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful())
                        {
                            downloadImageUrl= task.getResult().toString();
                            Toast.makeText(UserAddNewProductsActivity.this, "Url lưu thành công...", Toast.LENGTH_SHORT).show();
                            SaveProductInfoToDatabase();
                        }
                    }
                });
            }
        });
    }

    private void SaveProductInfoToDatabase() {

        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("pid", productRandomKey);
        productMap.put("date", saveCurrentDate);
        productMap.put("time", saveCurrentTime);
        productMap.put("description", Description);
        productMap.put("image", downloadImageUrl);
        productMap.put("category", CategoryName);
        productMap.put("price", Price);
        productMap.put("pname", Pname);
        productMap.put("address", Address);
        productMap.put("pphonecontact", PhoneContact);

        ProductRef.child(productRandomKey).updateChildren(productMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Intent intent = new Intent(UserAddNewProductsActivity.this, UserCategoryActivity.class);
                            startActivity(intent);

                            loadingBar.dismiss();
                            Toast.makeText(UserAddNewProductsActivity.this, "Add successful products.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            loadingBar.dismiss();
                            String message = task.getException().toString();
                            Toast.makeText(UserAddNewProductsActivity.this, "Error: "+ message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
