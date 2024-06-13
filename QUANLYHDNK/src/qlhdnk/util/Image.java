package qlhdnk.util;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class Image {

    public static String encodeToBase64(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }
    public static ImageIcon resizeImage( ImageIcon imageIcon,int width,int height ){
        java.awt.Image scaleImage = imageIcon.getImage();
        scaleImage=scaleImage.getScaledInstance(width, height, java.awt.Image.SCALE_REPLICATE );
        return new ImageIcon(scaleImage);
    }
    public static byte[] ImageIconToByte(ImageIcon imageIcon) throws IOException{
        BufferedImage bufferedImage = new BufferedImage(
            imageIcon.getIconWidth(),
            imageIcon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB
        );
        bufferedImage.getGraphics().drawImage(imageIcon.getImage(), 0, 0, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        byte[] imageData = baos.toByteArray();
        return imageData;

    }
    public static ImageIcon ByteToImageIcon(byte[] byteImage) throws IOException{
        
        // Chuyển đổi byte[] thành BufferedImage
        ByteArrayInputStream bais = new ByteArrayInputStream(byteImage);
        BufferedImage bufferedImage = ImageIO.read(bais);

        // Chuyển đổi BufferedImage thành ImageIcon
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        return imageIcon;
    }
}
