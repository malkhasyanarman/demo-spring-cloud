package com.madness.demo.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

public final class FileUtility implements LoggingService {

    private FileUtility() {
    }

    public static String addTimeStamp(Path fileName) {
        String fileNameWithTimestamp = fileName.toString()
                .substring(0, fileName.getFileName().toString().length() - 4);
        fileNameWithTimestamp += "-" + LocalDateTime.now().toString();
        fileNameWithTimestamp += fileName.toString().substring(
                fileName.toString().length() - 4
        );

        return fileNameWithTimestamp;
    }


    public static String getFileName(Path filePath) {
        String[] fileNameParts = filePath.getFileName()
                .toString()
                .split("_");

        StringBuilder fileName = new StringBuilder()
                .append(fileNameParts[0]);

        for (int i = 1; i < fileNameParts.length - 1; i++) {
            fileName.append("_");
            fileName.append(fileNameParts[i]);
        }

        return fileName.toString();
    }

    public static void moveFile(Path sourcePath, Path destinationPath) {
        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.ATOMIC_MOVE);
            log.info("Moved file from {} to {}.", sourcePath, destinationPath);

        } catch (IOException e) {
            log.error("Unable to move file. Error: {}", e.getMessage());
        }
    }

    public static String removeFileExtension(Path fileName) {
        String fileNameWithExtension = fileName.toString();
        return fileNameWithExtension.substring(0, fileNameWithExtension.lastIndexOf('.'));
    }
}
