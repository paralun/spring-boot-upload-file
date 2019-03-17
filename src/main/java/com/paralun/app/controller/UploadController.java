package com.paralun.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    private static String UPLOADED_PATH = "D://UploadImage//";

    @GetMapping(value = "/")
    public String index(Model model) {
        return "upload";
    }

    @PostMapping(value = "/upload")
    public String singleUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if(file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_PATH + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename());
        }catch (IOException e){}
        return "redirect:/uploadStatus";
    }

    @GetMapping(value = "/multipartUpload")
    public String multiUpload(){
        return "multipartUpload";
    }

    @PostMapping(value = "/multipartUpload")
    public String multipartUpload(@RequestParam("files") MultipartFile[] files, RedirectAttributes rd) {
        for(MultipartFile file : files) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_PATH + file.getOriginalFilename());
                Files.write(path, bytes);
            }catch (IOException e){}
        }
        rd.addFlashAttribute("files", files);
        return"redirect:/multipartUploadStatus";
    }

    @GetMapping(value = "/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @GetMapping(value = "/multipartUploadStatus")
    public String multipartUploadStatus() {
        return "multipartUploadStatus";
    }
}
