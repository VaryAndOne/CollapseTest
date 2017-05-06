package com.vary.collapsetest.modules.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vary.collapsetest.R;
import com.vary.collapsetest.app.TkApplication;
import com.vary.collapsetest.base.BaseRecyclerAdapter;
import com.vary.collapsetest.base.CommonHolder;
import com.vary.collapsetest.modules.widget.CircleImageView;
import com.vary.collapsetest.mvp.model.Food;
import com.vary.collapsetest.mvp.model.Person;
import com.vary.collapsetest.mvp.model.Photo;

import butterknife.Bind;

/**
 * Created by Administrator on 2017-04-21.
 */

public class PersonAdapter extends BaseRecyclerAdapter<Person> {
    @Override
    public CommonHolder<Person> setViewHolder(ViewGroup parent) {

        return new PersonAdapter.CardHolder(parent.getContext(), parent);
    }

    class CardHolder extends CommonHolder<Person> {

//        @Bind(R.id.avatar)
//        CircleImageView avatar;
//
        @Bind(R.id.tv_person)
        TextView tv_food;
//
//        @Bind(R.id.tv_info)
//        TextView tv_info;

        @Bind(R.id.iv_person)
        ImageView iv_food;

        public CardHolder(Context context, ViewGroup root) {
            super(context, root, R.layout.item_person);
        }

        @Override
        public void bindData(Person person) {
//            avatar.setImageResource(food.avatar_id);
            iv_food.setImageResource(person.imageSrc);
            tv_food.setText(person.title);

//            tv_info.setText(food.info);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
////                    ToastUtil.show("item clicked!");
//                }
//            });
        }
    }
}
