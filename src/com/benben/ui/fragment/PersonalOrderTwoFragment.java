package com.benben.ui.fragment;

import com.benben.R;
import com.benben.listener.CommonClickListener;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 私人定制--微创作
 * 
 * @author gqiu
 * 
 */
public class PersonalOrderTwoFragment extends BaseListFragment implements OnClickListener
{

    private Button bt_all, bt_mine, bt_others;
    private CommonClickListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    public void setListener(CommonClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected void addLayoutHeaderView()
    {
        View headerView =
            LayoutInflater.from(getActivity()).inflate(R.layout.personal_order_two_header, null);
        bt_all = (Button) headerView.findViewById(R.id.bt_all);
        bt_mine = (Button) headerView.findViewById(R.id.bt_mine);
        bt_others = (Button) headerView.findViewById(R.id.bt_others);
        bt_all.setOnClickListener(this);
        bt_mine.setOnClickListener(this);
        bt_others.setOnClickListener(this);

        headerLayout.addView(headerView, new LayoutParams(LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT));
    }

    /** 按钮背景控制器 */
    private void buttonBackgroundController(int id)
    {
        switch (id)
        {
            case R.id.bt_all:
                bt_all.setBackgroundResource(R.drawable.shape_grey_radius);
                bt_mine.setBackgroundResource(R.drawable.shape_white_radius);
                bt_others.setBackgroundResource(R.drawable.shape_white_radius);
                break;
            case R.id.bt_mine:
                bt_all.setBackgroundResource(R.drawable.shape_white_radius);
                bt_mine.setBackgroundResource(R.drawable.shape_grey_radius);
                bt_others.setBackgroundResource(R.drawable.shape_white_radius);
                break;
            case R.id.bt_others:
                bt_all.setBackgroundResource(R.drawable.shape_white_radius);
                bt_mine.setBackgroundResource(R.drawable.shape_white_radius);
                bt_others.setBackgroundResource(R.drawable.shape_grey_radius);
                break;
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bt_all:
                break;
            case R.id.bt_mine:
                break;
            case R.id.bt_news:
                break;
            case R.id.bt_hot:
                break;
        }
        buttonBackgroundController(v.getId());

    }

    private class MyAdapter extends BaseAdapter
    {

        @Override
        public int getCount()
        {

            return 10;
        }

        @Override
        public Object getItem(int position)
        {

            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder = null;
            if (convertView == null)
            {
                holder = new ViewHolder();
                convertView =
                    LayoutInflater.from(getActivity()).inflate(R.layout.personal_order_two_item, null);
            }

            return convertView;
        }

    }

    private static class ViewHolder
    {
        public ImageView iv_icon;
        public TextView tv_name;
    }

    @Override
    protected void setAdapter()
    {
        MyAdapter adapter = new MyAdapter();
        mListView.setAdapter(adapter);
    }
}
