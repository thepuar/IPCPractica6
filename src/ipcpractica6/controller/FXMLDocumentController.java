/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipcpractica6.controller;

import ipcpractica6.App;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 *
 * @author thepuar
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private LineChart<String, Number> GraphLinechart;
    @FXML
    private BarChart<String, Number> GraphBarChart;
    @FXML
    private PieChart GraphPieChart;
    private App app;
    @FXML
    private NumberAxis xaxisLineChart;
    @FXML
    private CategoryAxis yaxisLineChart;
    @FXML
    private NumberAxis yaxisBarChart;
    @FXML
    private CategoryAxis xaxisBarChart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = new App();
        app.poblate();
        
        //<editor-fold defaultstate="collapsed" desc="PieChart">
        ObservableList<PieChart.Data> datospiechart ;
        GraphPieChart.setData(this.getObsListData());
        GraphPieChart.setTitle("Datos aleatorios");
        //</editor-fold>
       
        //<editor-fold defaultstate="collapsed" desc="LineChart">
        xaxisLineChart.setLabel("Nº Dato aleatorio");
        GraphLinechart.setTitle("Datos de caracter aleatorio");
        XYChart.Series series = new XYChart.Series();
        series.setName("2017");
        this.getObsListData().forEach(d-> series.getData().add(new XYChart.Data(d.getName(),d.getPieValue())));
        GraphLinechart.getData().add(series);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="BarChart">
        GraphBarChart.setTitle("Datos de caracter aleatorio");
        xaxisBarChart.setLabel("Nº Dato aleatorio");
        app.poblate();
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2017");
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2018");
        this.getObsListData().forEach(d-> series1.getData().add(new XYChart.Data(d.getName(),d.getPieValue())));
        app.poblate();
        this.getObsListData().forEach(d-> series2.getData().add(new XYChart.Data(d.getName(),d.getPieValue())));
        //GraphBarChart.getData().addAll(series,series1);
        GraphBarChart.getData().addAll(series1,series2);
        
//</editor-fold>

    }
    
    public LineChart getLineChart(){
        return this.GraphLinechart;
    }
    
    public ObservableList<PieChart.Data> getObsListData(){
        ObservableList<PieChart.Data> datospiechart = FXCollections.observableArrayList();
            for(int i = 0; i< app.getHist().length;i++){
            datospiechart.add(new PieChart.Data("Dato"+i,app.getHistIndex(i)));
            }
        return datospiechart;
    }

}
