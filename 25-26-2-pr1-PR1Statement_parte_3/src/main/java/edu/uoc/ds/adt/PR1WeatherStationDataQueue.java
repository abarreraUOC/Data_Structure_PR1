package edu.uoc.ds.adt;

import edu.uoc.ds.adt.model.WeatherStationData;
import edu.uoc.ds.adt.model.WeatherStationDataSummaryItem;
import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.traversal.Iterator;

public class PR1WeatherStationDataQueue {

    public final int CAPACITY;

    private final Queue<WeatherStationData> queue;
    private final int[] years;
    private final WeatherStationDataSummaryItem[] summaryItems;

    public PR1WeatherStationDataQueue() {
        this(10, new int[0]);
    }

    public PR1WeatherStationDataQueue(int capacity, int[] years) {
        this.CAPACITY = capacity;
        this.queue = new QueueArrayImpl<>(capacity);

        this.years = new int[years.length];
        this.summaryItems = new WeatherStationDataSummaryItem[years.length];

        for (int i = 0; i < years.length; i++) {
            this.years[i] = years[i];
            this.summaryItems[i] = new WeatherStationDataSummaryItem(years[i]);
        }
    }

    public Queue<WeatherStationData> getQueue() {
        return this.queue;
    }

    public void add(WeatherStationData weatherData) {
        this.queue.add(weatherData);
        updateYearSummary(weatherData);
    }

    private void updateYearSummary(WeatherStationData weatherData) {
        int year = weatherData.getLastUpdated().getYear();

        for (int i = 0; i < years.length; i++) {
            if (years[i] == year) {
                summaryItems[i].add(weatherData);
                return;
            }
        }
    }

    public double getMeanPrecipitation() {
        if (this.queue.isEmpty()) return 0.0;

        double sum = 0.0;
        int count = 0;

        Iterator<WeatherStationData> it = this.queue.values();
        while (it.hasNext()) {
            WeatherStationData data = it.next();
            sum += data.getPrecipitation();
            count++;
        }

        return count == 0 ? 0.0 : sum / count;
    }

    public double getMeanAvgAirTemperature() {
        if (this.queue.isEmpty()) return 0.0;

        double sum = 0.0;
        int count = 0;

        Iterator<WeatherStationData> it = this.queue.values();
        while (it.hasNext()) {
            WeatherStationData data = it.next();
            sum += data.getAvgAirTemperature();
            count++;
        }

        return count == 0 ? 0.0 : sum / count;
    }

    public WeatherStationDataSummaryItem getWeatherStationDataSummaryItem(int year) {
        for (int i = 0; i < years.length; i++) {
            if (years[i] == year) {
                return summaryItems[i];
            }
        }
        return null;
    }
}