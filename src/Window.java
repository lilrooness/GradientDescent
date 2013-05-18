import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Window extends JFrame {
	
	private JButton fitLine;
	private View dataView;
	private float[] xData, yData;
	private LineFitter fitter;
	private int width, height;
	
	public Window(int width, int height) {
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		setupViews();
		fitLine = new JButton("Fit Line");
		fitLine.addActionListener(new Handler());
		this.add(fitLine);
		this.setVisible(true);
	}
	
	public void setupViews() {
		dataView = new View(10, width, height);
		this.add(dataView);
	}
	
	public void setData() {
		dataView.setxData(xData);
		dataView.setyData(yData);
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
	
	public LineFitter getFitter() {
		return fitter;
	}

	public void setFitter(LineFitter fitter) {
		this.fitter = fitter;
	}

	private class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
				dataView.setFitLine(fitter.fitLine(xData, yData));
				dataView.repaint();
		}
		
	}
}
