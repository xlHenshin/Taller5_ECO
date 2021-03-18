package com.example.taller5_eco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button left, right, up, down, color;
    private BufferedWriter bwriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = findViewById(R.id.izquierda);
        right = findViewById(R.id.derecha);
        up = findViewById(R.id.arriba);
        down = findViewById(R.id.abajo);
        color = findViewById(R.id.color);

        new Thread(

                ()->{

                    try {
                        Socket socket = new Socket("192.168.1.5", 5000);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bwriter = new BufferedWriter(osw);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

        ).start();

        botonIzquierda();
        botonDerecha();
        botonArriba();
        botonAbajo();
        botonColor();

    }


    private void botonIzquierda(){

        left.setOnClickListener(

                v->{

                    new Thread(

                            ()->{

                                try {
                                    bwriter.write("left\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    bwriter.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                    ).start();

                }

        );

    }

    private void botonDerecha(){

        right.setOnClickListener(

                v->{

                    new Thread(

                            ()->{

                                try {
                                    bwriter.write("right\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    bwriter.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                    ).start();

                }

        );

    }

    private void botonArriba(){

        up.setOnClickListener(

                v->{

                    new Thread(

                            ()->{

                                try {
                                    bwriter.write("up\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    bwriter.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                    ).start();

                }

        );

    }

    private void botonAbajo(){

        down.setOnClickListener(

                v->{

                    new Thread(

                            ()->{

                                try {
                                    bwriter.write("down\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    bwriter.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                    ).start();

                }

        );

    }

    private void botonColor(){

        color.setOnClickListener(

                v->{

                    new Thread(

                            ()->{

                                try {
                                    bwriter.write("color\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    bwriter.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                    ).start();

                }

        );

    }


}