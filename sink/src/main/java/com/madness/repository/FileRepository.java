package com.madness.repository;

import com.madness.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<FileEntity, Long> {

}
