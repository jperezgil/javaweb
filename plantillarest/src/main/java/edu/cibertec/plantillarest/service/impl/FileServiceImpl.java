/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.plantillarest.service.impl;

import edu.cibertec.plantillarest.service.FileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jpere
 */
@Service
public class FileServiceImpl implements FileService {
    private final Map<String, byte[]> fileStorage = new HashMap<>();

    public void saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        byte[] fileBytes = file.getBytes();
        fileStorage.put(fileName, fileBytes);
    }

    public byte[] getFileByName(String fileName) {
        return fileStorage.get(fileName);
    }
    // @Value("${file.dir}")
    // private String dir;
    // public void saveFile(MultipartFile file) throws IOException {
    // String fileName = file.getOriginalFilename();
    // Path filePath = Path.of(dir, fileName); // AQUI MODIFICAR
    //
    // // Asegurarse de que la carpeta de destino exista o crearla si no existe
    // File destFolder = new ClassPathResource(dir).getFile();
    // if (!destFolder.exists()) {
    // destFolder.mkdirs();
    // }
    //
    // // Copiar el archivo al directorio de destino
    // Files.copy(file.getInputStream(), filePath,
    // StandardCopyOption.REPLACE_EXISTING);
    // }
    //
    // public byte[] getFileByName(String fileName) {
    // try {
    // Path filePath = Path.of(dir, fileName);
    // return Files.readAllBytes(filePath);
    // } catch (IOException e) {
    // e.printStackTrace();
    // return null;
    // }
    // }
}
