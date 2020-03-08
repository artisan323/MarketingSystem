package cn.artisan323.util;

import cn.artisan323.domain.Poster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


/**
 * 创建海报工具类
 * @author wannengqingnian
 */
public class PosterUtil {

    private static Logger logger = LoggerFactory.getLogger(PosterUtil.class);

    public static void drawPoster(Poster poster){
        int width = 1300;
        int height = 600;
        try {
            // RGB形式背景颜色
            BufferedImage bgBufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D bgBufImageGraphics = bgBufImage.createGraphics();

            // 设置背景色
            bgBufImageGraphics.setBackground(new Color(242, 244, 246, 1));

            // 通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
            bgBufImageGraphics.clearRect(0, 0, width, height);

            // 设置画笔,设置Paint属性
            bgBufImageGraphics.setPaint(new Color(82, 82, 82));
            Font font = new Font("宋体", Font.PLAIN, 20);
            bgBufImageGraphics.setFont(font);
            bgBufImageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            bgBufImageGraphics.drawString(poster.getSlogen(), 650, 100);

            BufferedImage posterBufImage = ImageIO.read(new FileInputStream(poster.getUpImgFullPath()));
            bgBufImageGraphics.drawImage(posterBufImage, 20, 20, 600, 400, null);
            bgBufImageGraphics.dispose();
            File posterf = new File(poster.getPosterFullPath());

            ImageIO.write(bgBufImage, "png", posterf);
        }catch (Exception e){
            logger.error("生成海报失败： {}", e.getMessage());
            e.printStackTrace();
        }
    }

}
