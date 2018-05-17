/**
 * Controlador para el modelo Proyecto
 *
 * @see: FS.PRAC.FINAL8.model.Proyecto
 * */

package FS.PRAC.FINAL8.controller;

import FS.PRAC.FINAL8.model.Proyecto;
import FS.PRAC.FINAL8.repository.EmpleadoProyectoRepository;
import FS.PRAC.FINAL8.repository.ProyectoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.List;

import static FS.PRAC.FINAL8.controller.RestURIConstants.*;

//@RestController
@Controller
public class ProyectoController {

    /** */
    private static final Logger logger = LoggerFactory.getLogger(ProyectoController.class);

    /**Control de fechas
    SimpleDateFormat sdf = new SimpleDateFormat();
    private Calendar fechaActual; // = Calendar.getInstance();*/

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private EmpleadoProyectoRepository emPre;

    /**
     * Añade un proyecto en la BD, si no existe nadie con su NIF
     * */
    @RequestMapping(value = ADD_PROYECTO, method = RequestMethod.POST)
    @ResponseBody
    public Proyecto addProyecto(
                @RequestBody Proyecto proyecto
            ){
        logger.info("Trying to create a new project");
        logger.info("");
        logger.info("Recived info:");
        logger.info(proyecto.toString());

        String message = "Proyecto: ";

        try{
            if(!proyectoRepository.existsById(proyecto.getIdProyecto())){
                //TODO Verificar campos: fechas ...
                proyectoRepository.save(proyecto);
                message += "AÑADIDO";
            }
            else{
                logger.info("The NIF: '" + proyecto.getIdProyecto() + "' already exists in the system.");
                message += "‘Es obligatorio introducir todos los datos para dar de alta un nuevo proyecto’";
            }

        }catch (Exception e){
            ManErrorControler.showError(logger, e);
        }

        logger.info(message);

        return proyecto;
    }

    /**
     * Inhabilita un proyecto en la BD
     *
     * */
    @RequestMapping(value = DEL_PROYECTO, method = RequestMethod.PUT)
    @ResponseBody
    public boolean delProyecto(
            @RequestBody Proyecto proyecto
    ){
        boolean success = false;

        logger.info("Trying to disable a proyect");
        logger.info("");

        String message = "Proyecto: ";

        try{
            if(!emPre.existsByPk_IdProyecto(proyecto.getIdProyecto())){
                if(proyectoRepository.existsById(proyecto.getIdProyecto())){
                    //TODO Verificar que no pertenzca a ningun proyecto
                    proyecto.setfBaja(Calendar.getInstance());
                    proyectoRepository.save(proyecto);
                    message += "ELIMINADO";
                    success = true;
                }
                else{
                    logger.info("The proyect: '" + proyecto.getIdProyecto() + "' already exists in the system.");
                    message += "NO EXISTE";
                }
            }else{
                logger.info("The proyect: '" + proyecto.getIdProyecto() + "' has employees asigned.");
                message += "‘No se puede dar de baja el proyecto " + proyecto.getTxDescripcion() + "porque tiene\n" +
                        "asignado al menos un recurso’";
            }

        }catch (Exception e){
            ManErrorControler.showError(logger, e);
            message += "FALTAN CAMPOS";
    }

        logger.info(message);

        return success;
    }

    /**
     * Muestra los proyectos cuya F_BAJA sea NULL
     * */
    @RequestMapping(value = GET_PROYECTO, method = RequestMethod.GET)
    @ResponseBody
    public List<Proyecto> getProyecto(){

        logger.info("Showing all proyects");
        logger.info("");

        List<Proyecto> allProyecto = null;

        try{
            allProyecto = proyectoRepository.findAllByFBajaIsNullOrderByFInicio();
//            allProyecto = proyectoRepository.findAll();
        }catch (Exception e){
            ManErrorControler.showError(logger, e);
        }

        return allProyecto;
    }
}
