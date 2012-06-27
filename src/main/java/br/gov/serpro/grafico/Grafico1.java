package br.gov.serpro.grafico;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico1 {

	private static final String FILE = "/tmp/imagem.png";

	public static void main(String[] args) throws IOException {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(0.5, "bateria 1", "50 users");
		dataset.addValue(0.9, "bateria 1", "100 users");
		dataset.addValue(0.8, "bateria 2", "50 users");
		dataset.addValue(1.0, "bateria 2", "100 users");

		JFreeChart jfreechart = 
				ChartFactory.createBarChart("Tempo de Resposta", null, "segundos", dataset, PlotOrientation.VERTICAL,
				true, true, false);
		ChartUtilities.saveChartAsPNG(new File("/tmp/imagem.png"), jfreechart, 750, 400);
		Runtime.getRuntime().exec("eog " + FILE);
	}
}
