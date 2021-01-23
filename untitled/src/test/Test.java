package test;

import com.zwb.www.ResourceManger;
import org.junit.Assert;
import sun.awt.image.BufferedImageDevice;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Package: com.test.www
 * @ClassName: Test
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/18 0:10
 * @Description:my picture test class
 */
public class Test {
    public static BufferedImage[] explodImage=new BufferedImage[16];
        @org.junit.Test
      public void test(){


          assertNotNull(new Object());
            try {
                BufferedImage image= ImageIO.read(new File("D:/我的照片/IMG_20200710_132121.jpg"));
                //pathname为绝对路径
                assertNotNull(image);
                BufferedImage image1=ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/IMG_20200710_132121.jpg"));
                //pathname为相对路径，this.getClass可以换成Test.Class
                assertNotNull(image1);
                for(int i=0;i<16;i++){
                    explodImage[i]=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


}