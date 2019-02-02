package com.wy.bottomNavigations;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wy.bottomNavigations.adpter.ManageAdapter;
import com.wy.bottomNavigations.fragment.HomeTabFragment;
import com.wy.bottomNavigations.fragment.OrderTabFragment;
import com.wy.bottomNavigations.fragment.StatisticsTabFragment;
import com.wy.bottomNavigations.widget.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 第三种实现：使用RadioButton的底部导航栏
 */
public class ThirdImplementionsActivity extends AppCompatActivity {

    @BindView(R.id.manage_viewpager)
    NoScrollViewPager viewpager;
    @BindView(R.id.manage_radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.listen)
    ImageView listen;

    private ArrayList<Fragment> fragments;
    private ManageAdapter manageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_implementions);
        ButterKnife.bind(this);

        //判断当前设备版本号是否为4.4以上，如果是，则通过调用setTranslucentStatus让状态栏变透明
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        initViewPager();
        initRadioButtonListener();
        initViewPagerListener();
    }


    private void initViewPager() {
        fragments = new ArrayList<>();
        fragments.add(new HomeTabFragment());
        fragments.add(new OrderTabFragment());
        fragments.add(new StatisticsTabFragment());

        manageAdapter = new ManageAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(manageAdapter);

        viewpager.setOffscreenPageLimit(fragments.size());
    }

    private void initRadioButtonListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.third_home:
                        viewpager.setCurrentItem(0);
//                        titlebarText.setText("首页");
//                        titlebarRightBtn.setImageResource(R.mipmap.add);
                        break;
                    case R.id.third_classify:
                        viewpager.setCurrentItem(1);

//                        titlebarText.setText("订单");
//                        titlebarRightBtn.setImageBitmap(null);
                        break;
                    case R.id.third_shoppingCar:
                        viewpager.setCurrentItem(2);

//                        titlebarText.setText("统计");
//                        titlebarRightBtn.setImageBitmap(null);
                        break;
                }
            }
        });

    }

    private void initViewPagerListener() {
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.third_home);
                        break;
                    case 1:
                        radioGroup.check(R.id.third_classify);
                        break;
                    case 2:
                        radioGroup.check(R.id.third_shoppingCar);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.listen)
    public void onClick() {
        Toast.makeText(getApplicationContext(), "点击了图片", Toast.LENGTH_SHORT).show();

    }
}

