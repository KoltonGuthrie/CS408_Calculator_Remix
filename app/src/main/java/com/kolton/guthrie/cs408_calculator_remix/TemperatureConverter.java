package com.kolton.guthrie.cs408_calculator_remix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kolton.guthrie.cs408_calculator_remix.databinding.FragmentTemperatureConverterBinding;

public class TemperatureConverter extends Fragment {

    private FragmentTemperatureConverterBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTemperatureConverterBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.convertButton.setOnClickListener(v -> {
            String fahrenheitInput = binding.fahrenheitInput.getText().toString();
            String celsiusInput = binding.celsiusInput.getText().toString();

            if(fahrenheitInput.length() <= 0 && celsiusInput.length() <= 0) {
                Toast.makeText(binding.getRoot().getContext(), R.string.empty_inputs_error, Toast.LENGTH_SHORT).show();
                return; // Both are empty
            }

            if((!fahrenheitInput.isEmpty() && !isNumeric(fahrenheitInput)) || (!celsiusInput.isEmpty() && !isNumeric(celsiusInput))) {
                Toast.makeText(binding.getRoot().getContext(), R.string.non_numeric_inputs_error, Toast.LENGTH_SHORT).show();
                return; // One of the inputs is not numeric
            }

            if(binding.fahrenheitInput.getText().length() > 0) { // Convert Fahrenheit to Celsius
                double fTemp = Double.parseDouble(binding.fahrenheitInput.getText().toString());
                double temp = convertFToC(fTemp);

                binding.celsiusInput.setText(String.valueOf(temp));
            } else { // Convert Celsius to Fahrenheit
                double cTemp = Double.parseDouble(binding.celsiusInput.getText().toString());
                double temp = convertCToF(cTemp);

                binding.fahrenheitInput.setText(String.valueOf(temp));
            }

        });
    }

    private double convertFToC(double fahr) {
        double cel = (fahr - 32.0) * (5.0 / 9.0);

        // Round to 2 decimal
        return Math.round(cel * 100.0) / 100.0;
    }

    private double convertCToF(double cel) {
        double fahr = (cel * 1.8) + 32;

        return Math.round(fahr * 100.0) / 100.0;
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