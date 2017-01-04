package com.decisionsupport.AhpMethod.AhpSteps;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.decisionsupport.R;
import com.decisionsupport.databinding.AhpMethodAddCriterionsStepBinding;
import com.github.fcannizzaro.materialstepper.AbstractStep;

/**
 * Created by denisvieira on 04/01/17.
 */
public class AddCriterionsStep extends AbstractStep {

    private AhpMethodAddCriterionsStepBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.ahp_method_add_criterions_step,container,false);

        return mBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
    }

    @Override
    public String name() {
        return "Tab " + getArguments().getInt("position", 0);
    }

    @Override
    public boolean isOptional() {
        return true;
    }

    @Override
    public void onStepVisible() {
    }

    @Override
    public void onNext() {
        System.out.println("onNext");
    }

    @Override
    public void onPrevious() {
        System.out.println("onPrevious");
    }

    @Override
    public String optional() {
        return "You can skip";
    }


    @Override
    public String error() {
        return "<b>You must click!</b> <small>this is the condition!</small>";
    }
}