package com.ahpandroid.ahpmethod.ahpdashboard;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.ahpandroid.R;
import com.ahpandroid.databinding.AhpDashboardCriterionItemBinding;
import com.ahpandroid.domain.entity.Criterion;
import com.ahpandroid.utils.GuidGenerator;

import java.util.List;

/**
 * Created by denisvieira on 19/02/17.
 */

public class AhpDashboardCriterionAdapter extends RecyclerSwipeAdapter<AhpDashboardCriterionAdapter.ItemViewHolder> {

    private List<String> mCriterions;
    private Context mContext;
    private AhpDashboardContract.View mAhpDashboardContract;
    private AhpDashboardCriterionAdapter.ItemViewHolder mViewHolder;

    private void setList(List<String> list) {
        mCriterions = list;
    }

    public AhpDashboardCriterionAdapter(List<String> criterions, Context context, AhpDashboardContract.View ahpDashboardContract) {
        this.mCriterions = criterions;
        this.mContext = context;
        this.mAhpDashboardContract = ahpDashboardContract;
    }

    public List<String> getCriterions(){
        return mCriterions;
    }

    public void replaceData(List<String> criterions) {
        setList(criterions);
        notifyDataSetChanged();
    }

    public void addItem(String criterionTitle){
        String criterion = criterionTitle;
        mCriterions.add(criterion);
        notifyDataSetChanged();
        mAhpDashboardContract.checkListsContent();
    }
    public void removeItem(int position){
        mCriterions.remove(position);
        notifyDataSetChanged();
        mAhpDashboardContract.checkListsContent();
    }

    @Override
    public int getItemCount() {
        return mCriterions.size();
    }


    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.ahp_dashboard_criterion_item_swipe_layout;
    }

    @Override
    public AhpDashboardCriterionAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AhpDashboardCriterionItemBinding ahpDashboardCriterionItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.ahp_dashboard_criterion_item,
                        parent, false);

        return new AhpDashboardCriterionAdapter.ItemViewHolder(ahpDashboardCriterionItemBinding);
    }

    @Override
    public void onBindViewHolder(AhpDashboardCriterionAdapter.ItemViewHolder holder, int position) {

        mViewHolder = holder;

        String criterion = mCriterions.get(position);

        holder.mAhpDashboardCriterionItemBinding.setCriterion(criterion);

        holder.mAhpDashboardCriterionItemBinding.ahpDashboardRemoveCriterionLinearLayout.setOnClickListener(v -> {
            removeItem(position);
        });

    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private AhpDashboardCriterionItemBinding mAhpDashboardCriterionItemBinding;

        public ItemViewHolder(AhpDashboardCriterionItemBinding ahpDashboardCriterionItemBinding) {
            super(ahpDashboardCriterionItemBinding.getRoot());

            this.mAhpDashboardCriterionItemBinding = ahpDashboardCriterionItemBinding;

        }
    }
}
