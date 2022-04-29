package controller;

import dao.facturaDaoImplements;
import entity.detalleFactura;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class facturaControllers {

    facturaDaoImplements factura = new facturaDaoImplements();

    public void setFactura(List<detalleFactura> lista){
        factura.calcular(lista);
        factura.mostrar(lista);
    }

    public void Menu(){
         Scanner s = new Scanner(System.in);
        List<detalleFactura> ListaDetalle= new ArrayList<>();
        detalleFactura detalleFactura;
        String op;
        do{
            detalleFactura = new detalleFactura();
            System.out.println("Ingresar cantidad:");
            detalleFactura.setCantidad(verificacionI(s.nextLine()));
            System.out.println("Ingresar Detalle:");
            detalleFactura.setDescripcion(s.nextLine());
            System.out.println("Ingresar Precio Unitario:");
            detalleFactura.setPvu(verificacionF(s.nextLine()));
            System.out.println("Ingresar Descuento:");
            detalleFactura.setDescuento(verificacionF(s.nextLine()));
            detalleFactura.setTotalproducto();
            ListaDetalle.add(detalleFactura);
            System.out.println("Presione S para pagar");
            op=s.nextLine();
        }while (!op.toUpperCase().equals("S"));
        setFactura(ListaDetalle);


    }

    private float verificacionF(String X){

        boolean x=false;
        float v=0;
        do{
            try {
                    v=Float.parseFloat(X);
                    x=true;
            } catch ( NumberFormatException ex) {
                System.out.println("Ingrese un valor Valido:");
                Scanner s = new Scanner(System.in);
                X=s.nextLine();
                x=false;
            }
        }while (!x);

        return v;
    }
    private int verificacionI(String X){
        boolean x=false;
        int v=0;

        do{

            try {
                v=Integer.parseInt(X);
                x=true;
            } catch (NumberFormatException ex) {
                System.out.println("Ingrese un valor Valido:");
                Scanner s = new Scanner(System.in);
                X=s.nextLine();
                x=false;
            }
        }while (!x);

        return v;
    }
}
