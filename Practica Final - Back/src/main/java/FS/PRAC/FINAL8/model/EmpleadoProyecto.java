/**
 * El modelo sigue la siguiente estrctura SQL
 * <p>
 * CREATE TABLE PRACTICA.PR_EMPLEADOS_PROYECTO
 * (
 * ID_PROYECTO 				INT(5) NOT NULL,
 * ID_EMPLEADO 				INT(7) NOT NULL,
 * F_ALTA					DATE,
 * CONSTRAINT PK_PR_EMPLEADOS_PROYECTO PRIMARY KEY (ID_PROYECTO, ID_EMPLEADO)
 * );
 */
package FS.PRAC.FINAL8.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "PR_EMPLEADOS_PROYECTO")
public class EmpleadoProyecto {

     /**
     * Default void constructor
     * */
    public EmpleadoProyecto() {
    }

    /**Custom contructor*/
    public EmpleadoProyecto(EmpleadoProyectoPK pk, Empleado empleado, Proyecto proyecto, Calendar fAlta) {
        this.pk = pk;
        this.empleado = empleado;
        this.proyecto = proyecto;
        this.fAlta = fAlta;
    }

    /**
     *PRIMARY_KEY
     * */
    @Id
    @EmbeddedId
    private EmpleadoProyectoPK pk;

    @Column(name = "f_Alta")
    private Calendar fAlta;

    /**Resolucion de claves foraneas*/

    /**Empleado*/
//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_Empleado", insertable = false, updatable = false)
    private Empleado empleado;

    /**Proyecto*/
//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_Proyecto", insertable = false, updatable = false)
    private Proyecto proyecto;

    /**
     * Getters & Setters
     * */
    public EmpleadoProyectoPK getPk() {
        return pk;
    }

    public void setPk(EmpleadoProyectoPK pk) {
        this.pk = pk;
    }

    public Calendar getfAlta() {
        return fAlta;
    }

    public void setfAlta(Calendar fAlta) {
        this.fAlta = fAlta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * Método que muestra el contenido del objeto Empleado-Proyecto
     */
    @Override
    public String toString() {
        return "EmpleadoProyecto{" +
                "pk=" + pk +
                ", fAlta=" + fAlta +
                ", empleado=" + empleado +
                ", proyecto=" + proyecto +
                '}';
    }
}
