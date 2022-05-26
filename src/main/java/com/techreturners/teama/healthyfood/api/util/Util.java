package com.techreturners.teama.healthyfood.api.util;

import com.techreturners.teama.healthyfood.api.model.User;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Base64;

public class Util {
    public static String frameIcon="iVBORw0KGgoAAAANSUhEUgAAABEAAAAPCAIAAACN07NGAAAB+UlEQVR4XmP4jxt8/PHq3Lvt259NWfGwZsGDooUPixc8KGy56MuArhAMrnzYP/l2XMt1986bft23gvpuh0+4E111wSbliGzsAREseubdK2i54dl/K3zinWggmnQnuvN6UO4JrczjqmnH5OfeLELXs/RhZefNAIhqMIrpuxWWfVw944hS1jH1pKOSJ15uQNHz8tu9puuucA2T78ROvhc35W78tHtJ0+6nVJ+3iT4s+ObbYxQ9+18t6roVCNMQl3dSJ+OocuFpg6rz1q1XfYpOG8YcFAIqg+n59w9I7Hg+DehjoIYp9+JzjmtmHFPOOq4GRNkn1EGME2rZx9Shep5+vg615+U8oD2T7sRMvhsLNLjpinv9Rceq8zZAPbkntTKOK7Vc8AHp2fVottsuho6LgS+/Pnjx/U73rcDO6yA04XbU5HsJQJ9MvZeQeUwFqCfpiPTWR5NAev78+bn2XgfQoQH7mOrPubZe9QL6IeOYChBlHlUBujD/lG72Cc2cE+rRQM+AfAD3z///ux7Nyjymmn5UMfGIFNAnOSc1QQikWgPIDTvAffnNXohKlHBbda85/rDYzffHGs67xx8UAbKBKPaQUOUZ28efr8GVoehZeqc66iA/nPvy66Mnn6//+vMTSQkIoOhZAtRzAKEHF0DRM/dmvv8e9NSECQDO1TQ8GJG1qwAAAABJRU5ErkJggg==";
    public static Color leafColor = new Color(51, 104, 51);
    public static User defaultUser = new User("1", "Shurel Reynolds", "shurel_reynolds@yahoo.com", 2500, 1600, 600, 900);


    public static String encodeImage(String url) throws IOException {
       return encodeImage(new URL(url));
    }

    public static String encodeImage(File file) throws IOException {

        BufferedImage sourceImage = ImageIO.read(file);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ImageIO.write(sourceImage, "png", bytes);
        String str = Base64.getEncoder().encodeToString(bytes.toByteArray());
        return str;
    }

    public static String encodeImage(URL url) throws IOException {

        BufferedImage sourceImage = ImageIO.read(url);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ImageIO.write(sourceImage, "png", bytes);
        String str = Base64.getEncoder().encodeToString(bytes.toByteArray());
        return str;
    }

    public static BufferedImage decodeImage(String base64) throws IOException {
        byte[] decodeBytes = Base64.getDecoder().decode(base64);
        InputStream is = new ByteArrayInputStream(decodeBytes);
        return ImageIO.read(is);
    }
}
