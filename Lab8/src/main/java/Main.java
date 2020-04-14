import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String Args[]) throws IOException, TemplateException {
        ChartController chartController = new ChartController();
        ArrayList<Chart> listaChart = new ArrayList<>();
        listaChart = chartController.getChart();
        //System.out.println(listaChart);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File("/Users/remusbulboaca/Desktop/topjava"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        Map<String,Object> root = new HashMap<>();
        root.put("charts",listaChart);
        Template temp = cfg.getTemplate("test.ftlh");
        Writer console = new OutputStreamWriter(System.out);
        temp.process(root,console);
        console.flush();
        Writer file = new FileWriter(new File("/Users/remusbulboaca/Desktop/topjava/index.html"));
        temp.process(root,file);
        file.flush();
        file.close();



    }
}
