package com.miyani.sample.spring.boot.jpa.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FILE_INFO", indexes = { @Index(columnList = "FILE_NAME") })
public class FileInfo
{
    @Id
    @Column(name = "FILE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    public UUID getId() {
        return id;
    }

    @Column(name = "ORG_FILE_NAME")
    private String originalFileName;
    public String getOriginalFileName() {
        return originalFileName;
    }
    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    @Column(name = "FILE_NAME")
    private String fileName;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Lob
    @Column(name = "CONTENTS")
    private byte[] contents;
    public byte[] getContents() {
        return contents;
    }
    public void setContents(byte[] contents) {
        this.contents = contents;
    }
}
