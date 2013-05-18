import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javax.swing.JPanel;


public class View extends JPanel{
	
	private Line fitLine;
	private float[] xData, yData;
	private int scale;
	private int width, height;
	
	public View(int scale, int width, int height) {
		this.width = width-10;
		this.height = height- 10;
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.scale = scale;
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setRoundingMode(RoundingMode.HALF_DOWN);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.RED);
		if(!(xData == null || yData == null)) {
			for(int i = 0; i < yData.length; i++) {
					g.fillRect((int)xData[i]*scale, (int)yData[i]*scale, 5, 5);
			}
		}

		if(fitLine != null) {
			g.drawLine(0, Math.round(fitLine.getC())*scale, (int) (xData[xData.length-1]*scale), (Math.round(fitLine.getM()*(xData[xData.length-1])) + Math.round(fitLine.getC()))*scale);
		}
	}

	public Line getFitLine() {
		return fitLine;
	}

	public void setFitLine(Line fitLine) {
		this.fitLine = fitLine;
	}

	public float[] getxData() {
		return xData;
	}

	public void setxData(float[] xData) {
		this.xData = xData;
	}

	public float[] getyData() {
		return yData;
	}

	public void setyData(float[] yData) {
		this.yData = yData;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
	
}
