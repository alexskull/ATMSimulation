package cola_simple;


import javax.swing.*;

public class Imagenes {
	
    ImageIcon imagen;
    JLabel etiqueta;
    InterfazSimulacion Is;

	public Imagenes(InterfazSimulacion pn) {
		imagen = new ImageIcon("img/C11.png");
		Is=pn;
	}

	  public void initComponets(JFrame f) {


          etiqueta = new JLabel(imagen);  
          etiqueta.setBounds(10, 580, 58, 97);
          etiqueta.setVisible(false);
          f.add(etiqueta);
     
          
  }
	  

	  

	 public void Mover(int Pos) throws InterruptedException{
	        int CursorImg=1;
	        this.etiqueta.setLocation(this.etiqueta.getX(), this.etiqueta.getY());
	        do {
	            this.etiqueta.setVisible(true);
	            ImageIcon imagen = new ImageIcon("img/C1"+CursorImg+".png");
	            this.etiqueta.setIcon(imagen);
	            this.etiqueta.setLocation(this.etiqueta.getX()+20, this.etiqueta.getY());
	            
	            Thread.sleep(Is.GetSleep());
	            CursorImg++;
	            if(CursorImg==5){
	            	CursorImg=1;
	            }
	        } while (this.etiqueta.getX()<1050 - (this.etiqueta.getWidth())*(Pos));
	        ImageIcon imagen = new ImageIcon("img/C1"+5+".png");
	            this.etiqueta.setIcon(imagen);
	            
	    }
	    public void Retirado() throws InterruptedException{
	        int CursorImg=1;
	        int movimiento=-20;
	        this.etiqueta.setLocation(this.etiqueta.getX(), this.etiqueta.getY());
	        do {
	            this.etiqueta.setVisible(true);
	            if(movimiento==-20){
	                imagen = new ImageIcon("img/C1"+CursorImg+".png");
	            }
	            else{
	                imagen = new ImageIcon("img/C2"+CursorImg+".png");
	            }
	            this.etiqueta.setIcon(imagen);
	            this.etiqueta.setLocation(this.etiqueta.getX()-movimiento, this.etiqueta.getY());

	            Thread.sleep(Is.GetSleep());
	            CursorImg++;
	            if(CursorImg==5){
	            CursorImg=1;
	            }
	            if(this.etiqueta.getX()>=100){
	                ImageIcon imagen = new ImageIcon("img/C1"+5+".png");
	                this.etiqueta.setIcon(imagen);
	                Thread.sleep(Is.GetSleep());
	                imagen = new ImageIcon("img/C2"+5+".png");
	                this.etiqueta.setIcon(imagen);
	                Thread.sleep(Is.GetSleep());
	                movimiento=20;
	            }
	        } while (this.etiqueta.getX()>-40);
	        this.etiqueta.setVisible(false);
	            this.etiqueta.setIcon(imagen);
	            
	    }
	    public void Atencion(int ContadorImg) throws InterruptedException{
	        int CursorImg=1;
	        int desplazamiento=20;
	        int suma=100;
	        int mul=0;
	        if(ContadorImg>0){
	        suma=0;
	        mul=1;
	        }
	        do {
	            this.etiqueta.setVisible(true);
	            ImageIcon imagen = new ImageIcon("img/C1"+CursorImg+".png");
	            this.etiqueta.setIcon(imagen);
	            this.etiqueta.setLocation(this.etiqueta.getX()+desplazamiento, this.etiqueta.getY());
	        
	            Thread.sleep(Is.GetSleep());
	            CursorImg++;
	            if(CursorImg==5){
	            CursorImg=1;
	            }
	        } while (this.etiqueta.getX() < 1050 - (this.etiqueta.getWidth())*(ContadorImg-1)*mul+suma);
	        ImageIcon imagen = new ImageIcon("img/C1"+5+".png");
	            this.etiqueta.setIcon(imagen);
	    }
	
	
}
