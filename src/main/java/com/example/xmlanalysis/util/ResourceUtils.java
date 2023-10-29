package com.example.xmlanalysis.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

public class ResourceUtils {
    private static final ResourceLoader resourceLoader = new DefaultResourceLoader();

    public static InputStream getFileInputStream(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource(filePath);
        return resource.getInputStream();
    }
}
