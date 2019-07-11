package com.awatef.loggin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class Profile extends AppCompatActivity {
    //ImageView img;
    ImageView img1;
    EditText ename;
    EditText ebio;
    EditText emob;
    EditText email;
    SharedPreferences sharedPreferences;
    private String URLline="";
    //String getId;
    //private Bitmap bitmap;

    static final String mypreference = "mypreference";
    static final String Name = "NameKey";
    static final String Bio = "BioKey";
    static final String Mob = "MobKey";
    static final String Mail = "MailKey";
    //private android.app.ProgressDialog ProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ename = (EditText) findViewById(R.id.ed_name);
        ebio = (EditText) findViewById(R.id.ed_bio);
        //emob = (EditText) findViewById(R.id.ed_mob);
        email = (EditText) findViewById(R.id.ed_mail);
       // ProgressDialog = new ProgressDialog(this);
    }

    public void bnt_photo(View view) {
        img1 = (ImageView) findViewById(R.id.imageButton3);
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.putExtra("crop","true");
        intent.putExtra("aspectX",1);
        intent.putExtra("aspectY",1);
        intent.putExtra("outputX",150);
        intent.putExtra("outputY",150);
        intent.putExtra("return-data",true);


        startActivityForResult(intent,100);
       /* Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select picture"), 1);*/

    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                img1.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            UploadPicture(getId, getStringImage(bitmap));
        }
    }**/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK){
            Uri uri=data.getData();
            img1.setImageURI(uri);
            img1.setImageBitmap((Bitmap)data.getExtras().get("data"));

        }
    }

   /* private void UploadPicture(final String id, final String photo) {
    }

    public String getStringImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageByteArray = byteArrayOutputStream.toByteArray();
        String encodedImage = Base64.encodeToString(imageByteArray, Base64.DEFAULT);

        return encodedImage;
    }
*/
    public void save(View v) {
        final String n = ename.getText().toString();
        final String b = ebio.getText().toString();
       // final String m = emob.getText().toString();
        final String e = email.getText().toString();
        String UsernameKey="username=";
        String PasswordKey="&password=";
        String EmailKey="&email";
        URLline="http://192.168.1.4/profile/profile.php?";

        final String Final_Link=URLline+UsernameKey+n+PasswordKey+b+EmailKey+e;
        if (n.equals("")||b.equals("")||e.equals(""))
        {
            Toast.makeText(Profile.this,"Please Enter your Data Completely", Toast.LENGTH_LONG).show();
        }
        else
        {

            StringRequest stringRequest = new StringRequest(Request.Method.GET, Final_Link,
                    new Response.Listener<String> () {

                        @Override
                        public void onResponse(String response) {




                            if (response.contains("login successfully"))
                            {
                                Intent i = new Intent(Profile.this,content.class);
                                startActivity(i);
                            }
                            if (response.contains("incorrect username or password "))
                            {
                                Toast.makeText(Profile.this,response,Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(Profile.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        }
                    }){};
                RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

            }

        }
            }
       /* StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        ProgressDialog.dismiss();
                        try {
                            JSONObject jsonObject =new JSONObject(response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ProgressDialog.hide();
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> params = new HashMap<>();

                params.put("name",n);
                params.put("bio",b);
                params.put("mob",m);
                params.put("mail",e);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }*/
        /*sharedPreferences = getSharedPreferences("mypreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, n);
        editor.putString(Bio, b);
        editor.putString(Mob, m);
        editor.putString(Mail, e);
        editor.apply();*/



 /*   public void clear(View v) {
        ename.setText("");
        ebio.setText("");
        emob.setText("");
        email.setText("");

    }*/

   /* public void load(View v) {
        sharedPreferences=getSharedPreferences("mypreference", Context.MODE_PRIVATE);
           if(sharedPreferences.contains(Name)){
               ename.setText(sharedPreferences.getString(Name,""));

           }
        if(sharedPreferences.contains(Bio)){
            ebio.setText(sharedPreferences.getString(Bio,""));

        }
        if(sharedPreferences.contains(Mob)){
            emob.setText(sharedPreferences.getString(Mob,""));

        }
        if(sharedPreferences.contains(Mail)){
            email.setText(sharedPreferences.getString(Mail,""));

        }

    }*/




