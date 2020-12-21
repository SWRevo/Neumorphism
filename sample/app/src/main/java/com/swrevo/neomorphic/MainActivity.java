package com.swrevo.neomorphic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ImageView;
import android.content.Context;
import android.os.Vibrator;
import android.widget.CompoundButton;
import android.view.View;
import android.graphics.Typeface;
import com.flask.colorpicker.*;
import com.swrevo.neomorphismlib.*;
import com.allenliu.badgeview.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import com.flask.colorpicker.builder.*;

public class MainActivity extends  AppCompatActivity  { 
	
	
	private  PolygonButton pb;
	private  PolygonView pv;
	private  CircleView cirViewBtn;
	private  neoText neotext;
	private  RectButton rectButton;
	private double LT_Rad = 0;
	private double RT_Rad = 0;
	private double RB_Rad = 0;
	private double LB_Rad = 0;
	private double paddingValue = 0;
	private String colorDipilih = "";
	private  int currentBackgroundColor = 0xffffffff;
	
	private LinearLayout base;
	private LinearLayout nest;
	private LinearLayout linear3;
	private LinearLayout linear7;
	private LinearLayout linear5;
	private LinearLayout textviewforneo;
	private LinearLayout linear1;
	private LinearLayout polygon_view;
	private LinearLayout circle_view;
	private LinearLayout linear2;
	private LinearLayout linear8;
	private RadioButton style1;
	private RadioButton style2;
	private RadioButton style3;
	private TextView textview5;
	private LinearLayout linear9;
	private SeekBar line;
	private Switch switch_border;
	private TextView textview6;
	private ImageView pick_color;
	private LinearLayout rect_view;
	private LinearLayout linear6;
	private TextView textview1;
	private SeekBar seek_lt;
	private TextView textview2;
	private SeekBar seek_rt;
	private TextView textview3;
	private SeekBar seek_rb;
	private TextView textview4;
	private SeekBar seek_lb;
	private Switch mode;
	
	private Vibrator gtr;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		base = (LinearLayout) findViewById(R.id.base);
		nest = (LinearLayout) findViewById(R.id.nest);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textviewforneo = (LinearLayout) findViewById(R.id.textviewforneo);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		polygon_view = (LinearLayout) findViewById(R.id.polygon_view);
		circle_view = (LinearLayout) findViewById(R.id.circle_view);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		style1 = (RadioButton) findViewById(R.id.style1);
		style2 = (RadioButton) findViewById(R.id.style2);
		style3 = (RadioButton) findViewById(R.id.style3);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		line = (SeekBar) findViewById(R.id.line);
		switch_border = (Switch) findViewById(R.id.switch_border);
		textview6 = (TextView) findViewById(R.id.textview6);
		pick_color = (ImageView) findViewById(R.id.pick_color);
		rect_view = (LinearLayout) findViewById(R.id.rect_view);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview1 = (TextView) findViewById(R.id.textview1);
		seek_lt = (SeekBar) findViewById(R.id.seek_lt);
		textview2 = (TextView) findViewById(R.id.textview2);
		seek_rt = (SeekBar) findViewById(R.id.seek_rt);
		textview3 = (TextView) findViewById(R.id.textview3);
		seek_rb = (SeekBar) findViewById(R.id.seek_rb);
		textview4 = (TextView) findViewById(R.id.textview4);
		seek_lb = (SeekBar) findViewById(R.id.seek_lb);
		mode = (Switch) findViewById(R.id.mode);
		gtr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		style1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					style1.setChecked(true);
					style2.setChecked(false);
					style3.setChecked(false);
					pv.setStyle(1);
					neotext.setStyle(1);
					rectButton.setStyle(1);
				}
			}
		});
		
		style2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					style1.setChecked(false);
					style2.setChecked(true);
					style3.setChecked(false);
					pv.setStyle(2);
					neotext.setStyle(2);
					rectButton.setStyle(2);
				}
			}
		});
		
		style3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					style1.setChecked(false);
					style2.setChecked(false);
					style3.setChecked(true);
					pv.setStyle(3);
					neotext.setStyle(3);
					rectButton.setStyle(3);
				}
			}
		});
		
		line.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				pv.setBorderWidth((float)_progressValue);
				cirViewBtn.setBorderWidth((float)_progressValue);
				rectButton.setBorderWidth((float)_progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		switch_border.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					pv.setBorderColor(0xFF212121);
					cirViewBtn.setBorderColor(0xFF212121);
					rectButton.setBorderColor(0xFF212121);
				}
				else {
					pv.setBorderColor(0xFFE0E0E0);
					cirViewBtn.setBorderColor(0xFFE0E0E0);
					rectButton.setBorderColor(0xFFE0E0E0);
				}
			}
		});
		
		pick_color.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final Context context = MainActivity.this;
				ColorPickerDialogBuilder.with(context)
				.setTitle("Pick Color")
				.initialColor(currentBackgroundColor)
				.wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
				.density(12)
				.setOnColorChangedListener(new OnColorChangedListener() {
					@Override
					public void onColorChanged(int selectedColor) {
						// Handle on color change
						Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));
					}
				})
				.setOnColorSelectedListener(new OnColorSelectedListener() {
					@Override
					public void onColorSelected(int selectedColor) {
						ApplicationUtil.showMessage(context, "onColorSelected: 0x" + Integer.toHexString(selectedColor));
					}
				})
				.setPositiveButton("ok", new ColorPickerClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
						changeBackgroundColor(selectedColor);
						if (allColors != null) {
							StringBuilder sb = null;
							
							for (Integer color : allColors) {
								if (color == null)
								continue;
								if (sb == null)
								sb = new StringBuilder("Color List:");
								sb.append("\r\n#" + Integer.toHexString(color).toUpperCase());
								
								colorDipilih = ("\r\n#" + Integer.toHexString(color).toUpperCase());
								textview5.setText(colorDipilih.trim());
								pv.setBorderColor(Color.parseColor(colorDipilih.trim()));
								cirViewBtn.setBorderColor(Color.parseColor(colorDipilih.trim()));
								rectButton.setBorderColor(Color.parseColor(colorDipilih.trim()));
							}
							
							if (sb != null)
							Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
						}
					}
				})
				.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				})
				.showColorEdit(true)
				.setColorEditTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.darker_gray))
				.build()
				.show();
			}
		});
		
		seek_lt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				LT_Rad = _progressValue;
				rectButton.setTopLeftRadius((float)LT_Rad);
				rectButton.setTopRightRadius((float)RT_Rad);
				rectButton.setBottomLeftRadius((float)LB_Rad);
				rectButton.setBottomRightRadius((float)RB_Rad);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		seek_rt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				RT_Rad = _progressValue;
				rectButton.setTopLeftRadius((float)LT_Rad);
				rectButton.setTopRightRadius((float)RT_Rad);
				rectButton.setBottomLeftRadius((float)LB_Rad);
				rectButton.setBottomRightRadius((float)RB_Rad);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		seek_rb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				RB_Rad = _progressValue;
				rectButton.setTopLeftRadius((float)LT_Rad);
				rectButton.setTopRightRadius((float)RT_Rad);
				rectButton.setBottomLeftRadius((float)LB_Rad);
				rectButton.setBottomRightRadius((float)RB_Rad);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		seek_lb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				LB_Rad = _progressValue;
				rectButton.setTopLeftRadius((float)LT_Rad);
				rectButton.setTopRightRadius((float)RT_Rad);
				rectButton.setBottomLeftRadius((float)LB_Rad);
				rectButton.setBottomRightRadius((float)RB_Rad);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					AJCode.setBackgroundGradient(base, 0xFF27282A, 0xFF27282A);
					pb.setBackground_color(0xFF303234);
					pb.setDark_color(0x66000000);
					pb.setLight_color(0x66494949);
					pv.setBackground_color(0xFF303234);
					pv.setDark_color(0x66000000);
					pv.setLight_color(0x66494949);
					ImageView icon = new ImageView(MainActivity.this);
					icon.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
					icon.setImageResource(R.drawable.ic_3d_rotation_white);
					icon.setColorFilter(0xFFD1C4E9, PorterDuff.Mode.MULTIPLY);
					int ICONpaddingDp = (int)paddingValue;
					float ICONdensity = getApplicationContext().getResources().getDisplayMetrics().density;
					int ICONpaddingPixel = (int)(ICONpaddingDp * ICONdensity);
					icon.setPadding(ICONpaddingPixel, ICONpaddingPixel , ICONpaddingPixel , ICONpaddingPixel);
					pb.addView(icon);
					cirViewBtn.setBackground_color(0xFF303234);
					cirViewBtn.setDark_color(0x66000000);
					cirViewBtn.setLight_color(0x66494949);
					ImageView icon2 = new ImageView(MainActivity.this);
					icon2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
					icon2.setImageResource(R.drawable.ic_security_white);
					icon2.setColorFilter(0xFFD1C4E9, PorterDuff.Mode.MULTIPLY);
					int ICON2paddingDp = (int)paddingValue;
					float ICON2density = getApplicationContext().getResources().getDisplayMetrics().density;
					int ICON2paddingPixel = (int)(ICON2paddingDp * ICON2density);
					icon2.setPadding(ICON2paddingPixel, ICON2paddingPixel , ICON2paddingPixel , ICON2paddingPixel);
					cirViewBtn.addView(icon2);
					style1.setTextColor(0xFFF3E5F5);
					style2.setTextColor(0xFFF3E5F5);
					style3.setTextColor(0xFFF3E5F5);
					neotext.setBackground_color(0xFF303234);
					neotext.setDark_color(0x66000000);
					neotext.setLight_color(0x66494949);
					rectButton.setBackground_color(0xFF303234);
					rectButton.setDark_color(0x66000000);
					rectButton.setLight_color(0x66494949);
					rectButton.removeAllViews();
					ImageView ic_rect = new ImageView(MainActivity.this);
					ic_rect.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
					ic_rect.setImageResource(R.drawable.color_like_icon_pressed);
					int IC_RECTpaddingDp = (int) paddingValue;
					float IC_RECTdensity = getApplicationContext().getResources().getDisplayMetrics().density;
					int IC_RECTpaddingPixel = (int)(IC_RECTpaddingDp * IC_RECTdensity);
					ic_rect.setPadding(IC_RECTpaddingPixel, IC_RECTpaddingPixel , IC_RECTpaddingPixel , IC_RECTpaddingPixel);
					rectButton.addView(ic_rect);
				}
				else {
					AJCode.setBackgroundGradient(base, 0xFFE0E0E0, 0xFFE0E0E0);
					pb.setBackground_color(0xFFECF0E3);
					pb.setDark_color(0xFFA3B1C6);
					pb.setLight_color(0xFFFFFFFF);
					pv.setBackground_color(0xFFECF0E3);
					pv.setDark_color(0xFFA3B1C6);
					pv.setLight_color(0xFFFFFFFF);
					ImageView icon = new ImageView(MainActivity.this);
					icon.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
					icon.setImageResource(R.drawable.ic_3d_rotation_white);
					icon.setColorFilter(0xFF673AB7, PorterDuff.Mode.MULTIPLY);
					int ICONpaddingDp = (int)paddingValue;
					float ICONdensity = getApplicationContext().getResources().getDisplayMetrics().density;
					int ICONpaddingPixel = (int)(ICONpaddingDp * ICONdensity);
					icon.setPadding(ICONpaddingPixel, ICONpaddingPixel , ICONpaddingPixel , ICONpaddingPixel);
					pb.addView(icon);
					cirViewBtn.setBackground_color(0xFFECF0E3);
					cirViewBtn.setDark_color(0xFFA3B1C6);
					cirViewBtn.setLight_color(0xFFFFFFFF);
					ImageView icon2 = new ImageView(MainActivity.this);
					icon2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
					icon2.setImageResource(R.drawable.ic_security_white);
					icon2.setColorFilter(0xFF673AB7, PorterDuff.Mode.MULTIPLY);
					int ICON2paddingDp = (int)paddingValue;
					float ICON2density = getApplicationContext().getResources().getDisplayMetrics().density;
					int ICON2paddingPixel = (int)(ICON2paddingDp * ICON2density);
					icon2.setPadding(ICON2paddingPixel, ICON2paddingPixel , ICON2paddingPixel , ICON2paddingPixel);
					cirViewBtn.addView(icon2);
					style1.setTextColor(0xFF333B51);
					style2.setTextColor(0xFF333B51);
					style3.setTextColor(0xFF333B51);
					neotext.setBackground_color(0xFFECF0E3);
					neotext.setDark_color(0xFFA3B1C6);
					neotext.setLight_color(0xFFFFFFFF);
					rectButton.setBackground_color(0xFFECF0E3);
					rectButton.setDark_color(0xFFA3B1C6);
					rectButton.setLight_color(0xFFFFFFFF);
					rectButton.removeAllViews();
					ImageView ic_rect = new ImageView(MainActivity.this);
					ic_rect.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
					ic_rect.setImageResource(R.drawable.color_menu_ic_send);
					int IC_RECTpaddingDp = (int) paddingValue;
					float IC_RECTdensity = getApplicationContext().getResources().getDisplayMetrics().density;
					int IC_RECTpaddingPixel = (int)(IC_RECTpaddingDp * IC_RECTdensity);
					ic_rect.setPadding(IC_RECTpaddingPixel, IC_RECTpaddingPixel , IC_RECTpaddingPixel , IC_RECTpaddingPixel);
					rectButton.addView(ic_rect);
				}
			}
		});
	}
	
	private void initializeLogic() {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); getWindow().setStatusBarColor(Color.TRANSPARENT);
		AJCode.setBackgroundGradient(base, 0xFFE0E0E0, 0xFFE0E0E0);
		paddingValue = 55;
		_NeoTextViewWidget();
		_PolygonViewWidget();
		_RectButtonWidget();
		_CircleViewWidget();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _RectButtonWidget () {
		rectButton = new RectButton(MainActivity.this);
		rectButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		rect_view.addView(rectButton);
		rectButton.setBorderWidth((float)3);
		rectButton.setBorderColor(0xFFE0E0E0);
		ImageView ic_rect = new ImageView(MainActivity.this);
		ic_rect.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		ic_rect.setImageResource(R.drawable.color_menu_ic_send);
		int IC_RECTpaddingDp = (int) paddingValue;
		float IC_RECTdensity = getApplicationContext().getResources().getDisplayMetrics().density;
		int IC_RECTpaddingPixel = (int)(IC_RECTpaddingDp * IC_RECTdensity);
		ic_rect.setPadding(IC_RECTpaddingPixel, IC_RECTpaddingPixel , IC_RECTpaddingPixel , IC_RECTpaddingPixel);
		rectButton.addView(ic_rect);
		rectButton.setTopLeftRadius((float)LT_Rad);
		rectButton.setTopRightRadius((float)RT_Rad);
		rectButton.setBottomLeftRadius((float)LB_Rad);
		rectButton.setBottomRightRadius((float)RB_Rad);
		rectButton.setBackground_color(0xFFECF0E3);
		rectButton.setDark_color(0xFFA3B1C6);
		rectButton.setLight_color(0xFFFFFFFF);
	}
	
	
	public void _PolygonViewWidget () {
		pv = new PolygonView(MainActivity.this);
		pv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		pv.setStyle(3);
		pv.setSide(4);
		polygon_view.addView(pv);
		pv.setBorderWidth((float)3);
		pv.setBorderColor(0xFFE0E0E0);
		pv.setBackground_color(0xFFECF0E3);
		pv.setDark_color(0xFFA3B1C6);
		pv.setLight_color(0xFFFFFFFF);
		pb = new PolygonButton(MainActivity.this);
		pb.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		pb.setSide(4);
		pv.addView(pb);
		ImageView icon = new ImageView(MainActivity.this);
		icon.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		icon.setImageResource(R.drawable.ic_3d_rotation_white);
		icon.setColorFilter(0xFF673AB7, PorterDuff.Mode.MULTIPLY);
		int ICONpaddingDp = (int)paddingValue;
		float ICONdensity = getApplicationContext().getResources().getDisplayMetrics().density;
		int ICONpaddingPixel = (int)(ICONpaddingDp * ICONdensity);
		icon.setPadding(ICONpaddingPixel, ICONpaddingPixel , ICONpaddingPixel , ICONpaddingPixel);
		pb.addView(icon);
		pb.setBackground_color(0xFFECF0E3);
		pb.setDark_color(0xFFA3B1C6);
		pb.setLight_color(0xFFFFFFFF);
		pb.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View _view){
				gtr.vibrate((long)(50));
				ApplicationUtil.showMessage(getApplicationContext(), "Good Job Bro 👍");
			}
		});
	}
	
	
	public void _CircleViewWidget () {
		cirViewBtn = new CircleView(MainActivity.this);
		cirViewBtn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		cirViewBtn.setBackgroundColor(0xFFECF0E3);
		circle_view.addView(cirViewBtn);
		cirViewBtn.setBorderWidth((float)3);
		cirViewBtn.setBorderColor(0xFFE0E0E0);
		ImageView icon2 = new ImageView(MainActivity.this);
		icon2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		icon2.setImageResource(R.drawable.ic_security_white);
		icon2.setColorFilter(0xFF673AB7, PorterDuff.Mode.MULTIPLY);
		int ICON2paddingDp = (int)paddingValue;
		float ICON2density = getApplicationContext().getResources().getDisplayMetrics().density;
		int ICON2paddingPixel = (int)(ICON2paddingDp * ICON2density);
		icon2.setPadding(ICON2paddingPixel, ICON2paddingPixel , ICON2paddingPixel , ICON2paddingPixel);
		cirViewBtn.addView(icon2);
		        ViewGroup viewGroup = cirViewBtn;
		        final ImageView ICON2 = (ImageView) viewGroup.getChildAt(0);
		        cirViewBtn.setOnTouchListener(new View.OnTouchListener() {
			            @Override
			            public boolean onTouch(View v, MotionEvent event) {
				                // is shape Contains Point ----> for detect place of Touch is in the shape or not
				                if (cirViewBtn.isShapeContainsPoint(event.getX(), event.getY())) {
					                    switch (event.getAction()) {
						                        case MotionEvent.ACTION_DOWN:
						                            // PRESSED
						                            //use only "small inner shadow" because its same size with "drop shadow" style and "big inner shadow" is bigger
						                            // "small inner shadow" = "drop shadow"
						                            // "big inner shadow"  > "drop shadow"
						                            cirViewBtn.setStyle(neo.small_inner_shadow);
						                            ICON2.setScaleX(ICON2.getScaleX() * 0.9f);
						                            ICON2.setScaleY(ICON2.getScaleY() * 0.9f);
						                            gtr.vibrate((long)(50));
						ApplicationUtil.showMessage(getApplicationContext(), "Good Job Bro 👍");
						                            return true; // if you want to handle the touch event
						                        case MotionEvent.ACTION_UP:
						                        case MotionEvent.ACTION_CANCEL:
						                            // RELEASED
						                            cirViewBtn.setStyle(neo.drop_shadow);
						                            ICON2.setScaleX(1);
						                            ICON2.setScaleY(1);
						                            return true; // if you want to handle the touch event
						                    }
					                }
				                return false;
				            }
			        });
	}
	
	
	public void _NeoTextViewWidget () {
		neotext = new neoText(MainActivity.this);
		neotext.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
		neotext.setStyle(1);
		textviewforneo.addView(neotext);
		neotext.setShadow_position_x((float)5);
		neotext.setShadow_position_y((float)5);
		neotext.setShadow_radius((float)5);
		TextView txt = new TextView(MainActivity.this);
		txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		txt.setTextColor(0xFF000000);
		txt.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);
		neotext.addView(txt);
		neotext.setBackground_color(0xFFECF0E3);
		neotext.setDark_color(0xFFA3B1C6);
		neotext.setLight_color(0xFFFFFFFF);
		txt.setText("© IndoSW");
		txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/squadaone_regular.ttf"), 0);
	}
	
	
	public void _VoidOnChageColor () {
	}
	private void changeBackgroundColor(int selectedColor) {
				currentBackgroundColor = selectedColor;
				
		
		}
	{
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
