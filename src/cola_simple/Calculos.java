package cola_simple;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Calculos {

	int T, M, Ns, n, Nll;
	double TP, t_med_sistema, t_med_cola, acumulo1, acumulo2, Tsuc_tll,
			Tsuc_ts, Y, X, t, tsuc, Miu, landa;
	private ArrayList<Double> LL = new ArrayList<Double>();
	private ArrayList<Double> S = new ArrayList<Double>();
	private ArrayList<Double> Serv = new ArrayList<Double>();
	
	//Edito
	int Totaldellegadas,NoAtendidos;
	float TServicio;
	int	Tipo_demanda;
	Random Rd1;
	Random Rd2;
	int NumPromAtend[]={0,0,0};
	double PorDiarioOcuCajero[]={0,0,0};
	int DiaActual = 0;
	int DSimulacion;
	DecimalFormat df = new DecimalFormat("0.0000");
	InterfazSimulacion Is;
	File rep = new File("Reporte.txt");
	Graficas grafica = new Graficas(),grafica2 = new Graficas(), grafica3 = new Graficas();
	boolean BandGraph=false;
	 
	//
	
	int MinutoSimulacion, HoraSimulacion, DiaSimulacion,Replicaciones;
	
	public Calculos(int M, double Miu) {//D Dias de Simulacion
		t = tsuc = Nll = Ns = n = 0;
		Tsuc_ts = Tsuc_tll = this.M = M;
	
		
		this.Miu = Miu;
		landa=10;
		Tipo_demanda=2;

		
		
		LL.add((double) 0);
		S.add((double) 0);
		Serv.add((double) 0);
		t_med_sistema = 0;
		t_med_cola = 0;
		X = 0;
		TP = 0;
		Totaldellegadas=0;
		NoAtendidos=0;
		
		//
			TServicio=0;
			Is = new InterfazSimulacion();
			Is.setVisible(true);
		//
			
		
	}
	public void inicializacion(){
		
		landa=10;
		Tipo_demanda=2;


		DiaActual = 0;
		BandGraph=false;
		
		LL.add((double) 0);
		S.add((double) 0);
		Serv.add((double) 0);
		t_med_sistema = 0;
		t_med_cola = 0;
		X = 0;
		TP = 0;
		Totaldellegadas=0;
		NoAtendidos=0;
		
	}

	public void ColaSimple(int D, int semilla1, int semilla2, int replicaciones ) throws InterruptedException, IOException {
		
		
			FileWriter Escribir = new FileWriter(rep);
	
		
		DSimulacion=D;
		this.T = D*24; // T Horas que durara la Simulacion
		Rd1 = new Random(semilla1);
		Rd2 = new Random(semilla2);
		
		for(Replicaciones=0;Replicaciones<replicaciones;Replicaciones++){
			
			Escribir.write("\n");
            Escribir.write("\t\t*-*-*   Replicacion: " + (Replicaciones + 1) + "   *-*-*\n");
			
			inicializacion();
		
		X = GenerarTiemposdellegada(landa);
		if (X > T) {
			TP = t_med_sistema = t_med_cola = 0;
			return;
		} else {
			Llegada(X);
			
			while (Tsuc_tll != M || Tsuc_ts != M) {
				
				
				
				if (Tsuc_tll < Tsuc_ts) {
					tsuc = Tsuc_tll;
					
					if( (CalculoDeHora(CalculoDia(tsuc))>=6 && CalculoDeHora(CalculoDia(tsuc))<8) || (CalculoDeHora(CalculoDia(tsuc))>=16 && CalculoDeHora(CalculoDia(tsuc))<21) ){
						Tipo_demanda = 0;
						landa = 40;
					}
					if(CalculoDeHora(CalculoDia(tsuc))>=8 && CalculoDeHora(CalculoDia(tsuc))<16){
						Tipo_demanda = 1;
						landa = 20;
					}
					if((CalculoDeHora(CalculoDia(tsuc))>=0 && CalculoDeHora(CalculoDia(tsuc))<6) || (CalculoDeHora(CalculoDia(tsuc))>=21 && CalculoDeHora(CalculoDia(tsuc))<24)){
						Tipo_demanda = 2;
						landa = 10;

					}
					
					Tsuc_tll = M;
					Llegada(tsuc);

				} else {
					tsuc = Tsuc_ts;
					
					if( (CalculoDeHora(CalculoDia(tsuc))>=6 && CalculoDeHora(CalculoDia(tsuc))<8) || (CalculoDeHora(CalculoDia(tsuc))>=16 && CalculoDeHora(CalculoDia(tsuc))<21) ){
						Tipo_demanda = 0;
						landa = 40;
					}
					if(CalculoDeHora(CalculoDia(tsuc))>=8 && CalculoDeHora(CalculoDia(tsuc))<16){
						Tipo_demanda = 1;
						landa = 20;
					}
					if((CalculoDeHora(CalculoDia(tsuc))>=0 && CalculoDeHora(CalculoDia(tsuc))<6) || (CalculoDeHora(CalculoDia(tsuc))>=21 && CalculoDeHora(CalculoDia(tsuc))<24)){
						Tipo_demanda = 2;
						landa = 10;

					}
					
					Tsuc_ts = M;
					Servidor(tsuc);
				}
				
				
				//
				
				if(CalculoDia(t)!=DiaActual){
					
					DiaActual=CalculoDia(t);
					
					Escribir.write("\n");
		            Escribir.write("\t\t\t\t*-*-*   Dia: " + DiaActual + "   *-*-*\n");
					
		            Escribir.write("Numero de No Atendidos: "+NoAtendidos);
		            Escribir.write("\n");
		            Escribir.write("Costo de Oportunidad por Clientes Perdidos: "+NoAtendidos*2000);
					Escribir.write("\n");
					
					NoAtendidos=0;
					
					Escribir.write("Porcentaje del tiempo que estuvo ocupado el Servidor Alta Demanda "+df.format((float)(PorDiarioOcuCajero[0]*100)/7)+" %");
					Escribir.write("\n");
					Escribir.write("Porcentaje del tiempo que estuvo ocupado el Servidor Media Demanda "+df.format((float)(PorDiarioOcuCajero[1]*100)/8)+" %");
					Escribir.write("\n");
					Escribir.write("Porcentaje del tiempo que estuvo ocupado el Servidor baja Demanda "+df.format((float)(PorDiarioOcuCajero[2]*100)/9)+" %");
					Escribir.write("\n");
					
					
					 float[] alta = {(float) ((PorDiarioOcuCajero[0] * 100) / 7)};
                     float[] media = {(float) ((PorDiarioOcuCajero[1] * 100) / 8)};
                     float[] baja = {(float) ((PorDiarioOcuCajero[2] * 100) / 9)};

                     String[] porras2 = {"Dia " + Integer.toString(DiaActual)};

                     if (BandGraph == false) {
                         grafica.grafica_lineal(alta, porras2, "Clientes", "Dias", "Porcentaje de uso en Demanda Alta"+" It: "+(Replicaciones+1), 0, 80, 0, 0);
                         grafica2.grafica_lineal(media, porras2, "Clientes", "Dias", "Porcentaje de uso en Demanda Media"+" It: "+(Replicaciones+1), 650, 80, 0, 0);
                         grafica3.grafica_lineal(baja, porras2, "Clientes", "Dias", "Porcentaje de uso en Demanda Baja"+" It: "+(Replicaciones+1), 300, 380, 0, 0);
                         BandGraph = true;
                     }

                     grafica.dataset.setValue(alta[0], "Dia", porras2[0]);
                     grafica2.dataset.setValue(media[0], "Dia", porras2[0]);
                     grafica3.dataset.setValue(baja[0], "Dia", porras2[0]);
					
					PorDiarioOcuCajero[0]=0;
					PorDiarioOcuCajero[1]=0;
					PorDiarioOcuCajero[2]=0;
					
					
					
				}
				
				//
				

			}
			TP = Math.max(0, t - T);
			acumulo1 = acumulo2 = 0;

			for (int i = 0; i < Nll; i++) {

				acumulo1 += S.get(i) - LL.get(i);
				acumulo2 += S.get(i) - LL.get(i) - Serv.get(i);
				TServicio += Serv.get(i);
			}

			t_med_sistema = acumulo1 / Nll;
			t_med_cola = acumulo2 / Nll;

			
			//
			if(t<T){
				
				Escribir.write("\n");
	            Escribir.write("\t\t\t\t*-*-*   Dia: " + DiaActual + "   *-*-*\n");
				
	            Escribir.write("Numero de No Atendidos: "+NoAtendidos);
	            Escribir.write("\n");
	            Escribir.write("Costo de Oportunidad por Clientes Perdidos: "+NoAtendidos*2000);
				Escribir.write("\n");
				
				NoAtendidos=0;
				
				 
				
				Escribir.write("Porcentaje del tiempo que estuvo ocupado el Servidor Alta Demanda "+df.format((float)(PorDiarioOcuCajero[0]*100)/7)+" %");
				Escribir.write("\n");
				Escribir.write("Porcentaje del tiempo que estuvo ocupado el Servidor Media Demanda "+df.format((float)(PorDiarioOcuCajero[1]*100)/8)+" %");
				Escribir.write("\n");
				Escribir.write("Porcentaje del tiempo que estuvo ocupado el Servidor baja Demanda "+df.format((float)(PorDiarioOcuCajero[2]*100)/9)+" %");
				Escribir.write("\n");
				
				float[] alta = {(float) ((PorDiarioOcuCajero[0] * 100) / 7)};
                float[] media = {(float) ((PorDiarioOcuCajero[1] * 100) / 8)};
                float[] baja = {(float) ((PorDiarioOcuCajero[2] * 100) / 9)};
                String[] porras2 = {"Dia " + Integer.toString(DiaActual)};
				
				grafica.dataset.setValue(alta[0], "Dia", porras2[0]);
                grafica2.dataset.setValue(media[0], "Dia", porras2[0]);
                grafica3.dataset.setValue(baja[0], "Dia", porras2[0]);
				
				PorDiarioOcuCajero[0]=0;
				PorDiarioOcuCajero[1]=0;
				PorDiarioOcuCajero[2]=0;
				
			}//
			
			
			
			//
			Escribir.write("\n");
			Escribir.write("*-*   Promedios de Clientes Atendidos por Distribucion    *-*\n");
			Escribir.write("\n");
			Escribir.write("Numero promedio de Clientes atendidos en Alta Demanda "+df.format((float)(NumPromAtend[0]/DSimulacion)));
			Escribir.write("\n");
			Escribir.write("Numero promedio de Clientes atendidos en Media Demanda "+df.format((float)(NumPromAtend[1]/DSimulacion)));
			Escribir.write("\n");
			Escribir.write("Numero promedio de Clientes atendidos en baja Demanda "+df.format((float)(NumPromAtend[2]/DSimulacion)));
			Escribir.write("\n");
			
			//Graficas
			float[] aux = {(float) (NumPromAtend[0] / DSimulacion), (float) (NumPromAtend[1] / DSimulacion), (float) (NumPromAtend[2] / DSimulacion)};
            String[] demandas = {"Alta demanda", "Media Demanda", "Baja Demanda"};
            grafica.grafica_barras_vertical(aux, demandas, "Demandas", "Clientes", "Numero de Clientes Atendidos Discriminados"+" It: "+(Replicaciones+1), 550, 0, 400, 200);
			//
            
            NumPromAtend[0]=0;
			NumPromAtend[1]=0;
			NumPromAtend[2]=0;
			
			
			
			System.out.println("Tiempo medio en el Sistema:  " + df.format(t_med_sistema*60));
			System.out.println("Tiempo medio en la cola:  " + df.format(t_med_cola*60));
			System.out.println("Total de Personas que llegaron al Sistema "+Totaldellegadas);
			System.out.println("Clientes que lograron ser Atendidos " + Nll);
			//
			

		
			 
			 
			
			System.out.println(t);
		}
		
	}//
		Escribir.close();
	}

	private void Servidor(double tsuc2) throws InterruptedException {


		
		t = tsuc2;
		Is.SetTiempo(CalculoDia(t), CalculoDeHora(CalculoDia(t)), CalculoDeHora(), Replicaciones);
		Is.sacar(n);
		n--;
		Ns++;
		S.add(Ns, t);
		NumPromAtend[Tipo_demanda]++;
		

		if (n > 0) {

			Y = GenerarTiemposdeSalida(Miu);
			Tsuc_ts = (t + Y);
			Serv.add(Ns + 1, Y);
			PorDiarioOcuCajero[Tipo_demanda]+=Y;

		}

	}

	public void Llegada(double Tsuc) throws InterruptedException {


		
		t = Tsuc; // Nota Cualquier cosa colocar Dentro del If
		Is.SetTiempo(CalculoDia(t), CalculoDeHora(CalculoDia(t)), CalculoDeHora(), Replicaciones);
		//
		Totaldellegadas++;
		if ( n < 17 ){
			Is.getimg(n).Mover(n);
			n++;
			
			Nll++;
			LL.add(Nll, t);	
		}else{
			Is.getimg(n).Retirado();
			NoAtendidos++;	
		}
		//
		
		X = GenerarTiemposdellegada(landa);
		
		if ((t + X) < T) {
			Tsuc_tll = (t + X);
		}
		if (n == 1) {

			Y = GenerarTiemposdeSalida(Miu);
			Tsuc_ts = (t + Y);
			Serv.add(Ns + 1, Y);
			PorDiarioOcuCajero[Tipo_demanda]+=Y;

		}
		
	}
	public int CalculoDia(double t){
		return (int)t/24;
	}
	
	public int CalculoDeHora(int Dia){
			return (int)t-(24*Dia);
	}
	
	public int CalculoDeHora(){
		double modulo = ((t*60)%60);
		return (int)modulo;
	}

	public double GenerarTiemposdellegada(double landa) {

		return (-Math.log(1 - Rd1.nextDouble()) / landa);
	}

	public double GenerarTiemposdeSalida(double Miu) {

		return (-Math.log(1 - Rd2.nextDouble()) / Miu);
	}

}
