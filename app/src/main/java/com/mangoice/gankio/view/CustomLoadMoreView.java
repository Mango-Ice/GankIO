package com.mangoice.gankio.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.mangoice.gankio.R;

/**
 * Created by MangoIce on 2018/5/25.
 */
public class CustomLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.load_more_view;
    }


    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return 0;
    }
}
