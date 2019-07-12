package com.awatef.loggin.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.awatef.loggin.R;
import com.awatef.loggin.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername, editTextPassword;
    private Button buttonRegister;
    private ProgressDialog ProgressDialog;
    private Spinner _spinner;
    private String URLline = "";

    private FirebaseAuth mAuth;
    private User recievedUser;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        ProgressDialog = new ProgressDialog(this);
        buttonRegister.setOnClickListener(this);
        _spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> Adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(Adapter);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    FirebaseDatabase
                            .getInstance()
                            .getReference("users")
                            .child(user.getUid())
                            .addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    recievedUser = dataSnapshot.getValue(User.class);
                                    if (recievedUser != null) {

                                        if (recievedUser.getType().equals("Doctor")) {
                                            Intent i = new Intent(MainActivity.this, Profile.class);//بدل الcontent اكتب اسم اكتيفيتي الطالب
                                            Bundle b = new Bundle();
                                            b.putString("UserName", String.valueOf(editTextUsername));
                                            b.putString("Password", String.valueOf(editTextPassword));
                                            i.putExtras(b);
                                            startActivity(i);
                                        } else if (recievedUser.getType().equals("Student")) {
                                            Intent i = new Intent(MainActivity.this, content.class);//بدل الcontent اكتب اسم اكتيفيتي الدكتور
                                            Bundle b = new Bundle();
                                            b.putString("UserName", String.valueOf(editTextUsername));
                                            b.putString("Password", String.valueOf(editTextPassword));
                                            i.putExtras(b);
                                            startActivity(i);
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                }
            }
        };


    }

    void login() {

        final String email = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        ProgressDialog.setMessage("Logining user....");
        ProgressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new
                                                                                        OnCompleteListener<AuthResult>() {
                                                                                            @Override
                                                                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                                                                ProgressDialog.cancel();
                                                                                                if (!task.isSuccessful()) {
                                                                                                    if (task.getException() instanceof FirebaseAuthInvalidUserException
                                                                                                            || task.getException()
                                                                                                            instanceof FirebaseAuthInvalidCredentialsException) {
                                                                                                        Toast.makeText(MainActivity.this, "Wrong Email or Password",
                                                                                                                Toast.LENGTH_SHORT).show();
                                                                                                    } else
                                                                                                        Toast.makeText(MainActivity.this, "Error In Connection",
                                                                                                                Toast.LENGTH_SHORT).show();
                                                                                                }
                                                                                            }
                                                                                        });
    }


    private void registerUser() {

        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        //final String type_id = ;

        String UsernameKey = "username=";
        String PasswordKey = "&password=";
        String type_idKey = "&type_id";
        URLline = "http://192.168.1.4/login/login.php?";

        final String Final_Link = URLline + UsernameKey + username + PasswordKey + password + type_idKey;

      /*  if (TextUtils.isEmpty(username)) {
            editTextUsername.setError("Please enter your username");
            editTextUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please enter your password");
            editTextPassword.requestFocus();
            return;
        }*/

        ProgressDialog.setMessage("Registering user....");
        ProgressDialog.show();

        if (username.equals("") || password.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter your Data Completely", Toast.LENGTH_LONG).show();
        } else {

            StringRequest stringRequest = new StringRequest(Request.Method.GET, Final_Link,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {

                            /*try {
                                JSONArray jsonArray = new JSONArray(response);
                                JSONObject jsonObject = jsonArray.getJSONObject(0);

                                String type_id = jsonObject.getString("type_id");


                               // firstNameTV.setText(firstName);
                               // lastNameTV.setText(lastName);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }*/


                            if (response.contains("login successfully")) {
                               /* Intent i = new Intent(MainActivity.this,content.class);
                                startActivity(i);*/
                                String item = _spinner.getSelectedItem().toString();
                                if (item.equals("Doctor")) {
                                    Intent i = new Intent(MainActivity.this, Profile.class);//بدل الcontent اكتب اسم اكتيفيتي الطالب
                                    Bundle b = new Bundle();
                                    b.putString("UserName", String.valueOf(editTextUsername));
                                    b.putString("Password", String.valueOf(editTextPassword));
                                    i.putExtras(b);
                                    startActivity(i);

                                } else if (item.equals("Student")) {
                                    Intent i = new Intent(MainActivity.this, content.class);//بدل الcontent اكتب اسم اكتيفيتي الدكتور
                                    Bundle b = new Bundle();
                                    b.putString("UserName", String.valueOf(editTextUsername));
                                    b.putString("Password", String.valueOf(editTextPassword));
                                    i.putExtras(b);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                                }

                            }
                            if (response.contains("incorrect username or password ")) {
                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG)
                                        .show();
                            }

                            //هحط الtry&&catch عشان لو الترميز عربي مايحصلش مشكله
                       /* try {
                            String encodedstring= URLEncoder.encode(response,"ISO-8859-1");
                            response= URLDecoder.decode(encodedstring,"UTF-8");
                        }catch (UnsupportedEncodingException e){
                               e.printStackTrace();
                        }*/

                            ProgressDialog.dismiss();
                            /*try {
                                JSONObject jsonObject =new JSONObject(response);
                                Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }*/

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            ProgressDialog.hide();
                            Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {

           /* @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> params = new HashMap<>();
                params.put("username",username);
                params.put("password",password);

                return params;
            }*/
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }

    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister)
            login();


     /*   Intent i = new Intent(MainActivity.this,content.class);
        startActivity(i);*/


    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}