package com.mangoice.gankio.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.mangoice.gankio.base.BaseFragment;
import com.mangoice.gankio.model.Channel;
import com.mangoice.gankio.ui.home.MainDetailFragment;
import com.mangoice.gankio.ui.news.NewsFragment;

import java.util.List;

/**
 * Created by MangoIce on 2018/5/24.
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {
    private List<Channel> mChannels;

    public HomePagerAdapter(FragmentManager fm, List<Channel> channels) {
        super(fm);
        this.mChannels = channels;
    }

    public void updateChannel(List<Channel> channels){
        this.mChannels = channels;
        notifyDataSetChanged();
    }

    @Override
    public BaseFragment getItem(int position) {
        return MainDetailFragment.newInstance(mChannels.get(position).getChannelType());
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels.get(position).getChannelName();
    }

    @Override
    public int getCount() {
        return mChannels != null ? mChannels.size() : 0;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
