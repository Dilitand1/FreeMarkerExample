package ru.freemarker.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
        root.put("name", "Freemarker");
        // шаблон
        Template temp = cfg.getTemplate("test.ftl");
        // обработка шаблона и модели данных
        Writer out = new OutputStreamWriter(System.out);
        // вывод в консоль
        temp.process(root, out);
    }

    public void freeMarkerExampleMtemplate() throws IOException, TemplateException {
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

}