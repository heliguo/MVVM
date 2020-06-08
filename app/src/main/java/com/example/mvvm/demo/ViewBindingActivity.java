package com.example.mvvm.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityViewBindingBinding;
import com.example.mvvm.score.ScoreActivity;

import java.util.List;

/**
 * author:lgh on 2020/6/5 9:06
 */
public class ViewBindingActivity extends AppCompatActivity {

    private static final String TAG = "ViewBindingActivity";

    private ActivityViewBindingBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_binding);
        mBinding.button.setOnClickListener(v -> {
            startActivity(new Intent(this, ScoreActivity.class));
            System.out.println(mBinding.name.getText().toString());
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("");
            List<Fragment> fragments = fm.getFragments();
            for (Fragment fragment : fragments) {
                System.out.println(fragment.getId());
            }
            User user = new User();
            user.setFirstName("hahaha");

            MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
            myViewModel.getUsers().observe(this,
                    new Observer<List<User>>() {
                        @Override
                        public void onChanged(List<User> users) {
                            Log.e(TAG, "onCreate: ");
                            myViewModel.setUserName("hahahah");
                        }
                    });
        });


    }
}
