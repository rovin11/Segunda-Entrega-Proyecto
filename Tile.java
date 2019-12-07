package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile {
	private int x;
	private int y;
	//Parametros dentro de la imagen principal
	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	private String indiceImagen;
	private int velocidad;
	public Tile(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}
	
	public Tile(int tipoTile,int x, int y, String indiceImagen, int velocidad){
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		//this.invertir = invertir;
		switch(tipoTile){
			case 1:
				this.altoImagen = 100;
				this.anchoImagen = 400;
				this.xImagen = 0;
				this.yImagen =200;
			break;
			case 2:
				this.altoImagen = 100;
				this.anchoImagen = 400;
				this.xImagen = 0;
				this.yImagen =300;
			break;
		case 3:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 0;
			this.yImagen =400;
			break;
			case 4:
				this.altoImagen = 100;
				this.anchoImagen = 400;
				this.xImagen = 0;
				this.yImagen =500;
			break;
		case 5:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 0;
			this.yImagen =600;
			break;
		case 6:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 400;
			this.yImagen =500;
			break;
		case 7:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 400;
			this.yImagen =400;
			break;
		case 8:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 400;
			this.yImagen =600;
		break;
		case 9:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 400;
			this.yImagen =300;
		break;
		case 10:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 400;
			this.yImagen =200;
		break;
		case 11:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 800;
			this.yImagen =600;
		break;
		case 12:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 800;
			this.yImagen =500;
		break;
		case 13:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 800;
			this.yImagen =400;
		break;
		case 14:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 800;
			this.yImagen =300;
		break;
		case 15:
			this.altoImagen = 100;
			this.anchoImagen = 400;
			this.xImagen = 800;
			this.yImagen =200;
		break;
		
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getAltoImagen() {
		return altoImagen;
	}
	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}
	public int getAnchoImagen() {
		return anchoImagen;
	}
	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}
	public int getxImagen() {
		return xImagen;
	}
	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}
	public int getyImagen() {
		return yImagen;
	}
	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
			graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x--, 
				this.y,
				this.anchoImagen, this.altoImagen
			);
	}
}