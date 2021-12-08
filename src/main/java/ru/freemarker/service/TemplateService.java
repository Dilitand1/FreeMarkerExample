package ru.freemarker.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.freemarker.model.Product;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

@Service
public class TemplateService {

    //Конфигурация
    @Qualifier("ConfigTemplate")
    @Autowired
    Configuration cfg;

    public void freeMarkerExampleTest() throws IOException, TemplateException {
        // модель данных
        Map<String, Object> root = new HashMap<>();
        //треугольные скобки <>
        root.put("name", "Freemarker");
        root.put("configFpName", "ИМЯ ЕСТЬ");

        //todo dot нотации - не работает
        //root.put("configFpName.second", "ДОТ НОТАЦИИ");

        // шаблон
        Template temp = cfg.getTemplate("test.ftl");
        // обработка шаблона и модели данных
        Writer out = new OutputStreamWriter(System.out);
        // вывод в консоль
        temp.process(root, out);
    }

    public void freeMarkerExampleMtemplate() {
        // модель данных
        Map<String, Object> root = new HashMap<>();
        // для ${name}
        root.put("name", "Fremarker");

        // для <#list persons
        List<List> persons = new ArrayList<>();
        persons.add(Arrays.asList("Alexander", "Petrov", 47));
        persons.add(Arrays.asList("Slava", "Petrov", 13));
        root.put("persons", persons);

        try {
            Template template = cfg.getTemplate("mtemplate.ftl");
            Writer out = new OutputStreamWriter(System.out);
            try {
                template.process(root, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void freeMarkerExampleDevs() throws IOException, TemplateException {
        //Устанавливаем синтаксис квадратных скобок (работают или []  или <>  вместе нет)
        cfg.setInterpolationSyntax(Configuration.SQUARE_BRACKET_INTERPOLATION_SYNTAX);
        cfg.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);

        /* Create a data-model */
        Map root = new HashMap();

        root.put("user", "Big Joe");
        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");
        latest.setServiceName("serviceName");
        root.put("latestProduct", latest);

        root.put("serviceName2","asdasd");

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("devs.ftl");

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }

}