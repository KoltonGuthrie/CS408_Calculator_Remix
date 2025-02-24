package com.kolton.guthrie.cs408_calculator_remix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kolton.guthrie.cs408_calculator_remix.databinding.FragmentDistanceCalculatorBinding;

public class DistanceCalculator extends Fragment {

    private FragmentDistanceCalculatorBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDistanceCalculatorBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.convertButton.setOnClickListener(v -> {
            String milesInput = binding.milesInput.getText().toString();
            String kilometersInput = binding.kilometersInput.getText().toString();

            if(milesInput.length() <= 0 && kilometersInput.length() <= 0) {
                Toast.makeText(binding.getRoot().getContext(), R.string.empty_inputs_error, Toast.LENGTH_SHORT).show();
                return; // Both are empty
            }

            if((!milesInput.isEmpty() && !isNumeric(milesInput)) || (!kilometersInput.isEmpty() && !isNumeric(kilometersInput))) {
                Toast.makeText(binding.getRoot().getContext(), R.string.non_numeric_inputs_error, Toast.LENGTH_SHORT).show();
                return; // One of the inputs is not numeric
            }

            if(binding.milesInput.getText().length() > 0) { // Convert miles to kilometers
                double fTemp = Double.parseDouble(binding.milesInput.getText().toString());
                double temp = convertMToK(fTemp);

                binding.kilometersInput.setText(String.valueOf(temp));
            } else { // Convert kilometers to miles
                double cTemp = Double.parseDouble(binding.kilometersInput.getText().toString());
                double temp = convertKToM(cTemp);

                binding.milesInput.setText(String.valueOf(temp));
            }

        });
    }

    private double convertMToK(double miles) {
        double kilometers = miles * 1.6;

        // Round to 2 decimal
        return Math.round(kilometers * 100.0) / 100.0;
    }

    private double convertKToM(double kilometers) {
        double miles = kilometers / 1.6;

        // Round to 2 decimal
        return Math.round(miles * 100.0) / 100.0;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}