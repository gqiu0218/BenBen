package com.benben.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.benben.R;
import com.benben.adapter.TitleFragmentAdapter;
import com.benben.listener.CommonClickListener;
import com.benben.ui.dialog.CommonTopMenuDialog;
import com.benben.ui.fragment.PersonalOrderOneFragment;
import com.benben.ui.fragment.PersonalOrderTwoFragment;
import com.benben.utils.UIUtils;
import com.viewpagerindicator.TabPageIndicator;

/**
 * @projectName: BB
 * @fileName: PersonalOrderActivity.java
 * @author:Pengkun
 * @createDate:2014-8-17 下午4:22:18
 * @Description:私人定制
 */
public class PersonalOrderActivity extends BaseFragmentActivity implements OnPageChangeListener ,
    CommonClickListener
{
    private TabPageIndicator indicator;
    private ViewPager viewPager;
    private TitleFragmentAdapter adapter;
    private String[] contents = {"微创作", "我要买" };
    private ScaleAnimation animation;
    private ImageView iv_praise;

    @Override
    public void initViews()
    {
        setContentView(R.layout.personal_order);
        setLayout();

        init();
    }

    private void setLayout()
    {
        indicator = (TabPageIndicator) findViewById(R.id.indicator);
        viewPager = (ViewPager) findViewById(R.id.pager);

        iv_praise = (ImageView) findViewById(R.id.iv_praise);

        PersonalOrderOneFragment personalOneOrder = new PersonalOrderOneFragment();
        personalOneOrder.setListener(this);
        PersonalOrderTwoFragment personalTwoOrder = new PersonalOrderTwoFragment();
        Fragment frags[] = {personalOneOrder, personalTwoOrder };
        adapter = new TitleFragmentAdapter(getSupportFragmentManager(), this, frags, contents);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        indicator.setOnPageChangeListener(this);
    }

    private void init()
    {
        animation =
            new ScaleAnimation(1.0f,
                0.0f,
                1.0f,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);
        AccelerateInterpolator interpolator = new AccelerateInterpolator();
        animation.setDuration(800);
        animation.setFillAfter(true);
        animation.setRepeatCount(0);
        animation.setInterpolator(interpolator);

    }

    @Override
    public void setData()
    {
        showBack(false);
        setTitle("犇犇");
        setBtnRight(-1);
    }

    @Override
    public void setListener()
    {
    }

    @Override
    public void click(int viewId)
    {
        switch (viewId)
        {
            case R.id.btnRight:
                int[] iconIdArray =
                    new int[] {R.drawable.ic_avatar, R.drawable.ic_avatar, R.drawable.ic_avatar };
                String[] menuArray = new String[] {"发布微创作", "发布我要买", "喊喇叭" };
                CommonTopMenuDialog dialog = new CommonTopMenuDialog(this, iconIdArray, menuArray, this);
                dialog.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0)
    {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2)
    {
    }

    @Override
    public void onPageSelected(int arg0)
    {
    }

    @Override
    public void commonClickListener(Object object)
    {
        if (object == null)
            return;

        if (object instanceof String)
        {
            String tag = (String) object;
            if (tag.equals("clickPraise"))
            {// 执行显示“赞”的动画
                iv_praise.setVisibility(View.VISIBLE);
                iv_praise.startAnimation(animation);
            }
        }
        else if (object instanceof Integer)
        {
            int item = (Integer) object;
            switch (item)
            {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
            }
        }
    }

}
