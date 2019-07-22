package com.trustathanas.absaclone.activities.register;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trustathanas.absaclone.R;
import com.trustathanas.absaclone.activities.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class RegisterLoginFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);

        TextInputLayout accessAccountLayout = view.findViewById(R.id.til_access_account_number);
        accessAccountLayout.setHintAnimationEnabled(true);
        return view;
    }

    @NotNull
    @Override
    protected String getLogTag() {
        return "RegisterLoginFragment";
    }

    @Override
    protected int getLayout() {
        return R.layout.register_login_fragment;
    }
}
