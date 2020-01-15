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
public class UEPS {
   int cant;
   int UD;float UEP;
   float UEPS[][];

   public UEPS(){}

    public UEPS(int cant, int UD, float UEP, float[][] UEPS) {
        this.cant = cant;
        this.UD = UD;
        this.UEP = UEP;
        this.UEPS=UEPS;
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

    public float getUEP() {
        return UEP;
    }

    public void setUEP(float UEP) {
        this.UEP = UEP;
    }

    public float[][] getUEPS() {
        return UEPS;
    }

    public void setPEPS(float[][] UEPS) {
        this.UEPS=UEPS;
    }
    
  public void CFM(){
        float CM=0;
        float CM2=0;
        System.out.println("Unidades en produccion por UEPS");
        System.out.println("Fecha|Unidades |Costo   |Total");
        System.out.println("     |compradas|unitario|");
        for(int i=getCant()-1;i>=0;i--){
            for(int j=0;j<4;j++){
                CM+=getUEPS()[i][3];
                if(getUEPS()[i][1]<getUEP()){
                  System.out.print(getUEPS()[i][j]+"-----");
                }else{
                   getUEPS()[i][1]=getUEP();
                   if(getUEP()>0){
                   getUEPS()[i][3]=getUEP()*getUEPS()[i][2];
                   System.out.print(getUEPS()[i][j]+"-----");
                   CM2=getUEP()*getUEPS()[i][3];
                //  p.setCM2(CM2);
                   }
                }    
            }
            setUEP(getUEP()-getUEPS()[i][1]);
            
        }
        System.out.println("El costo de produccion es :"+CM);
  }

    
    public int UP(){
        int un=0;
        for(int i=0;i<getCant();i++){
            un+=getUEPS()[i][1];
        }
            return un;
    }
    
    
      public float Total(){
        float un=0;
        for(int i=0;i<getCant();i++){
          un+=getUEPS()[i][3];
    }
        return un;
    }
    
    public void print(){
        System.out.println("");
        System.out.println("Fecha|Unidades |Costo   |Total");
        System.out.println("     |compradas|unitario|");
        for(int i=0;i<getCant();i++){
            for(int j=0;j<4;j++){
                System.out.print(getUEPS()[i][j]+"-----");
            }
            System.out.println("");
        }
        System.out.println("---------|"+UP()+"|             |"+Total());
        CFM();
      
    }
    
    
   

   
}