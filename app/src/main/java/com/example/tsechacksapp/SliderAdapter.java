package com.example.tsechacksapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public String slidedesc[] = {
            "A crime has been reported in a nearby area,the police is trying to find out the culprit.",
            "While the police officers search for the culprit we have a small task lined up for you.","At the end of each correct question you solve " +
            "in the given quiz you will be provided with a clue.",
            "The clues, clubbed together will give the name of the weapon used in commiting the act." +
                    "So whats waiting you from helping the police?Lets Dive In!!!!"
    };

    @Override
    public int getCount() {
        return slidedesc.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;


    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        TextView slidedesc1 = (TextView) view.findViewById(R.id.slide_desc);
        slidedesc1.setText(slidedesc[position]);
        container.addView(view);
        return view;



    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}