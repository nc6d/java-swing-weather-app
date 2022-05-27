
package weather.forecast.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ForecastWeatherClickListener implements ActionListener {
    private MainMenuFrame frame;

    public ForecastWeatherClickListener(MainMenuFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.initializeForecastWeatherDialog();
        frame.getForecastWeatherDialog().setVisible(true);
    }

}
