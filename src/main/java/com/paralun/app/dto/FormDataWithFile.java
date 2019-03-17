package com.paralun.app.dto;

import org.springframework.web.multipart.MultipartFile;

public class FormDataWithFile {

    private String nama;
    private String email;
    private MultipartFile photo;

    public FormDataWithFile() {
    }

    public FormDataWithFile(String nama, String email, MultipartFile photo) {
        this.nama = nama;
        this.email = email;
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
