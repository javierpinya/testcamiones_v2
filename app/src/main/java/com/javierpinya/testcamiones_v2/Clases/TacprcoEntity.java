package com.javierpinya.testcamiones_v2.Clases;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.javierpinya.testcamiones_v2.Constants.Constants;

import java.util.Date;


@Entity(tableName = Constants.NAME_TABLE_TACPRCO,
        indices = {@Index(value = {"id"}, unique = true)})
public class TacprcoEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String matricula;
    public Date fec_cadu_itv;
    public Date fec_cadu_adr;
    public int tara;
    public int peso_maximo;
    public int chip;
    public String tipo;
    public Date fec_baja;
    public String cod_nacion;
    public boolean solo_gasoleos = false;
    public boolean ind_bloqueo = false;
    public boolean ind_queroseno = false;

    public TacprcoEntity(String matricula, int tara, int peso_maximo, int chip, String tipo, String cod_nacion) {
        this.matricula = matricula;
        this.tara = tara;
        this.peso_maximo = peso_maximo;
        this.chip = chip;
        this.tipo = tipo;
        this.cod_nacion = cod_nacion;
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

    public boolean isSolo_gasoleos() {
        return solo_gasoleos;
    }

    public void setSolo_gasoleos(boolean solo_gasoleos) {
        this.solo_gasoleos = solo_gasoleos;
    }

    public boolean isInd_bloqueo() {
        return ind_bloqueo;
    }

    public void setInd_bloqueo(boolean ind_bloqueo) {
        this.ind_bloqueo = ind_bloqueo;
    }

    public boolean isInd_queroseno() {
        return ind_queroseno;
    }

    public void setInd_queroseno(boolean ind_queroseno) {
        this.ind_queroseno = ind_queroseno;
    }
}
