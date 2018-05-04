package com.jw.api;

import java.io.File;
import java.io.InputStream;

public interface MaterialApi {
    String IMAGE = "image";
    String VOICE = "voice";
    String VIDEO = "video";
    String THUMB = "thumb";

    String addTempMedia(String mediaType, File file);

    String getTempMedia(String meidaId);

}
