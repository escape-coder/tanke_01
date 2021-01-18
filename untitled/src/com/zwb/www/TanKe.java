package com.zwb.www;

import sun.net.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Package: com.zwb.www
 * @ClassName: Tanke
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/11 22:20
 * @Description:坦克类
 */
public class TanKe extends Frame {
    //坦克横向位移x，纵向位移y
    private int x;
    private int y;
    //坦克的长宽
    private static final int HEIGHT=50,WIDTH=50;
    //引入坦克方向枚举类
    private Dir dir=Dir.DOWN;
    //定义坦克的速度
    private static final int SPEED=1;
    //坦克的运动状态
    private boolean tk_moving=true;
    //坦克的生命
    private boolean tk_live=true;
    //窗体
    ExtendsFrameTest eft;

    //敌我标识
    private Group group=Group.BLUE;
    //随机对象
    private Random random=new Random();
    //坦克长和宽
     static final int tank_width=ResourceManger.tankD.getWidth();
     static final int tank_height=ResourceManger.tankD.getHeight();


    public void setTk_moving(boolean tk_moving) {
        this.tk_moving = tk_moving;
    }
    public boolean  getTk_moving(){
        return this.tk_moving;
    }
    public boolean getTk_live(){
        return this.tk_live;
    }
    public static int getTank_width() {
        return tank_width;
    }

    public static int getTank_height() {
        return tank_height;
    }
    public Group getGroup() {
        return group;
    }

    //tanke构造方法
    public TanKe(int x,int y,Dir dir,Group group,ExtendsFrameTest eft){
        super();
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.group=group;
        this.eft=eft;

    }
    //setter and getter

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
    @Override
    public void paint(Graphics g){
        //由测试结果可以看出paint方法会被自动调用，它会在窗口需要重新绘制的时候被调用
        //窗口第一次显示的时候，窗口被别人盖住然后又出来的时候，窗口改变大小的时候
        //System.out.println("哈哈哈");
//        Color color=g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fill3DRect(x, y, 50, 50, true);
//        g.setColor(color);
//              x+=10;
//              y+=10;
        if(!tk_live)
        {
            eft.enemies.remove(this);
        }
           switch (dir){
               case UP:
                   g.drawImage(ResourceManger.tankU,this.x,this.y,null);
                   break;
               case DOWN:
                   g.drawImage(ResourceManger.tankD,this.x,this.y,null);
                   break;
               case LEFT:
                   g.drawImage(ResourceManger.tankL,this.x,this.y,null);
                   break;
               case RIGHT:
                   g.drawImage(ResourceManger.tankR,this.x,this.y,null);
                   break;
           }

        //调用坦克移动方法
          move();
        }

  //坦克移动
    private void move() {
        //根据方向
        if(!this.tk_moving) return;
        switch (dir) {
            case LEFT:
                x -= 10;
                break;
            case RIGHT:
                x += 10;
                break;
            case UP:
                y -= 10;
                break;
            case DOWN:
                y += 10;
            default:
                break;
    }
    //根据随机值开火
        if(random.nextInt(10)>7){
            this.fire();
        }

    }
    //开火方法

    public void fire(){
        int bu_ux,bu_uy,bu_dx,bu_dy,bu_lx,bu_ly,bu_rx,bu_ry;
        bu_ux=(this.x+ResourceManger.tankU.getWidth()/2)-(ResourceManger.bulletU.getWidth()/2);
        bu_uy=this.y;
        bu_dx=(this.x+ResourceManger.tankD.getWidth()/2)-(ResourceManger.bulletD.getWidth()/2);
        bu_dy=this.y+ResourceManger.tankD.getHeight();

        bu_lx=this.x;
        bu_ly=(this.y+ResourceManger.tankL.getHeight()/2)-(ResourceManger.bulletL.getHeight()/2);
        bu_rx=this.x+ResourceManger.tankR.getWidth();
        bu_ry=(this.y+ResourceManger.tankR.getHeight()/2)-(ResourceManger.bulletR.getHeight()/2);
        switch (dir) {
            case UP:
            this.eft.bullets.add(new Bullet(bu_ux,bu_uy, this.dir,this.group,this.eft));
            break;
            case DOWN:
                this.eft.bullets.add(new Bullet(bu_dx,bu_dy, this.dir, this.group,this.eft));
                break;
            case LEFT:
                this.eft.bullets.add(new Bullet(bu_lx,bu_ly, this.dir,this.group, this.eft));
                break;
            case RIGHT:
                this.eft.bullets.add(new Bullet(bu_rx,bu_ry, this.dir,this.group ,this.eft));
                break;

        }
    }
//坦克毁灭
    public void die() {
        this.tk_live=false;
    }
}
