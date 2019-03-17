package com.paralun.app.controller;

import com.paralun.app.dto.FormDataWithFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "form")
public class UploadFormDataController {

    @GetMapping(value = "/formUpload")
    public String data(Model model) {
        model.addAttribute("formDataWithFile", new FormDataWithFile());
        return "form/formUpload";
    }

    @PostMapping(value = "/formUpload")
    public String formUpload(@ModelAttribute FormDataWithFile formDataWithFile, Model model) {
        model.addAttribute("formData", formDataWithFile);
        return "form/formUploadStatus";
    }
}
