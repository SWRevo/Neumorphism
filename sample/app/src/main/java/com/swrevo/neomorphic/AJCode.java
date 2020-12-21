package com.swrevo.neomorphic;

import android.graphics.drawable.*;
import android.view.*;
import android.widget.*;
import com.google.android.material.textfield.*;
import android.content.res.*;
import android.graphics.*;
import androidx.core.graphics.drawable.*;
import com.allenliu.badgeview.*;
import android.view.Gravity;

public class AJCode
{
public static void setBackgroundGradient(View view, int color1, int color2){
GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] {color1,color2});
view.setBackgroundDrawable(gd);
}

public static void createMaterialTIL(View view,String hint,EditText editText){
if(((LinearLayout)view) != null){
((LinearLayout)view).removeAllViews();
}
TextInputLayout textInputLayout = new TextInputLayout(view.getContext(), null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox);
textInputLayout.setLayoutParams(new LinearLayout.LayoutParams(-1,-2));
textInputLayout.setHint(hint);
textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
textInputLayout.setBoxCornerRadii(5, 5, 5, 5);
textInputLayout.addView(editText);
editText.setHint("");
((LinearLayout)view).addView(textInputLayout);
}

public static void setCircularImageView(ImageView iv,int resImg){
Resources res = iv.getContext().getResources();
Bitmap b = BitmapFactory.decodeResource(res, resImg);
RoundedBitmapDrawable dr =  RoundedBitmapDrawableFactory.create(res, b);
dr.setCircular(true);
iv.setImageDrawable(dr);
}

public static void setRoundedRipple(View v,int LT,int RT,int RB,int LB,int color1,int size,int color2,int color3){
GradientDrawable shape = new GradientDrawable();
shape.setColor(color1);
shape.setCornerRadii(new float[]{(float)LT,(float)LT,(float)RT,(float)RT,(float)RB,(float)RB,(float)LB,(float)LB});
shape.setStroke(size, color2);
RippleDrawable ripdr = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{color3}), shape, null);
v.setBackgroundDrawable(ripdr);
}
}