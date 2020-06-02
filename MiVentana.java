import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class MiVentana extends JFrame implements KeyListener{

	BufferedImage imagen;
	BufferedImage subImagen;
	Monito monito;
	int indiceX=0;


	public MiVentana()
	{
		try{
			imagen = ImageIO.read(new File("./imagenes/professor_walk.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		subImagen = imagen.getSubimage(0,64*3,64,64);
		monito = new Monito(subImagen);

		this.add(monito);


		this.setTitle("Mi Ventana");
		this.setBounds(500,400,500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(this);

	}



	public void keyPressed(KeyEvent e)
	{
		//System.out.println("Tecla presionada = "+e.getKeyCode());
		int t = e.getKeyCode();


		Point pos = monito.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		//System.out.println( (int) pos.getX() );

		if(t==68)
		{
			x = x+5;
			indiceX = ((indiceX + 1) % 9) * 64;
			monito.imagen = imagen.getSubimage(indiceX,64*3,64,64);
		}

		else if(t==65)
		{
			x = x-5;
			indiceX = ((indiceX + 1) % 9) * 64;
			monito.imagen = imagen.getSubimage(indiceX,64*1,64,64);
		}

		else if(t==83)
		{
			y = y+5;
			indiceX = ((indiceX + 1) % 9) * 64;
			monito.imagen = imagen.getSubimage(indiceX,64*2,64,64);
		}
		else if(t==87)
		{
			y = y-5;
			indiceX = ((indiceX + 1) % 9) * 64;
			monito.imagen = imagen.getSubimage(indiceX,64*0,64,64);
		}


		monito.setLocation(x,y);


	}

	public void keyReleased(KeyEvent e)
	{
		//System.out.println("Tecla liberada.");
	}

	public void keyTyped(KeyEvent e)
	{
		//System.out.println("Tecla en el buffer.");

	}
}