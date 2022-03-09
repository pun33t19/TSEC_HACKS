package com.example.tsechacksapp

import android.os.Bundle
import android.util.Log
import com.example.tsechacksapp.QuizQuestionsFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tsechacksapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [QuizQuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class QuizQuestionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val questionList = Questions.getQuestions()
        Log.i("Questions Size","${questionList.size}")



    }
}