package mhwang.com.takecareofmoney;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    public static final int MENU_COUNT = 5;
    public static final int HOME = 0;
    public static final int DETAIL = 1;
    public static final int ACCOUNT = 2;
    public static final int REPORT = 3;
    public static final int MORE = 4;


    /**
     *  显示的界面列表
     */
    private List<View> mViews;

    /**
     *  用来显示界面的容器，类似ListView
     */
    private ViewPager mViewPager;

    /**
     *  界面切换的适配器
     */
    private PagerAdapter pagerAdapter;

    /**
     *  按钮组
     */
    private RadioGroup mRadioGroup;

    private RadioButton[] mMenuButtons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // 初始化数据
        initData();

        // 初始化控件
        initComponent();

        // 添加事件
        initEvent();
    }

    /**
     *  添加事件
     */
    private void initEvent() {
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mMenuButtons[i].setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int which = -1;
                switch (checkedId){
                    case R.id.rb_home:
                        which = HOME;
                        break;
                    case R.id.rb_detail:
                        which = DETAIL;
                        break;
                    case R.id.rb_account:
                        which = ACCOUNT;
                        break;
                    case R.id.rb_report:
                        which = REPORT;
                        break;
                    case R.id.rb_more:
                        which = MORE;
                        break;
                }

                if (which != -1){
                    mViewPager.setCurrentItem(which);
                }
            }
        });
    }

    /**
     *  初始化控件
     */
    private void initComponent() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mRadioGroup = (RadioGroup) findViewById(R.id.menu);
        mMenuButtons[HOME] = (RadioButton) findViewById(R.id.rb_home);
        mMenuButtons[DETAIL] = (RadioButton) findViewById(R.id.rb_detail);
        mMenuButtons[ACCOUNT] = (RadioButton) findViewById(R.id.rb_account);
        mMenuButtons[REPORT] = (RadioButton) findViewById(R.id.rb_report);
        mMenuButtons[MORE] = (RadioButton) findViewById(R.id.rb_more);

        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }
        };
    }

    /**
     *  初始化数据
     */
    private void initData() {
        // 初始化显示界面的view
        mViews = new ArrayList<>();
        mViews.add(new HomeFragment(this).getView());
        mViews.add(new MoneyDetailFragment(this).getView());
        mViews.add(new AccountFragment(this).getView());
        mViews.add(new MoneyReportFragment(this).getView());
        mViews.add(new MoreFragment(this).getView());

        mMenuButtons = new RadioButton[MENU_COUNT];
    }


}
