package dao;

import entity.detalleFactura;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class facturaDaoImplements implements  facturaDao{
    private List<detalleFactura> listadetalles = new ArrayList<>();
    float totaldescujento=0;
    float subtotal=0;
    float iva=0;
    float totalFactura=0;
    @Override
    public void cargarProductos(List<detalleFactura> lista) {
        listadetalles = lista;
    }

    @Override
    public void calcular(List<detalleFactura> lista) {

        if(!lista.isEmpty()){
            for (detalleFactura detalleFactura:lista  ) {
                totaldescujento += detalleFactura.getDescuento();
                subtotal += detalleFactura.getTotalproducto();

            }
            iva=(float)(0.12*subtotal);
            totalFactura= iva + subtotal;

        }else {
            System.out.println("No se han cargado producto a la Factura");
            return;
        }
    }

    @Override
    public void mostrar(List<detalleFactura> lista) {
        System.out.println("|Cantidad \tDetalle \tPvu \tDesc  \tTotal |");
        for (detalleFactura e:lista) {
            System.out.println("|\t"+e.getCantidad()+"\t"+e.getDescripcion()+"\t"+e.getPvu()+"\t"+e.getDescuento()+"\t"+e.getTotalproducto()+" |");
        }

        System.out.println("********************VALORES**********************");
        DecimalFormat decimalFormat = new DecimalFormat("#0.##");
        System.out.println("Subtotal : "+decimalFormat.format(subtotal));
        System.out.println("Descuento : "+decimalFormat.format(totaldescujento));
        System.out.println("Iva 12% : "+decimalFormat.format(iva));
        System.out.println("Total : "+decimalFormat.format(totalFactura));
    }
}
