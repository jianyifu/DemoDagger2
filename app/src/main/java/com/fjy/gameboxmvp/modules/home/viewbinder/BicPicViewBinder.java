package com.fjy.gameboxmvp.modules.home.viewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fjy.gameboxmvp.R;
import com.fjy.gameboxmvp.data.pojo.BigPicBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fujianyi on 2017/12/13.
 */

public class BicPicViewBinder extends ItemViewBinder<BigPicBean, BicPicViewBinder.ViewHolder> implements View.OnClickListener{

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new BicPicViewBinder.ViewHolder(inflater.inflate(R.layout.item_big_pic, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BigPicBean item) {
        Glide.with(holder.root.getContext()).load(item.getImg())
                .into(holder.ivImg);
        setImgTitle(holder,item);
        setBottomBar(holder,item);
        holder.root.setOnClickListener(this);
    }

    private void setBottomBar(ViewHolder holder,BigPicBean item) {
        if (!TextUtils.isEmpty(item.getIconTitle())) {
            //set icon
            holder.ivIcon.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(item.getIcon())) {
                Glide.with(holder.root.getContext()).load(item.getIcon()).into(holder.ivIcon);
            }
            //set icon title
            holder.tvIconTitle.setVisibility(View.VISIBLE);
            holder.tvIconTitle.setText(item.getIconTitle());
        } else {
            //hide all the bottom views
            holder.ivIcon.setVisibility(View.GONE);
            holder.tvIconTitle.setVisibility(View.GONE);
            holder.taskStatusTv.setVisibility(View.GONE);
            holder.taskPb.setVisibility(View.GONE);
        }
    }

    private void setImgTitle(ViewHolder holder,BigPicBean item) {
        if (!TextUtils.isEmpty(item.getImgTitle())) {
            holder.imgMask.setVisibility(View.VISIBLE);
            holder.tvImgTitle.setVisibility(View.VISIBLE);
            holder.tvImgTitle.setText(item.getImgTitle());
        } else {
            holder.tvImgTitle.setVisibility(View.GONE);
            holder.imgMask.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"somewhere has been clicked",Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.root)
        View root;
        @BindView(R.id.divider)
        View divider;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_img_title)
        TextView tvImgTitle;
        @BindView(R.id.img_mask)
        View imgMask;
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_icon_title)
        TextView tvIconTitle;
        @BindView(R.id.tv_play)
        TextView taskStatusTv;
        @BindView(R.id.pb_download)
        ProgressBar taskPb;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
