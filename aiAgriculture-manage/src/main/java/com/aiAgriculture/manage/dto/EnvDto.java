package com.aiAgriculture.manage.dto;

public class EnvDto {
    private  String potId = "L001T01";
    private  String temperature;
    private  String humidity = "60";
    private  String lightIntensity = "500";
    private  String PM25 = "30";
    private  String CO2 = "450";
    private  String windSpeed ="10";
    private  String pressure = "101.325";
    private  String soilMoisture = "70";
    private  String ultravioletRays = "800";

    public String getPotId() {
        return potId;
    }

    public void setPotId(String potId) {
        this.potId = potId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(String lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public String getPM25() {
        return PM25;
    }

    public void setPM25(String PM25) {
        this.PM25 = PM25;
    }

    public String getCO2() {
        return CO2;
    }

    public void setCO2(String CO2) {
        this.CO2 = CO2;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(String soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public String getUltravioletRays() {
        return ultravioletRays;
    }

    public void setUltravioletRays(String ultravioletRays) {
        this.ultravioletRays = ultravioletRays;
    }

}
