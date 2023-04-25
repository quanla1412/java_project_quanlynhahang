/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author tuant
 */
public class NewClass {

    public static void main(String[] args) {

        // Create a sample dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(10, "Series 1", "Category 1");
        dataset.setValue(20, "Series 1", "Category 2");
        dataset.setValue(30, "Series 1", "Category 3");
        dataset.setValue(40, "Series 2", "Category 1");
        dataset.setValue(50, "Series 2", "Category 2");
        dataset.setValue(60, "Series 2", "Category 3");

        // Create a chart and add the dataset
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Example", "Category Axis", "Value Axis", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Get the plot of the chart
        CategoryItemRenderer renderer = chart.getCategoryPlot().getRenderer();

        // Create a label generator and set it for the renderer
        CategoryItemLabelGenerator labelGenerator = new CategoryItemLabelGenerator() {
            @Override
            public String generateLabel(org.jfree.data.category.CategoryDataset categoryDataset, int series, int category) {
                return categoryDataset.getValue(series, category).toString();
            }
        };
        renderer.setBaseItemLabelGenerator(labelGenerator);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));

        // Display the chart in a frame
        ChartFrame frame = new ChartFrame("Bar Chart Example", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
