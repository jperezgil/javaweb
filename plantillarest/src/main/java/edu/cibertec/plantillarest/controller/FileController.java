package edu.cibertec.plantillarest.controller;
/**
 *
 * @author jpere
 */
import edu.cibertec.plantillarest.service.FileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//Para costruir un cargador de archivos
@RestController
@RequestMapping("/files")
@Tag(name = "File", description = "Api para cargar archivos")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.saveFile(file);
            return ResponseEntity.status(HttpStatus.OK).body("Archivo cargado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al cargar el archivo.");
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        byte[] fileContent = fileService.getFileByName(fileName);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                .body(fileContent);
    }
}

