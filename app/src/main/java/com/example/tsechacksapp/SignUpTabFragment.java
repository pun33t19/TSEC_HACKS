package com.example.tsechacksapp;

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
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpTabFragment extends Fragment {

    EditText userEmail,pass,confirmPass;
    Button registerButton;
    private FirebaseAuth mAuth;
    private final String TAG="success";



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
           // NavHostFragment.findNavController(SignUpTabFragment.this).navigate(R.id.action_signUpTabFragment_to_homeFragment);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_up_tab,container,false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userEmail=view.findViewById(R.id.user_email);
        pass=view.findViewById(R.id.user_pass);
        confirmPass=view.findViewById(R.id.user_confirm_pass);
        registerButton =view.findViewById(R.id.button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailStr=userEmail.getText().toString();
                String passStr=pass.getText().toString();
                String confirmPassStr=confirmPass.getText().toString();

                if (!mailStr.isEmpty() && !passStr.isEmpty() && !confirmPassStr.isEmpty() && passStr.equals(confirmPassStr)){
                mAuth.createUserWithEmailAndPassword(mailStr,passStr).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d("Success","Authentication successful");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getActivity(), "Registered successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getActivity(), "Enter a valid Email", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                }
                else{
                    Toast.makeText(getActivity(), "Enter the credentials", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}