package edu.cibertec.plantillarest.service;

import edu.cibertec.plantillarest.bean.Pet;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface PetService {
    List<Pet> findAll();
    Pet findById(Long id);
    Pet save(Pet pet);
    void deleteById(Long id);
    byte[] exportPdf() throws JRException, FileNotFoundException;
    byte[] exportPdfPorNombre(String nombre) throws JRException, FileNotFoundException;
    byte[] exportXls() throws JRException, FileNotFoundException;
}
