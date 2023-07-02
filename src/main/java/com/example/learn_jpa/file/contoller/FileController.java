package com.example.learn_jpa.file.contoller;

import com.example.learn_jpa.file.service.DBService;
import com.example.learn_jpa.file.service.FileStorageService;
import com.example.learn_jpa.file.model.FileInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequiredArgsConstructor
@RequestMapping("/files")
@CrossOrigin("http://localhost:8081")
@RestController
public class FileController {

    private final FileStorageService service;

    private final DBService dbService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file) {
        String message = "";
        try {
            service.save(file);
            return  "Upload the file successfully: " + file.getOriginalFilename();
        } catch (Exception e) {
            return "Could not upload the file: " + file.getOriginalFilename() +". Error: " + e.getMessage();
        }
    }

    @GetMapping
    public List<FileInfo> getListFiles() {
        Supplier<Stream<Path>> paths = service.loadAll();
        List<FileInfo> ls = new ArrayList<>();
        for (Path path : paths.get().collect(Collectors.toList())) {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, path.getFileName().toString()).build().toString();
//            String url = path.toUri().toString().substring(8);
            ls.add(new FileInfo(filename, url));
        }
        return ls;
    }

    @GetMapping("/{filename:.+}")
    public Resource getFile(@PathVariable String filename) {
        return service.load(filename);
    }

    @PostMapping("/upload-db")
    public String uploadFileDB(@RequestParam("file") MultipartFile file) throws IOException {
        return dbService.saveFile(file);
    }
}
