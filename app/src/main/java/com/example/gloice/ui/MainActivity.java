package com.example.gloice.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.gloice.R;
import com.example.gloice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        binding.setLifecycleOwner(this);
        binding.getRoot();
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.frame,new MainFragment()).
                commit();
    }


}
