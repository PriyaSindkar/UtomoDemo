package com.webmyne.utomodemo.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.utomodemo.R;
import com.webmyne.utomodemo.helpers.Functions;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by priyasindkar on 23-02-2016.
 */
public class UserGuideFragment extends Fragment {
    private int sliderNo;
    private ImageView imgBG;

    public static UserGuideFragment newInstance(int sliderNo) {
        UserGuideFragment fragment = new UserGuideFragment();
        Bundle arguments = new Bundle();
        arguments.putInt("slider_no", sliderNo);
        fragment.setArguments(arguments);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sliderNo = getArguments().getInt("slider_no");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_guide, null);

        TextView txtUserGuideText = (TextView) view.findViewById(R.id.txtUserGuideText);
        txtUserGuideText.setTypeface(Functions.getTypeFace(getActivity()), Typeface.BOLD);

        TextView txtSkip = (TextView) view.findViewById(R.id.txtSkip);
        txtSkip.setTypeface(Functions.getTypeFace(getActivity()), Typeface.BOLD);

        imgBG = (ImageView) view.findViewById(R.id.imgBG);
        imgBG.setBackgroundResource(sliderNo);
        return view;
    }
}
