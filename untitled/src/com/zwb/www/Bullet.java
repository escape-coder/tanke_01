package com.zwb.www;

import java.awt.*;

/**
 * @Package: com.zwb.www
 * @ClassName: Bullet
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/15 23:06
 * @Description:
 */
public class Bullet extends Frame {
    private int x,y;
    private static final int HEIGHT=10,WIDTH=10;
    private Dir dir;
    private  static final int SPEED=20;
    private  boolean pd_lives=true;
    ExtendsFrameTest eft=null;
    //private static final int bullet_width=ResourceManger.bulletD.getWidth();
    //private static final int bullet_height=ResourceManger.bulletD.getHeight();
    public  Bullet(int x,int y,Dir dir,ExtendsFrameTest eft){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.eft=eft;
    }
    public boolean isPd_lives() {
        return pd_lives;
    }
    @Override
    public  void  paint(Graphics g){
        if (!this.pd_lives){
            this.eft.bullets.remove(this);
        }
//        Color color=g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(color);

        switch (dir){
            case UP:
                g.drawImage(ResourceManger.bulletU,this.x,this.y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManger.bulletD,this.x,this.y,null);
                break;
            case LEFT:
                g.drawImage(ResourceManger.bulletL,this.x,this.y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManger.bulletR,this.x,this.y,null);
                break;
        }
        move();
    }
    //炮弹移动
    private void move() {
        if(this.x<0||this.y<0||this.x>this.eft.GAME_WIDTH||this.y>this.eft.GAME_HEIGHT){
            this.pd_lives=false;
        }
        else this.pd_lives=true;

            switch (dir) {
                case LEFT:
                    x -= 20;
                    break;
                case RIGHT:
                    x += 20;
                    break;
                case UP:
                    y -= 20;
                    break;
                case DOWN:
                    y += 20;
                default:
                    break;
            }

    }

}
