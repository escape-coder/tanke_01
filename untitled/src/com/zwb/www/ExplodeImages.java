package com.zwb.www;

import java.awt.*;

/**
 * @Package: com.zwb.www
 * @ClassName: ExplodeImages
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/18 18:00
 * @Description:爆炸图片的类
 */
public class ExplodeImages extends Frame{
    //炮弹图片位置
    private int x,y;
    //炮弹图片长宽
    static int WIDTH=ResourceManger.explodImage[0].getWidth();
    static int HEIGHT=ResourceManger.explodImage[0].getHeight();
    //炮弹图片生命
    private  boolean pd_lives=true;
    //窗体
    ExtendsFrameTest eft=null;
//指示器
      private int step=0;
    //炮弹构造方法
    public  ExplodeImages(int x,int y,ExtendsFrameTest eft){
        this.x=x;
        this.y=y;
        this.eft=eft;
    }
    public boolean isPd_lives() {
        return pd_lives;
    }
    //重写的paint方法
    @Override
    public  void  paint(Graphics g){
           g.drawImage(ResourceManger.explodImage[step++],x,y,null);
           if(step>ResourceManger.explodImage.length){
               step=0;
           }
    }


}
