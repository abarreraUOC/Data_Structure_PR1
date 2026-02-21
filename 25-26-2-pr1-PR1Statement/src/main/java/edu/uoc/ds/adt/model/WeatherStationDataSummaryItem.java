package edu.uoc.ds.adt.model;

public class WeatherStationDataSummaryItem {

    private final int year;
    private int rows;
    private double accumulatedPrecipitation;
    private double accumulatedAvgAirTemperature;

    public WeatherStationDataSummaryItem(int year) {
        this.year = year;
        this.rows = 0;
        this.accumulatedPrecipitation = 0.0;
        this.accumulatedAvgAirTemperature = 0.0;
    }

    public void add(WeatherStationData data) {
        rows++;
        accumulatedPrecipitation += data.getPrecipitation();
        accumulatedAvgAirTemperature += data.getAvgAirTemperature();
    }

    public int getYear() {
        return year;
    }

    public int numRows() {
        return rows;
    }

    public double getAccumulatedPrecipitation() {
        return accumulatedPrecipitation;
    }

    public double getMeanAvgAirTemperature() {
        return rows == 0 ? 0.0 : accumulatedAvgAirTemperature / rows;
    }
}