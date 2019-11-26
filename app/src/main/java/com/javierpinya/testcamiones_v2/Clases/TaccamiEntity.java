package com.javierpinya.testcamiones_v2.Clases;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.javierpinya.testcamiones_v2.Constants.Constants;
import com.javierpinya.testcamiones_v2.Converters.Converters;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = Constants.NAME_TABLE_TACCAMI,
        foreignKeys = {
                @ForeignKey(entity = TacprcoEntity.class,
                        parentColumns = "id",
                        childColumns = "tractoraId",
                        onDelete = CASCADE),
                @ForeignKey(entity = TacsecoEntity.class,
                        parentColumns = "id",
                        childColumns = "cisternaId",
                        onDelete = CASCADE)
        },
        indices = {@Index(value = {"id"}, unique = true),
                @Index(value = {"tractoraId"}, unique = true),
                @Index(value = {"cisternaId"}, unique = true)}
)
@TypeConverters(Converters.class)
public class TaccamiEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int cod_vehiculo;
    public int tractoraId;
    public int cisternaId;
    public int tara;
    public int pesoMaximo;
    public Date fec_baja;

    public TaccamiEntity(){}

    public TaccamiEntity(int cod_vehiculo, int tara, int pesoMaximo, Date fec_baja) {
        this.cod_vehiculo = cod_vehiculo;
        this.tara = tara;
        this.pesoMaximo = pesoMaximo;
        this.fec_baja = new Date();
        this.fec_baja = fec_baja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_vehiculo() {
        return cod_vehiculo;
    }

    public void setCod_vehiculo(int cod_vehiculo) {
        this.cod_vehiculo = cod_vehiculo;
    }

    public int getTractoraId() {
        return tractoraId;
    }

    public void setTractoraId(int tractoraId) {
        this.tractoraId = tractoraId;
    }

    public int getCisternaId() {
        return cisternaId;
    }

    public void setCisternaId(int cisternaId) {
        this.cisternaId = cisternaId;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public Date getFec_baja() {
        return fec_baja;
    }

    public void setFec_baja(Date fec_baja) {
        this.fec_baja = fec_baja;
    }
}

