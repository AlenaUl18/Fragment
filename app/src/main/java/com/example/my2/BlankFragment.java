package com.example.my2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BlankFragment extends Fragment {
    public BlankFragment() {
        super(R.layout.fragment_blank);
    }
    private final static String TAG = "ContentFragment";
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        Toast.makeText(context, "onAttach", Toast.LENGTH_LONG).show();
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        Toast.makeText(context, "onCreate", Toast.LENGTH_LONG).show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        Toast.makeText(context, "onCreateView", Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_blank, container, false);

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
        Log.d(TAG, "onViewCreated");
        Toast.makeText(context, "onViewCreated", Toast.LENGTH_LONG).show();
        Button button = view.findViewById(R.id.button3);
        button.setOnClickListener(v -> { Bundle result = new Bundle();
            result.putString("bundleKey", String.valueOf("Аня"));
            getParentFragmentManager().setFragmentResult("requestKey", result); getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, BlankFragment2.class, null).commit();});
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onViewStateRestored");
        Toast.makeText(context, "onViewStateRestored", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        Toast.makeText(context, "OnStart", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Toast.makeText(context, "OnResume", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(context, "OnPause", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(context, "OnStop", Toast.LENGTH_LONG).show();
        if (getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView");
        Toast.makeText(context, "onDestroyView", Toast.LENGTH_LONG).show();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        Toast.makeText(context, "onDestroy", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach");
        Toast.makeText(context, "onDetach", Toast.LENGTH_LONG).show();
        super.onDetach();
    }
}