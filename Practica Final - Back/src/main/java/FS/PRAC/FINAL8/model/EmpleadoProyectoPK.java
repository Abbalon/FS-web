/**
 * Clase que recoge la clave compuesta de EmpleadoProyecto
 */
package FS.PRAC.FINAL8.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpleadoProyectoPK implements Serializable {

    @Column(name = "id_Proyecto")
    private int idProyecto;

    @Column(name = "id_Empleado")
    private int idEmpleado;

    /**
     * Default void constructor
     * */
    public EmpleadoProyectoPK() {
    }

    /**Overcharged constructor*/
    public EmpleadoProyectoPK(int idProyecto, int idEmpleado) {
        this.idProyecto = idProyecto;
        this.idEmpleado = idEmpleado;
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

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Método que muestra la clave del objeto Empleado-Proyecto
     */
    @Override
    public String toString() {
        return "EmpleadoProyectoPK{" +
                "idProyecto=" + idProyecto +
                ", idEmpleado=" + idEmpleado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpleadoProyectoPK)) return false;
        EmpleadoProyectoPK that = (EmpleadoProyectoPK) o;
        return getIdProyecto() == that.getIdProyecto() &&
                getIdEmpleado() == that.getIdEmpleado();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdProyecto(), getIdEmpleado());
    }
}
