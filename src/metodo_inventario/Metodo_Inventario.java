/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo_inventario;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author gabriel
 */
public class Metodo_Inventario {
    
static PEPS peps = new PEPS();
static UEPS ueps = new UEPS();
static CostoPromedioPonderado CPP = new CostoPromedioPonderado();
static Costo_Promedio CP =new Costo_Promedio();
static String NombrePro;
    
    public static void main(String[] args) {
       int cant=0,canInv, cosU;
       int cdia,dia; float CPS[][];
       int UEP=0,UD;boolean man=true;
       
       Scanner leer = new Scanner(System.in);
       Pattern p = Pattern.compile("\\d*");
       Matcher m;
       boolean flag;
       String value;
       int opc=0;
          
       
       do{
           do{
        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
        System.out.println("Metodo de Valuacio de Inventario");
        System.out.println("1-Costo Promedio\n2-PEPS(Primero en entrar primero en salir)");
        System.out.println("3-UEPS(Ultimo en entrar primero en salir)");
        
        System.out.print("opcion:");
       // opc  = leer.nextInt(); 
           
           System.out.println("");
           value=leer.next();
           m = p.matcher(value);
           if(!m.matches()){
               flag=true;
               opc=0;
           }else
               opc=Integer.parseInt(value);
               
       }while(opc<=0 || opc>5);
        
        
        switch(opc){
            case 1:{
                int opc2=0;
                 do{
                System.out.println("-------------------------------------------");
                System.out.println("1-Costo promedio-Promedio Simple");
                System.out.println("2-Costo Promedio-Promedio Ponderado");
                System.out.print("opcion:");
                
               // opc2 =leer.nextInt();
               value=leer.next();
               m = p.matcher(value);
               if(!m.matches()){
               flag=true;
               opc2=0;
               }else
               opc2=Integer.parseInt(value);
               
       }while(opc2<=0 || opc2>5);
               
                switch(opc2){
                    case 1:{
                        System.out.println("-------------------------------------------");
                        System.out.println("Costo promedio Simple");
                        System.out.println("Ingrese el nombre del producto");
                        NombrePro = leer.next();
                       
                       // cant=leer.nextInt();
                       do{
                        System.out.println("Ingrese los dias que se recibio el producto");
                        value=leer.next();
                        m = p.matcher(value);
                        if(!m.matches()){
                        flag=true;
                        cant=0;
                        }else
                        cant=Integer.parseInt(value);
                        }while(cant<=0 || cant>30);
                        
                        CP.setCant(cant);
                        CPS = new float[CP.getCant()][2];
                        for(int i=0;i<CP.getCant();i++){
                            for(int j=0;j<2;j++){
                                if(j==0){
                                    
                                
                               // CPS[i][j]=leer.nextFloat();
                                     do{
                                  System.out.println("Ingrese la fecha");
           value=leer.next();
           m = p.matcher(value);
           if(!m.matches()){
               flag=true;
               CPS[i][j]=0;
           }else
               CPS[i][j]=Integer.parseInt(value);
               
       }while(CPS[i][j]<=0 || CPS[i][j]>30);
                                CP.setMetodo(CPS);
                                 
                                
                                
                                }else
                                    if(j==1){
                                   // CPS[i][j] =  leer.nextFloat();
                                    do{
                                    System.out.println("Ingrese el costo Unitario");  
                                    value=leer.next();
                                    m = p.matcher(value);
                                    if(!m.matches()){
                                    flag=true;
                                    CPS[i][j]=0;
                                    }else
               CPS[i][j]=Integer.parseInt(value);
               
       }while(CPS[i][j]<=0 || CPS[i][j]>30);
                                 
                                   
                                   
                                    CP.setMetodo(CPS);
                                    }
                            }
                        }
                        
                        int total;
                        do{
                                   System.out.println("Ingrese el total de entradas");
                                    value=leer.next();
                                    m = p.matcher(value);
                                    if(!m.matches()){
                                    flag=true;
                                    total=0;
                                    }else
                         total=Integer.parseInt(value);
               
                     }while(total<=0);
                       // total = leer.nextInt();
                          
                        CP.setUD(total);
                       
                         do{
                           System.out.println("Ingrese la cantidad de unidades mandadas a produccion");
                           value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                           UEP=0;
                          }else
                         total=Integer.parseInt(value);
                         }while(UEP<=0 || UEP>total);
                        //UEP = leer.nextInt();
                         
                        CP.setUEP(UEP);
                         CP.print();
                                
                        break;
                    }
                    case 2:{
                        System.out.println("-------------------------------------------");
                        System.out.println("Costo promedio Ponderado");
                        System.out.println("Ingrese el nombre del producto");
                        //NombrePro = leer.next();
                        
                        System.out.println("Ingrese los dias que se recibio el producto");
                        //cant=leer.nextInt();
                         do{
                           System.out.println("Ingrese la cantidad de unidades mandadas a produccion");
                           value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                           UEP=0;
                          }else
                         cant=Integer.parseInt(value);
                         }while(cant<=0 || cant>30);
                        CPP.setCant(cant);
                        CPS = new float[CPP.getCant()][4];
                        for(int i=0;i<CPP.getCant();i++){
                            for(int j=0;j<4;j++){
                               if(j==0){
                                 do{
                                   System.out.println("Ingrese la fecha");
                                 //CPS[i][j]=leer.nextFloat();
                                  

                           value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                           CPS[i][j]=0;
                          }else
                         CPS[i][j]=Integer.parseInt(value);
                         }while(CPS[i][j]<=0 || CPS[i][j]>30);
                                 do{
                                 System.out.println("Ingrese las unidades compradas");
                                // CPS[i][j+1]= leer.nextFloat();
                                 value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                           CPS[i][j+1]=0;
                          }else
                         CPS[i][j+1]=Integer.parseInt(value);
                         }while(CPS[i][j+1]<=0);
                                 do{
                                     
                                 
                                 System.out.println("Ingrese el costo unitario");
                                 //CPS[i][j+2] = leer.nextFloat();
                                       value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                           CPS[i][j+2]=0;
                          }else
                         CPS[i][j+1]=Integer.parseInt(value);
                         }while(CPS[i][j+2]<=0);
                                 CPS[i][j+3]=CPS[i][j+1]*CPS[i][j+2];
                                 CPP.setPP(CPS);                      
                               }
                            }
                        }
                        do{
                        System.out.println("Ingrese la cantidad de unidades mandadas a produccion");
                        //UEP = leer.nextInt();
                              value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          UEP=0;
                          }else
                         UEP=Integer.parseInt(value);
                         }while(UEP<=0 || UEP>CPP.UC());
                        CPP.setUEP(UEP);
                        CPP.print();
                        
                        break;
                    }
                    
                    default:{
                        break;
                    }
                    
                }
        
                break;
            }
       
            case 2:{
                System.out.println("-------------------------------------------");
                System.out.println("PEPS-(Primeras en entrar primeras en salir)");
                System.out.println("Ingrese el nombre del producto");
                NombrePro = leer.next();
                do{
                System.out.println("Ingrese los dias que se recibio el produto");
                //cant=leer.nextInt();
                    value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          cant=0;
                          }else
                         cant=Integer.parseInt(value);
                         }while(cant<=0 || cant>30);
                peps.setCant(cant);
                CPS = new float[peps.getCant()][4];
                for(int i=0;i<peps.getCant();i++){
                    for(int j=0;j<4;j++){
                        if(j==0){
                       do{
                            System.out.println("Ingrese la fecha");
                    //      CPS[i][j]=leer.nextFloat();
                         value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          CPS[i][j]=0;
                          }else
                         CPS[i][j]=Integer.parseInt(value);
                         }while(CPS[i][j]<=0 || CPS[i][j]>30);
                       do{
                    System.out.println("Ingrese las unidades compradas");
                         // CPS[i][j+1]= leer.nextFloat();
                         value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          CPS[i][j+1]=0;
                          }else
                         CPS[i][j+1]=Integer.parseInt(value);
                         }while(CPS[i][j+1]<=0);
                       do{
                         System.out.println("Ingrese el costo unitario");
                          //CPS[i][j+2] = leer.nextFloat();
                         value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          CPS[i][j+2]=0;
                          }else
                         CPS[i][j+2]=Integer.parseInt(value);
                         }while(CPS[i][j+2]<=0); 
                          CPS[i][j+3]=CPS[i][j+1]*CPS[i][j+2];
                          peps.setPEPS(CPS);
                    }
                    }
                }
                do{
                System.out.println("Ingrese las unidades Mandadas a produccion");
                //UEP = leer.nextInt();
                       value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          UEP=0;
                          }else
                            UEP=Integer.parseInt(value);
                         }while(UEP<=0 || UEP>peps.UP());
                peps.setUEP(UEP);      
                peps.print();
               break;
                
            }
            
            case 3:{
                
                System.out.println("-------------------------------------------");
                System.out.println("UEPS-(Ultimas en entrar primeras en salir)");
                
                System.out.println("Ingrese el nombre del producto");
                NombrePro = leer.next();
                  do{
                System.out.println("Ingrese los dias que se recibio el producto: ");
                //cant=leer.nextInt();
                value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          cant=0;
                          }else
                            cant=Integer.parseInt(value);
                         }while(cant<=0 || cant>30);
                ueps.setCant(cant);
                CPS = new float[ueps.getCant()][4];
                for(int i=0;i<ueps.getCant();i++){
                    for(int j=0;j<4;j++){
                          if(j==0){
                          do{
                              System.out.println("Ingrese la fecha");
                          //CPS[i][j]=leer.nextFloat();
                          value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          CPS[i][j]=0;
                          }else
                            CPS[i][j]=Integer.parseInt(value);
                         }while(CPS[i][j]<=0 || CPS[i][j]>30);
                          do{
                          System.out.println("Ingrese las unidades compradas");
                          //CPS[i][j+1]= leer.nextFloat();
                           value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          CPS[i][j+1]=0;
                          }else
                            CPS[i][j+1]=Integer.parseInt(value);
                         }while(CPS[i][j+1]<=0);
                          do{
                          System.out.println("Ingrese el costo unitario");
                          //CPS[i][j+2] = leer.nextFloat();
                          value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          CPS[i][j+2]=0;
                          }else
                            CPS[i][j+2]=Integer.parseInt(value);
                         }while(CPS[i][j+2]<=0);
                          CPS[i][j+3]=CPS[i][j+1]*CPS[i][j+2];         
                          ueps.setPEPS(CPS);
                          }
                    }
                }
                do{
                System.out.println("Ingrese la cantidad de unidades mandadas a produccion");
                //UEP = leer.nextInt();
                value=leer.next();
                           m = p.matcher(value);
                           if(!m.matches()){
                           flag=true;
                          UEP=0;
                          }else
                            UEP=Integer.parseInt(value);
                         }while(UEP<=0 || UEP>ueps.UP());
                ueps.setUEP(UEP);
                ueps.print();
                break;
            }
            
            case 4:{
                System.out.println("-------------------------------------------");
                System.out.println("Adios");
                break;
            }
            
            default:{
                man=false;
                break;
            }
           
        }
        
       }while(opc!=4 || true==false);
       
    }
    
}
