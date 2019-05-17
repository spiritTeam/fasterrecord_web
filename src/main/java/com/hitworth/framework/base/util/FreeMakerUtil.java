package com.hitworth.framework.base.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreeMakerUtil {
  private static String FREE_MARKER_TEMP_DIR = ConfigUtil.getConfigContent("config/properties/free_marker",
      "free_marker_temp_dir");
  
  
  public static String format(String temp, String... values) {

    Resource resource = new ClassPathResource(FREE_MARKER_TEMP_DIR);

    Configuration cfg = new Configuration();

    try {
      cfg.setDirectoryForTemplateLoading(resource.getFile());
      cfg.setObjectWrapper(new DefaultObjectWrapper());
      cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
      cfg.setDefaultEncoding("UTF-8");
      Map<String, String> root = new HashMap<String, String>();

      for (int i = 0; i < values.length; i++) {
        root.put("arg" + i, values[i]);
      }

      Template template = cfg.getTemplate(temp);
      StringWriter stringWriter = new StringWriter();
      try {
        template.process(root, stringWriter);
        return stringWriter.toString();
      } catch (TemplateException e) {
        e.printStackTrace();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
