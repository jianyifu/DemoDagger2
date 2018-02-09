package com.fjy.gameboxmvp.modules.home.viewbinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fjy.gameboxmvp.R;
import com.fjy.gameboxmvp.data.pojo.GameListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fujianyi on 2017/12/13.
 */

public class CateGameTitleViewBinder extends ItemViewBinder<GameListBean, CateGameTitleViewBinder.ViewHolder> implements View.OnClickListener {

    @NonNull
    @Override
    protected CateGameTitleViewBinder.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new CateGameTitleViewBinder.ViewHolder(inflater.inflate(R.layout.item_cate_game_title, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull CateGameTitleViewBinder.ViewHolder holder, @NonNull GameListBean item) {
        if (holder != null && item != null) {
            Glide.with(holder.context).load(item.getIcon()).into(holder.ivIcon);
            holder.tvTitle.setText(item.getTitle());
            holder.tvMore.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (R.id.tv_more == v.getId()) {
            Toast.makeText(v.getContext(), "more is clicked", Toast.LENGTH_SHORT).show();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_more)
        TextView tvMore;

        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            this.context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }
    }

}