package com.api_file_upload.app.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "X:\\FileUpload\\src\\main\\resources\\static\\uploads";

    public boolean uploadFile(MultipartFile multipart) {
        boolean f = false;
        try {
//            //creating a input stream of that multipart file.
//            InputStream is = multipart.getInputStream();
//
//            //now we need to read this input stream and write it on that UPLOAD_DIR path
//            byte data[] = new byte[is.available()];  // byte array will be of size same as input stream
//            is.read(data); //Reads some number of bytes from the input stream and stores them into the buffer array b. The number of bytes actually read is returned as an integer. This method blocks until input data is available, end of file is detected, or an exception is thrown
//
//            // write
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+ File.separator + multipart.getOriginalFilename());
//            fos.write(data);
//
//            fos.close();
//            fos.flush();

//            one line code by using java.nio
            Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + multipart.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);


            f = true;
        } catch(Exception e) {
            e.printStackTrace();
        }


        return f;
    }
}
