package com.noirix.service;

import java.io.IOException;

public interface AmazonUploadingFileService {
    String uploadFile(byte[] imageBytes, Long userId) throws IOException;
}

