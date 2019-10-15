package com.javierpinya.testcamiones_v2.Clases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.javierpinya.testcamiones_v2.Constants.Constants;

import java.util.Date;

@Entity(tableName = Constants.NAME_TABLE_TACCOND)
public class TaccondEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "conductor")
    public String cod_conductor;
    public String id_tipo_documento;
    public String dni;
    public String nombre;
    public String apellidos;
    public Date fec_cadu_perm_conduccion;
    public Date fec_cadu_adr;
    public Date fec_inic_bloqueo;
    public Date fec_fin_bloqueo;
    public String tipo_autorizacion;
    public String ind_empleado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_conductor() {
        return cod_conductor;
    }

    public void setCod_conductor(String cod_conductor) {
        this.cod_conductor = cod_conductor;
    }

    public String getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(String id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFec_cadu_perm_conduccion() {
        return fec_cadu_perm_conduccion;
    }

    public void setFec_cadu_perm_conduccion(Date fec_cadu_perm_conduccion) {
        this.fec_cadu_perm_conduccion = fec_cadu_perm_conduccion;
    }

    public Date getFec_cadu_adr() {
        return fec_cadu_adr;
    }

    public void setFec_cadu_adr(Date fec_cadu_adr) {
        this.fec_cadu_adr = fec_cadu_adr;
    }

    public Date getFec_inic_bloqueo() {
        return fec_inic_bloqueo;
    }

    public void setFec_inic_bloqueo(Date fec_inic_bloqueo) {
        this.fec_inic_bloqueo = fec_inic_bloqueo;
    }

    public Date getFec_fin_bloqueo() {
        return fec_fin_bloqueo;
    }

    public void setFec_fin_bloqueo(Date fec_fin_bloqueo) {
        this.fec_fin_bloqueo = fec_fin_bloqueo;
    }

    public String getTipo_autorizacion() {
        return tipo_autorizacion;
    }

    public void setTipo_autorizacion(String tipo_autorizacion) {
        this.tipo_autorizacion = tipo_autorizacion;
    }

    public String getInd_empleado() {
        return ind_empleado;
    }

    public void setInd_empleado(String ind_empleado) {
        this.ind_empleado = ind_empleado;
    }
}
