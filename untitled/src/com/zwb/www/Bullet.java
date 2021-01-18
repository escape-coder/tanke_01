package com.zwb.www;

import java.awt.*;

/**
 * @Package: com.zwb.www
 * @ClassName: Bullet
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/15 23:06
 * @Description:炮弹类
 */
public class Bullet extends Frame {
    //炮弹位置
    private int x,y;
    //炮弹长宽
    private static final int HEIGHT=10,WIDTH=10;
    //方向
    private Dir dir;
    //炮弹速度
    private  static final int SPEED=20;
   //炮弹生命
    private  boolean pd_lives=true;
    //窗体
    ExtendsFrameTest eft=null;
    //敌我标识
    private Group group=Group.BLUE;
    //private static final int bullet_width=ResourceManger.bulletD.getWidth();
    //private static final int bullet_height=ResourceManger.bulletD.getHeight();
    //炮弹构造方法
    public  Bullet(int x,int y,Dir dir,Group group,ExtendsFrameTest eft){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.group=group;
        this.eft=eft;
    }
    public boolean isPd_lives() {
        return pd_lives;
    }
    //重写的paint方法
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

    //碰撞检测
     void crash(TanKe tanKe){
        if(this.group==tanKe.getGroup()) return;
       //分别创建一个覆盖坦克和炮弹的矩形对象
        Rectangle bulletRe=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle tankeRe=new Rectangle(tanKe.getX(),tanKe.getY(),tanKe.getTank_width(),tanKe.getTank_height());
        //判断两者是否相撞
         if(bulletRe.intersects(tankeRe)){
            //坦克毁灭，炮弹毁灭
             tanKe.die();
             this.die();


         }

    }
//炮弹毁灭

    private void die() {
     this.pd_lives=false;
    }

}
