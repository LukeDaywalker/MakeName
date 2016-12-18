package com.luke.makename.util;

import com.google.common.io.Resources;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by LukeSkywalker on 2016/12/16.
 */
public class Util {

    public static File findResource(String resource) throws URISyntaxException {
        URL resUrl = Resources.getResource(resource);
        return new File(resUrl.toURI());
    }
}
