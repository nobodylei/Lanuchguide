package com.lei.lanuchguide.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lei.lanuchguide.MainActivity;
import com.lei.lanuchguide.R;

/**
 * Created by yanle on 2018/2/25.
 */

public class ContentFragment extends Fragment{
    private int[] bgRes = {R.drawable.iiii,R.drawable.hhhh,R.drawable.eeee};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, null);
        Button btn = view.findViewById(R.id.btn);
        RelativeLayout rl = view.findViewById(R.id.rl);



        int index = getArguments().getInt("index");
        Log.i("tag","ContentFragment" + index);
        rl.setBackgroundResource(bgRes[index]);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        btn.setVisibility(index == 2 ? View.VISIBLE : View.GONE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
