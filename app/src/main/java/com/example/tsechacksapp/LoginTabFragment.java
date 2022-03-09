package com.example.tsechacksapp;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginTabFragment extends Fragment {

    private static final String TAG = "Success";
    private FirebaseAuth mAuth;
    NavController navController;
    EditText userEmail,userPass;
    private FirebaseUser user;
    Button loginButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();

    }

    @Override
    public void onStart() {
        super.onStart();
        user=mAuth.getCurrentUser();
        if (user!=null){
            //NavHostFragment.findNavController(LoginTabFragment.this).navigate(R.id.action_loginTabFragment_to_homeFragment);
            startActivity(new Intent(getActivity(),MainActivity.class));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_login_tab,container,false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userEmail=view.findViewById(R.id.user_email);
        userPass=view.findViewById(R.id.user_pass);
        loginButton=view.findViewById(R.id.button);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailStr=userEmail.getText().toString();
                String passStr=userPass.getText().toString();

                mAuth.signInWithEmailAndPassword(mailStr,passStr).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //NavHostFragment.findNavController(LoginTabFragment.this).navigate(R.id.action_loginTabFragment_to_homeFragment);
                            Toast.makeText(getActivity(), "Signed in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getActivity(),MainActivity.class));
                        }
                        else {
                            Log.w("Failed", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });

            }
        });



    }

    private void updateUI(FirebaseUser user) {

    }
}