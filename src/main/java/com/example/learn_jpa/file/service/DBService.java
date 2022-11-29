package com.example.learn_jpa.file.service;

import com.example.learn_jpa.file.entity.Upload;
import com.example.learn_jpa.file.entity.repository.UploadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DBService {

    private final UploadRepository repository;

    private final String path = "C:/testStorage/";

    @PostConstruct
    public void init() throws IOException {
        try {
            Path p = Paths.get(path);
            Files.createDirectories(p);
        } catch (IOException e) {
            throw new RuntimeException("Failed making local directory for saving multipart data");
        }
    }

    @PreDestroy
    public void destroy() throws IOException {
        try {
            Path p = Paths.get(path);
            FileSystemUtils.deleteRecursively(p);
        } catch (IOException e) {
            throw new RuntimeException("Failed remove local directory for saving multipart data");
        }
    }

    public String saveFile(MultipartFile file) throws IOException {
        try {
            if (file.isEmpty()) return null;

            String orgName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String extension = orgName.substring(orgName.lastIndexOf("."));
            String savedName = uuid + extension;
            Upload u = Upload.builder()
                    .originalName(orgName)
                    .savedName(savedName)
                    .file(path + savedName)
                    .build();
            file.transferTo(new File(path + savedName));
            repository.save(u);
            return "Successfully saving data";
        } catch (IOException e) {
            return "IOException happen" + e.getMessage();
        }
    }
}
