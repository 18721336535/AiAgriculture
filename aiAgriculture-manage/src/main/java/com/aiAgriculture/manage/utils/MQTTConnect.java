package com.aiAgriculture.manage.utils;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

/**
 * MQTT工具类操作
 *
 * @author
 * @since v1.1.0 2020-01-10
 */
@Component
public class MQTTConnect {

    private String HOST = "tcp://127.0.0.1:1883"; //mqtt服务器的地址和端口号
    private final String clientId = "DC" + (int) (Math.random() * 100000000);
    private MqttClient mqttClient;

    /**
     * 客户端connect连接mqtt服务器
     *
     * @param userName     用户名
     * @param passWord     密码
     * @param mqttCallback 回调函数
     **/
    public void setMqttClient(String userName, String passWord, MqttCallback mqttCallback) throws MqttException {
        MqttConnectOptions options = mqttConnectOptions(userName, passWord);
        if (mqttCallback == null) {
            mqttClient.setCallback(new Callback());
        } else {
            mqttClient.setCallback(mqttCallback);
        }
        mqttClient.connect(options);
    }

    /**
     * MQTT连接参数设置
     */
    private MqttConnectOptions mqttConnectOptions(String userName, String passWord) throws MqttException {
        mqttClient = new MqttClient(HOST, clientId, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName("melon");
        options.setPassword("password2".toCharArray());
        options.setConnectionTimeout(10);///默认：30
        options.setAutomaticReconnect(true);//默认：false
        options.setCleanSession(false);//默认：true
        //options.setKeepAliveInterval(20);//默认：60
        return options;
    }

    /**
     * 关闭MQTT连接
     */
    public void close() throws MqttException {
        mqttClient.close();
        mqttClient.disconnect();
    }

    /**
     * 向某个主题发布消息 默认qos：1
     *
     * @param topic:发布的主题
     * @param msg：发布的消息
     */
    public void pub(String topic, String msg) throws MqttException {
        MqttMessage mqttMessage = new MqttMessage();
        //mqttMessage.setQos(2);
        mqttMessage.setPayload(msg.getBytes());
        MqttTopic mqttTopic = mqttClient.getTopic(topic);
        MqttDeliveryToken token = mqttTopic.publish(mqttMessage);
        token.waitForCompletion();
    }

    /**
     * 向某个主题发布消息
     *
     * @param topic: 发布的主题
     * @param msg:   发布的消息
     * @param qos:   消息质量    Qos：0、1、2
     */
    public void pub(String topic, String msg, int qos) throws MqttException {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(qos);
        mqttMessage.setPayload(msg.getBytes());
        MqttTopic mqttTopic = mqttClient.getTopic(topic);
        MqttDeliveryToken token = mqttTopic.publish(mqttMessage);
        token.waitForCompletion();
    }

    /**
     * 订阅某一个主题 ，此方法默认的的Qos等级为：1
     *
     * @param topic 主题
     */
    public void sub(String topic) throws MqttException {
        mqttClient.subscribe(topic);
    }

    /**
     * 订阅某一个主题，可携带Qos
     *
     * @param topic 所要订阅的主题
     * @param qos   消息质量：0、1、2
     */
    public void sub(String topic, int qos) throws MqttException {
        mqttClient.subscribe(topic, qos);
    }

    /**
     * main函数自己测试用
     */
//    public static void main(String[] args) throws MqttException {
//        MQTTConnect mqttConnect = new MQTTConnect();
//        mqttConnect.setMqttClient("admin", "public", new Callback());
//        mqttConnect.sub("com/iot/init");
//        mqttConnect.pub("com/iot/init", "Mr.Qu" + (int) (Math.random() * 100000000));
//    }
}