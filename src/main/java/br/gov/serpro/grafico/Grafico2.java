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

public class Grafico2 {

	private static final String FILE = "/tmp/imagem.png";

	public static void main(String[] args) throws IOException {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(0.598, "bateria 1", "50 users");
		dataset.addValue(0.94, "bateria 1", "100 users");
		dataset.addValue(0.38, "bateria 2", "50 users");
		dataset.addValue(1.96598, "bateria 2", "100 users");

		JFreeChart jfreechart = ChartFactory.createBarChart("Tempo de Resposta", null, "segundos", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		plotLabels(jfreechart);


		ChartUtilities.saveChartAsPNG(new File("/tmp/imagem.png"), jfreechart, 750, 400);
		Runtime.getRuntime().exec("eog " + FILE);
	}
	
	public static void plotLabels(JFreeChart jfreechart) {
		CategoryPlot plot = jfreechart.getCategoryPlot();
		CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setBaseItemLabelsVisible(true);
		NumberFormat nf = new DecimalFormat("0.#s");
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", nf));
		renderer.setBaseItemLabelFont(new Font("Monospace", Font.PLAIN, 10));
	}
}
