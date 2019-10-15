package org.yann.icloud.movie.feign.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MovieController {

    @Autowired
    private UploadFeignClient uploadFeignClient;

    @GetMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file) throws Exception {
        return this.uploadFeignClient.handlerFileUpload(file);
    }

}
