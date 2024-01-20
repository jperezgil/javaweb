/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.cibertec.plantillarest.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jpere
 */
public interface FileService {
    public void saveFile(MultipartFile file) throws IOException;
    public byte[] getFileByName(String fileName);
}
