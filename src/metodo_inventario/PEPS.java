/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo_inventario;

public class PEPS {
    int cant;
    int UD;float UEP;
    float PEPS[][];

    public PEPS(){}

    public PEPS(int cant, int UD,float UEP, float[][] PEPS) {
        this.cant = cant;
        this.UD = UD;
        this.UEP = UEP;
        this.PEPS = PEPS;
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

    public float[][] getPEPS() {
        return PEPS;
    }

    public void setPEPS(float[][] PEPS) {
        this.PEPS = PEPS;
    }
    
    
   public void CFM(){
        float CM=0;
        float CM2=0;
        System.out.println("Unidades en produccion por PEPS");
        System.out.println("Fecha|Unidades |Costo   |Total");
        System.out.println("     |compradas|unitario|");
        for(int i=0;i<getCant();i++){
            CM+=getPEPS()[i][3];
            for(int j=0;j<4;j++){
                if(getPEPS()[i][1]<getUEP()){
                  System.out.print(getPEPS()[i][j]+"-----");
                 
                  //setCM(CM);
                }else{
                   getPEPS()[i][1]=getUEP();
                   if(getUEP()>0){
                   getPEPS()[i][3]=getUEP()*getPEPS()[i][2];
                   System.out.print(getPEPS()[i][j]+"-----");
                   
                //  setCM2(CM2);
                   }
                }   
            }
           // CM2=getUEP()*getPEPS()[i][2];
            setUEP(getUEP()-getPEPS()[i][1]);
            
            System.out.println("");  
    } 
        System.out.println("El costo final  de materiales es :"+(CM));
   }

    
    public int UP(){
        int un=0;
        for(int i=0;i<getCant();i++){
            un+=getPEPS()[i][1];
        }
            return un;
    }
    
    
      public float Total(){
        float un=0;
        for(int i=0;i<getCant();i++){
          un+=getPEPS()[i][3];
    }
        return un;
    }
    
    public void print(){
        System.out.println("");
        System.out.println("Fecha|Unidades |Costo   |Total");
        System.out.println("     |compradas|unitario|");
        for(int i=0;i<getCant();i++){
            for(int j=0;j<4;j++){
                System.out.print(getPEPS()[i][j]+"-----");
            }
            System.out.println("");
        }
        System.out.println("---------|"+UP()+"|             |"+Total());
        CFM();
      
    }
    
    
}
