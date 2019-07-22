package com.trustathanas.absaclone.activities.register;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trustathanas.absaclone.R;
import com.trustathanas.absaclone.activities.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class RegisterFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        return view;
    }

    @NotNull
    @Override
    protected String getLogTag() {
        return "RegisterFragment";
    }

    @Override
    protected int getLayout() {
        return R.layout.register_fragment;
    }
}
