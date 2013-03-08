package exo2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class Histogramme extends JPanel {

	public Histogramme() {
		// TODO Auto-generated constructor stub
		super(new BorderLayout());

		BufferedImage bi = null;
		BufferedImage bi2 = null;

		try {
			bi = ImageIO.read(this.getClass().getResource("qcm.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bi2 = plotHistogram(bi);

		ImageIcon ii = new ImageIcon(bi);
		JLabel label = new JLabel();
		label.setIcon(ii);
		this.add(label, BorderLayout.CENTER);

		ImageIcon ii2 = new ImageIcon(bi2);
		JLabel label2 = new JLabel();
		label2.setIcon(ii2);
		this.add(label2, BorderLayout.EAST);

	}

	public static BufferedImage plotHistogram(BufferedImage bi){

		//int pixels[] = getPixelsHorizontal(bi);

		int red, green, blue;
		int width = 256;
		int height = bi.getHeight();
		int pixel;
		int[] pixels = new int[256];
		Color color;
		BufferedImage avg = new BufferedImage(width, height, bi.getType());
		//System.out.println("width: " + width + " height: " + height + " type: " + bi.getType());

		for(int i=0; i<pixels.length; i++){
			pixels[i]  = 0;
		}
		
		for(int i = 0; i<width; i++){
			for(int j = 0; j<height; j++){
		//initialze avg to white color
		avg.setRGB(i, j, Histogramme.mixColor(255, 255, 255));
			}
		}

		for(int i = 0; i<bi.getWidth(); i++){
			for(int j = 0; j<bi.getHeight(); j++){

				color = new Color(bi.getRGB(i, j));
				red = color.getRed();
				green = color.getGreen();
				blue = color.getBlue();

				pixel = (red + green + blue)/3;
				//System.out.println("pixel[" +i+", " +j+ "]= " + pixel);
				pixels[pixel] ++;
				//System.out.println("\npixels table[" + pixel + "]: " + pixels[pixel]);
			}
		}
		
		for(int i=0; i<pixels.length; i++){
			//System.out.println(" pixels["+ i + "]: " + pixels[i]);
			if(pixels[i] > height) pixels[i] = height-1;
			//System.out.println(" pixels["+ i + "]: " + pixels[i]);
		}

		for(int i =0; i<256; i++){
			int j=height-1;
			do{				
				//System.out.println("j: " + j + " pixels["+ i + "]: " + pixels[i]);
				avg.setRGB(i, j, Histogramme.mixColor(0, 0, 0));
				j--;
			}while(j>0 && j>height-pixels[i]);
		}
		return avg;
	}

	private static int mixColor(int red, int green, int blue){
		return red<<16|green<<8|blue;
	}

}
