package com.webmyne.utomodemo.customViewPager;

import android.view.View;

/**
 * Created by Samuel on 2015-07-06.
 */

public abstract class SCPageAnimation {
    public int page;
    public abstract void applyTransformation(View onView, float positionOffset);
}