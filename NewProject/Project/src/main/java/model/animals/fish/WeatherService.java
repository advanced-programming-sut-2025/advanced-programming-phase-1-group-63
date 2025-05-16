package model.animals.fish;

import model.enums.Weather;

/**
 * Provides current weather
 */
class WeatherService {
    public static Weather getCurrentWeather() {
        if (Weather.valueOf("STORM") == Weather.STORM) {
        } else if (Weather.valueOf("RAIN") == Weather.RAIN) {
        } else if (Weather.valueOf("OTHER") == Weather.OTHER) {
        }
        return Weather.SUNNY; // integrate real weather; default SUNNY
    }
}
