/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sivu;

import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class Usuario {
    public String nombreUsuario;
    private String contraseña; 
    
    public Usuario(String nombreUsuario, String contraseña){
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
    
    public String getUsuario(){
        return this.nombreUsuario;
    }
    //la cantidad de ventas que se realizaron por el usuario en esa sesión 
    public int totalVentas(ArrayList<Venta> ventas){
        return ventas.size();    
    
    }
    
    public void mostrarTotalVentas(int total){
        System.out.println("El numero de ventas para el usuario "+this.nombreUsuario+" es de: "+total);
    }
    //la cantidad de productos vendidos por el usuario en esa sesión
    public int cantidadVendida(ArrayList<Venta> ventas){
        int cantidadVendida = 0;
        for(Venta item: ventas){
            cantidadVendida += item.returnCantidad();
        }
        return cantidadVendida;
    }
    public void mostrarCantidadVendida(int total){
        System.out.println("La cantidad total de productos vendidos por el usuario "+this.nombreUsuario+" es de: "+total);
    }
    //el valor total que se vendio entre todos los productos vendidos por el usuario en esa sesión
    public int valorVendido(ArrayList<Venta> ventas){
        int valorVendido = 0;
        for(Venta item: ventas){
            valorVendido += item.getValor();
        }
        return valorVendido;
    }
    
    public void mostrarValorVendido(int total){
        System.out.println("El valor total vendido por el usuario "+this.nombreUsuario+" es de: $"+total+" pesos");
    }
    //el porcentaje de productos vendidos por el usuario comparados con el total de los productos vendidos por todos los usuarios
   
    public double porcentajeVendido(ArrayList<Venta> ventasUsuario, ArrayList<Venta> ventasTotales){
        int total = 0; 
        int totalUsuario = cantidadVendida(ventasUsuario);
        for(Venta item2: ventasTotales){
            total += item2.returnCantidad();
        }
        double porcentaje = (totalUsuario*100)/total;
        return porcentaje; 
    }
    
    public void mostrarProcentajeVentas(double porcentaje){
        System.out.println("El usuario "+this.nombreUsuario+" vendió un "+porcentaje+"% de las ventas totales");
    }
    
    //el porcentaje de su valor total vendido entre todos los productos del usuario, comparado con el total vendido entre todos
    public double porcentajeValorVentas(ArrayList<Venta> ventasUsuario, ArrayList<Venta> ventasTotales){
        int totalUsuario = valorVendido(ventasUsuario);
        int total = 0;
        for(Venta item2: ventasTotales){
            total += item2.getValor();
        }
        double porcentajeValor = (totalUsuario*100)/total; 
        return porcentajeValor;
    }
    
    public void mostrarPorcentajeValorVentas(double porcentajeValor){
        System.out.println("El usuario "+this.nombreUsuario+" ha vendido un "+porcentajeValor+"% del total vendido");
    }
}
