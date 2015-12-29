package echo_server;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Rubare {
	Rubare istanza=new Rubare();
	public Rubare() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws IOException {
		String cartella="/home/diego/Scrivania/rubare/";
		
		BufferedImage bf=  ImageIO.read(new File(cartella+"frammento.jpg"));
		File f = new File(cartella);
		String [] elenco=f.list();
		for(int i=0;i<elenco.length;i++){
			//if (!elenco[i].equals("frammento.jpg")){
				(new Thread(new threadLavoro(cartella+elenco[i], bf))).start();
				
					
				
		//	}

		}
		
    }
	
		
}
