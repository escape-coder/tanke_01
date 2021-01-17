package com.zwb.www;
import javax.swing.plaf.synth.SynthScrollBarUI;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Package: com.zwb.www
 * @ClassName: FileDemo
 * @Author: Mr.Zhang
 * @CreateTime: 2020/9/26 20:41
 * @Description:
 */
/*
 * 流:一串连续不断的数据集合
 * 文件的判断
 * */
public class FileDemo {
    /*
     * 1.利用File file=new File(“a.tex”);创建了代表此抽象路径名表示的文件(a.txt)
     *2.并没有真正创建a.txt文件
     *3.路径表示:"\"为转义字符，表示路径是用"\\"或"/"
     * */
    public static void main(String[] args) {
        File file = new File("a.txt");
//需要用.exists()进行判断a.txt(文件或文件夹)是否存在，若存在则返回值为true
        System.out.println(file.exists());
        //1.isFile()判断代表此抽象路径名表示的文件是否是标准文件。
        //2.标准文件:不是目录且满足系统要求。
        //若文件存在且不为目录，则返回true
        System.out.println(file.isFile());
        //isDirectory()判断代表此抽象路径名表示的文件是否是目录。
        System.out.println(file.isDirectory());
        //用.length()获取长度，单位长度。
        System.out.println(file.length());
        //1.lastModified()：返回此抽象路径名表示的文件最后一次被修改的时间的long值
        //2.需要转换才能正确表示时间。
        System.out.println(file.lastModified());
        //1.创建sdf对象，并进行时间转换
        //2.注意yyyy-MM-dd hh:mm:ss的表示。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //显示时间，对file.lastModified()的返回值进行转换显示成正确的时间
        System.out.println(sdf.format(new Date(file.lastModified())));
        /*
        * 或表示为
        * SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        * Date date=new Date(file.lastModified());
        * String d=sdf.format(date);
         System.out.println(d);
        * */
        /*
         * File file=new File("E:java\\s");创建了代表此抽象路径名表示的文件。
         *System.out.println(file.exists());若s存在，返回值为true
         *System.out.println(isFile());判断s是否不为目录。
         * */
        /*
         * 延伸:
         *在f盘下创建q.txt的文件，但不能创建文件
         *File f=new File("f:\\q.txt");
         * try{
         *  f.creatNewFile();
         * }catch(IOException e){
         * //ToDo自动生成catch块
         * e.printStackTrace();
         * }
         * */
    }
}
