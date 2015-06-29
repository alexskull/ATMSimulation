package cola_simple;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Graficas {
DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    public void grafica_lineal(float[] y, String[] x, String datah, String datav, String titulo,int posx,int posy,int alto,int ancho) {
        

        for (int d = 0; d < y.length; d++) {
            dataset.addValue(y[d], "Día 1", x[d]);
        }

        JFreeChart chart = ChartFactory.createLineChart(titulo, datav, datah, dataset, PlotOrientation.VERTICAL,
        false, true, false);

        ChartFrame frame = new ChartFrame(titulo, chart);
        frame.setBounds(posx, posy, alto, ancho);
        frame.pack();
        frame.setVisible(true);
    }

    public void grafica_torta(float[] y, String[] x, String titulo,int posx,int posy,int alto,int ancho) {
        DefaultPieDataset data = new DefaultPieDataset();
        
        for (int d = 0; d < y.length; d++) {
            data.setValue(x[d], y[d]);
        }
        
        JFreeChart chart = ChartFactory.createPieChart(titulo, data, true, true, true);
        ChartFrame frame = new ChartFrame(titulo, chart);
        frame.setBounds(posx, posy, alto, ancho);
        frame.pack();
        frame.setVisible(true);
    }

    public void grafica_barras_vertical(float[] y, String[] x, String datah, String datav, String titulo,int posx,int posy,int alto,int ancho) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        
        for (int d = 0; d < y.length; d++) {
            data.setValue(y[d], x[d], x[d]);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(titulo, datah, datav, data, PlotOrientation.VERTICAL, false,
        true, false);
        ChartFrame frame = new ChartFrame(titulo, chart);
        frame.setBounds(posx, posy, alto, ancho);
        frame.pack();
        frame.setVisible(true);
    }

    public void grafica_barras_horizontal(float[] y, String[] x, String datah, String datav, String titulo,int posx,int posy,int alto,int ancho) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        System.out.println(y.length);
        //int a=0;
        for (int d = 0; d < y.length; d++) {
            data.setValue(y[d], x[d], x[d]);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(titulo, datah, datav, data, PlotOrientation.HORIZONTAL, false,
                true, false);
        ChartFrame frame = new ChartFrame(titulo, chart);
        frame.setBounds(posx, posy, alto, ancho);
        frame.pack();
        frame.setVisible(true);
    }
}

