
public class LineFitter {
	
	private float learningRate;
	
	/**
	 * @param learningRate
	 */
	public LineFitter(float learningRate) {
		super();
		this.learningRate = learningRate;
	}

	/**
	 * Fits a line to the test data using the gradient descent algorithm
	 * @param xData
	 * @param yData
	 * @return
	 */
	public Line fitLine(float[] xData, float[] yData) {
		float t0 = 1;
		float t1 = 1;
		
		float temp0;
		float temp1;
		
		boolean converged = false;
		
		float cost0;
		float cost1;
		
		while(!converged) {
			System.out.println(String.format("%f, %f", t0, t1));
			cost0 = cost(t0, t1, xData, yData, false);
			cost1 = cost(t0, t1, xData, yData, true);
			temp0 = t0 - (learningRate*cost0);
			temp1 = t1 - (learningRate*cost1);	// I have split up the calculating of the costs and temps for debugging
			t0 = temp0;
			t1 = temp1;
			//round here or cost0 and cost1 will never be exactly 0
			if((Math.round(cost0 * 1000) == 0 && Math.round(cost1 * 1000) == 0) || Float.isInfinite(t0) || Float.isInfinite(t1)) {
				converged = true;
			}
		}
		//return new Line(Math.round(t0 * 1000)/1000.0f,Math.round(t1 * 1000)/1000.0f);
		return new Line(t0, t1);
	}
	
	/**
	 * Calculates the derivitive of the cost function J(t0, t1)
	 * @param t0
	 * @param t1
	 * @param xData
	 * @param yData
	 * @param forT1
	 * @return
	 */
	private float cost(float t0, float t1, float[] xData, float[] yData, boolean forT1) {
		float sum = 0;
		for(int i=0; i<xData.length; i++) {
			if(forT1) {
				sum += (float) ((t0 + (t1*xData[i])) - yData[i])*xData[i];
			}else{
				sum += (float) ((t0 + (t1*xData[i])) - yData[i]);
			}
		}
		float cost = sum *(1.0f/((float)xData.length));
		return cost;
	}
	
	/**
	 * @return the learningRate
	 */
	public float getLearningRate() {
		return learningRate;
	}


	/**
	 * @param learningRate the learningRate to set
	 */
	public void setLearningRate(float learningRate) {
		this.learningRate = learningRate;
	}
}
