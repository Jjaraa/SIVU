/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sivu;

import java.util.*;

/**
 *
 * @author Mauricio
 */
public class SIVU {
    public ArrayList<Producto> productos;
    public ArrayList<Venta> ventas;
    private int contador;

    public SIVU(){ 
        this.productos =  new ArrayList<Producto>();
        this.ventas = new ArrayList<Venta>();
        this.contador = 1;
    }
    
  /*  public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a el Sistema de Inventario y Ventas Automatizado S.I.V.U");
        System.out.println("Eliga que accion desea realizar:");
        System.out.println("1)Añadir un producto");
        System.out.println("2)Mostrar el inventario");
        System.out.println("3)Añadir o Disminuir el Stock de un producto");
        System.out.println("4)Aumentar o rebajar el precio de un producto");
        System.out.println("5)Realizar una venta");
        
        int i = sc.nextInt();
        switch(i){
            case 1:
                String nombre1 = preguntarString("nombre");
                int precio = preguntarInt("precio","producto");
                int stock = preguntarInt("stock","producto");
                añadirProducto(nombre1,precio,stock);
                menu();
                break;
            case 2:
                 imprimirInventario();
                 menu();
                 break;
            case 3:
                String nombre2 = preguntarString("nombre");
                int valor = preguntarInt("valor","stock");
                sumarStock(nombre2,valor);
                menu();
                break;
            case 4:
                String nombre3 = preguntarString("nombre");
                int valor2 = preguntarInt("valor","stock");
                sumarPrecio(nombre3,valor2);
                menu();
                break;
            case 5:
                String nombre4 = preguntarString("nombre");
                menu();
                break;
        }
    }
    */
    
    public void menuUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a el Sistema de Inventario y Ventas Automatizado S.I.V.U");
        System.out.println("Eliga que accion desea realizar:");
        System.out.println("1)Realizar una venta");
        System.out.println("2)Mostrar el inventario");
        System.out.println("3)Buscar producto");        
        System.out.println("4)Cerrar sesión");
        int seleccion = sc.nextInt();
        seleccionUsuario(seleccion);
    }
    //Jonathan: Se puede hacer un switch para el metodo seleccionUsuario, y crear metodos faltantes
    public void seleccionUsuario(int seleccion){
        
    }
    
    public void menuAdmin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a el Sistema de Inventario y Ventas Automatizado S.I.V.U");
        System.out.println("Eliga que accion desea realizar:");
        System.out.println("1)Crear Usuario");
        System.out.println("2)Mostrar el inventario");
        System.out.println("4)Buscar producto");
        System.out.println("5)Aumentar o rebajar el precio de un producto");
        System.out.println("6)Añadir o Disminuir el Stock de un producto");
        System.out.println("7)Cerrar sesión");
        int seleccion = sc.nextInt();
        seleccionAdmin(seleccion);
    }
    //Jonathan: Lo mismo que en el caso del usuario
    public void seleccionAdmin(int seleccion){
    
    }
    
    private  void añadirProducto(String nombre, int precio, int stock){
        this.productos.add(new Producto(nombre,precio,stock,this.contador));
        this.contador++;
    }
    
    private String preguntarString(String palabra){
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese el "+palabra+" del producto");
        String word = sc.nextLine();
        return word;
    }
    
    private int preguntarInt(String palabra, String palabra2){
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese el "+palabra+" del "+palabra2);
        int valor = sc.nextInt();
        return valor;
    }
    
    public void sumarStock(String nombre, int valor){
        for(Producto item:this.productos){
            if(nombre.equals(item.getNombre())){
                item.sumarStock(valor);
            }
        }
    }
    
    public void sumarPrecio(String nombre, int valor){
        for(Producto item:this.productos){
            if(nombre.equals(item.getNombre())){
                item.sumarPrecio(valor);
            }
        }
    }
    
    public String toString() {
        String s="";
        s+="El inventario contiene:\n";
        for (Producto item:this.productos) {
            s+='\n'+item.toString();
        }
        return s;
    }
    
    public void imprimirInventario(){
        System.out.println(toString());
    }
    /* Jonathan: cambie un poco el metodo vender. en vez de buscar
    por el nombre, que busque por el codigo del producto. Además, separé el metodo
    y cree un "mostrarVender" para que muestre el precioTotal */
    public void vender(int codigo, int cantidad){
        int precioTotal;
       
        for(Producto item:this.productos){
            if(codigo == item.getCodigo()){
                item.sumarStock(-cantidad);
                precioTotal = item.getPrecio()*cantidad;
                codigo = item.getCodigo();
                this.ventas.add(new Venta(precioTotal, codigo, cantidad)); 
                mostrarVender(precioTotal);
            }
        }
    }
    
    private void mostrarVender(int precioTotal){
        System.out.println("El valor total de la venta es de : "+(precioTotal));
    }
    
    /* Jonathan: Cree el metodo getVentas para poder trabajar con el array 
    en las demas clases */
    public ArrayList<Venta> getVentas(){
        return this.ventas;
    }
    // Jonathan: Lo mismo que lo anterior
    public ArrayList<Producto> getProductos(){
        return this.productos;
    }
    
}
