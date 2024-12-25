package com.aiAgriculture.manage.service;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface IotService {
    public void sendMsgToMqttServer(String topic, String msg) throws MqttException;
    public String getMsgFromCache(String key);
}
