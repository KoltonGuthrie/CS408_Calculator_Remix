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
        // Inflate the layout using view binding
        binding = TabFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        int id = args.getInt(ARG_ID);

        // Add logic for each tab
        switch (id) {
            case 1:
                setupTemperatureConverter();
                break;
            case 2:
                setupSumCalculator();
                break;
            case 3:
                setupTaxCalculator();
                break;
        }
    }

    // Tab 1: Temperature Converter
    private void setupTemperatureConverter() {
        View view = getLayoutInflater().inflate(R.layout.fragment_temperature_converter, null);
        binding.linearLayout.addView(view);
        new TemperatureConverter();
    }

    // Tab 2: Tax Calculator
    private void setupTaxCalculator() {
        View view = getLayoutInflater().inflate(R.layout.fragment_distance_calculator, null);
        binding.linearLayout.addView(view);
        new DistanceCalculator();
    }

    // Tab 3: Sum Calculator
    private void setupSumCalculator() {
        View view = getLayoutInflater().inflate(R.layout.fragment_tip_calculator, null);
        binding.linearLayout.addView(view);
        new TipCalculator();
    }
}