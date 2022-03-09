package com.example.tsechacksapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class SignUpTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_up_tab,container,false);
        return root;
    }
}