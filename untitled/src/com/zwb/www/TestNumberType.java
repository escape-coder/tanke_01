package com.zwb.www;


/**
 * @Package: com.zwb.www
 * @ClassName: TestNumberType
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/6 17:05
 * @Description:
 */
public class TestNumberType {
    public static void main(String[] args) {
      //char类型在java中占两个字节，int占4个字节，byte占一个字节，short占两个字节，long占八个字节
        char i=10;
        byte j=10;
        Integer h=new Integer(12);
        System.out.println("the h of Size:"+h.SIZE+"    "+System.currentTimeMillis());
        System.out.println("i:"+i);
System.out.println("the size of j:"+j+"    "+System.currentTimeMillis());
//int a=1.2; System.out.println(a); 因为会损失精度编译不会通过，只能float a=1;double也是如此
        //数据类型自动转换只可以从低精度往高精度
//精度排序 byte<short<int<long<float<double
       // float a=3.4; 该语句编译不会通过，java中小数值默认属于double类型应写成3.4f
        double b=5.6f;
        System.out.println(b);
        //强制转换
        int c=(int)3.10f;
        int d=(int)3.99f;
        System.out.println(c+"***"+d);//丢失精度，都是向下转没有四舍五入
        //当一个整型类型的变量和一个float/double类型变量进行四则运算后，所得的结果都会向高精度自动转换
//思考题
    char test1='b'+'a';
    char test2='b';
    char test3='a';
    char test4=27;
char test5='b'+27;
        char test6='a'+28;
//        char test8=26361;
//        char test9=34003;
//        char test10=25105;
//        char test11=29233;
//        char test12=20320;
//        System.out.println(test8+" "+test9+" "+test10+" "+test11+" "+test12);

      System.out.println("test7对应的编码值:"+(int)(test6)+"  "+test6);
      System.out.println();
        //在java中，对char变量进行运算时javac会将该变量当成其ascii码来进行运算
System.out.println(test6);
    System.out.println(test5);
    System.out.println("'test2'="+(int)test2+"  "+"'test3='"+(int)test3);
    System.out.println("the result:"+test1+"  "+(int)test1);
//Test test=new Test();
//System.out.println(test.hashCode());
    }
}
