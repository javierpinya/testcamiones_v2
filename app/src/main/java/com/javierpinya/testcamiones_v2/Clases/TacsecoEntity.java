package com.javierpinya.testcamiones_v2.Clases;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import com.javierpinya.testcamiones_v2.Constants.Constants;
import com.javierpinya.testcamiones_v2.Converters.Converters;

import java.util.Date;

@Entity(tableName = Constants.NAME_TABLE_TACSECO,
        indices = {@Index(value = {"id"}, unique = true)})
@TypeConverters(Converters.class)
public class TacsecoEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String matricula;
    public Date fec_cadu_itv;
    public Date fec_cadu_adr;
    public int tara;
    public int peso_maximo;
    public int chip;
    public String tipo;
    public Date fec_cadu_calibracion;
    public int num_ejes;
    public boolean ind_carga_pesados;
    public Date fec_baja = new Date();
    public String cod_nacion;
    public boolean solo_gasoleos=false;
    public boolean ind_bloqueo = false;
    public boolean ind_queroseno = false;

    public TacsecoEntity(String matricula, Date fec_cadu_itv, Date fec_cadu_adr, int tara, int peso_maximo, int chip, String tipo, Date fec_cadu_calibracion, int num_ejes, boolean ind_carga_pesados, Date fec_baja, String cod_nacion, boolean solo_gasoleos, boolean ind_bloqueo, boolean ind_queroseno) {
        this.matricula = matricula;
        this.fec_cadu_itv = new Date();
        this.fec_cadu_adr = new Date();
        this.fec_cadu_calibracion = new Date();
        this.fec_baja = new Date();
        this.fec_cadu_itv = fec_cadu_itv;
        this.fec_cadu_adr = fec_cadu_adr;
        this.tara = tara;
        this.peso_maximo = peso_maximo;
        this.chip = chip;
        this.tipo = tipo;
        this.fec_cadu_calibracion = fec_cadu_calibracion;
        this.num_ejes = num_ejes;
        this.ind_carga_pesados = ind_carga_pesados;
        this.fec_baja = fec_baja;
        this.cod_nacion = cod_nacion;
        this.solo_gasoleos = solo_gasoleos;
        this.ind_bloqueo = ind_bloqueo;
        this.ind_queroseno = ind_queroseno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFec_cadu_itv() {
        return fec_cadu_itv;
    }

    public void setFec_cadu_itv(Date fec_cadu_itv) {
        this.fec_cadu_itv = fec_cadu_itv;
    }

    public Date getFec_cadu_adr() {
        return fec_cadu_adr;
    }

    public void setFec_cadu_adr(Date fec_cadu_adr) {
        this.fec_cadu_adr = fec_cadu_adr;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public int getPeso_maximo() {
        return peso_maximo;
    }

    public void setPeso_maximo(int peso_maximo) {
        this.peso_maximo = peso_maximo;
    }

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFec_cadu_calibracion() {
        return fec_cadu_calibracion;
    }

    public void setFec_cadu_calibracion(Date fec_cadu_calibracion) {
        this.fec_cadu_calibracion = fec_cadu_calibracion;
    }

    public int getNum_ejes() {
        return num_ejes;
    }

    public void setNum_ejes(int num_ejes) {
        this.num_ejes = num_ejes;
    }

    public boolean isInd_carga_pesados() {
        return ind_carga_pesados;
    }

    public void setInd_carga_pesados(boolean ind_carga_pesados) {
        this.ind_carga_pesados = ind_carga_pesados;
    }

    public Date getFec_baja() {
        return fec_baja;
    }

    public void setFec_baja(Date fec_baja) {
        this.fec_baja = fec_baja;
    }

    public String getCod_nacion() {
        return cod_nacion;
    }

    public void setCod_nacion(String cod_nacion) {
        this.cod_nacion = cod_nacion;
    }

    public boolean getSolo_gasoleos() {
        return solo_gasoleos;
    }

    public void setSolo_gasoleos(Boolean solo_gasoleos) {
        this.solo_gasoleos = solo_gasoleos;
    }

    public boolean getInd_bloqueo() {
        return ind_bloqueo;
    }

    public void setInd_bloqueo(Boolean ind_bloqueo) {
        this.ind_bloqueo = ind_bloqueo;
    }

    public boolean getInd_queroseno() {
        return ind_queroseno;
    }

    public void setInd_queroseno(Boolean ind_queroseno) {
        this.ind_queroseno = ind_queroseno;
    }
}

