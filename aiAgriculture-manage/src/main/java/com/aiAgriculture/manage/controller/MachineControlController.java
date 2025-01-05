package com.aiAgriculture.manage.controller;

import com.aiAgriculture.common.core.controller.BaseController;
import com.aiAgriculture.common.core.domain.AjaxResult;
import com.aiAgriculture.manage.dto.EnvDto;
import com.aiAgriculture.manage.dto.FaceDetectResultDto;
import com.aiAgriculture.manage.service.IotService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/manage/iot/machine")
public class MachineControlController extends BaseController {
    static String FILE_DIR = "D:\\workspace\\a_ruoyi-vue-projects\\ai_agriculture\\ruoyi3.8.7\\20241027224845\\AiAgriculture\\static_data";
    static String PYTHON_SCRIPT_PATH = "D:\\workspace\\a_ruoyi-vue-projects\\ai_agriculture\\ruoyi3.8.7\\20241027224845\\AiAgriculture\\scripts\\faceDetect.py";

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
        EnvDto envdto = new EnvDto();
        envdto.setTemperature(msg.replaceAll("\\\\","").replaceAll("\"",""));
        return success(envdto);
    }


    @PostMapping("/upload/image")
    public AjaxResult insert(
            @RequestParam("file") MultipartFile file,
            @RequestPart("jsonParam") String jsonParam) throws IOException {
        File fle = new File(FILE_DIR + File.separator+"cur.jpg");
        file.transferTo(fle);
        ProcessBuilder pb = new ProcessBuilder("python", PYTHON_SCRIPT_PATH, FILE_DIR + File.separator + "cur.jpg", "other");
        pb.redirectErrorStream(true);
        String line;
        FaceDetectResultDto dto = new FaceDetectResultDto(jsonParam,"N","");
        try {//执行Python脚本,进行人脸识别
            Process p = pb.start();
            // 读取Python脚本的输出
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = in.readLine()) != null) {
                if( "1".equals(line.replaceAll("\\n", ""))) {
                    dto.setFaceExist("Y");
                }
            }
            in.close();
            // 等待Python脚本执行完成
            p.waitFor();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return success(dto);
    }
}

