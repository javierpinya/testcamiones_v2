package com.javierpinya.testcamiones_v2.Clases;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "credenciales")
public class UsuarioEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String usuario;
    public String password;

    public UsuarioEntity(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
