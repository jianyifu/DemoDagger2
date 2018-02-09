package com.fjy.gameboxmvp.modules.home.viewbinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fjy.gameboxmvp.R;
import com.fjy.gameboxmvp.data.pojo.GameInfo;
import com.fjy.gameboxmvp.data.pojo.GameInfos;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by fujianyi on 2017/12/19.
 */

public class HomeHistoryViewBinder extends ItemViewBinder<GameInfos, HomeHistoryViewBinder.OuterViewHolder> {


    @NonNull
    @Override
    protected OuterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new HomeHistoryViewBinder.OuterViewHolder(inflater.inflate(R.layout.section_history, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull OuterViewHolder holder, @NonNull GameInfos item) {
        holder.history.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        //去掉RecyclerView滑到边界产生的蓝色阴影
        holder.history.setOverScrollMode(View.OVER_SCROLL_NEVER);
        holder.historyAdapter = new HistoryAdapter(holder.itemView.getContext(), item.getDatas());
        holder.history.setAdapter(holder.historyAdapter);
    }

    public static class OuterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.history_recyclerView)
        RecyclerView history;
        private RecyclerView.Adapter historyAdapter;

        public OuterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }

    private static class HistoryAdapter extends RecyclerView.Adapter implements OnItemClickListener {
        private LayoutInflater mInflater;
        private List<GameInfo> items;
        private OnItemClickListener onItemClickListener;
        public HistoryAdapter(Context context, List<GameInfo> items) {
            checkNotNull(context);
            checkNotNull(items);
            mInflater = LayoutInflater.from(context);
            this.items = items;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            checkNotNull(holder);
            InnerViewHolder innerViewHolder = (InnerViewHolder) holder;
            GameInfo gameInfo = items.get(position);
            Glide.with(innerViewHolder.itemView.getContext()).load(gameInfo.getIconImg()).into(innerViewHolder.ivGameIcon);
            innerViewHolder.tvGameName.setText(gameInfo.getName());
            innerViewHolder.itemView.setOnClickListener(v -> onItemClick(v,position));
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new InnerViewHolder(mInflater.inflate(R.layout.item_history, parent, false));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public void onItemClick(View v, int pos) {
            Toast.makeText(v.getContext(),"pos = "+pos,Toast.LENGTH_SHORT).show();
        }

    }
    public interface OnItemClickListener{
        void onItemClick(View v,int pos);
    }
    public static class InnerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_game_icon)
        ImageView ivGameIcon;
        @BindView(R.id.tv_game_name)
        TextView tvGameName;
        @BindView(R.id.root)
        LinearLayout root;
        public InnerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
