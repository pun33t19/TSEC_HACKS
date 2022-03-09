package com.example.tsechacksapp;



import android.os.Bundle;
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

import com.example.tsechacksapp.authentication.FirebaseServices;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginTabFragment extends Fragment {

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

        FirebaseUser currUser=mAuth.getCurrentUser();
        if (currUser!=null){
            navController=NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_loginTabFragment_to_homeFragment);
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



        FirebaseServices fs=new FirebaseServices();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail=userEmail.getText().toString();
                String pass=userPass.getText().toString();

                if (!(mail.isEmpty() && pass.isEmpty())){
                    user=fs.loginUserWithEmail(mAuth,mail,pass);
                }
                else{
                    Toast.makeText(getActivity(), "Enter your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}