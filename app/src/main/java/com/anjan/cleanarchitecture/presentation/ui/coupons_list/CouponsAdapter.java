package com.anjan.cleanarchitecture.presentation.ui.coupons_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.anjan.cleanarchitecture.R;
import com.anjan.cleanarchitecture.presentation.model.Coupon;

import java.util.List;

class CouponsAdapter extends RecyclerView.Adapter<CouponsAdapter.ViewHolder> {

    private List<Coupon> couponList;
    private Context context;

    public CouponsAdapter(List<Coupon> cpnList, Context ctx) {
        couponList = cpnList;
        context = ctx;
    }

    @Override
    public CouponsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_item, parent, false);

        CouponsAdapter.ViewHolder viewHolder = new CouponsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CouponsAdapter.ViewHolder holder, int position) {
        Coupon coupon = couponList.get(position);
        holder.store.setText(coupon.getStore());
        holder.coupon.setText(coupon.getCoupon());
        holder.expiry.setText(coupon.getExpiryDate());
        holder.code.setText(coupon.getCouponCode());
    }

    @Override
    public int getItemCount() {
        return couponList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView store;
        public TextView coupon;
        public TextView expiry;
        public TextView code;

        public ViewHolder(View view) {
            super(view);

            store = (TextView) view.findViewById(R.id.store);
            coupon = (TextView) view.findViewById(R.id.coupon);
            expiry = (TextView) view.findViewById(R.id.expiry);
            code = (TextView) view.findViewById(R.id.coupon_code);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "You chose coupon " + getAdapterPosition(),
                    Toast.LENGTH_LONG).show();
        }
    }
}