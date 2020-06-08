package com.example.mvvm.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {

    ActivityNavigationBinding mActivityNavigationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityNavigationBinding = DataBindingUtil.setContentView(this,R.layout.activity_navigation);
        NavController controller = Navigation.findNavController(this, R.id.fragment_navigation11);
        NavigationUI.setupActionBarWithNavController(this, controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController controller = Navigation.findNavController(this, R.id.fragment_navigation11);
        return controller.navigateUp();
    }
}