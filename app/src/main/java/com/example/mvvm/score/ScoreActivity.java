package com.example.mvvm.score;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityScoreBinding;

/**
 * author:lgh on 2020/6/8 10:37
 */
public class ScoreActivity extends AppCompatActivity {

    ScoreViewModel       mScoreViewModel;
    ActivityScoreBinding mScoreBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScoreBinding = DataBindingUtil.setContentView(this, R.layout.activity_score);
        mScoreViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
        mScoreBinding.setData(mScoreViewModel);
        mScoreBinding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScoreViewModel.save();//保存数据
    }

    @Override
    protected void onDestroy() {
        Log.e("TAG", "onDestroy: ");
        super.onDestroy();
    }
}
