package cola_simple;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class InterfazSimulacion extends javax.swing.JFrame {


    public InterfazSimulacion() {
        initComponents();
    }
    
    public InterfazSimulacion(int a) {
      
    }
    
    int max=10,min=0;
    ArrayList <Imagenes> etiquetas;
    JLabel TiempoDia;
    JLabel TiempoHora;
    JLabel TiempoMinutos;
    JLabel TiempoReplicacion;
    
    JSlider jSlider1;
    static  JTextField SemillaCola;
    static  JTextField SemillaServicio;
    static	JTextField Dias;
    static	JTextField Replicaciones;
    JButton Start;
    JButton Pause;
    static Calculos ob;
    static boolean Paso=true;
    boolean Pausar=false;
    
    JLabel D;
    JLabel H;
    JLabel M;
    JLabel R;

    
    public void iniciar(){
    	
        	this.setSize(1125, 707);
        	this.setResizable(false);
        	etiquetas=new ArrayList<Imagenes>();
            ImageIcon imagen = new ImageIcon("img/Fondo.jpg");
            JLabel fondo = new JLabel(imagen);
            fondo.setBounds(0,0,this.getWidth(), this.getHeight());
            fondo.setVisible(true);  
            
            TiempoReplicacion = new JLabel();
            TiempoReplicacion.setText("0");
            TiempoReplicacion.setFont(new java.awt.Font("Tahoma", 0, 24));
            TiempoReplicacion.setForeground(new java.awt.Color(255, 255, 255));
            TiempoReplicacion.setBounds(800, 30 , 120, 30);
            TiempoReplicacion.setVisible(true);
            
            TiempoDia = new JLabel();
            TiempoDia.setText("0");
            TiempoDia.setFont(new java.awt.Font("Tahoma", 0, 24));
            TiempoDia.setForeground(new java.awt.Color(255, 255, 255));
            TiempoDia.setBounds(30, 30 , 120, 30);
            TiempoDia.setVisible(true);
            
            TiempoHora = new JLabel();
            TiempoHora.setText("0");
            TiempoHora.setFont(new java.awt.Font("Tahoma", 0, 24));
            TiempoHora.setForeground(new java.awt.Color(255, 255, 255));
            TiempoHora.setBounds(60, 30 , 120, 30);
            TiempoHora.setVisible(true);
            
            TiempoMinutos = new JLabel();
            TiempoMinutos.setText("0");
            TiempoMinutos.setFont(new java.awt.Font("Tahoma", 0, 24));
            TiempoMinutos.setForeground(new java.awt.Color(255, 255, 255));
            TiempoMinutos.setBounds(90, 30 , 120, 30);
            TiempoMinutos.setVisible(true);
            
            JLabel NRep = new JLabel("N Replicaciones");
            NRep.setBounds(540, 10 , 200, 30);
            NRep.setForeground(new java.awt.Color(255, 255, 255));
            NRep.setVisible(true);
            this.add(NRep);
            
            Replicaciones = new javax.swing.JTextField();
            Replicaciones.setBounds(540, 30 , 50, 30);
            Replicaciones.setText("1");
            Replicaciones.setVisible(true);
            this.add(Replicaciones);
            
            
            R = new JLabel();
            R.setText("Replicaciones");
            R.setFont(new java.awt.Font("Tahoma", 0, 24));
            R.setForeground(new java.awt.Color(255, 255, 255));
            R.setBounds(800, 10 , 200, 30);
            R.setVisible(true);
            
            D = new JLabel();
            D.setText("D");
            D.setFont(new java.awt.Font("Tahoma", 0, 24));
            D.setForeground(new java.awt.Color(255, 255, 255));
            D.setBounds(30, 10 , 120, 30);
            D.setVisible(true);
            
            H = new JLabel();
            H.setText("H");
            H.setFont(new java.awt.Font("Tahoma", 0, 24));
            H.setForeground(new java.awt.Color(255, 255, 255));
            H.setBounds(60, 10 , 120, 30);
            H.setVisible(true);
            
            M = new JLabel();
            M.setText("M");
            M.setFont(new java.awt.Font("Tahoma", 0, 24));
            M.setForeground(new java.awt.Color(255, 255, 255));
            M.setBounds(90, 10 , 120, 30);
            M.setVisible(true);
                      
            
            JLabel Slider = new JLabel("Velocidad");
            Slider.setBounds(130, 10 , 200, 30);
            Slider.setForeground(new java.awt.Color(255, 255, 255));
            Slider.setVisible(true);
            this.add(Slider);
            
            jSlider1 = new javax.swing.JSlider();
            jSlider1.setBounds(130, 30 , 200, 30);
            jSlider1.setMaximum(max);
            jSlider1.setMinimum(min);
            jSlider1.setValue(5);
            jSlider1.setVisible(true);
            this.add(jSlider1);
            
            
            JLabel SemCola = new JLabel("S.Cola");
            SemCola.setBounds(350, 10 , 200, 30);
            SemCola.setForeground(new java.awt.Color(255, 255, 255));
            SemCola.setVisible(true);
            this.add(SemCola);
            
            SemillaCola = new javax.swing.JTextField();
            SemillaCola.setBounds(350, 30 , 50, 30);
            SemillaCola.setText("19");
            SemillaCola.setVisible(true);
            this.add(SemillaCola);
            
            JLabel SemServ = new JLabel("S.Servicio");
            SemServ.setBounds(410, 10 , 200, 30);
            SemServ.setForeground(new java.awt.Color(255, 255, 255));
            SemServ.setVisible(true);
            this.add(SemServ);
            
            SemillaServicio = new javax.swing.JTextField();
            SemillaServicio.setBounds(410, 30 , 50, 30);
            SemillaServicio.setText("21");
            SemillaServicio.setVisible(true);
            this.add(SemillaServicio);
            
            JLabel NDias = new JLabel("N Dias");
            NDias.setBounds(470, 10 , 200, 30);
            NDias.setForeground(new java.awt.Color(255, 255, 255));
            NDias.setVisible(true);
            this.add(NDias);
            
            Dias = new javax.swing.JTextField();
            Dias.setBounds(470, 30 , 50, 30);
            Dias.setText("10");
            Dias.setVisible(true);
            this.add(Dias);
            
            
            Start = new JButton("Start");
            Start.setBounds(650, 30 , 80, 30);
            Start.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    StartMouseClicked(evt);
                }
            });
            Start.setVisible(true);
            this.add(Start);
           
            
            for (int i = 0; i < 18; i++) {
                Imagenes im=new Imagenes(this);
                im.initComponets(this);
                etiquetas.add(im);
                }
            
            
            this.add(TiempoMinutos);
            this.add(TiempoHora);
            this.add(TiempoDia);
            this.add(TiempoReplicacion);
            this.add(M);
            this.add(H);
            this.add(D);
            this.add(R);
            this.add(fondo);
           
            this.repaint();
               
            }

    //Eventos
    	
    public void StartMouseClicked(java.awt.event.MouseEvent evt) {                                      
        Paso=false;
    }
    //
    
    public Imagenes getimg(int n){
        return etiquetas.get(n);
        }
    
    public void SetTiempo(int Dia, int Hora, int Mins, int Replicaciones){
    	TiempoReplicacion.setText(Integer.toString(Replicaciones+1));
    	TiempoDia.setText(Integer.toString(Dia+1));
    	TiempoHora.setText(Integer.toString(Hora));
    	TiempoMinutos.setText(Integer.toString(Mins));
    }
    
    public int GetSleep(){
    	return max - jSlider1.getValue();
    	
    }
    
        public void sacar(int n) throws InterruptedException{
            for (int i = 0; i < n; i++) {
                this.etiquetas.get(i).Atencion(i);
            }
            
            for (int i = 0; i < n; i++) {
                ImageIcon imagen = new ImageIcon("img/C1"+5+".png");
                this.etiquetas.get(i).etiqueta.setIcon(imagen);
              
                this.repaint();
                this.etiquetas.get(i).etiqueta.setLocation(this.etiquetas.get(i+1).etiqueta.getX(), this.etiquetas.get(i+1).etiqueta.getY()); 
                
                this.repaint();
            }
            this.etiquetas.get(n).etiqueta.setVisible(false);
        }

    
                       
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1160, 707));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
        
        iniciar();
    }  
    
   public int GetDias(){
	   return Integer.parseInt(Dias.getText());
   }
    
  

    public static void main(String args[]) throws InterruptedException, NumberFormatException, IOException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        ob = new Calculos(100000000, 30); //Tasa de salida 30, llegada Variable y T 10 dias
        
        do{
        	Thread.sleep(1);
        }while(Paso);
        ob.ColaSimple(Integer.parseInt(Dias.getText()),Integer.parseInt(SemillaCola.getText()),Integer.parseInt(SemillaServicio.getText()),Integer.parseInt(Replicaciones.getText()));
 
        

 
    }

                
}

