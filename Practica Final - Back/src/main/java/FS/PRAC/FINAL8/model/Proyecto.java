/**
 * El modelo sigue la siguiente estrctura SQL
 *
 *  CREATE TABLE PRACTICA.PR_PROYECTOS
 * (
 *    ID_PROYECTO 				INT(5) PRIMARY KEY NOT NULL,
 *    TX_DESCRIPCIÓN 			VARCHAR(125) NOT NULL,
 *    F_INICIO 				DATE NOT NULL,
 *    F_FIN 					DATE,
 *    F_BAJA					DATE,
 *    TX_LUGAR 				VARCHAR(30),
 *    TX_OBSERVACIONES 		VARCHAR(300)
 * );
 */
package FS.PRAC.FINAL8.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "PR_PROYECTOS")
public class Proyecto {

    private static final String NOT_NULL = "Cannot be Null.";
    private static final String SIZE_LIMIT = "Limit of characters exceded or none founded.";

    /**
     *PRIMARY_KEY
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY, AUTO
    @Column(name = "id_Proyecto")
    private int idProyecto;

    @NotNull(message = NOT_NULL)
    @Size(min = 1, max = 125, message = SIZE_LIMIT)
    @Column(name = "tx_Descripcion")
    private String txDescripcion;

    @Size(max = 30, message = SIZE_LIMIT)
    @Column(name = "tx_Lugar")
    private String txLugar;

    @Size(max = 300, message = SIZE_LIMIT)
    @Column(name = "tx_Observaciones")
    private String txObservaciones;

    @NotNull(message = NOT_NULL)
    @Column(name = "f_Inicio")
    private Calendar fInicio;


    @Column(name = "f_Baja")
    private Calendar fBaja;

    @Column(name = "f_Fin")
    private Calendar fFin;

    /*@OneToMany(mappedBy = "proyecto")
    private List<EmpleadoProyecto> empleados;*/

    /**Resuelve las join*/
    @JoinTable(name = "PR_EMPLEADOS_PROYECTO", joinColumns = {
            @JoinColumn(name = "id_Proyecto", nullable = false, updatable = false)
    },inverseJoinColumns = {
            @JoinColumn(name ="id_Empleado",nullable = false, updatable = false)
    })
    @ManyToMany
    private List<Empleado> empleados;

    /**
     * Default void constructor
     * */
    public Proyecto() {
    }

    /**
     * Getters & Setters
     * */
    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getTxDescripcion() {
        return txDescripcion;
    }

    public void setTxDescripcion(String txDescripcion) {
        this.txDescripcion = txDescripcion;
    }

    public String getTxLugar() {
        return txLugar;
    }

    public void setTxLugar(String txLugar) {
        this.txLugar = txLugar;
    }

    public String getTxObservaciones() {
        return txObservaciones;
    }

    public void setTxObservaciones(String txObservaciones) {
        this.txObservaciones = txObservaciones;
    }

    public Calendar getfInicio() {
        return fInicio;
    }

    public void setfInicio(Calendar fInicio) {
        this.fInicio = fInicio;
    }

    public Calendar getfBaja() {
        return fBaja;
    }

    public void setfBaja(Calendar fBaja) {
        this.fBaja = fBaja;
    }

    public Calendar getfFin() {
        return fFin;
    }

    public void setfFin(Calendar fFin) {
        this.fFin = fFin;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**Método que muestra el contenido del objeto Proyecto*/
    @Override
    public String toString() {
        return "Proyecto{" +
                "idProyecto=" + idProyecto +
                ", txDescripcion='" + txDescripcion + '\'' +
                ", txLugar='" + txLugar + '\'' +
                ", txObservaciones='" + txObservaciones + '\'' +
                ", fInicio=" + fInicio +
                ", fBaja=" + fBaja +
                ", fFin=" + fFin +
                '}';
    }
}
