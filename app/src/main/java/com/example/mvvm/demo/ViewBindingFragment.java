package com.example.mvvm.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvvm.R;
import com.example.mvvm.databinding.FragmentBlankBinding;
/**
 * author:lgh on 2020/6/5 9:31
 */
public class ViewBindingFragment extends Fragment {


    private FragmentBlankBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentBlankBinding.inflate(inflater, container, false);
        mBinding.textViewFragment.setText(R.string.bingfragment);
        return mBinding.getRoot();
    }

//    //如果视图膨胀使用此方法
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        mBinding = FragmentBlankBinding.bind(view);
//        mBinding.name.setText(R.string.bindfragment);
//    }


    @Override
    public void onDestroyView() {
        mBinding = null;
        super.onDestroyView();
    }

}
