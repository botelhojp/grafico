package br.gov.serpro.grafico;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico4 {

	private static final String FILE = "/tmp/imagem.png";

	public static void main(String[] args) throws IOException {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(51.98, "bateria 1", "50 threads");
		dataset.addValue(63.4, "bateria 1", "100 threads");
		dataset.addValue(70.8, "bateria 2", "50 threads");
		dataset.addValue(96.0, "bateria 2", "100 threads");

		JFreeChart jfreechart = ChartFactory.createBarChart("Taxa de Processamento (Throughput)", "Threads Concorrentes", "operações/segundo", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		plotLabels(jfreechart);


		ChartUtilities.saveChartAsPNG(new File("/tmp/imagem.png"), jfreechart, 750, 400);
		Runtime.getRuntime().exec("eog " + FILE);
	}
	
	public static void plotLabels(JFreeChart jfreechart) {
		CategoryPlot plot = jfreechart.getCategoryPlot();
		CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setBaseItemLabelsVisible(true);
		//NumberFormat nf = new DecimalFormat("0.#");
		NumberFormat nf = new DecimalFormat ("##");
		
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", nf));
		renderer.setBaseItemLabelFont(new Font("Monospace", Font.PLAIN, 10));
	}
}
