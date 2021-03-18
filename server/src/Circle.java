import processing.core.PApplet;

public class Circle {

	private int posX, posY, size, r, g, b;
	private PApplet app;
	
	public Circle(int posX, int posY, int size, int r, int g, int b, PApplet app) {
		
		this.app=app;
		this.posX=posX;
		this.posY=posY;
		this.size=size;
		this.r=r;
		this.g=g;
		this.b=b;
		
	}
	
	public void paintCircle(int x, int y) {
		
		app.fill(r, g, b);
		app.ellipse(x, y, size, size);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
