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
    private BarChart<?, ?> GraphBarChart;
    @FXML
    private PieChart GraphPieChart;
    private App app;
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
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Nº Dato aleatorio");
        GraphLinechart = new LineChart<>(xAxis,yAxis);
        GraphLinechart.setTitle("Datos de caracter aleatorio");
        XYChart.Series series = new XYChart.Series();
        series.setName("Mis datos");
        this.getObsListData().forEach(d-> series.getData().add(new XYChart.Data(d.getName(),d.getPieValue())));
        GraphLinechart.getData().add(series);
        //</editor-fold>

    }
    
    public ObservableList<PieChart.Data> getObsListData(){
        ObservableList<PieChart.Data> datospiechart = FXCollections.observableArrayList();
            for(int i = 0; i< app.getHist().length;i++){
            datospiechart.add(new PieChart.Data("Dato"+i,app.getHistIndex(i)));
            }
        return datospiechart;
    }

}
