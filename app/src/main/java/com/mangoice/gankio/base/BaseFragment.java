package com.mangoice.gankio.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mangoice.gankio.R;
import com.mangoice.gankio.adapter.GankAdapter;
import com.mangoice.gankio.common.Constant;
import com.mangoice.gankio.model.GankModel;
import com.mangoice.gankio.net.Api;
import com.mangoice.gankio.net.NetManager;
import com.mangoice.gankio.utils.ResourceHelper;
import com.mangoice.gankio.utils.ToastWrapper;
import com.mangoice.gankio.view.EmptyRecyclerView;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MangoIce on 2017/11/17.
 *
 * 使用了 dasu 的懒加载封装
 */

public abstract class BaseFragment<V extends BaseView, T extends BasePresenter<V>> extends Fragment {
    @Nullable
    @BindView(R.id.fragment_loading_view)
    AVLoadingIndicatorView mLoadingView;
    @Nullable
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mRefreshView;
    protected Context mContext;
    private Unbinder unbinder;
    private View mRootView;
    private boolean isFragmentVisible;
    private boolean isReuseView;
    private boolean isFirstVisible;
    protected T presenter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
        initVariable();
    }

    /**
     * 设置Presenter
     */
    public abstract T createPresenter();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //setUserVisibleHint()有可能在fragment的生命周期外被调用
        if (mRootView == null) {
            return;
        }
        if (isFirstVisible && isVisibleToUser) {
            onFragmentFirstVisible();
            isFirstVisible = false;
        }
        if (isVisibleToUser) {
            onFragmentVisibleChange(true);
            isFragmentVisible = true;
            return;
        }
        if (isFragmentVisible) {
            isFragmentVisible = false;
            onFragmentVisibleChange(false);
        }
    }

    private void initVariable() {
        isFirstVisible = true;
        isFragmentVisible = false;
        mRootView = null;
        isReuseView = true;
    }

    /**
     * 设置是否使用 view 的复用，默认开启
     * view 的复用是指，ViewPager 在销毁和重建 Fragment 时会不断调用 onCreateView() -> onDestroyView()
     * 之间的生命函数，这样可能会出现重复创建 view 的情况，导致界面上显示多个相同的 Fragment
     * view 的复用其实就是指保存第一次创建的 view，后面再 onCreateView() 时直接返回第一次创建的 view
     *
     * @param isReuse
     */
    protected void reuseView(boolean isReuse) {
        isReuseView = isReuse;
    }

    /**
     * 去除setUserVisibleHint()多余的回调场景，保证只有当fragment可见状态发生变化时才回调
     * 回调时机在view创建完后，所以支持ui操作，解决在setUserVisibleHint()里进行ui操作有可能报null异常的问题
     *
     * 可在该回调方法里进行一些ui显示与隐藏，比如加载框的显示和隐藏
     *
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    protected void onFragmentVisibleChange(boolean isVisible) {

    }

    /**
     * 在fragment首次可见时回调，可在这里进行加载数据，保证只在第一次打开Fragment时才会加载数据，
     * 这样就可以防止每次进入都重复加载数据
     * 该方法会在 onFragmentVisibleChange() 之前调用，所以第一次打开时，可以用一个全局变量表示数据下载状态，
     * 然后在该方法内将状态设置为下载状态，接着去执行下载的任务
     * 最后在 onFragmentVisibleChange() 里根据数据下载状态来控制下载进度ui控件的显示与隐藏
     */
    protected void onFragmentFirstVisible() {

    }

    protected boolean isFragmentVisible() {
        return isFragmentVisible;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initVariable();
//        if (mRootView != null) {
//            ViewGroup parent = (ViewGroup) mRootView.getParent();
//            if (parent != null) {
//                parent.removeView(mRootView);
//            }
//        } else {
//            mRootView = inflater.inflate(getContentLayout(), container, false);
//            unbinder = ButterKnife.bind(this, mRootView);
//        }
        mRootView = inflater.inflate(getContentLayout(), container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    protected abstract int getContentLayout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = view;
            if (getUserVisibleHint()) {
                if (isFirstVisible) {
                    onFragmentFirstVisible();
                    isFirstVisible = false;
                }
                onFragmentVisibleChange(true);
                isFragmentVisible = true;
            }
        }
        //设置下拉刷新的颜色
        if (mRefreshView != null) {
            mRefreshView.setColorSchemeColors(ResourceHelper.getColor(R.color.colorPrimary));

            mRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    initRefreshListener();
                }
            });
        }
        initOptions();
        super.onViewCreated(isReuseView ? mRootView : view, savedInstanceState);
    }

    /**
     * 设置下拉刷新操作
     */
    protected abstract void initRefreshListener();

    /**
     * 开启下拉刷新
     */
    public void showRefresh() {
        if (mRefreshView != null) {
            mRefreshView.setRefreshing(true);
        }

    }

    /**
     * 关闭下拉刷新
     */
    public void hideRefresh() {
        if (mRefreshView != null && mRefreshView.isRefreshing()) {
            mRefreshView.setRefreshing(false);
        }
    }

    /**
     * 显示加载等待动画
     */
    public void showLoading() {
        if (mLoadingView != null) {
            mLoadingView.smoothToShow();
        }
    }

    /**
     * 隐藏加载动画
     */
    public void hideLoading() {
        if (mLoadingView != null && mLoadingView.isShown()) {
            mLoadingView.smoothToHide();
        }
    }

    /**
     * 子类实现具体操作
     */
    protected abstract void initOptions();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
        unbinder.unbind();
        initVariable();
    }
}
