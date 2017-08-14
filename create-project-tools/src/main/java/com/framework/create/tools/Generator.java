package com.framework.create.tools;

import com.framework.create.tools.logic.CreateProjectGenerator;
import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;

public class Generator {
    private static Configuration config;

    static {
        if (null == config) {
            config = new Configuration();
            try {
                String filePath = Generator.class.getResource("/").getPath().replaceAll("%20", " ") + "template";
                config.setDirectoryForTemplateLoading(new File(filePath));
                config.setDefaultEncoding("UTF-8");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            CreateProjectGenerator.genaratorEntity(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
