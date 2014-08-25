package com.benben.ui.dialog;

import java.util.ArrayList;
import java.util.List;

import com.benben.R;
import com.benben.listener.CommonClickListener;
import com.benben.utils.CommonUtils;
import com.benben.utils.UIUtils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommonTopMenuDialog extends Dialog implements android.view.View.OnClickListener
{
    private List<LinearLayout> ll_menuList = new ArrayList<LinearLayout>();
    private List<TextView> tv_menuList = new ArrayList<TextView>();
    private List<ImageView> iv_menuList = new ArrayList<ImageView>();
    private List<View> lineList = new ArrayList<View>();
    private int[] iconIdArray;
    private String[] menuArray;
    private CommonClickListener listener;
    private Context context;
    private View view;

    public CommonTopMenuDialog(Context context, int[] iconIdArray, String[] menuArray,
        CommonClickListener listener)
    {
        super(context,R.style.dialog);
        this.context = context;
        this.iconIdArray = iconIdArray;
        this.menuArray = menuArray;
        this.listener = listener;
    }

    //
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = LayoutInflater.from(context).inflate(R.layout.common_top_menu, null);
        int[] devices = CommonUtils.getResolution();
        // setContentView(view, new LayoutParams(devices[0], devices[1]));
        setContentView(view);
        setLayout();
        initView();
        init();
    }

    private void init()
    {
        setCanceledOnTouchOutside(true);

        ScaleAnimation animation = new ScaleAnimation(1.0f, 1.0f, 0.3f, 1.0f);
        animation.setDuration(200);
        animation.setFillAfter(true);
        animation.setRepeatCount(0);

        view.startAnimation(animation);
    }

    @Override
    public void onBackPressed()
    {
    }

    private void setLayout()
    {
        ll_menuList.add(((LinearLayout) findViewById(R.id.ll_menu_1)));
        ll_menuList.add(((LinearLayout) findViewById(R.id.ll_menu_2)));
        ll_menuList.add(((LinearLayout) findViewById(R.id.ll_menu_3)));
        ll_menuList.add(((LinearLayout) findViewById(R.id.ll_menu_4)));
        ll_menuList.add(((LinearLayout) findViewById(R.id.ll_menu_5)));
        ll_menuList.add(((LinearLayout) findViewById(R.id.ll_menu_6)));

        tv_menuList.add(((TextView) findViewById(R.id.tv_1)));
        tv_menuList.add(((TextView) findViewById(R.id.tv_2)));
        tv_menuList.add(((TextView) findViewById(R.id.tv_3)));
        tv_menuList.add(((TextView) findViewById(R.id.tv_4)));
        tv_menuList.add(((TextView) findViewById(R.id.tv_5)));
        tv_menuList.add(((TextView) findViewById(R.id.tv_6)));

        iv_menuList.add(((ImageView) findViewById(R.id.iv_1)));
        iv_menuList.add(((ImageView) findViewById(R.id.iv_2)));
        iv_menuList.add(((ImageView) findViewById(R.id.iv_3)));
        iv_menuList.add(((ImageView) findViewById(R.id.iv_4)));
        iv_menuList.add(((ImageView) findViewById(R.id.iv_5)));
        iv_menuList.add(((ImageView) findViewById(R.id.iv_6)));

        lineList.add(((View) findViewById(R.id.line1)));
        lineList.add(((View) findViewById(R.id.line2)));
        lineList.add(((View) findViewById(R.id.line3)));
        lineList.add(((View) findViewById(R.id.line4)));
        lineList.add(((View) findViewById(R.id.line5)));
    }

    private void initView()
    {
        for (int i = 0; i < iconIdArray.length; i++)
        {
            ll_menuList.get(i).setVisibility(View.VISIBLE);
            ll_menuList.get(i).setOnClickListener(this);
            lineList.get(i).setVisibility(View.VISIBLE);
            iv_menuList.get(i).setBackgroundResource(iconIdArray[i]);
            tv_menuList.get(i).setText(menuArray[i]);
        }
        view.setOnClickListener(this);

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = UIUtils.dip2px(50);
        dialogWindow.setGravity(Gravity.RIGHT | Gravity.TOP);
        dialogWindow.setAttributes(lp);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.ll_menu_1:
                listener.commonClickListener(0);
                break;
            case R.id.ll_menu_2:
                listener.commonClickListener(1);
                break;
            case R.id.ll_menu_3:
                listener.commonClickListener(2);
                break;
            case R.id.ll_menu_4:
                listener.commonClickListener(3);
                break;
            case R.id.ll_menu_5:
                listener.commonClickListener(4);
                break;
            case R.id.ll_menu_6:
                listener.commonClickListener(5);
                break;
        }

        dismiss();
    }

}
