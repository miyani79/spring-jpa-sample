package com.miyani.sample.spring.boot.jpa.dto;

import java.util.Arrays;
import java.util.Objects;

public class FileInfoDTO
{
    private String fileName;
    private String originalFileName;
    private String contentType;
    private byte[] contents;
    private long size;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileInfoDTO that = (FileInfoDTO) o;
        return size == that.size &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(originalFileName, that.originalFileName) &&
                Objects.equals(contentType, that.contentType) &&
                Arrays.equals(contents, that.contents);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fileName, originalFileName, contentType, size);
        result = 31 * result + Arrays.hashCode(contents);
        return result;
    }

    @Override
    public String toString() {
        return "FileInfoDTO{" +
                "name='" + fileName + '\'' +
                ", originalFilename='" + originalFileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", contents=" + Arrays.toString(contents) +
                ", size=" + size +
                '}';
    }
}
