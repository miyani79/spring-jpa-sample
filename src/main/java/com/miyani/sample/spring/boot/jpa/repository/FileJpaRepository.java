package com.miyani.sample.spring.boot.jpa.repository;

import com.miyani.sample.spring.boot.jpa.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileJpaRepository extends JpaRepository<FileInfo, UUID> {
}
