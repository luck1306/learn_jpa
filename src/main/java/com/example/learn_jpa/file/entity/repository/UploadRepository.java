package com.example.learn_jpa.file.entity.repository;

import com.example.learn_jpa.file.entity.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Long> {
}
