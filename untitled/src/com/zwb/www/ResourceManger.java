package com.zwb.www;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Package: com.zwb.www
 * @ClassName: ResourceManger
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/18 3:00
 * @Description:加载资源的类
 */
public class ResourceManger {
    public static BufferedImage tankU,tankD,tankL,tankR;
    public static BufferedImage bulletU,bulletD,bulletL,bulletR;

    static {
        try {
            tankU=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankL=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankR.gif"));

            bulletU=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletL=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR=ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
