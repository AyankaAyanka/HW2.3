package com.geeks.hw23;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {

    private int counter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        TextView tvCounter = view.findViewById(R.id.tvCounter);
        Button btnIncrement = view.findViewById(R.id.btnIncrement);
        Button btnDecrement = view.findViewById(R.id.btnDecrement);
        Button btnNavigate = view.findViewById(R.id.btnNavigate);

        // Увеличение счётчика
        btnIncrement.setOnClickListener(v -> {
            counter++;
            tvCounter.setText(String.valueOf(counter));
        });

        // Уменьшение счётчика
        btnDecrement.setOnClickListener(v -> {
            counter--;
            tvCounter.setText(String.valueOf(counter));
        });

        // Навигация к ResultFragment
        btnNavigate.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("counter_value", counter);

            ResultFragment resultFragment = new ResultFragment();
            resultFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, resultFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}
