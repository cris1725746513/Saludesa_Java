package dao;

import entity.detalleFactura;

import java.util.List;

public interface facturaDao {



    void cargarProductos(List<detalleFactura> lista);
    void calcular (List<detalleFactura> lista);
    void mostrar(List<detalleFactura> lista);
}
