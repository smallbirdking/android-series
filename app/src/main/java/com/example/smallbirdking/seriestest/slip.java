package com.example.smallbirdking.seriestest;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
/**
 * HorizontalScrollView��ViewPager����Ч��
 * ����ΪHorizontalScrollView,����ΪViewPager
 * @author zj
 * 2012-5-23 ����1:07:06
 */
public class slip extends Activity implements OnCheckedChangeListener{
	private RadioGroup mRadioGroup;
	private RadioButton mRadioButton1;
	private RadioButton mRadioButton2;
	private RadioButton mRadioButton3;
	private RadioButton mRadioButton4;
	private RadioButton mRadioButton5;
	private ImageView mImageView;
	private float mCurrentCheckedRadioLeft;//��ǰ��ѡ�е�RadioButton�������ľ���
	private HorizontalScrollView mHorizontalScrollView;//�����ˮƽ�����ؼ�
	private ViewPager mViewPager;	//�·��Ŀɺ����϶��Ŀؼ�
	private ArrayList<View> mViews;//��������·�������layout(layout_1,layout_2,layout_3)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slip);
        
        iniController();
        iniListener();
        iniVariable();
        
        mRadioButton1.setChecked(true);
        mViewPager.setCurrentItem(1);
        mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();
        
    }
    
    private void iniVariable() {
		// TODO Auto-generated method stub
    	mViews = new ArrayList<View>();
    	mViews.add(getLayoutInflater().inflate(R.layout.layout_0, null));
    	mViews.add(getLayoutInflater().inflate(R.layout.layout_1, null));
    	mViews.add(getLayoutInflater().inflate(R.layout.layout_2, null));
    	mViews.add(getLayoutInflater().inflate(R.layout.layout_3, null));
    	mViews.add(getLayoutInflater().inflate(R.layout.layout_4, null));
    	mViews.add(getLayoutInflater().inflate(R.layout.layout_5, null));
    	mViews.add(getLayoutInflater().inflate(R.layout.layout_0, null));
    	
    	mViewPager.setAdapter(new MyPagerAdapter());//����ViewPager��������
	}
    
    /**
	 * RadioGroup���CheckedChanged����
	 */
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		
		AnimationSet _AnimationSet = new AnimationSet(true);
		TranslateAnimation _TranslateAnimation;
		
		Log.i("zj", "checkedid="+checkedId);
		if (checkedId == R.id.btn1) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo1), 0f, 0f);
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			/*LayoutParams _LayoutParams1 = new LayoutParams(100, 4);
			_LayoutParams1.setMargins(0, 0, 0, 0);
			_LayoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);*/
			//mImageView.bringToFront();
			mImageView.startAnimation(_AnimationSet);//��ʼ������ɫ����ͼƬ�Ķ����л�
			//mImageView.setLayoutParams(_LayoutParams1);
			mViewPager.setCurrentItem(1);//���·�ViewPager���������HorizontalScrollView�л�
			FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
			fab.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
							.setAction("Action", null).show();
				}
			});
		}else if (checkedId == R.id.btn2) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo2), 0f, 0f);

			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);

			//mImageView.bringToFront();
			mImageView.startAnimation(_AnimationSet);
			
			mViewPager.setCurrentItem(2);
		}else if (checkedId == R.id.btn3) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo3), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			
			//mImageView.bringToFront();
			mImageView.startAnimation(_AnimationSet);
			
			mViewPager.setCurrentItem(3);
		}else if (checkedId == R.id.btn4) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo4), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			
			//mImageView.bringToFront();
			mImageView.startAnimation(_AnimationSet);
			mViewPager.setCurrentItem(4);
		}else if (checkedId == R.id.btn5) {
			_TranslateAnimation = new TranslateAnimation(mCurrentCheckedRadioLeft, getResources().getDimension(R.dimen.rdo5), 0f, 0f);
			
			_AnimationSet.addAnimation(_TranslateAnimation);
			_AnimationSet.setFillBefore(false);
			_AnimationSet.setFillAfter(true);
			_AnimationSet.setDuration(100);
			
			//mImageView.bringToFront();
			mImageView.startAnimation(_AnimationSet);
			
			mViewPager.setCurrentItem(5);
		}
		
		mCurrentCheckedRadioLeft = getCurrentCheckedRadioLeft();//���µ�ǰ��ɫ����������ߵľ���
		
		Log.i("zj", "getCurrentCheckedRadioLeft="+getCurrentCheckedRadioLeft());
		Log.i("zj", "getDimension="+getResources().getDimension(R.dimen.rdo2));
		
		mHorizontalScrollView.smoothScrollTo((int)mCurrentCheckedRadioLeft-(int)getResources().getDimension(R.dimen.rdo2), 0);
	}
    
	/**
     * ��õ�ǰ��ѡ�е�RadioButton�������ľ���
     */
	private float getCurrentCheckedRadioLeft() {
		// TODO Auto-generated method stub
		if (mRadioButton1.isChecked()) {
			//Log.i("zj", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo1));
			return getResources().getDimension(R.dimen.rdo1);
		}else if (mRadioButton2.isChecked()) {
			//Log.i("zj", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo2));
			return getResources().getDimension(R.dimen.rdo2);
		}else if (mRadioButton3.isChecked()) {
			//Log.i("zj", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo3));
			return getResources().getDimension(R.dimen.rdo3);
		}else if (mRadioButton4.isChecked()) {
			//Log.i("zj", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo4));
			return getResources().getDimension(R.dimen.rdo4);
		}else if (mRadioButton5.isChecked()) {
			//Log.i("zj", "currentCheckedRadioLeft="+getResources().getDimension(R.dimen.rdo5));
			return getResources().getDimension(R.dimen.rdo5);
		}
		return 0f;
	}

	private void iniListener() {
		// TODO Auto-generated method stub
		
		mRadioGroup.setOnCheckedChangeListener(this);
		
		
		mViewPager.setOnPageChangeListener(new MyPagerOnPageChangeListener());
	}

	private void iniController() {
		// TODO Auto-generated method stub
		mRadioGroup = (RadioGroup)findViewById(R.id.radioGroup);
		mRadioButton1 = (RadioButton)findViewById(R.id.btn1);
		mRadioButton2 = (RadioButton)findViewById(R.id.btn2);
		mRadioButton3 = (RadioButton)findViewById(R.id.btn3);
		mRadioButton4 = (RadioButton)findViewById(R.id.btn4);
		mRadioButton5 = (RadioButton)findViewById(R.id.btn5);
		
		mImageView = (ImageView)findViewById(R.id.img1);
		
		mHorizontalScrollView = (HorizontalScrollView)findViewById(R.id.horizontalScrollView);
		
		mViewPager = (ViewPager)findViewById(R.id.pager);
	}

	/**
	 * ViewPager��������
	 * @author zj
	 * 2012-5-24 ����2:26:57
	 */
	private class MyPagerAdapter extends PagerAdapter{

		@Override
		public void destroyItem(View v, int position, Object obj) {
			// TODO Auto-generated method stub
			((ViewPager)v).removeView(mViews.get(position));
		}

		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mViews.size();
		}

		@Override
		public Object instantiateItem(View v, int position) {
			((ViewPager)v).addView(mViews.get(position));
			return mViews.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/**
	 * ViewPager��PageChangeListener(ҳ��ı�ļ�����)
	 * @author zj
	 * 2012-5-24 ����3:14:27
	 */
	private class MyPagerOnPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		/**
		 * ����ViewPager��ʱ��,���Ϸ���HorizontalScrollView�Զ��л�
		 */
		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			//Log.i("zj", "position="+position);
			
			if (position == 0) {
				mViewPager.setCurrentItem(1);
			}else if (position == 1) {
				mRadioButton1.performClick();
			}else if (position == 2) {
				mRadioButton2.performClick();
			}else if (position == 3) {
				mRadioButton3.performClick();
			}else if (position == 4) {
				mRadioButton4.performClick();
			}else if (position == 5) {
				mRadioButton5.performClick();
			}else if (position == 6) {
				mViewPager.setCurrentItem(5);
			}
		}
		
	}
	
}