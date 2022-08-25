package com.dh.clinicaOdontologica.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    public ConfigurationJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public ConfigurationJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/teste;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'createUsuario.sql'";
        this.nomeUsuario = "";
        this.senha = "";
    }

    public Connection conectarComBancoDeDados() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }

}
