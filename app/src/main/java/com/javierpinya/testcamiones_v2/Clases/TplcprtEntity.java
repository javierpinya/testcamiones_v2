package com.javierpinya.testcamiones_v2.Clases;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.javierpinya.testcamiones_v2.Constants.Constants;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = Constants.NAME_TABLE_TPLCPRT,
        foreignKeys = {
                @ForeignKey(entity = TacsecoEntity.class,
                parentColumns = "id",
                childColumns = "cisternaId",
                onDelete = CASCADE)
        },
        indices = {@Index(value = {"id"}, unique = true),
                @Index(value = {"cisternaId"}, unique = true)}
)
public class TplcprtEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int cod_compartimento;
    public String id_tipo_componente;
    public int cisternaId;
    public int can_capacidad;
    public String cod_tag_cprt;

    public TplcprtEntity(int cod_compartimento, String id_tipo_componente, int cisternaId, int can_capacidad, String cod_tag_cprt) {
        this.cod_compartimento = cod_compartimento;
        this.id_tipo_componente = id_tipo_componente;
        this.cisternaId = cisternaId;
        this.can_capacidad = can_capacidad;
        this.cod_tag_cprt = cod_tag_cprt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_compartimento() {
        return cod_compartimento;
    }

    public void setCod_compartimento(int cod_compartimento) {
        this.cod_compartimento = cod_compartimento;
    }

    public String getId_tipo_componente() {
        return id_tipo_componente;
    }

    public void setId_tipo_componente(String id_tipo_componente) {
        this.id_tipo_componente = id_tipo_componente;
    }

    public int getCisternaId() {
        return cisternaId;
    }

    public void setCisternaId(int cisternaId) {
        this.cisternaId = cisternaId;
    }

    public int getCan_capacidad() {
        return can_capacidad;
    }

    public void setCan_capacidad(int can_capacidad) {
        this.can_capacidad = can_capacidad;
    }

    public String getCod_tag_cprt() {
        return cod_tag_cprt;
    }

    public void setCod_tag_cprt(String cod_tag_cprt) {
        this.cod_tag_cprt = cod_tag_cprt;
    }
}
