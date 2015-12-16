package com.mhwang.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mhwang.com.selfview.R;

/**
 * 项目名称：
 * 类描述：自定义菜单项view
 * 作者：mhwang
 * 创建时间：2015/12/16
 */
public class MenuView extends LinearLayout{
    /*菜单项文本*/
    private TextView tvText = null;
    /*菜单项图片*/
    private ImageView ivPitcture = null;

    public MenuView(Context context) {
        super(context);
        /*获得布局的inflater*/
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        /*将自定义布局加入当前布局*/
        inflater.inflate(R.layout.view_menu, this);

        /*初始化控件*/
        initComponent();
    }

    public MenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /*获得布局的inflater*/
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        /*将自定义布局加入当前布局*/
        inflater.inflate(R.layout.view_menu,this);

        /*初始化控件*/
        initComponent();

        /*获取布局设置的属性集*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.Menu);

        /*根据获得的属性集设置自定义控件*/
        initWidgt(typedArray);
    }

    /**
     * 初始化控件
     */
    private void initComponent() {
        tvText = (TextView)findViewById(R.id.tv_menu_text);
        ivPitcture = (ImageView)findViewById(R.id.iv_menu_picture);
    }

    /**初始化控件属性
     * @param typedArray    属性集,里面包含在xml中设置的控件属性
     */
    private void initWidgt(TypedArray typedArray) {
        /*获取xml中设置的text属性*/
        String text = typedArray.getString(R.styleable.Menu_text);
        int textSize = (int)typedArray.getDimension(
                R.styleable.Menu_textSize,15);
        int textColor = (int)typedArray.getColor(
                R.styleable.Menu_textColor,0xffffff);

        /*设置文本*/
        tvText.setText(text);
        tvText.setTextSize(textSize);
        tvText.setTextColor(textColor);

        /*获取xml中设置的图片属性*/
        int pictureHeight = (int)typedArray.getDimension(
                R.styleable.Menu_picture_height,20);
        int pictureWidth = (int)typedArray.getDimension(
                R.styleable.Menu_picture_width,20);
        int pictureSrc = (int)typedArray.getResourceId(
                R.styleable.Menu_picture_src,0);

        /*设置图片属性*/
        ivPitcture.setLayoutParams(new LayoutParams(pictureWidth,pictureHeight));
        ivPitcture.setImageResource(pictureSrc);

        /*记得释放typedArray对象*/
        typedArray.recycle();
    }

    /**设置菜单文本内容
     * @param text  要设置的文本
     */
    public void setMenuText(String text){
        if(text != null) {
            tvText.setText(text);
        }
    }

    /**取得菜单文本
     * @return  菜单文本字符串
     */
    public String getMenuText(){
        return tvText.getText().toString();
    }

    /**设置菜单文本字体大小
     * @param size  字体大小
     */
    public void setMenuTextSize(int size){
        tvText.setTextSize(size);
    }

    /**获取菜单文本字体大小
     * @return  字体大小
     */
    public float getMenuTextSize(){
        return tvText.getTextSize();
    }

    /**设置菜单文本颜色
     * @param color 颜色
     */
    public void setMenuTextColor(int color){
        tvText.setTextColor(color);
    }

    /**获取菜单文本颜色
     * @return
     */
    public int getMenuTextColor(){
        return tvText.getCurrentTextColor();
    }

    /**设置图片宽度和高度大小
     * @param width 宽度大小
     * @param height    高度大小
     */
    public void setPictureParams(int width,int height){
        ivPitcture.setLayoutParams(new LayoutParams(width,height));
    }

    /**获得图片宽度
     * @return  图片宽度整形值
     */
    public int getPictureWidth(){
        return ivPitcture.getWidth();
    }

    /**获取图片高度
     * @return  图片高度整形值
     */
    public int getPictureHeight(){
        return ivPitcture.getHeight();
    }

    /**设置菜单图片
     * @param srcId 图片的id
     */
    public void setPictureSrc(int srcId){
        ivPitcture.setImageResource(srcId);
    }


}
