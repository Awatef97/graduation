package com.awatef.loggin.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.awatef.loggin.R;
import com.awatef.loggin.model.User;
import com.awatef.loggin.model.Utilities;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRActivity extends AppCompatActivity
        implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private FirebaseAuth mAuth;
    private User recievedUser;
    public User updatedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
//        Log.v(TAG, rawResult.getText()); // Prints scan results
//        Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        mScannerView.resumeCameraPreview(this);
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            FirebaseDatabase
                    .getInstance()
                    .getReference("users")
                    .child(user.getUid())
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            recievedUser = dataSnapshot.getValue(User.class);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            if (recievedUser != null) {
                updatedUser = new User(recievedUser.getEmail(), recievedUser.getName(), recievedUser.getId(), recievedUser.getType(), recievedUser.getAttendence() + 1);

                Toast.makeText(QRActivity.this, updatedUser.toString(), Toast.LENGTH_LONG).show();

            FirebaseDatabase.getInstance()
                    .getReference("users")
                    .child(user.getUid())
                    .setValue(updatedUser)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Utilities.dismissLoadingDialog();
                                QRActivity.this.finish();

                            } else {
                                Toast.makeText(QRActivity.this,
                                        "Error in connection", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }}
//
    }
}