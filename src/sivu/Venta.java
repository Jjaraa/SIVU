/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sivu;


/*Jonathan: cambie el atributo de nombre por el de cantidad, ya que nuestro 
identificador para buscar y vender productos es el codigo, asi que el nombre 
sería redundante a mi parecer, y la cantidad es necesaria para los metodos de la
clase Usuario*/
public class Venta {
    private int valor;
    private int codigo;
    private int cantidad;
    
    public Venta(int valor, int codigo, int cantidad){
        this.valor = valor;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public int returnCodigo(){
        return this.codigo;
    }
    
    public int returnCantidad(){
        return this.cantidad;
    }


}
