package com.example.learn_jpa.file.entity;

import com.example.learn_jpa.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Upload extends BaseIdEntity {

    private String originalName;

    private String savedName;

    private String file;

    @Builder
    public Upload(String originalName, String savedName, String file) {
        this.originalName = originalName;
        this.savedName = savedName;
        this.file = file;
    }
}
