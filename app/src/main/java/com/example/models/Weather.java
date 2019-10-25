package com.example.models;

public class Weather {

    private int temperature;
    private Integer humidity;
    private String description;
    private City city;

    public Integer getTemperature() {

        return temperature;
    }

    public void setTemperature(Integer temperature) {

        this.temperature = temperature;
    }

    public Integer getHumidity() {

        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }
}
