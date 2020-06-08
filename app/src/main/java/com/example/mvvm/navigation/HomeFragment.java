package com.example.mvvm.navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.mvvm.R;
import com.example.mvvm.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    HomeFragmentBinding mHomeFragmentBinding;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mHomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);
        mViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        mHomeFragmentBinding.setData(mViewModel);
        mHomeFragmentBinding.setLifecycleOwner(getActivity());
        mHomeFragmentBinding.seekBar.setProgress(mViewModel.getNumber().getValue());
        mHomeFragmentBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mViewModel.getNumber().setValue(progress);

                Integer value = mViewModel.getNumber().getValue();
                Log.e("TAG", "onProgressChanged: " + value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mHomeFragmentBinding.button2.setOnClickListener(v -> {
            NavController controller = Navigation.findNavController(v);
            controller.navigate(R.id.action_homeFragment_to_detailFragment);

        });
        return mHomeFragmentBinding.getRoot();
    }

}