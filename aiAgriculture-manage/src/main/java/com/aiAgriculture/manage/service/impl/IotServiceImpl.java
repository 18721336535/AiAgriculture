package com.aiAgriculture.manage.service.impl;

import com.aiAgriculture.manage.service.IotService;
import com.aiAgriculture.manage.service.mqtt.MQTTListener;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class IotServiceImpl implements IotService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private MQTTListener mqtTListener;
    @Override
    public void sendMsgToMqttServer(String topic, String msg) throws MqttException {
        mqtTListener.getServerClient().pub(topic, msg);
    }

    @Override
    public String getMsgFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
