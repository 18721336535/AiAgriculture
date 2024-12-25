import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class TestPython {
    public static void main(String[] args) {
        // Python脚本名为script.py
        String pythonScriptPath = "D:\\workspace\\a_ruoyi-vue-projects\\ai_agriculture\\ruoyi3.8.7\\20241027224845\\AiAgriculture\\scripts\\faceDetect.py";

        // 传递给Python脚本的参数
//        String arg1 = "D:/workspace/a_ruoyi-vue-projects/ai_agriculture/ruoyi3.8.7/20241027224845/AiAgriculture/scripts/face1.jpg";
        String arg1 = "D:\\workspace\\a_ruoyi-vue-projects\\ai_agriculture\\ruoyi3.8.7\\20241027224845\\AiAgriculture\\static_data\\cur.jpg";
        String arg2 = "D:\\workspace\\a_ruoyi-vue-projects\\ai_agriculture\\ruoyi3.8.7\\20241027224845\\AiAgriculture\\static_data\\hdImg.jpg";

        ProcessBuilder pb = new ProcessBuilder("python", pythonScriptPath, arg2,arg1);
        pb.redirectErrorStream(true);

        try {
            Process p = pb.start();

            // 读取Python脚本的输出
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();

            // 等待Python脚本执行完成
            p.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
