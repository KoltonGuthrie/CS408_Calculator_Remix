package com.kolton.guthrie.cs408_calculator_remix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kolton.guthrie.cs408_calculator_remix.databinding.FragmentTipCalculatorBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class TipCalculator extends Fragment {

    private FragmentTipCalculatorBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTipCalculatorBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.calculateButton.setOnClickListener(v -> {
            String billAmount = binding.totalBillInput.getText().toString();
            String tipPercentage = binding.tipInput.getText().toString();
            String numPeople = binding.numPeopleInput.getText().toString();

            if(billAmount.isEmpty() || tipPercentage.isEmpty() || numPeople.isEmpty()) {
                Toast.makeText(binding.getRoot().getContext(), R.string.empty_inputs_error, Toast.LENGTH_SHORT).show();
                return; // One of three inputs is empty
            }

            if(!isNumeric(billAmount) || !isNumeric(tipPercentage) || !isNumeric(numPeople)) {
                Toast.makeText(binding.getRoot().getContext(), R.string.non_numeric_inputs_error, Toast.LENGTH_SHORT).show();
                return; // One of the inputs is not numeric
            }

            double billAmountValue = Double.parseDouble(billAmount);
            double tipPercentageValue = Double.parseDouble(tipPercentage);
            double numPeopleValue = Double.parseDouble(numPeople);

            double amount = (billAmountValue + (billAmountValue * (tipPercentageValue / 100))) / numPeopleValue;
            binding.totalPerPersonValue.setText(NumberFormat.getCurrencyInstance(Locale.US).format(amount));

        });
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