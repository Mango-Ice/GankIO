package com.mangoice.gankio.ui.home.show_image;

import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

import com.bm.library.PhotoView;
import com.mangoice.gankio.R;
import com.mangoice.gankio.base.BaseActivity;
import com.mangoice.gankio.base.BasePresenter;

import java.util.List;


/**
 * Created by MangoIce on 2018/5/20.
 */
public class ShowImageActivity extends BaseActivity {
    private List<String> mListPics;
    private int mPosition;
    private int mPage;
    private ViewPager mViewPager;
    private ImagePagerAdapter mAdapter;
    private PhotoView mPhotoView;

    @Override
    protected void initOptions() {
        mViewPager = findViewById(R.id.show_image_view_pager);
        //获取传递的参数
        mListPics = getIntent().getStringArrayListExtra("picList");
        mPosition = getIntent().getIntExtra("position", 0);
        mPage = getIntent().getIntExtra("page", 0);

        mAdapter = new ImagePagerAdapter(this, mListPics);

        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(mPosition);
    }

    @Override
    protected String initToolbarTitle() {
        return null;
    }

    @Override
    protected void updateOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_search).setVisible(false);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected View initContentView() {
        return View.inflate(this, R.layout.activity_show_image, null);
    }
}
