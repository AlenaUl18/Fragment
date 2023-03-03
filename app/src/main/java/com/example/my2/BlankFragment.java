package com.example.my2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BlankFragment extends Fragment {
    public BlankFragment() {
        super(R.layout.fragment_blank);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView text = (TextView) view.findViewById(R.id.textView7);
        String s = "КинотеатрMyCinema";
        text.setText(s);

        ImageView image = (ImageView) view.findViewById(R.id.imageView2);
        Drawable draw = getResources().getDrawable(R.drawable.movie_player_play_video_svgrepo_com);
        image.setImageDrawable(draw);
    }
}