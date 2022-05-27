
package weather.forecast.DetailedCity;

import javax.swing.*;

import weather.forecast.main.MainMenuFrame;

public class CurrentWeatherDialog extends JDialog {

    private JButton forecastWeatherBtn;
    private JPanel jPanel1;
    private MainMenuFrame frame;

    public CurrentWeatherDialog(MainMenuFrame frame, boolean modal) {
        super(frame, modal);
        this.frame = frame;
        initComponents();
        frame.initializeForecastWeatherClickListener();
        forecastWeatherBtn.addActionListener(frame.getForecastWeatherClickListener());
        setVisible(false);
    }


    private void initComponents() {

        jPanel1 = new WeatherDetailPanel(frame.getCurrSelectedCity(), frame.getCurrSelectedCity().getString("name"));
        forecastWeatherBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        forecastWeatherBtn.setText("Forecast Weather");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(forecastWeatherBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forecastWeatherBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }


}
