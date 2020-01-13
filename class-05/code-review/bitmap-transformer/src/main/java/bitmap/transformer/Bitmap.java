package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {

    //instance variables
    File bitFile;
    File newBitFile;
    String newName;

    //define the constructor
    public Bitmap (String inputPath, String outputPath, String newName) {
        this.bitFile = new File(inputPath);
        this.newBitFile = new File(outputPath + "/" + newName);
        this.newName = newName;
    }

    //instance methods
    public void bitOutputFile (BufferedImage bit) {
        try {

            ImageIO.write(bit, "bmp", this.newBitFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Bitmap bitTransformBlackWhite () {

        try {
            BufferedImage bitOG = ImageIO.read(this.bitFile);
//            BufferedImage bitMono = bitOG.setRGB(0, 0, 10);
            //We used this resource for this code block: https://www.tutorialspoint.com/java_dip/grayscale_conversion.htm
            for(int i=0; i <bitOG.getHeight(); i++) {
                for(int j=0; j<bitOG.getWidth(); j++){
                    Color bitColor = new Color(bitOG.getRGB(i,j));
                    int r = (int)(bitColor.getRed()*0.299);
                    int g = (int)(bitColor.getGreen()*0.587);
                    int b = (int)(bitColor.getBlue()*0.114);
                    Color newBitColor = new Color(r+b+g,r+b+g,r+b+g);

                    bitOG.setRGB(j,i,newBitColor.getRGB());
                }
            }
            this.bitOutputFile(bitOG);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Bitmap bitTransformBluify () {
        try {
            BufferedImage bitOG = ImageIO.read(this.bitFile);
//            BufferedImage bitMono = bitOG.setRGB(0, 0, 10);
            //We used this resource for this code block: https://www.tutorialspoint.com/java_dip/grayscale_conversion.htm
            // iterate over all pixels
            for(int i=0; i <bitOG.getHeight(); i++) {
                for(int j=0; j<bitOG.getWidth(); j++){
                    Color bitColor = new Color(bitOG.getRGB(i,j));

                    int blue = (int)(bitColor.getBlue());
                    int red = (int)(bitColor.getRed());
                    Color newBitColor = new Color(red, 0, blue);

                    bitOG.setRGB(i,j,newBitColor.getRGB());
                }
            }
            this.bitOutputFile(bitOG);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Bitmap mirror () {
        try {
            BufferedImage bitOG = ImageIO.read(this.bitFile);
//            BufferedImage bitMono = bitOG.setRGB(0, 0, 10);
            //We used this resource for this code block: https://www.tutorialspoint.com/java_dip/grayscale_conversion.htm
            // iterate over all pixels
            for(int i=0; i <bitOG.getHeight(); i++) {
                for(int j= bitOG.getWidth() -1; j > bitOG.getWidth() / 2; j--){
                    Color bitColor = new Color(bitOG.getRGB(i,j));

                    bitOG.setRGB(i,bitOG.getWidth() - 1 - j,bitColor.getRGB());
                }
            }
            this.bitOutputFile(bitOG);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
