package com.madness.service;

import com.madness.demo.dto.TextDataWrapper;
import com.madness.demo.utility.LoggingService;
import com.madness.entity.FileEntity;
import com.madness.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EntityService implements LoggingService {
    private final FileRepository fileRepository;

    public void process(TextDataWrapper object) {
        FileEntity fileEntity = new FileEntity();

        fileEntity.setName(object.getFileName());
        fileEntity.setDescription(object.getData());
        fileEntity.setUpdateDate(LocalDateTime.now().toString());

        fileRepository.save(fileEntity);
    }
}
