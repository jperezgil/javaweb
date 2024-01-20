package edu.cibertec.plantillarest.repository;


import edu.cibertec.plantillarest.bean.Pet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    // Método personalizado para buscar un cliente por su ID utilizando una consulta SQL
    @Query(value = "SELECT * FROM pet WHERE name LIKE CONCAT('%', :nombre,'%' )", nativeQuery = true)
    List<Pet> ObtenerPetsPorNombre(@Param("nombre") String nombre);
    
}
