package com.javierpinya.testcamiones_v2.Clases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.javierpinya.testcamiones_v2.Constants.Constants;
import com.javierpinya.testcamiones_v2.Converters.Converters;

import java.util.Date;

@Entity(tableName = Constants.NAME_TABLE_TACCATR,
        foreignKeys = @ForeignKey(entity=TaccamiEntity.class,
        parentColumns = "id",
        childColumns = "vehiculoId"),
        indices = {@Index(value = {"id"}, unique = true),
                @Index(value = {"vehiculoId"}, unique = true)}
        )
@TypeConverters(Converters.class)
public class TaccatrEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int vehiculoId;
    @ColumnInfo(name = "transportista")
    public String cod_transportista;
    public String slo;
    public Date fec_baja;

    //public TaccatrEntity(){}
    public TaccatrEntity(String cod_transportista, String slo, Date fec_baja) {
        this.cod_transportista = cod_transportista;
        this.slo = slo;
        this.fec_baja = new Date();
        this.fec_baja = fec_baja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getCod_transportista() {
        return cod_transportista;
    }

    public void setCod_transportista(String cod_transportista) {
        this.cod_transportista = cod_transportista;
    }

    public String getSlo() {
        return slo;
    }

    public void setSlo(String slo) {
        this.slo = slo;
    }

    public Date getFec_baja() {
        return fec_baja;
    }

    public void setFec_baja(Date fec_baja) {
        this.fec_baja = fec_baja;
    }
}
