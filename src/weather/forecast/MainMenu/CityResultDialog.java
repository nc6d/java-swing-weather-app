
package weather.forecast.MainMenu;

import weather.forecast.DetailedCity.DateSelectionPanel;
import weather.forecast.main.MainMenuFrame;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.ArrayList;
import javax.swing.*;


public class CityResultDialog extends javax.swing.JDialog {

    private JList<String> cityList;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JButton selectBtn;

    public CityResultDialog(MainMenuFrame parent, boolean modal) {
        super(parent, modal);
        currData = parent.getDataCurrWeather();
        initComponents();
        ArrayList<String> li = new ArrayList<>();
        if (currData != null) {
            for (JsonValue el : currData) {
                String listval = el.asJsonObject().getString("name");
                listval += " (" + el.asJsonObject().getJsonObject("coord").getInt("lon");
                listval += ", " + el.asJsonObject().getJsonObject("coord").getInt("lat") + ")";

                li.add(listval);
            }
        }
        String[] strs = new String[li.size()];
        li.toArray(strs);
        cityList.setModel(new AbstractListModel<>() {
            String[] strings = strs;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        parent.initializeSelectCityListener(li, cityList);
        selectBtn.addActionListener(parent.getSelectCityListener());
        setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cityList = new javax.swing.JList<>();
        selectBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select a City");

        cityList.setBackground(new java.awt.Color(250, 250, 250));
        cityList.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        DateSelectionPanel.setModelAndViewportView(cityList, jScrollPane1);

        selectBtn.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        selectBtn.setText("Select");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(103, 103, 103)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(138, 138, 138)
                                                .addComponent(selectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(selectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private JsonArray currData;

    public JsonArray getCurrData() {
        return currData;
    }

    public void setCurrData(JsonArray currData) {
        this.currData = currData;
    }

    private JsonArray forecastData;

    public JsonArray getForecastData() {
        return forecastData;
    }

    public void setForecastData(JsonArray forecastData) {
        this.forecastData = forecastData;
    }


}
