package entity;

public class detalleFactura {

    private int cantidad;
    private String Descripcion;
    private float pvu;
    private float descuento;
    private float totalproducto;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public float getPvu() {
        return pvu;
    }

    public void setPvu(float pvu) {
        this.pvu = pvu;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getTotalproducto() {
        return totalproducto;
    }

    public void setTotalproducto() {
        this.totalproducto = (this.pvu*this.cantidad)-this.descuento;
    }


}
