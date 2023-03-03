package com.example.my2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BlankFragment2 extends Fragment {
    public BlankFragment2() {
        super(R.layout.fragment_blank2);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, (key, bundle) -> {
            String result = bundle.getString("bundleKey");
            TextView text = (TextView) getView().findViewById(R.id.editTextTextPersonName4);
            text.setText(result);
        });
        Button button = view.findViewById(R.id.button5);
        button.setOnClickListener(v -> {
            Bundle result = new Bundle();
            result.putString("bundleKey", String.valueOf("Вы зашли в аккаунт"));
            getParentFragmentManager().setFragmentResult("requestKey", result);

            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, BlankFragment.class, null).commit();
        });
    }
}