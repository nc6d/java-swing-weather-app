
package weather.forecast.main;

import javax.json.JsonValue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SelectCityListener implements ActionListener{
    private ArrayList<String> list_selection;
    private MainMenuFrame frame;
    private JList<String> list_city;
    
    public SelectCityListener(MainMenuFrame frame, ArrayList<String> list_selection, JList<String> list_city){
        this.list_selection = list_selection;
        this.frame = frame;
        this.list_city = list_city;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int idxCity = findIdxCity();
        setSelectedCity(idxCity);
        frame.getCityResultDialog().setVisible(false);
        frame.initializeCurrentWeatherDialog();
        frame.getCurrentWeatherDialog().setVisible(true);
        
        
    }
    
    private int findIdxCity(){
        int idxCity = 0;
        for (String el : list_selection){
            if (el.equals(list_city.getSelectedValue())){
                break;
            }
            idxCity++;
        }
        return idxCity;
    }
    
    private void setSelectedCity(int idxCity){
        frame.setCurrSelectedCity(frame.getDataCurrWeather().getJsonObject(idxCity));
        int id_city = frame.getDataCurrWeather().getJsonObject(idxCity).getInt("id");
        for (JsonValue obj : frame.getDataForecastWeather()){
            if (obj.asJsonObject().getJsonObject("city").getInt("id") == id_city){
                frame.setForecastSelectedCity(obj.asJsonObject());
                break;
            }
        }
    }
}
