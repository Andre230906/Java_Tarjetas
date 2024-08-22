/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Clientes {
    private String nombre;
    private TipoCliente tipoCliente;
    
    public Clientes (int id,String nombre,TipoCliente TipoCliente ){
        this.id =id;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre (String nombre){
        this.nombre=nombre;
    }
    public TipoCliente getTipoCliente(){
        return tipoCliente;
    }
    public void setTipoCliente (TipoCliente TipoCliente){
        this.tipoCliente=tipoCliente;
    }

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
