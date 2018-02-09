package com.fjy.gameboxmvp.modules.home.viewbinder;

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
import com.fjy.gameboxmvp.data.pojo.GameInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fujianyi on 2017/12/13.
 */

public class CateGameViewBinder extends ItemViewBinder<GameInfo, CateGameViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected CateGameViewBinder.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_cate_game, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull CateGameViewBinder.ViewHolder holder, @NonNull GameInfo item) {
        if (holder != null && item != null) {
            holder.tvGameName.setText(item.getName() + "");
            holder.tvGameBrief.setText(item.getShortDescription() + "");

            holder.tvGamePlay.setText(item.getPlayText());


            Glide.with(holder.itemView.getContext()).load(item.getIconImg()).into(holder.ivGameIcon);
            holder.tvGamePlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "game play is clicked", Toast.LENGTH_SHORT).show();
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "itemView is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_game_icon)
        ImageView ivGameIcon;
        @BindView(R.id.tv_game_name)
        TextView tvGameName;
        @BindView(R.id.tv_game_brief)
        TextView tvGameBrief;
        @BindView(R.id.tv_game_play)
        TextView tvGamePlay;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

}