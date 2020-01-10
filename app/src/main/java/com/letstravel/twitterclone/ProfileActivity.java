package com.letstravel.twitterclone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import api.TwitterApi;
import model.ResponsFromAPI;
import model.TwitterModel;
import model.TwitterModelAPI;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;


public class ProfileActivity extends AppCompatActivity {

    private Button btn_profile_picture;
    private ImageView btnCamera;
    private String username, emailaddress, propassword,imageName,imagePath;
    private TextView tv_create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile );

        btn_profile_picture = findViewById( R.id.btn_profile_picture );
        btnCamera = findViewById( R.id.btnCamera );
        tv_create_account = findViewById( R.id.tv_create_account );
        checkPermission();

        Bundle profileBundle = getIntent().getExtras();
        if (profileBundle != null) {
            username = profileBundle.getString( "pname" );
            emailaddress = profileBundle.getString( "pemail" );
            propassword = profileBundle.getString( "password" );
        }
//        System.out.println( username );
//        System.out.println( emailaddress );
//        System.out.println( propassword );


        btnCamera.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();

            }
        } );


        btn_profile_picture.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ProfileActivity.this, DescribeActivity.class );
                intent.putExtra( "pname1", username );
                intent.putExtra( "pemail1", emailaddress );
                intent.putExtra( "password1", propassword );
                intent.putExtra( "filename1", "myImage-1578656629755.jpg" );
                startActivity( intent );
            }
        } );
    }

    private void BrowseImage() {
        Intent intent = new Intent( Intent.ACTION_PICK );
        intent.setType( "image/*" );
        startActivityForResult( intent, 0 );
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText( this, "Please select an image", Toast.LENGTH_SHORT ).show();
            }
        }
        Uri uri = data.getData();
        btnCamera.setImageURI( uri );
        imagePath = getRealPathFromUri( uri );
        Toast.makeText( this, "image  name" + imagePath, Toast.LENGTH_LONG ).show();
//        UploadImage();
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader( getApplicationContext(), uri, projection, null, null, null );
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow( MediaStore.Images.Media.DATA );
        cursor.moveToFirst();
        String result = cursor.getString( colIndex );
        cursor.close();
        return result;
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission( this, Manifest.permission.CAMERA ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions( this, new String[]{
                    Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0
            );
        }
    }

    private void UploadImage() {
        File file = new File(imagePath);
        final RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("myImage", file.getName(), requestBody);
        TwitterApi twitterApi= Url.getInstance().create( TwitterApi.class );
        Call<ResponsFromAPI> responseCall = twitterApi.uploadImage(body);
        StrictMode();
        try {
            Response<ResponsFromAPI> responseFromAPIImageResponse = responseCall.execute();
            imageName = responseFromAPIImageResponse.body().getFileName();
        } catch (IOException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }



}
