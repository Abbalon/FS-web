package FS.PRAC.FINAL8.repository;

import FS.PRAC.FINAL8.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    /**
     * Muestra todos proyectos con F_BAJA igual a NULL
     * */
    List<Proyecto> findAllByFBajaIsNullOrderByFInicio();

    /**
     * Devuelve si el proyecto tiene fecha de baja o está fianlizado*/
    boolean existsByIdProyectoAndFBajaIsNullAndFFinIsNull(int idProyecto);

    /**Devuelve el proecto con esa id*/
    Proyecto getProyectoByIdProyecto(int idProyecto);


}
