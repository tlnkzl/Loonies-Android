package com.android.loonies.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.loonies.R;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 7485; // Any number
    List<AuthUI.IdpConfig> providers;

    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logout
                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                logoutButton.setEnabled(false);
                                showSignInOptions();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, ""+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        //Init Provider
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),     // Email Builder
                new AuthUI.IdpConfig.GoogleBuilder().build()     // Google Builder
        //      new AuthUI.IdpConfig.FacebookBuilder().build(),  // Facebook Builder
        //      new AuthUI.IdpConfig.PhoneBuilder().build(),     // Phone Builder
        );

        showSignInOptions();

    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTheme(R.style.authTheme)
                .build(), MY_REQUEST_CODE
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE)
        {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK)
            {
                // Get User
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // Show email on ToastMessage
                Toast.makeText(this, ""+ (user != null ? user.getEmail() : null),Toast.LENGTH_SHORT).show();
                // Set Button Logout
                logoutButton.setEnabled(true);

            }
            else
            {
                Toast.makeText(this, ""+ Objects.requireNonNull(response != null ? response.getError() : null).getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initViews() {
        logoutButton = findViewById(R.id.button_logout);
    }
}
