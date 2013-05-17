
public class Line {
	private float c;
	private float m;
	
	/**
	 * @param c
	 * @param m
	 */
	public Line(float c, float m) {
		super();
		this.c = c;
		this.m = m;
	}
	/**
	 * @return the c
	 */
	public float getC() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(float c) {
		this.c = c;
	}
	/**
	 * @return the m
	 */
	public float getM() {
		return m;
	}
	/**
	 * @param m the m to set
	 */
	public void setM(float m) {
		this.m = m;
	}
	
	@Override
	public String toString() {
		return String.format("c = %f,m = %f", this.c, this.m);
	}
	
	
}
