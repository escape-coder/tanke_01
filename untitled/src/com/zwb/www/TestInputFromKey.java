package com.zwb.www;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * @Package: com.zwb.www
 * @ClassName: TestInputFromKey
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/6 20:45
 * @Description:从键盘输入值并根据值输出相应结果
 */
public class TestInputFromKey {
    public static void main(String[] args) throws IOException {
//        InputStreamReader o=new InputStreamReader(System.in);
//        BufferedReader p=new BufferedReader(o);
//    String k=p.readLine().toString();
//    System.out.println(k);
//        //Integer l=Integer.getInteger(k);
//        if (k.equals("\u001B")){System.out.println("bye");}
        //System.out.println(l);
//            char m=27;
//            System.out.println(m);
//            System.out.println("\u001B");
//根据用户输入的数据给用户贴上标签
/*
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true) {
            String e="e";
            System.out.println("请输入你的年龄⬇");
            String age = br.readLine();


            System.out.println("请输入你的身高⬇");
            String height = br.readLine();
            if(e.equals(age)||e.equals(age.toLowerCase())){
                System.out.println("那我掌滚了!");
                break;
            }
            float a = Float.parseFloat(age);
            float b=Float.parseFloat(height);

            if(a>20.0&&a<100.0&&b>2.0&&b<3.0){
                System.out.println("高帅可惜没富啊");}
            else if (a<20.0&&a>(0)&&b>0&&b<2.0){
                System.out.println("你还太嫩了，毛都没长齐吧");}
            else{
                System.out.println("你是外星人吧，地球没你这种的，你还是到别处去吧");
            }

        }

 */
//从键盘输入一位学生的成绩评价，然后输出该学生的分数段
        /*int a;
        String str;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      do{
          str=br.readLine();
          String str1=str.toLowerCase();
          char i=str1.charAt(0);
          a=i;
          // int a=Integer.parseInt(str1);
         switch (a){
             case 97:
                 System.out.println("恭喜你!你的成绩很优秀，分数区间在(90,100]");
                 break;
             case 98:
                 System.out.println("恭喜你!你的成绩良好,分数区间在(70,90]");
                 break;
             case 99:
                 System.out.println("恭喜你!你及格了，分数区间在(60,70]");
                 break;
             case 100:
                 System.out.println("别灰心!失败乃成功之母，继续加油!");
                 break;
             case 101:
                 System.out.println("Bye");
                 break;
             default:
                 System.out.println("请输入合法的评价编码!");
         }

      }while(a!=101);*/
//根据用户输入的金字塔层数，打印出相应层数的金字塔
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        char input=br.readLine().charAt(0);
//        int layer=input;
//        System.out.println(layer);
      /*
       int layer = 8;

        for (int i = 0; i < layer; i++) {
            for (int k = i; k < layer - 1; k++) {
                System.out.print(" ");
            }
            for (int x = 0; x < 2 * i + 1; x++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        System.out.println("It's ok!");
       */
//打印镂空金字塔
        int layer = 4;

        for (int i = 0; i < layer; i++) {
            for (int k = i; k < layer - 1; k++) {
                System.out.print(" ");
            }
            for (int x = 0; x < 2 * i + 1; x++) {
                if(i==0||i==layer-1) {
                    System.out.print("*");
                }
                else{
                    if(x==0||x==2*i){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                }
            System.out.println("");
        }

        System.out.println("It's ok!");

    }





    }

