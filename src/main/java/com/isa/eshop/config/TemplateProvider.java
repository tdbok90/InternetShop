package com.isa.eshop.config;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TemplateProvider {

    private static final Logger LOG = Logger.getLogger(TemplateProvider.class.getName());

    private static final String TEMPLATES_DIRECTORY_PATH = "fm-templates";
    private static final String TEMPLATE_EXT = ".ftlh";

    public static Template createTemplate(ServletContext servletContext, String templateName){
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATES_DIRECTORY_PATH);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);

        try {
            return configuration.getTemplate(templateName + TEMPLATE_EXT);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Could not create template: " + templateName, e);
            throw new IllegalStateException(e);
        }
    }

}
