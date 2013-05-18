
public class Main {
	public static void main(String[] args) {
		//test data
		float[] xData = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f};
		float[] yData = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f};
		LineFitter fitter = new LineFitter(0.1f);
		Window window = new Window(600, 400);
		window.setFitter(fitter);
		window.setxData(xData);
		window.setyData(yData);
		window.setData();
	}
}
