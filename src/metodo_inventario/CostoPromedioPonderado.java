/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo_inventario;

/**
 *
 * @author gabriel
 */
public class CostoPromedioPonderado{
    float PP[][];
    int cant;
    int UD,UEP;
    
    public CostoPromedioPonderado(){}

    public CostoPromedioPonderado(float[][] PP, int cant, int UD, int UEP) {
        this.PP = PP;
        this.cant = cant;
        this.UD = UD;
        this.UEP = UEP;
    }

    public float[][] getPP() {
        return PP;
    }

    public void setPP(float[][] PP) {
        this.PP = PP;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getUD() {
        return UD;
    }

    public void setUD(int UD) {
        this.UD = UD;
    }

    public int getUEP() {
        return UEP;
    }

    public void setUEP(int UEP) {
        this.UEP = UEP;
    }
    
    
    public float promedio(){
        float UC=0,Total=0;
        for(int i=0;i<getCant();i++){
             UC+=getPP()[i][1];
             Total+=getPP()[i][3];
        }
        return Total/UC;
    }
    
    public int UC(){
        int T=0;
        for(int i=0;i<getCant();i++){
            T+=getPP()[i][1];
        }
        return T;
    }
    
    public void print(){
        System.out.println("Fecha | Unidades |Costo    |Total");
        System.out.println("      | Compradas|Unitario |");
        for(int i=0;i<getCant();i++){
            for(int j=0;j<4;j++){
            System.out.print(getPP()[i][j]+"-----");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Promedio Ponderado :"+promedio());
        System.out.println("Unidades Enviadas a produccion :"+getUEP());
        System.out.println("Unidades disponibles :"+(UC()-getUEP()));
        System.out.println("Costo de Iventario Final :"+Costo_Final_Materiales());
        System.out.println("Costo de Produccion en Proceso :"+Costo_Produccion_Proceso());
    }
    
    public float Costo_Final_Materiales(){
        return promedio()*(UC()-getUEP());
    }
    
    public float Costo_Produccion_Proceso(){
        return promedio()*getUEP();
    }
    
    
    
}
