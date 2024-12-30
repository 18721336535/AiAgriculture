package com.aiAgriculture.manage.controller;

import com.aiAgriculture.common.core.controller.BaseController;
import com.aiAgriculture.common.core.domain.AjaxResult;
import com.aiAgriculture.manage.dto.FaceDetectResultDto;
import com.aiAgriculture.manage.service.IotService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manage/iot/machine")
public class MachineControlController extends BaseController {
    static String FILE_DIR = "D:\\workspace\\a_ruoyi-vue-projects\\ai_agriculture\\ruoyi3.8.7\\20241027224845\\AiAgriculture\\static_data";
    private static final Logger log = LoggerFactory.getLogger(MachineControlController.class);
    @Autowired
    IotService iotService;

    @GetMapping(value = "/{cmd}")
    public AjaxResult getInfo(@PathVariable("cmd") String cmd) throws MqttException {
        log.info("收到来自ui 的cmd  ：{}", cmd);
        iotService.sendMsgToMqttServer("melon/retained3",cmd);
        return success();
    }


    @GetMapping(value = "/getTemperature")
    public AjaxResult getTemperature() {
        String msg = iotService.getMsgFromCache("L001T01");
        Map<String,String> map = new HashMap<>();
//        JSONObject jsonObject = JSON.parseObject(msg);
//        String jsonOutput = jsonObject.toString();
//        map.put("temperature",jsonOutput);
        map.put("temperature",msg.replaceAll("\\\\","").replaceAll("\"",""));
        map.put("humidity","60");
        map.put("lightIntensity","500");
        map.put("PM25","30");
        map.put("CO2","450");
        map.put("windSpeed","10");
        map.put("pressure","101.325");
        map.put("soilMoisture","70");
        map.put("ultravioletRays","800");
        return success(map);
    }


    @PostMapping("/upload/image")
    public AjaxResult insert(
            @RequestParam("file") MultipartFile file,
            @RequestPart("jsonParam") String jsonParam) throws IOException {
        log.info("ui jsonParam : {}", jsonParam);
        File fle = new File(FILE_DIR + File.separator+"cur.jpg");
        file.transferTo(fle);
        String pythonScriptPath = "D:\\workspace\\a_ruoyi-vue-projects\\ai_agriculture\\ruoyi3.8.7\\20241027224845\\AiAgriculture\\scripts\\faceDetect.py";
        ProcessBuilder pb = new ProcessBuilder("python", pythonScriptPath, FILE_DIR + File.separator+"cur.jpg","other");
        pb.redirectErrorStream(true);
        String line;
        String result = "N";
        FaceDetectResultDto dto = new FaceDetectResultDto(jsonParam,result,"");
        try {
            Process p = pb.start();
            // 读取Python脚本的输出
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = in.readLine()) != null) {
                if(line == "1") result = "Y";
                log.info(line);
            }
            in.close();
            // 等待Python脚本执行完成
            p.waitFor();
            dto.setFaceExist(result);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return success(dto);
    }
}

