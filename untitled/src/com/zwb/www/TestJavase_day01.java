package com.zwb.www;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Package: com.zwb.www
 * @ClassName: TestJavase_day01
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/5 17:00
 * @Description:学习韩顺平javase的第一个程序，在控制台显示hello world
 */
//public 表示这个类是公共的，一个java文件中只能包含一个公共类
    //class表示这是一个类，TestJavase_day01表示类名，这个公共类的类名必须要和这个.java文件名一致，如果不一致编译不会通过
//这些代码是给人看的，机器看不懂，只能通过javac.exe编译成.class文件后，再通过解释执行器java.exe将.class文件加载到Java虚拟机中运行出结果
//java虚拟机(JVM):是java语言发明者虚拟出来的一个机器可以通过jvm跨操作系统运行java程序，而不是直接在操作系统上面运行

public class TestJavase_day01{
    //主函数相当于程序的入口
    public static void main(String[] args) throws InterruptedException {
//       Frame frame=new Frame();
//        frame.setVisible(true);
//         frame.setSize(1000,1000);
//         frame.setLocation(500,0);
//        frame.setResizable(false);
//        frame.setTitle("坦克大战V1.0");
//        //匿名内部类:没有名字的类，此处作用是作为一个窗口监听器的对象
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//               System.exit(0);
//            }
//        });

        //调用继承Frame类的ExtendsFrameTest类实现能画图的窗口
        ExtendsFrameTest e=new ExtendsFrameTest();
        //初始化若干两敌方坦克
        for(int i=0;i<5;i++){
         e.enemies.add(new TanKe(100+i*80,50,Dir.DOWN,Group.BLUE,e));
        }
        while(true){
           Thread.sleep(50);
            e.repaint();

        }


      //int占内存4字节，long占8字节
//        int a=0;
//        int b=1;
//        int c=a+b;
//        System.out.println("c的值为:"+c);
    }
}
