package lab3Packages;

import java.util.function.Function;

/**
 * This class provides a Function that converts
 * a temperature from Celsius to Fahrenheit.
 */
public class TemperatureConverter implements Function<Double , Double> { 
            @Override
            public Double apply(Double tempInC) {
                // Convert Celsius to Fahrenheit
                return tempInC * (9.0f / 5.0f) + 32.0f;
            }
        };

