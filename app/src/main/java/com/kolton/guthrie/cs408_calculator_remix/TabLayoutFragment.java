package com.kolton.guthrie.cs408_calculator_remix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kolton.guthrie.cs408_calculator_remix.databinding.TabFragmentBinding;

public class TabLayoutFragment extends Fragment {

    public static final String ARG_ID = "id";

    private TabFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TabFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        int id = args.getInt(ARG_ID);

        switch (id) {
            case 1:
                setupTemperatureConverter();
                break;
            case 2:
                setupSumCalculator();
                break;
            case 3:
                setupDistanceCalculator();
                break;
        }
    }

    private void setupTemperatureConverter() {
        View view = getLayoutInflater().inflate(R.layout.fragment_temperature_converter, null);
        binding.linearLayout.addView(view);
        new TemperatureConverter();
    }

    private void setupDistanceCalculator() {
        View view = getLayoutInflater().inflate(R.layout.fragment_distance_calculator, null);
        binding.linearLayout.addView(view);
        new DistanceCalculator();
    }

    private void setupSumCalculator() {
        View view = getLayoutInflater().inflate(R.layout.fragment_tip_calculator, null);
        binding.linearLayout.addView(view);
        new TipCalculator();
    }
}