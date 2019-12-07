package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado {
	private int x;
	private int y;
	private String indiceImagen;
	private int velocidad;
	private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int puntuacion = 0;
	
	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public void mover(){
		if (this.x>=1100)
			this.x = -100;
		if (Juego.derecha)
			this.x+=velocidad;
		
		if (Juego.izquierda)
			this.x-=velocidad;
		
		if (Juego.arriba)
			this.y-=velocidad;
		
		if (Juego.abajo)
			this.y+=velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.fillText("Puntuacion: " + puntuacion, 10, 10);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();	
			Rectangle coordenadasVolar[]= {
					new Rectangle(8, 192, 90, 88),
					new Rectangle(8, 192, 90, 88),
					new Rectangle(8, 192, 90, 88),
					new Rectangle(8, 192, 90, 88),
					new Rectangle(8, 192, 90, 88),
					new Rectangle(8, 192, 90, 88),
					new Rectangle(8, 192, 90, 88),
					new Rectangle(106, 193, 90, 88),
					new Rectangle(106, 193, 90, 88),
					new Rectangle(106, 193, 90, 88),
					new Rectangle(106, 193, 90, 88),
					new Rectangle(106, 193, 90, 88),
					new Rectangle(106, 193, 90, 88),
					new Rectangle(200, 192, 90, 88),
					new Rectangle(200, 192, 90, 88),
					new Rectangle(200, 192, 90, 88),
					new Rectangle(200, 192, 90, 88),
					new Rectangle(200, 192, 90, 88),
					new Rectangle(200, 192, 90, 88),
					new Rectangle(291, 192, 90, 88),
					new Rectangle(291, 192, 90, 88),
					new Rectangle(291, 192, 90, 88),
					new Rectangle(291, 192, 90, 88),
					new Rectangle(291, 192, 90, 88),
					new Rectangle(291, 192, 90, 88),
				
			};
					
			Animacion animacionVolar = new Animacion("volar",coordenadasVolar,0.04);
			animaciones.put("volar",animacionVolar);
			
			Rectangle coordenadasDescanso[] = {
					new Rectangle(8, 5, 56, 42),
					new Rectangle(61, 4, 57, 42),
					new Rectangle(115,5, 55,41),
					new Rectangle(167,5, 55,42),
					new Rectangle(221,4, 58,43),
					new Rectangle(279,5, 57,42),
			};
			Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.2);
			animaciones.put("descanso",animacionDescanso);
	}
	public void verificarColisiones(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				if (!item.isCapturado())
					this.puntuacion++;
				item.setCapturado(true);				
		}
	}
}
