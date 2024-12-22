package com.geeks.hw23;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView tvResult = view.findViewById(R.id.tvResult);

        if (getArguments() != null) {
            int counterValue = getArguments().getInt("counter_value", 0);
            tvResult.setText("Result: " + counterValue);
        }

        return view;
    }
}

