package com.example.learn_jpa.file.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileInfo {
    private String name;
    private String url;

    @Builder
    public FileInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
