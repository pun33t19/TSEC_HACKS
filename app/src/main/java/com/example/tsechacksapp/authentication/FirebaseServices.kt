package com.example.tsechacksapp.authentication

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

private const val TAG:String="login"

class FirebaseServices {

    fun loginUserWithEmail(auth:FirebaseAuth,email:String,pass:String):FirebaseUser{
        var user:FirebaseUser?=null

        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
            if (it.isSuccessful){
                Log.d(TAG, "createUserWithEmail:success")
                user = auth.currentUser

            }
            else{
                Log.w(TAG, "createUserWithEmail:failure", it.exception)
            }
        }

        return user!!
    }
}