package com.kolton.guthrie.cs408_calculator_remix;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.kolton.guthrie.cs408_calculator_remix.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Get the root view and set it as the content view
        setContentView(binding.getRoot());

        // Load the TabLayoutContainer fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TabLayoutContainer())
                    .commit();
        }
    }
}