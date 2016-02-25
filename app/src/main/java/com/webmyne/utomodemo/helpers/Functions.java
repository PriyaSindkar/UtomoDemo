package com.webmyne.utomodemo.helpers;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by priyasindkar on 23-02-2016.
 */
public class Functions {
    public static String fontFamilyPathThin = "fonts/HelveticaNeue-ThinExt.otf";

    public static Typeface getTypeFace(Context ctx) {
        Typeface typeface = Typeface.createFromAsset(ctx.getAssets(), fontFamilyPathThin);
        return typeface;
    }
}
