package com.example.mvvm.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mvvm.R;
import com.example.mvvm.databinding.DetailFragmentBinding;

public class DetailFragment extends Fragment {

    private HomeViewModel mViewModel;
    DetailFragmentBinding mDetailFragmentBinding;

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mDetailFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false);
        mViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        mDetailFragmentBinding.setData(mViewModel);
        mDetailFragmentBinding.setLifecycleOwner(getActivity());
        mDetailFragmentBinding.btnTz.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                        R.id.action_detailFragment_to_homeFragment));
        return mDetailFragmentBinding.getRoot();
    }

}