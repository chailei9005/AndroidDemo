package cn.dong.demo.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import cn.dong.demo.DongApplication;

public abstract class BaseActivity extends FragmentActivity implements Callback {
	protected FragmentActivity context;
	protected DongApplication application;

	protected Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		setContentView(initPageLayoutID());
		initPageView();
		initPageViewListener();
		process(savedInstanceState);
	}

	private void init() {
		context = this;
		application = DongApplication.getInstance();
		mHandler = new Handler(this);
	}

	/**
	 * 返回主布局id
	 */
	protected abstract int initPageLayoutID();

	/**
	 * 初始化页面控件
	 */
	protected abstract void initPageView();

	/**
	 * 页面控件点击事件处理
	 */
	protected abstract void initPageViewListener();

	/**
	 * 逻辑处理
	 * 
	 * @param savedInstanceState
	 */
	protected abstract void process(Bundle savedInstanceState);

	@Override
	public boolean handleMessage(Message msg) {
		return false;
	}

}
