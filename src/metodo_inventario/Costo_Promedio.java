package metodo_inventario;

public class Costo_Promedio{
    float Metodo[][];
    int cant;
    int UEP,UD;
      
    public Costo_Promedio(){}

    public Costo_Promedio(float[][] Metodo, int cant, int UEP, int UD) {
        this.Metodo = Metodo;
        this.cant = cant;
        this.UEP = UEP;
        this.UD = UD;
    }
    
    public float[][] getMetodo() {
        return Metodo;
    }

    public void setMetodo(float[][] Metodo) {
        this.Metodo = Metodo;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getUEP() {
        return UEP;
    }

    public void setUEP(int UEP) {
        this.UEP = UEP;
    }

    public int getUD() {
        return UD;
    }

    public void setUD(int UD) {
        this.UD = UD;
    }
     
    public float PromedioSimple(){
        float suma=0;
        for(int i=0;i<getCant();i++){
            suma+=getMetodo()[i][1];
        }
        return suma/getCant();
    }
       
    public void print(){
       // float pr[][] = new float[getCant()][2];
        this.setMetodo(Metodo);
        System.out.println("Fecha | Costo Unitario");
        for(int i=0;i<this.getCant();i++){
            for(int j=0;j<2;j++){
                System.out.print(this.getMetodo()[i][j]+"-----");
            }
            System.out.println("");
        }
        System.out.println("El promedio simple es :"+PromedioSimple());
        System.out.println("Unidades enviadas a produccion :"+getUEP());
        System.out.println("Unidades disponibles :"+(getUD()-getUEP()));
        System.out.println("El costo de produccion en proceso es :"+UnidadesProduccion());
        System.out.println("El costo de inventario final de materiales es :"+UnidadesDisponibles());
    }
    
    public float UnidadesProduccion(){
        return PromedioSimple()*getUEP();
    }
    
    public float UnidadesDisponibles(){
        return PromedioSimple()*(getUD()-getUEP());
    }
    
            
    
}
