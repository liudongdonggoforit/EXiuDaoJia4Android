package com.wuxianying.gd720.exiudaojia.fragments.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wuxianying.gd720.exiudaojia.R;
import com.wuxianying.gd720.exiudaojia.views.FlyBanner;

import java.util.ArrayList;
import java.util.List;

public class APPFragment extends Fragment {
	private FlyBanner mBannerLocal;//加载本地图片

	private FlyBanner mBannerNet;//加载网络图片
	private View view;
	private String[] mImagesUrl = {
			"http://img.blog.csdn.net/20151123175838192",
			"http://www.baidu.com/img/bdlogo.png",
			"http://img.blog.csdn.net/20131130184047953?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveHVfZnU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast",
			"http://www.baidu.com/img/bdlogo.png"
	};
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			view = inflater.inflate(R.layout.fragment_main,container,false);
			initLocalBanner();
			initNetBanner();
			return view;
		}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * 加载本地图片
	 */
	private void initLocalBanner() {
		mBannerLocal = (FlyBanner) view.findViewById(R.id.banner_1);

		List<Integer> images = new ArrayList<>();
		images.add(R.drawable.img_1);
		images.add(R.drawable.img_2);
		images.add(R.drawable.img_3);
		images.add(R.drawable.img_4);
		mBannerLocal.setImages(images);

		mBannerLocal.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				toast("点击了第" + position + "张图片");
			}
		});
	}

	/**
	 * 加载网页图片
	 */
	private void initNetBanner() {
		mBannerNet = (FlyBanner) view.findViewById(R.id.banner_2);

		List<String> imgesUrl = new ArrayList<>();
		for (int i = 0; i < mImagesUrl.length; i++) {
			imgesUrl.add(mImagesUrl[i]);
		}
		mBannerNet.setImagesUrl(imgesUrl);

		mBannerNet.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				toast("点击了第" + position + "张图片");
			}
		});
	}

	private void toast(String str) {
		Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
	}

}
