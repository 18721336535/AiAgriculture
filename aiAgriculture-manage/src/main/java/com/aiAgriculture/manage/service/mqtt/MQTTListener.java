package com.aiAgriculture.manage.service.mqtt;
import com.aiAgriculture.common.core.redis.RedisCache;
import com.aiAgriculture.manage.utils.Callback;
import com.aiAgriculture.manage.utils.MQTTConnect;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 项目启动 监听主题
 *
 * @author
 * @since
 */
@Component
public class MQTTListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger log = LoggerFactory.getLogger(MQTTListener.class);
    private final MQTTConnect serverClient;
    @Autowired
    private RedisCache redisCache;

    @Autowired
    public MQTTListener(MQTTConnect serverClient) {
        this.serverClient = serverClient;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            serverClient.setMqttClient("melon", "password2", new Callback(redisCache));
            serverClient.sub("melon/Wendu");
        } catch (MqttException e) {
            log.error(e.getMessage(), e);
        }
    }

    public MQTTConnect getServerClient() {
        return serverClient;
    }
}
