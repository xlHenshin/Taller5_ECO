import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import processing.core.PApplet;


public class Main extends PApplet{


	private int posX, posY;
	private Circle circle;
	private String commands;
	private int r, g, b;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main(Main.class.getName());
	}

	public void settings() {

		size(500, 500);

	}

	public void setup() {

		posX=250;
		posY=250;
		r = (int) random(0,255);
		g = (int) random(0,255);
		b = (int) random(0,255);
		circle = new Circle(posX, posY, 50, r, g, b, this);

		new Thread(() -> {
			try {
				ServerSocket server = new ServerSocket(5000);
				System.out.println("Esperando control...");
				Socket socket = server.accept();
				System.out.println("El control esta conectado");

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader breader = new BufferedReader(isr);

				while (true) {

					System.out.println("Esperando comando...");
					String mensajeRecibido = breader.readLine(); //BW::X::Y::ALTO::ANCHO
					System.out.println(mensajeRecibido);

					Gson gson = new Gson();

					commands = gson.fromJson(mensajeRecibido, String.class);
					commands();

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}

	public void draw() {

		background(0);
		circle.paintCircle(posX, posY);
	}

	public void commands() {

		switch (commands) {
		case "up":

			posY-=50;
			
			break;

		case "down":

			posY+=50;
			
			break;

		case "left":

			posX-=50;
			
			break;
			
		case "right":
			
			posX+=50;
			
			break;
			
		case "color":
			
			r = (int) random(0,255);
			g = (int) random(0,255);
			b = (int) random(0,255);
			circle = new Circle(posX, posY, 50, r, g, b, this);
			
			break;

		default:
			break;
		}

	}

}
