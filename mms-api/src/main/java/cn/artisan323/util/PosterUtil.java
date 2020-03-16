package cn.artisan323.util;

import cn.artisan323.domain.Poster;
import javafx.geometry.Pos;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
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

    public static void drawPoster0(Poster poster){
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

    public static void drawPoster(Poster poster) throws Exception {
        BufferedImage image = ImageIO.read(new File(poster.getUpImgFullPath()));
        Thumbnails.Builder<BufferedImage> builder = null;
        int imageHeitht = image.getHeight();
        int imageWidth = image.getWidth();
        if ((float)1220 / 500 != (float)imageWidth / imageHeitht) {
                image = Thumbnails.of(poster.getUpImgFullPath()).height(500).asBufferedImage();
                image = Thumbnails.of(poster.getUpImgFullPath()).width(1220).asBufferedImage();
                builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, 1220, 500).size(1220, 500);
        }else {
            builder = Thumbnails.of(image).size(1220, 500);
        }
        builder.outputFormat("jpg").toFile(poster.getPosterFullPath());
        //设置背景
        BufferedImage bgBufImage = new BufferedImage(1220, 500, BufferedImage.TYPE_INT_RGB);
        Graphics2D bgBufImageGraphics = bgBufImage.createGraphics();
        bgBufImageGraphics.clearRect(0, 0, 1220, 500);
        //设置图片
        BufferedImage posterBufImage1 = ImageIO.read(new FileInputStream(poster.getPosterFullPath()));
        bgBufImageGraphics.drawImage(posterBufImage1, 0, 0, 1220, 500, null);
        //设置边框
        BufferedImage posterBufImage2 = ImageIO.read(new FileInputStream("/Users/wannengqingnian/MyCode/MarketingSystem/mms-web/src/main/webapp/pic/index/writ.png"));
        bgBufImageGraphics.drawImage(posterBufImage2, 3, 3, 1215, 495, null);
        // 设置画笔,设置Paint属性
        bgBufImageGraphics.setPaint(new Color(248, 249, 251));
        Font font = new Font("宋体", Font.PLAIN, 20);
        bgBufImageGraphics.setFont(font);
        bgBufImageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (poster.getSlogen().length() > 13){
            bgBufImageGraphics.drawString(poster.getSlogen().substring(1, 13), 880, 330);
            bgBufImageGraphics.drawString(poster.getSlogen().substring(13), 880, 370);
        }else {
            bgBufImageGraphics.drawString(poster.getSlogen(), 880, 330);
        }
        bgBufImageGraphics.dispose();
        File posterf = new File(poster.getPosterFullPath());
        ImageIO.write(bgBufImage, "png", posterf);
        logger.info("海报生成完毕");
    }

}
