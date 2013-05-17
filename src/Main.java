
public class Main {
	public static void main(String[] args) {
		//test data
		float[] xData = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f};
		float[] yData = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f};
		
		LineFitter fitter = new LineFitter(0.01f);
		Line bestFit = fitter.fitLine(xData, yData);
		System.out.println(bestFit.toString());
		//the output should be close to c = 0 m = 1 given this test data (rounding errors make this inpresice)
	}
}
