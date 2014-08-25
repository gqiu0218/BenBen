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
public class PersonalOrderOneFragment extends BaseListFragment implements OnClickListener
{

    private Button bt_all, bt_mine, bt_news, bt_hot;
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
            LayoutInflater.from(getActivity()).inflate(R.layout.personal_order_one_header, null);
        bt_all = (Button) headerView.findViewById(R.id.bt_all);
        bt_mine = (Button) headerView.findViewById(R.id.bt_mine);
        bt_news = (Button) headerView.findViewById(R.id.bt_news);
        bt_hot = (Button) headerView.findViewById(R.id.bt_hot);
        bt_all.setOnClickListener(this);
        bt_mine.setOnClickListener(this);
        bt_news.setOnClickListener(this);
        bt_hot.setOnClickListener(this);

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
                break;
            case R.id.bt_mine:
                bt_all.setBackgroundResource(R.drawable.shape_white_radius);
                bt_mine.setBackgroundResource(R.drawable.shape_grey_radius);
                break;
            case R.id.bt_news:
                bt_news.setBackgroundResource(R.drawable.shape_grey_left_radius);
                bt_hot.setBackgroundResource(R.drawable.shape_white_right_radius);
                break;
            case R.id.bt_hot:
                bt_news.setBackgroundResource(R.drawable.shape_white_left_radius);
                bt_hot.setBackgroundResource(R.drawable.shape_grey_right_radius);
                break;
        }
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.bt_all:
                buttonBackgroundController(v.getId());
                break;
            case R.id.bt_mine:
                buttonBackgroundController(v.getId());
                break;
            case R.id.bt_news:
                buttonBackgroundController(v.getId());
                break;
            case R.id.bt_hot:
                buttonBackgroundController(v.getId());
                break;
            case R.id.ll_praise: // 点击了红心
                listener.commonClickListener("clickPraise");
                ImageView iv_praise = (ImageView) v.getTag();
                iv_praise.setBackgroundResource(R.drawable.ic_praise);
                break;
        }

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
                    LayoutInflater.from(getActivity()).inflate(R.layout.personal_order_one_item, null);
                holder.ll_praise = (LinearLayout) convertView.findViewById(R.id.ll_praise);
                holder.iv_praise = (ImageView) convertView.findViewById(R.id.iv_praise);
                holder.ll_praise.setOnClickListener(PersonalOrderOneFragment.this);
                holder.ll_praise.setTag(holder.iv_praise);
            }

            return convertView;
        }

    }

    private static class ViewHolder
    {
        public ImageView iv_icon;
        public TextView tv_name;
        public TextView tv_date;
        public TextView tv_comment;
        public LinearLayout ll_praise;
        public ImageView iv_praise;
        public TextView tv_praise_count;
        public LinearLayout ll_comment;
        public TextView tv_comment_count;
    }

    @Override
    protected void setAdapter()
    {
        MyAdapter adapter = new MyAdapter();
        mListView.setAdapter(adapter);
    }
}
