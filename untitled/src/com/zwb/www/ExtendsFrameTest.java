package com.zwb.www;
import javafx.scene.text.Font;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import  java.util.List;
import java.util.Random;

/**
 * @Package: com.zwb.www
 * @ClassName: ExtendsFrameTest
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/5 18:24
 * @Description:继承Frame类并重写Frame类中paint的方法
 */
public class ExtendsFrameTest extends Frame {
  //生成一个主坦克
    TanKe mytanke=new TanKe(200,700,Dir.DOWN,Group.RED,this);
    //生成炮弹
    List<Bullet> bullets=new ArrayList<Bullet>();
    //生成敌方坦克
    List<TanKe> enemies=new ArrayList<TanKe>();
    //banckground size
    static final int GAME_WIDTH=1000,GAME_HEIGHT=1000;
    //构造方法
    public ExtendsFrameTest() {
        //重写Frame类的一些方法
        setVisible(true);
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setLocation(500, 0);
        setResizable(false);
        setTitle("坦克大战V1.0");
        //匿名内部类:没有名字的类，此处作用是作为一个窗口监听器的对象
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        //调用内部类键盘事件响应器MyKeyListener
        addKeyListener(new MyKeyListener());

    }
    //处理屏幕的闪烁方法
    Image offScreenImage=null;
    @Override
    public void update(Graphics g){
         if(offScreenImage==null){
             offScreenImage=this.createImage(GAME_WIDTH,GAME_HEIGHT);
         }
         Graphics goffScreen=offScreenImage.getGraphics();
         Color c=goffScreen.getColor();
         goffScreen.setColor(Color.black);
         goffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
         goffScreen.setColor(c);
         paint(goffScreen);
         g.drawImage(offScreenImage,0,0,null);

    }

    //重写Frame类里面的paint方法以此实现在窗口中画图
 @Override
    public void paint(Graphics g){
        //显示炮弹数量
     Color c=g.getColor();
     g.setColor(Color.WHITE);
     g.drawString("炮弹的数量:"+bullets.size(),10,50);
     g.drawString("敌人的数量:"+enemies.size(),10,70);
     g.setColor(c);
    //让坦克自己画自己
     mytanke.paint(g);
     //让炮弹自己画自己
     for(int i=0;i< bullets.size();i++){
         this.bullets.get(i).paint(g);
     }
     //画敌方若干辆敌方坦克
     for (int j=0;j<enemies.size();j++){
            enemies.get(j).paint(g);

     }
     //迭代器删除子弹方法
     /*for(Iterator<Bullet> it=bullets.iterator();it.hasNext();){
         Bullet b=it.next();
         if (!b.isPd_lives()){
             it.remove();
         }
     }*/
     for(int i=0;i<bullets.size();i++){
         for (int j=0;j<enemies.size();j++){
             bullets.get(i).crash(enemies.get(j));
         }

     }

 }

//下面的类继承自KeyAdapter实现对键盘操作时进行的反馈
    class  MyKeyListener extends KeyAdapter{
        //定义四个代表按键状态的boolean值
        private boolean bl=false;
        private boolean br=false;
        private boolean bu=false;
        private boolean bd=false;
        @Override
        public void keyPressed(KeyEvent e){
//System.out.println("The Key pressed");
 //当按下键盘时改变坦克的横向位置
            //x+=20;
            //重新调用画笔刷新一下
            //repaint();
          int key=e.getKeyCode();
              switch (key) {
                  case KeyEvent.VK_LEFT:
                      bl = true;
                      break;
                  case KeyEvent.VK_RIGHT:
                      br = true;
                      break;
                  case KeyEvent.VK_UP:
                      bu = true;
                      break;
                  case KeyEvent.VK_DOWN:
                      bd = true;
                      break;
                  default:
                      break;

          }
          //调用设置坦克方向的方法
          setTanKeDir();
        }

        @Override
        public void keyReleased(KeyEvent e){
//System.out.println("The Key released");
           //获取被释放的键的键值并设置键的按键状态为false
            int key=e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        bl = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        br = false;
                        break;
                    case KeyEvent.VK_UP:
                        bu = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        bd = false;
                        break;
                    case KeyEvent.VK_SPACE:
                        mytanke.fire();
                        break;
                    default:
                        break;

            }
            //调用设置坦克方向的方法
            setTanKeDir();

        }
//设置坦克跑动方向的方法
    private void setTanKeDir() {
     if(!bl&&!br&&!bu&&!bd) mytanke.setTk_moving(false);
     else {
         mytanke.setTk_moving(true);
         if (bl) {
             mytanke.setDir(Dir.LEFT);
         }
         if (br) {
             mytanke.setDir(Dir.RIGHT);
         }
         if (bu) {
             mytanke.setDir(Dir.UP);
         }

         if (bd) {
             mytanke.setDir(Dir.DOWN);
         }

     }
        }


}



}
