package ru.freemarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.freemarker.config.YAMLConfig;
import ru.freemarker.service.TemplateService;


@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    TemplateService templateService;

    @Autowired
    private YAMLConfig myConfig;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------YAML CONFIG-------------");
        System.out.println("using environment: " + myConfig.getEnvironment());
        System.out.println("name: " + myConfig.getName());
        System.out.println("enabled:" + myConfig.isEnabled());
        System.out.println("servers: " + myConfig.getServers());

        System.out.println();
        System.out.println("-------------freeMarkerExampleTest-------------");
        templateService.freeMarkerExampleTest();
        System.out.println();
        System.out.println("-------------freeMarkerExampleMtemplate-------------");
        templateService.freeMarkerExampleMtemplate();

        System.out.println("-------------freeMarkerExampleDevs-------------");
        templateService.freeMarkerExampleDevs();
    }
}
