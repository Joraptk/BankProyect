package com.beeva.ProyectoBanco.DAO;

public abstract class Factory {
public abstract CuentaDAO getCuenta(int tipo);
}
