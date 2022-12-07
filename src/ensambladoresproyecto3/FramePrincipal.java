package ensambladoresproyecto3;

import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.Directory;
import compilerTools.Functions;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Luis Angel Rocha
 */
public class FramePrincipal extends javax.swing.JFrame {
     
    ArrayList<Elementos> modeloLista = new ArrayList<Elementos>();
   
    ArrayList<String> etiquetas = new ArrayList<String>();
    ArrayList<String> variables = new ArrayList<String>();
    ArrayList<String> constantes = new ArrayList<String>();
    ArrayList<String> tipo = new ArrayList<String>();

    public FramePrincipal() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo (null);
        PanelParaCodigoFuente.setEditable(true); 
        modelo = (DefaultTableModel) tabfaseuno.getModel();
        modelo2 = (DefaultTableModel) tabfasedos.getModel();
        modelo3 = (DefaultTableModel) tabsimbolos.getModel();
        Functions.setLineNumberOnJTextComponent(PanelParaCodigoFuente);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("code.png")));          
    }
    
   
    String [] nomColumnas = {"SEPARACION DE ELEMENTOS","ANALISIS LEXICO"};
    String [] datos = new String[2];
    DefaultTableModel modelo = new DefaultTableModel(null, nomColumnas){
           
    public boolean isCellEditable(int filas, int columnas) {
              if(columnas==3){
                  return true;
              }else{
                  return false;
              }}
    };
    
      
    String [] nomColumnas2 = {"DIRECCION","LINEA","ANALISIS","CODIFICACION"};
    String [] datos2 = new String[4];
    DefaultTableModel modelo2 = new DefaultTableModel(null, nomColumnas2){
        public boolean isCellEditable(int filas, int columnas) {
              if(columnas==4){
                  return true;
              }else{
                  return false;
              }}
    };
       
    String [] nomColumnas3 = {"SIMBOLO","TIPO","VALOR","TAMAÑO","DIRECCION"};
    String [] datos3 = new String[5];
    DefaultTableModel modelo3 = new DefaultTableModel(null, nomColumnas3){
        public boolean isCellEditable(int filas, int columnas) {
              if(columnas==5){
                  return true;
              }else{
                  return false;
              }}
    
    };
    
    
       public void Identificacion(){
       
            for (int i = 0; i < modeloLista.size(); i++) {
             
            ArrayList<String> elemento = modeloLista.get(i).getElemento();
            ArrayList<String> token = modeloLista.get(i).getToken();
            for (int j = 0; j < elemento.size(); j++) {

                if (token.get(j).matches("data_segment|code_segment|stack_segment|ends|db|dw|bptr|wptr|model_small")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "PSEUDOINSTRUCCION";
                    modelo.addRow(datos);
                }else if (token.get(j).matches("pseudo_const_num")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "PSEUDOINSTRUCCION, NUMERO DECIMAL";
                    modelo.addRow(datos);
                }else if (token.get(j).matches("pseudo_const_carac")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "PSEUDOINSTRUCCION, CONSTANTE";
                    modelo.addRow(datos);
                }else if (token.get(j).matches("pseudo_const_hexa")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "PSEUDOINTRUCCION, NUMERO HEXADECIMAL";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("pseudo_const_bin")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "PSEUDOINSTRUCCION, NUMERO BINARIO";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("pseudo_const_inco")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "PSEUDOINSTRUCCION SIN CONSTANTE";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("num_dec")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "NUMERO DECIMAL";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("num_exa")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "NUMERO HEXADECIMAL";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("num_bin")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "NUMERO BINARIO";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("const_carac")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "CONSTANTE";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("simbolo")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "SIMBOLO";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("registro")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "REGISTRO";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("instruccion")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "INSTRUCCION";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("instruccion2")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "INSTRUCCION";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("acc_memoria")) {
                    datos[0] = elemento.get(j);
                    datos[1] = "OPERACIONES EN MEMORIA";
                    modelo.addRow(datos);
                }
                else if (token.get(j).matches("etiqueta")) {
                    etiquetas.add(elemento.get(j));
                    datos[0] = elemento.get(j);
                    datos[1] = "ETIQUETA";
                    modelo.addRow(datos);
                }
                else{
                    datos[0] = elemento.get(j);
                    datos[1] = "ELEMENTO NO IDENTIFICADO";
                    modelo.addRow(datos);
                }
            }
        }
        Analisis();

    }

    Integer memoria = 0;
    
    public void Analisis(){//hexa
        for (int i = 0; i < modeloLista.size(); i++) {
            
            String linea = modeloLista.get(i).getLinea();
            ArrayList<String> elemento = modeloLista.get(i).getElemento();
            ArrayList<String> token = modeloLista.get(i).getToken();
            System.out.println("RESULTADO DE ELEMENTO"+elemento);
            System.out.println("RESULTADO DE TOKEN"+token);
            
            for (int j = 0; j < token.size(); j++) {
                if (token.get(j).matches("stack_segment|Data_Segment|data_segment|code_segment|ends")) {
                    int n = token.size();
                    if (n == 1) {
                        if (memoria == 0) {
                            datos2[0] = memoria.toString();
                        }else{
                            datos2[0] = memoria.toString();
                        }
                                
                        IniFinSegmento(token.get(j));
                        
                        datos2[1] = linea;
                        datos2[2] = "CORRECTO";
                        datos2[3] = "";
                        modelo2.addRow(datos2);
                        break;
                    }else{
                        datos2[1] = linea;
                        datos2[2] = "INCORRECTO";
                        datos2[3] = "";
                        modelo2.addRow(datos2);
                        break;
                    }
                }
                
                //----SHL----
                if(token.get(j).matches("instruccion")){
                   if(elemento.get(j).matches("SHL|shl")){ 
                       int n = token.size();
                        if(n == 3){
                            if(token.get(j+1).matches("registro") && token.get(j+2).matches("num_dec|num_bin|num_exa")){
                             
                             if(elemento.get(j+2).equals("1")){
                                  
                                  String codifig = codifSHLRegWithUno(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2), token.get(j+1), elemento.get(j+1));
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = codifig;
                                  modelo2.addRow(datos2);
                                  break;
                             } 
                           }if(token.get(j+1).matches("simbolo") && token.get(j+2).matches("num_dec|num_bin|num_exa")){
                              if(elemento.get(j+2).equals("1")){
                                  
                                  String codifig = codifSHLRegWithUno(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2), token.get(j+1), elemento.get(j+1));
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = codifig;
                                  modelo2.addRow(datos2);
                                  break;
                             }  
                           }
                            
                            if(token.get(j).matches("acc_memoria") && token.get(j+2).matches("num_dec")){
                                
                                if(elemento.get(j+2).equals("1")){
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = "";
                                  modelo2.addRow(datos2);
                                  break;
                                }
                                
                           }if(token.get(j+1).matches("registro") && token.get(j+2).matches("registro")){
                             
                             if(elemento.get(j+2).equals("CL")){
                                  
                                 String codifig = codifSHLRegWithUno(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2), token.get(j+1), elemento.get(j+1));
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = codifig;
                                  modelo2.addRow(datos2);
                                  break;
                             } 
                           }
                           if(token.get(j+1).matches("acc_memoria") && token.get(j+2).matches("registro")){
                             if(elemento.get(j+2).equals("CL")){
                                  
                                  String codifig = codifSHLRegWithUno(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2), token.get(j+1), elemento.get(j+1));
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = codifig;
                                  modelo2.addRow(datos2);
                                  break;
                             }   
                           }
                           if(token.get(j+1).matches("simbolo") && token.get(j+2).matches("registro")){
                              if(elemento.get(j+2).equals("CL")){
                                  
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = "";
                                  modelo2.addRow(datos2);
                                  break;
                             }     
                           }
                           if(token.get(j+1).matches("registro") && token.get(j+2).matches("num_dec")){
                               
                               String correcto = compInmByte(token.get(j+2), elemento.get(j+2));
                               
                               if(correcto.equals("correcto")){
                                  String codifig = codifSHLRegWithUno(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2), token.get(j+1), elemento.get(j+1));
                                  
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = codifig;
                                  modelo2.addRow(datos2);
                                  break;
                             }  
                           }
                           if(token.get(j+1).matches("acc_memoria") && token.get(j+2).matches("num_dec")){
                               String correcto = compInmByte(token.get(j+2), elemento.get(j+2));
                               
                               if(correcto.equals("correcto")){
                                  
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = "";
                                  modelo2.addRow(datos2);
                                  break;
                             }     
                           }
                            if(token.get(j+1).matches("simbolo") && token.get(j+2).matches("num_dec")){
                                String correcto = compInmByte(token.get(j+2), elemento.get(j+2));
                               
                               if(correcto.equals("correcto")){
                                  
                                  datos2[0] = memoria.toString();
                                  InstSHL(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = "";
                                  modelo2.addRow(datos2);
                                  break;
                             }     
                            }
                              
                            
                            }
                     
                        }
                   }
                
                
                //----XCHG----
                if(token.get(j).matches("instruccion")){
                    if(elemento.get(j).matches("XCHG|xchg")){
                        int n = token.size();
                        if(n>= 3){
                            if(token.get(j+1).matches("registro") && token.get(j+2).matches("registro")){
                              String reg_reg = verifRegReg(elemento.get(j+2), elemento.get(j+2));
                              
                              if (reg_reg.equals("correcto")) {
                                  
                                  String codifing = codifXCHG(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2), token.get(j+1), elemento.get(j+1));
                                  datos2[0] = memoria.toString();
                                  Instrucciones4(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                  datos2[1] = linea;
                                  datos2[2] = "CORRECTO";
                                  datos2[3] = codifing;
                                  modelo2.addRow(datos2);
                                  break;
                              }else{
                                    datos2[0] = memoria.toString();
                                    datos2[1] = linea;
                                    datos2[2] = "INCORRECTO";
                                    datos2[3] = "";
                                    modelo2.addRow(datos2);
                                    break;
                                }
                            }
                            
                            if (token.get(j+1).matches("registro") && token.get(j+2).matches("simbolo|acc_memoria")) {
                                String correcto = verifMemReg(token.get(j+2), elemento.get(j+2));
                                
                                if (correcto.equals("correcto")) {
                                    
                                    String codifing = codifXCHG(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2), token.get(j+1), elemento.get(j+1));
                                    datos2[0] = memoria.toString();
                                    
                                    Instrucciones4(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                    
                                    datos2[1] = linea;
                                    datos2[2] = "CORRECTO";
                                    datos2[3] = codifing;
                                    modelo2.addRow(datos2);
                                    break;
                                }else{
                                    datos2[0] = memoria.toString();
                                    datos2[1] = linea;
                                    datos2[2] = "INCORRECTO, LA MEMORIA NO ES VALIDA";
                                    datos2[3] = "";
                                    modelo2.addRow(datos2);
                                    break;
                                }
                            }
                          
                        }else if(n < 3){
                            datos2[0] = memoria.toString();
                            datos2[1] = linea;
                            datos2[2] = "INCORRECTO, LA INSTRUCION REQUIERE DE MAS OPERADORES";
                            datos2[3] = "";
                            modelo2.addRow(datos2);
                            break;
                        }
                    }
                    
                }

                //**********INSTRUCCIONES 4**********//
                if (token.get(j).matches("instruccion")) {
                    if (elemento.get(j).matches("ADD|add")) {
                        int n = token.size();
                        if (n >= 3) {
                            if (token.get(j+1).matches("registro") && token.get(j+2).matches("registro")) {
                                String reg_reg = verifRegReg(elemento.get(j+2), elemento.get(j+2));
                                
                                if (reg_reg.equals("correcto")) {
                                    
                                    String codifig = codificacionADDregwithreg1(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2));
                                    datos2[0] = memoria.toString();
                                    
                                    Instrucciones4(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                    
                                    datos2[1] = linea;
                                    datos2[2] = "CORRECTO";
                                    datos2[3] = codifig;
                                    modelo2.addRow(datos2);
                                    break;
                                }else{
                                    datos2[0] = memoria.toString();
                                    datos2[1] = linea;
                                    datos2[2] = "INCORRECTO";
                                    datos2[3] = "";
                                    modelo2.addRow(datos2);
                                    break;
                                }
                            } 
                            
                            if (token.get(j+1).matches("simbolo|acc_memoria") && token.get(j+2).matches("registro")) {
                                
                                String correcto = verifMemReg(token.get(j+1),elemento.get(j+1));
                                
                                if (correcto.equals("correcto")) {
                                    String codifig = codificacionADDregwithreg1(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2));
                                    datos2[0] = memoria.toString();
                                    
                                    Instrucciones4(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                    
                                    datos2[1] = linea;
                                    datos2[2] = "CORRECTO";
                                    datos2[3] = codifig;
                                    modelo2.addRow(datos2);
                                    break;
                                }else{
                                    datos2[0] = memoria.toString();
                                    datos2[1] = linea;
                                    datos2[2] = "INCORRECTO, LA MEMORIA NO ES VALIDA";
                                    datos2[3] = "";
                                    modelo2.addRow(datos2);
                                    break;
                                }
                                
                            }
                            
                            if (token.get(j+1).matches("registro") && token.get(j+2).matches("simbolo|acc_memoria")) {
                                String correcto = verifMemReg(token.get(j+2), elemento.get(j+2));
                                
                                if (correcto.equals("correcto")) {
                                    String codifig = codificacionADDregwithreg1(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2));
                                    datos2[0] = memoria.toString();
                                    
                                    Instrucciones4(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                    
                                    datos2[1] = linea;
                                    datos2[2] = "CORRECTO";
                                    datos2[3] = codifig;
                                    modelo2.addRow(datos2);
                                    break;
                                }else{
                                    datos2[0] = memoria.toString();
                                    datos2[1] = linea;
                                    datos2[2] = "INCORRECTO, LA MEMORIA NO ES VALIDA";
                                    datos2[3] = "";
                                    modelo2.addRow(datos2);
                                    break;
                                }
                            }
                            
                            if (token.get(j+1).matches("simbolo|acc_memoria") && token.get(j+2).matches("num_dec|num_exa|num_bin")) {

                                String correcto = verifMemReg(token.get(j+1), elemento.get(j+1));
                                
                                if (correcto.equals("correcto")) {
                                    String codifig = codificacionADDregwithreg1(elemento.get(j), elemento.get(j+1), elemento.get(j+2), token.get(j+2));
                                    datos2[0] = memoria.toString();
                                    
                                    Instrucciones4(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                    
                                    datos2[1] = linea;
                                    datos2[2] = "CORRECTO";
                                    datos2[3] = codifig;
                                    modelo2.addRow(datos2);
                                    break;
                                }else{
                                    datos2[0] = memoria.toString();
                                    datos2[1] = linea;
                                    datos2[2] = "INCORRECTO, LA MEMORIA NO ES VALIDA";
                                    datos2[3] = "";
                                    modelo2.addRow(datos2);
                                    break;
                                }
                            }
                            
                            if (token.get(j+1).matches("registro") && token.get(j+2).matches("num_dec|num_exa|num_bin")) {
                                
                                datos2[0] = memoria.toString();
                                String codifig = codificacionADDregwithreg1(elemento.get(j), elemento.get(j+1),elemento.get(j+2), token.get(j+2)); 
                                Instrucciones4(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                datos2[3] = codifig;
                                modelo2.addRow(datos2);
                                break;
                            }
                        }else if(n < 3){
                            datos2[0] = memoria.toString();
                            datos2[1] = linea;
                            datos2[2] = "INCORRECTO, LA INSTRUCION REQUIERE DE MAS OPERADORES";
                            datos2[3] = "";
                            modelo2.addRow(datos2);
                            break;
                        }
                    }
                }
                
                //**********INSTRUCCIONES 5**********//
                if (token.get(j).matches("instruccion")) {
                    if (elemento.get(j).matches("LEA|lea")) {
                        
                        int n = token.size();
        
                        if (n == 3) {
                            String correcto = verifMemReg(token.get(j+2), elemento.get(j+2));
                                
                            if (correcto.equals("correcto")) {
                                
                                datos2[0] = memoria.toString();
                                
                                Instrucciones5(token.get(j+2), elemento.get(j+2));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                modelo2.addRow(datos2);
                                break;
                            }else{
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA MEMORIA NO ES VALIDA";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }
                        }else{
                            if (n < 3) {
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION REQUIERE DE MAS OPERADORES";
                                datos2[3] = "";
                                modelo2.addRow(datos2); 
                                break;
                            }else if(n > 3){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, SE EXEDIO EL NUMERO DE OPERADORES NECESARIOS PARA LA INSTRUCCION";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }  
                        }
                    }
                }
                
                //**********INSTRUCCIONES 3**********//
                if (token.get(j).matches("instruccion")) {
                    if (elemento.get(j).matches("IDIV|DIV|IMUL|idiv|div|imul")) {
                        
                        int n = token.size();
        
                        if (n == 2) {
                            String correcto = instruccionRegistroMemoria(token.get(j+1), elemento.get(j+1)); 
                            if (correcto.equals("correcto")) {
                                
                                String codifig = codificacionImulDivIdiv(elemento.get(j), elemento.get(j+1), token.get(j+1), elemento.get(j+1));
                                datos2[0] = memoria.toString();
                                
                                Instrucciones3(elemento.get(j), token.get(j+1), elemento.get(j+1));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                datos2[3] = codifig;
                                modelo2.addRow(datos2);
                                break;
                            }else{
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, EL OPERADOR DE LA INSTRUCCION NO ES VALIDO";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }
                        }else{
                            if (n == 1) {
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION NECESITA UN OPERADOR MAS";
                                datos2[3] = "";
                                modelo2.addRow(datos2); 
                                break;
                            }else if(n > 2){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION SOLO REQUIERE DE UN OPERADOR";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }  
                        }
                    }
                }
                
                //CODIGO PARA INSTRUCCION LDS
                if (token.get(j).matches("instruccion")){
                    if(elemento.get(j).matches("LDS|lds")){
                        int n = token.size();
                        
                        if(n == 3){
                            String correcto = instruccionRegistroMemoria(token.get(j+1), elemento.get(j+1));
                            
                            if(correcto.equals("correcto")){
                                datos2[0] = memoria.toString();
                                InsLDS(elemento.get(j), token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                
                                String codifig = codificacionLDS(elemento.get(j), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                datos2[3] = codifig;
                                modelo2.addRow(datos2);
                                break;  
                            }else{
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, EL OPERADOR DE LA INSTRUCCION NO ES VALIDO";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }                                                                       
                        }else{
                            if(n <= 2){
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION REQUIERE MAS OPERADORES";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }else if(n >= 4){
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION REQUIERE MENOS OPERADORES";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }
                        }
                    }                    
                }
                
                //**********INSTRUCCIONES 2, SOLO NECESITAN UN OPERADOR**********//
                if (token.get(j).matches("instruccion")) {
                    if (elemento.get(j).matches("JNS|JS|LOOPNE|JAE|JCXZ|JL|jns|js|loopne|jae|jcxz|jl")) {
                        
                        int n = token.size();
        
                        if (n == 2) {
                            String correcto = instruccionesEtiquetas(elemento.get(j+1)); 
                            if (correcto.equals("correcto")) {
                                
                                datos2[0] = memoria.toString();
                                
                                System.out.println("IMPRESION DE LA MEMORIA DOS "+memoria);
                                Instrucciones2(elemento.get(j));
                                
                                String codifig = codificacion2(elemento.get(j), elemento.get(j+1));

                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                datos2[3] = codifig;
                                modelo2.addRow(datos2);
                                break;
                            }else{
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA ETIQUETA A LA QUE SE QUIERE REALIZAR EL SALTO NO ES CORRECTA";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }
                        }else{
                            if (n == 1) {
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION NECESITA DE UN OPERADOR MAS";
                                datos2[3] = "";
                                modelo2.addRow(datos2); 
                                break;
                            }else if(n > 2){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION SOLO REQUIERE DE UN OPERADOR";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }  
                        }
                    }
                }
                
                //INSTRUCCION POP SOLO LLEVA UN OPERANDO
                if(token.get(j).matches("instruccion")){
                    
                    if(elemento.get(j).matches("POP|pop")){
                        
                        int n = token.size();
                        
                        if(n == 2 ){
                          String correcto = instruccionRegistroMemoria(token.get(j+1), elemento.get(j+1));
                            
                            if(correcto.equals("correcto")){
                                
                                datos2[0] = memoria.toString();
                                Instrucciones3(elemento.get(j), token.get(j+1), elemento.get(j+1));
                                
                                String codifig = codificacion3(elemento.get(j), elemento.get(j+1), token.get(j+1), elemento.get(j+1));
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                datos2[3]  = codifig; 
                                modelo2.addRow(datos2);
                                break;  
                            }else{
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, EL OPERADOR DE LA INSTRUCCION NO ES VALIDO";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }                                                                       
                        }else{
                            if(n < 2){
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION REQUIERE MAS OPERADORES";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }else if(n >= 3){
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA INSTRUCCION REQUIERE MENOS OPERADORES";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }
                    }
                }
                }
                
                //**********INSTRUCCIONES 1, QUE NO LLEVAN OPERANDOS**********//
                if (token.get(j).matches("instruccion")) {
                                              
                    if (elemento.get(j).matches("STD|AAD|CLD|CWD|IRET|MOVSW|std|aad|cld|cwd|iret|movsw")) {

                        int n = token.size();
                        
                        if (n > 1) {
                            datos2[0] = memoria.toString();
                            datos2[1] = linea;
                            datos2[2] = "INCORRECTO, LA INSTRUCCION NO REQUIERE DE OPERADORES";
                            //datos2[3] = "";
                            modelo2.addRow(datos2);
                            break;
                        }else{
                            
                            datos2[0] = memoria.toString();
                                
                            Instrucciones1(elemento.get(j));
                            
                            String codifig = codificacion1(elemento.get(j));
                            
                            datos2[1] = linea;
                            datos2[2] = "CORRECTO";
                            datos2[3] = codifig;
                            modelo2.addRow(datos2); 
                            break;
                        }
                    }
                }
                
                //**********DATA SEGMENT**********//
                try {
                    if (token.get(j).matches("dw") && token.get(j+1).matches("num_dec|num_exa|num_bin") && 
                        token.get(j+2).matches("pseudo_const_num|pseudo_const_hexa|pseudo_const_bin")) {
                        
                        int n = token.size();
                        
                        if (n == 3) {
                            String correcto =  verifPila(token.get(j+1), elemento.get(j+1), token.get(j+2), elemento.get(j+2));
                            
                            if (correcto.equals("correcto")) {
                                datos2[0] = memoria.toString();
                                
                                DataSegment(token.get(j+1), elemento.get(j+1));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("num1_inc")){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA CONSTANTE DEBE ESTAR ENTRE 0 Y 65535";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("num2_inc")){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA CONSTANTE DEBE ESTAR ENTRE 0 Y 65535";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                            }
                            
                        }else if (n > 3) {
                            datos2[0] = memoria.toString();
                            datos2[1] = linea;
                            datos2[2] = "INCORRECTO, HAY UN EXCESO DE ELEMENTOS EN LA LINEA";
                            datos2[3] = "";
                            modelo2.addRow(datos2);
                            break;
                        }else if (n < 3) {
                            datos2[0] = memoria.toString();
                            datos2[1] = linea;
                            datos2[2] = "INCORRECTO, HACEN FALTA ELEMENTOS";
                            datos2[3] = "";
                            modelo2.addRow(datos2);
                            break;
                        }
                        
                    }
                } catch (Exception e) {
                }
                
                
                try{
                    if(token.get(j).equals("simbolo") && token.get(j+1).matches("db|dw")){
                         if (token.size() == 2) {                                
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, HACE FALTA ASIGNAR UN VALOR A LA VARIABLE";
                                datos2[3] = "";
                                modelo2.addRow(datos2);
                                break;
                    }
                    }
                }catch(Exception e){
                    
                }
                
                                try{
                    if(token.get(j).equals("simbolo") && token.get(j+1).matches("num_exa|num_bin|num_dec")){
                         if (token.size() == 2) {                                
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, HACE FALTA ASIGNAR EL TIPO DE VARIABLE";
                                modelo2.addRow(datos2);
                                break;
                    }
                    }
                }catch(Exception e){
                    
                }
                                
                try{
                    if(token.get(j).equals("db|dw") && token.get(j+1).matches("num_exa|num_bin|num_dec")){
                         if (token.size() == 2) {                                
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, HACE FALTA ASIGNAR UN NOMBRE PARA LA VARIABLE";
                                modelo2.addRow(datos2);
                                break;
                    }
                    }
                }catch(Exception e){
                    
                }
                
                //**********CONSTANTE - SIMBOLO EQU CONSTANTE NUMERICA PALABRA**********//
                try {
                    if (token.get(j).equals("simbolo") && token.get(j+1).matches("equ") && token.get(j+2).matches("num_exa|num_bin|num_dec")) {
                        int n = token.size();
                        
                        if (n == 3) {
                            String correcto = comprobarConstante(token.get(j), token.get(j+2), elemento.get(j+2));
                            
                            if (correcto.equals("correcto")) {
                                //variables.add(elemento.get(j));
                                //tipo.add(token.get(j+1));
                                                      
                                datos2[0] = memoria.toString();
                                
                                Constante(elemento.get(j), elemento.get(j+1), elemento.get(j+2));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("inc_simbolo")){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, EL SIMBOLO ES INCORRECTO";
                                modelo2.addRow(datos2);
                                break;
                            }else{
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA CONSTANTE DEBE ESTAR ENTRE 0 Y 65535";
                                modelo2.addRow(datos2);
                                break;
                            }
                        }else if (n > 3) {
                            datos2[0] = memoria.toString();
                            datos2[1] = linea;
                            datos2[2] = "INCORRECTO, HAY UN EXCESO DE ELEMENTOS";
                            modelo2.addRow(datos2);
                            break;
                        }else if (n < 3) {
                            datos2[0] = memoria.toString();
                            datos2[1] = linea;
                            datos2[2] = "INCORRECTO, HACEN FALTA ELEMENTOS";
                            modelo2.addRow(datos2);
                            break;
                        }
                    }
                } catch (Exception e) {
                }

                //**********VARIABLES 1 - SIMBOLO DB/DW CONSTANTE NUMERICA BYTE/CONSTANTE NUMERICA PALABRA**********//
                try {
                    if (token.get(j).equals("simbolo") && token.get(j+1).matches("db|dw") && token.get(j+2).matches("num_exa|num_bin|num_dec")) {
                        if (token.size() == 3) {
                            String correcto = comprobarVariable1(elemento.get(j), token.get(j+1), token.get(j+2), elemento.get(j+2));

                            if(correcto.equals("correcto")){
                                variables.add(elemento.get(j));
                                tipo.add(token.get(j+1));
                                                      
                                datos2[0] = memoria.toString();
                                
                                Memoria1(elemento.get(j), elemento.get(j+1), elemento.get(j+2));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("simbolo_invalido")){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, EL IDENTIFICADOR DE LA VARIABLE SOLO PUEDE TENER HASTA 10 CARACTERES";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("const_num_db_inc")){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA CONSTANTE NUMERICA BYTE DEBE ESTAR ENTRE 0 Y 255";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("const_num_dw_inc")){
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA CONSTRANTE NUMERICA WORD DEBE ESTAR ENTRE 0 Y 65535";
                                modelo2.addRow(datos2);
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                }
                
                //**********VARIABLES 2 - SIMBOLO DB CONSTANTE CARACTER**********//
                try {
                    if (token.get(j).equals("simbolo") && token.get(j+1).matches("db") && token.get(j+2).matches("const_carac")) {
                        if (token.size() == 3) {
                            if (elemento.get(j).length() <= 10) {
                                variables.add(elemento.get(j));
                                tipo.add(token.get(j+1));
                                
                                datos2[0] = memoria.toString();
                                
                                Memoria2(elemento.get(j), elemento.get(j+1), elemento.get(j+2));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                modelo2.addRow(datos2);
                                break;
                            }else{
                                datos2[0] = memoria.toString();
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, EL IDENTIFICADOR DE LA VARIABLE SOLO PUEDE TENER HASTA 10 CARACTERES";
                                modelo2.addRow(datos2);
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                }
                
                //**********VARIABLES 3 - SIMBOLO DB/DW CONSTANTE NUMERICA PALABRA DUP(CACARTER/NUMERICA/PALABRA)**********//
                try {
                    if (token.get(j).equals("simbolo") && token.get(j+1).matches("db|dw") && token.get(j+2).matches("num_exa|num_bin|num_dec") && token.get(j+3).matches("pseudo_const_carac|pseudo_const_num|pseudo_const_hexa|pseudo_const_bin")) {
                        if (token.size() == 4) {
                            String correcto = comprobarVariable2(elemento.get(j), token.get(j+1), token.get(j+2), elemento.get(j+2), token.get(j+3), elemento.get(j+3));
                            
                            if(correcto.equals("correcto")){
                                variables.add(elemento.get(j));
                                tipo.add(token.get(j+1));
                                
                                datos2[0] = memoria.toString();
                                
                                Memoria3(elemento.get(j), elemento.get(j+1), elemento.get(j+2), elemento.get(j+3), token.get(j+2));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("simbolo_invalido")){
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, EL IDENTIFICADOR DE LA VARIABLE SOLO PUEDE TENER HASTA 10 CARACTERES";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("const_num_inc")){
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO, LA CONSTANTE NUMERICA WORD DEBE ESTAR ENTRE 0 y 65535";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("error")){
                                datos2[1] = linea;
                                datos2[2] = "INCORRECTO";
                                modelo2.addRow(datos2);
                                break;
                            }else if(correcto.equals("const_inc")){
                                if (token.get(j+1).matches("db")) {
                                    datos2[1] = linea;
                                    datos2[2] = "INCORRECTO, LA CONSTANTE DENTRO DEL DUP() DEBE ESTAR ENTRE 0 Y 255";
                                    modelo2.addRow(datos2);
                                    break;
                                }else if(token.get(j+1).matches("dw")){
                                    datos2[1] = linea;
                                    datos2[2] = "INCORRECTO, LA CONSTANTE DENTRO DEL DUP() DEBE ESTAR ENTRE 0 Y 65535";
                                    modelo2.addRow(datos2);
                                    break;
                                }
                                
                            }
                        }
                    }
 
                } catch (Exception e) {
                }
                
                 try {
                    if (token.get(j).equals("simbolo") && token.get(j+1).matches("db|dw") && token.get(j+2).matches("num_exa|num_bin|num_dec") && token.get(j+3).matches("pseudo_const_inco")) {
                        if (token.size() == 4) {
                            String correcto = comprobarVariable2(elemento.get(j), token.get(j+1), token.get(j+2), elemento.get(j+2), token.get(j+3), elemento.get(j+3));
                            
                           // if(correcto.equals("correcto")){
                                variables.add(elemento.get(j));
                                tipo.add(token.get(j+1));
                                
                                datos2[0] = memoria.toString();
                                
                                Memoria3(elemento.get(j), elemento.get(j+1), elemento.get(j+2), elemento.get(j+3), token.get(j+2));
                                
                                datos2[1] = linea;
                                datos2[2] = "CORRECTO";
                                modelo2.addRow(datos2);
                                break;
                        
                        }
                    }
 
                } catch (Exception e) {
                }
                
                if (token.get(j).matches("etiqueta")) {
                    
                    datos2[0] = memoria.toString();
                                
                    Etiqueta(elemento.get(j));
                                
                    datos2[1] = linea;
                    datos2[2] = "CORRECTO";
                    datos2[3] = "";
                    modelo2.addRow(datos2);
                    break;
                }else{
                    datos2[0] = memoria.toString();
                    datos2[1] = linea;
                    datos2[2] = "INCORRECTO";
                    datos2[3] = "";
                    modelo2.addRow(datos2);
                    break;
                }
            }
        }
        MemHexa();
    }
    
    public String codifXCHG(String instruccion, String registro, String registro2, String num, String tipoIns, String variable){
      String  codificacion = "";
       
      if(instruccion.matches("XCHG|xchg")){
            if(registro.matches("AX|ax") && registro2.matches("AX|ax")){
                codificacion = "90";
           }if(registro.matches("AX|ax") && registro2.matches("CX|cx")){
               codificacion = "91";
           }if(registro.matches("AX|ax") && registro2.matches("DX|dx")){
               codificacion = "92";
           }if(registro.matches("AX|ax") && registro2.matches("BX|bx")){
               codificacion = "93";
           }if(registro.matches("AX|ax") && registro2.matches("SP|sp")){
               codificacion = "94";
           }if(registro.matches("AX|ax") && registro2.matches("BP|bp")){
               codificacion = "95";
           }if(registro.matches("AX|ax") && registro2.matches("SI|si")){
               codificacion = "96";
           }if(registro.matches("AX|ax") && registro2.matches("DI|di")){
               codificacion = "97";
           }
           
            if(registro.matches("CX|cx") && registro2.matches("AX|ax")){
                codificacion = "91";
           }if(registro.matches("CX|cx") && registro2.matches("CX|cx")){
               codificacion = "87C9";
           }if(registro.matches("CX|cx") && registro2.matches("DX|dx")){
               codificacion = "87CA";
           }if(registro.matches("CX|cx") && registro2.matches("BX|bx")){
               codificacion = "87CB";
           }if(registro.matches("CX|cx") && registro2.matches("SP|sp")){
               codificacion = "87CC";
           }if(registro.matches("CX|cx") && registro2.matches("BP|bp")){
               codificacion = "87CD";
           }if(registro.matches("CX|cx") && registro2.matches("SI|si")){
               codificacion = "87CE";
           }if(registro.matches("CX|cx") && registro2.matches("DI|di")){
               codificacion = "87CF";
           }
           
            if(registro.matches("DX|dx") && registro2.matches("AX|ax")){
                codificacion = "92";
           }if(registro.matches("DX|dx") && registro2.matches("CX|cx")){
               codificacion = "87D1";
           }if(registro.matches("DX|dx") && registro2.matches("DX|dx")){
               codificacion = "87D2";
           }if(registro.matches("DX|dx") && registro2.matches("BX|bx")){
               codificacion = "87D3";
           }if(registro.matches("DX|dx") && registro2.matches("SP|sp")){
               codificacion = "87D4";
           }if(registro.matches("DX|dx") && registro2.matches("BP|bp")){
               codificacion = "87D5";
           }if(registro.matches("DX|dx") && registro2.matches("SI|si")){
               codificacion = "87D6";
           }if(registro.matches("DX|dx") && registro2.matches("DI|di")){
               codificacion = "87D7";
           }
           
            if(registro.matches("BX|bx") && registro2.matches("AX|ax")){
               codificacion = "93";
           }if(registro.matches("BX|bx") && registro2.matches("CX|cx")){
               codificacion = "87D9";
           }if(registro.matches("BX|bx") && registro2.matches("DX|dx")){
               codificacion = "87DA";
           }if(registro.matches("BX|bx") && registro2.matches("BX|bx")){
               codificacion = "87DB";
           }if(registro.matches("BX|bx") && registro2.matches("SP|sp")){
               codificacion = "87DC";
           }if(registro.matches("BX|bx") && registro2.matches("BP|bp")){
               codificacion = "87DD";
           }if(registro.matches("BX|bx") && registro2.matches("SI|si")){
               codificacion = "87DE";
           }if(registro.matches("BX|bx") && registro2.matches("DI|di")){
               codificacion = "87DF";
           }
           
            if(registro.matches("SP|sp") && registro2.matches("AX|ax")){
               codificacion = "94";
           }if(registro.matches("SP|sp") && registro2.matches("CX|cx")){
               codificacion = "87E1";
           }if(registro.matches("SP|sp") && registro2.matches("DX|dx")){
               codificacion = "87E2";
           }if(registro.matches("SP|sp") && registro2.matches("BX|bx")){
               codificacion = "87E3";
           }if(registro.matches("SP|sp") && registro2.matches("SP|sp")){
               codificacion = "87E4";
           }if(registro.matches("SP|sp") && registro2.matches("BP|bp")){
               codificacion = "87E5";
           }if(registro.matches("SP|sp") && registro2.matches("SI|si")){
               codificacion = "87E6";
           }if(registro.matches("SP|sp") && registro2.matches("DI|di")){
               codificacion = "87E7";
           }
           
            if(registro.matches("BP|bp") && registro2.matches("AX|ax")){
               codificacion = "95";
           }if(registro.matches("BP|bp") && registro2.matches("CX|cx")){
               codificacion = "87E9";
           }if(registro.matches("BP|bp") && registro2.matches("DX|dx")){
               codificacion = "87EA";
           }if(registro.matches("BP|bp") && registro2.matches("BX|bx")){
               codificacion = "87EB";
           }if(registro.matches("BP|bp") && registro2.matches("SP|sp")){
               codificacion = "87EC";
           }if(registro.matches("BP|bp") && registro2.matches("BP|bp")){
               codificacion = "87ED";
           }if(registro.matches("BP|bp") && registro2.matches("SI|si")){
               codificacion = "87EE";
           }if(registro.matches("BP|bp") && registro2.matches("DI|di")){
               codificacion = "87EF";
           }
           
            if(registro.matches("SI|si") && registro2.matches("AX|ax")){
               codificacion = "96";
           }if(registro.matches("SI|si") && registro2.matches("CX|cx")){
               codificacion = "87F1";
           }if(registro.matches("SI|si") && registro2.matches("DX|dx")){
               codificacion = "87F2";
           }if(registro.matches("SI|si") && registro2.matches("BX|bx")){
               codificacion = "87F3";
           }if(registro.matches("SI|si") && registro2.matches("SP|sp")){
               codificacion = "87F4";
           }if(registro.matches("SI|si") && registro2.matches("BP|bp")){
               codificacion = "87F5";
           }if(registro.matches("SI|si") && registro2.matches("SI|si")){
               codificacion = "87F6";
           }if(registro.matches("SI|si") && registro2.matches("DI|di")){
               codificacion = "87F7";
           }
           
            if(registro.matches("DI|di") && registro2.matches("AX|ax")){
               codificacion = "97";
           }if(registro.matches("DI|di") && registro2.matches("CX|cx")){
               codificacion = "87F9";
           }if(registro.matches("DI|di") && registro2.matches("DX|dx")){
               codificacion = "87FA";
           }if(registro.matches("DI|di") && registro2.matches("BX|bx")){
               codificacion = "87FB";
           }if(registro.matches("DI|di") && registro2.matches("SP|sp")){
               codificacion = "87FC";
           }if(registro.matches("DI|di") && registro2.matches("BP|bp")){
               codificacion = "87FD";
           }if(registro.matches("DI|di") && registro2.matches("SI|si")){
               codificacion = "87FE";
           }if(registro.matches("DI|di") && registro2.matches("DI|di")){
               codificacion = "87FF";
           }
           
            if(registro.matches("AL|al") && registro2.matches("AL|al")){
               codificacion = "86C0";
           }if(registro.matches("AL|al") && registro2.matches("CL|cl")){
               codificacion = "86C1";
           }if(registro.matches("AL|al") && registro2.matches("DL|dl")){
               codificacion = "86C2";
           }if(registro.matches("AL|al") && registro2.matches("BL|bl")){
               codificacion = "86C3";
           }if(registro.matches("AL|al") && registro2.matches("AH|ah")){
               codificacion = "86C4";
           }if(registro.matches("AL|al") && registro2.matches("CH|ch")){
               codificacion = "86C5";
           }if(registro.matches("AL|al") && registro2.matches("DH|dh")){
               codificacion = "86C6";
           }if(registro.matches("AL|al") && registro2.matches("BH|bh")){
               codificacion = "86C7";
           }
           
            if(registro.matches("CL|cl") && registro2.matches("AL|al")){
               codificacion = "86C8";
           }if(registro.matches("CL|cl") && registro2.matches("CL|cl")){
               codificacion = "86C9";
           }if(registro.matches("CL|cl") && registro2.matches("DL|dl")){
               codificacion = "86CA";
           }if(registro.matches("CL|cl") && registro2.matches("BL|bl")){
               codificacion = "86CB";
           }if(registro.matches("CL|cl") && registro2.matches("AH|ah")){
               codificacion = "86CC";
           }if(registro.matches("CL|cl") && registro2.matches("CH|ch")){
               codificacion = "86CD";
           }if(registro.matches("CL|cl") && registro2.matches("DH|dh")){
               codificacion = "86CE";
           }if(registro.matches("CL|cl") && registro2.matches("BH|bh")){
               codificacion = "86CF";
           }
           
            if(registro.matches("DL|dl") && registro2.matches("AL|al")){
               codificacion = "86D0";
           }if(registro.matches("DL|dl") && registro2.matches("CL|cl")){
               codificacion = "86D1";
           }if(registro.matches("DL|dl") && registro2.matches("DL|dl")){
               codificacion = "86D2";
           }if(registro.matches("DL|dl") && registro2.matches("BL|bl")){
               codificacion = "86D3";
           }if(registro.matches("DL|dl") && registro2.matches("AH|ah")){
               codificacion = "86D4";
           }if(registro.matches("DL|dl") && registro2.matches("CH|ch")){
               codificacion = "86D5";
           }if(registro.matches("DL|dl") && registro2.matches("DH|dh")){
               codificacion = "86D6";
           }if(registro.matches("DL|dl") && registro2.matches("BH|bh")){
               codificacion = "86D7";
           }
           
            if(registro.matches("BL|bl") && registro2.matches("AL|al")){
               codificacion = "86D8";
           }if(registro.matches("BL|bl") && registro2.matches("CL|cl")){
               codificacion = "86D9";
           }if(registro.matches("BL|bl") && registro2.matches("DL|dl")){
               codificacion = "86DA";
           }if(registro.matches("BL|bl") && registro2.matches("BL|bl")){
               codificacion = "86DB";
           }if(registro.matches("BL|bl") && registro2.matches("AH|ah")){
               codificacion = "86DC";
           }if(registro.matches("BL|bl") && registro2.matches("CH|ch")){
               codificacion = "86DD";
           }if(registro.matches("BL|bl") && registro2.matches("DH|dh")){
               codificacion = "86DE";
           }if(registro.matches("BL|bl") && registro2.matches("BH|bh")){
               codificacion = "86DF";
           }
           
            if(registro.matches("AH|ah") && registro2.matches("AL|al")){
               codificacion = "86E0";
           }if(registro.matches("AH|ah") && registro2.matches("CL|cl")){
               codificacion = "86E1";
           }if(registro.matches("AH|ah") && registro2.matches("DL|dl")){
               codificacion = "86E2";
           }if(registro.matches("AH|ah") && registro2.matches("BL|bl")){
               codificacion = "86E3";
           }if(registro.matches("AH|ah") && registro2.matches("AH|ah")){
               codificacion = "86E4";
           }if(registro.matches("AH|ah") && registro2.matches("CH|ch")){
               codificacion = "86E5";
           }if(registro.matches("AH|ah") && registro2.matches("DH|dh")){
               codificacion = "86E6";
           }if(registro.matches("AH|ah") && registro2.matches("BH|bh")){
               codificacion = "86E7";
           }
           
            if(registro.matches("CH|ch") && registro2.matches("AL|al")){
               codificacion = "86E8";
           }if(registro.matches("CH|ch") && registro2.matches("CL|cl")){
               codificacion = "86E9";
           }if(registro.matches("CH|ch") && registro2.matches("DL|dl")){
               codificacion = "86EA";
           }if(registro.matches("CH|ch") && registro2.matches("BL|bl")){
               codificacion = "86EB";
           }if(registro.matches("CH|ch") && registro2.matches("AH|ah")){
               codificacion = "86EC";
           }if(registro.matches("CH|ch") && registro2.matches("CH|ch")){
               codificacion = "86ED";
           }if(registro.matches("CH|ch") && registro2.matches("DH|dh")){
               codificacion = "86EE";
           }if(registro.matches("CH|ch") && registro2.matches("BH|bh")){
               codificacion = "86EF";
           }
           
            if(registro.matches("DH|dh") && registro2.matches("AL|al")){
               codificacion = "86F0";
           }if(registro.matches("DH|dh") && registro2.matches("CL|cl")){
               codificacion = "86F1";
           }if(registro.matches("DH|dh") && registro2.matches("DL|dl")){
               codificacion = "86F2";
           }if(registro.matches("DH|dh") && registro2.matches("BL|bl")){
               codificacion = "86F3";
           }if(registro.matches("DH|dh") && registro2.matches("AH|ah")){
               codificacion = "86F4";
           }if(registro.matches("DH|dh") && registro2.matches("CH|ch")){
               codificacion = "86F5";
           }if(registro.matches("DH|dh") && registro2.matches("DH|dh")){
               codificacion = "86F6";
           }if(registro.matches("DH|dh") && registro2.matches("BH|bh")){
               codificacion = "86F7";
           }
           
            if(registro.matches("BH|bh") && registro2.matches("AL|al")){
               codificacion = "86F8";
           }if(registro.matches("BH|bh") && registro2.matches("CL|cl")){
               codificacion = "86F9";
           }if(registro.matches("BH|bh") && registro2.matches("DL|dl")){
               codificacion = "86FA";
           }if(registro.matches("BH|bh") && registro2.matches("BL|bl")){
               codificacion = "86FB";
           }if(registro.matches("BH|bh") && registro2.matches("AH|ah")){
               codificacion = "86FC";
           }if(registro.matches("BH|bh") && registro2.matches("CH|ch")){
               codificacion = "86FD";
           }if(registro.matches("BH|bh") && registro2.matches("DH|dh")){
               codificacion = "86FE";
           }if(registro.matches("BH|bh") && registro2.matches("BH|bh")){
               codificacion = "86FF";
        }   if(registro.matches("AX|ax") && num.matches("acc_memoria")){
            if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8700";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8701";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "8702";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "8703";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "8704";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "8705";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "8707";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "87400A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "874164";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "874201";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "874364";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "87440A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "874564";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "87460A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "874764";  
           }
        }if(registro.matches("CX|cx") && num.matches("acc_memoria")){
            if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8708";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8709";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "870A";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "870B";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "870C";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "870D";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "870F";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "87480A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "87480A";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "87480A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "874B64";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "874C0A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "874D6A";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "874E0A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "874F64";  
           }
        }if(registro.matches("DX|dx") && num.matches("acc_memoria")){
            if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8710";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8711";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "8712";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "8713";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "8714";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "8715";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "8717";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "87500A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "875164";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "87520A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "875364";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "87540A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "875564";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "87560A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "875764";  
           }
        } if(registro.matches("BX|bx") && num.matches("acc_memoria")){
            if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8718";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8719";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "871A";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "871B";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "871C";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "871D";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "871F";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "87580A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "875964";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "875A0A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "875B64";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "875C0A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "875D64";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "875E0A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "875F64";  
           }
        } if(registro.matches("SP|sp") && num.matches("acc_memoria")){
            if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8720";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8721";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "8722";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "8723";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "8724";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "8725";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "8727";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "87600A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "876164";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "87620A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "876364";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "87640A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "876564";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "87660A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "876764";  
           }
        }if(registro.matches("BP|bp") && num.matches("acc_memoria")){
            if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8728";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8729";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "872A";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "872B";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "872C";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "872D";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "872F";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "87680A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "876964";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "876A0A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "876B64";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "876C0A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "876D64";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "876E0A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "876F64";  
           }
        }
        if(registro.matches("SI|si") && num.matches("acc_memoria")){
            if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8730";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8731";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "8732";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "8733";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "8734";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "8735";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "8737";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "87700A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "877164";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "87720A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "877364";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "87740A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "877564";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "87760A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "877764";  
           }
        }
        
        if(registro.matches("DI|di") && num.matches("acc_memoria")){
            if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8738";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8739";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "873A";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "873B";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "873C";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "873D";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "873F";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "87780A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "877964";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "877A0A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "877B64";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "877C0A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "877D64";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "877E0A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "877F64";  
           }
        }        
          if(registro.matches("AL|al") && num.matches("acc_memoria")){
           if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8600";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8601";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "8602";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "8603";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "8604";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "8605";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "8607";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "86400A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "864164";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "86420A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "864364";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "86440A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "864564";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "86460A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "864764";  
           }
        }
          
                  if(registro.matches("CL|cl") && num.matches("acc_memoria")){
           if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8608";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8609";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "860A";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "860B";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "860C";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "860D";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "860F";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "86480A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "864964";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "864A0A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "864B64";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "864C0A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "864D64";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "864E0A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "864F64";  
           }
        }
                  
                  if(registro.matches("DL|dl") && num.matches("acc_memoria")){
           if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8610";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8611";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "8612";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "8613";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "8614";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "8615";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "8617";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "86500A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "865164";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "86520A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "865364";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "86540A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "865564";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "86560A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "865764";  
           }
        }

           if(registro.matches("BL|bl") && num.matches("acc_memoria")){
           if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8618";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8619";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "861A";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "861B";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "861C";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "861D";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "861F";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "86580A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "865964";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "865A0A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "865B64";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "865C0A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "865D64";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "865E0A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "865F64";  
           }
        }   
         
           if(registro.matches("AH|ah") && num.matches("acc_memoria")){
           if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8620";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8621";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "8622";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "8623";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "8624";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "8625";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "8627";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "86600A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "866164";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "86620A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "866364";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "86640A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "866564";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "86660A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "866764";  
           }
        }
           
           if(registro.matches("CH|ch") && num.matches("acc_memoria")){
           if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8628";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8629";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "862A";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "862B";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "862C";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "862D";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "862F";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "86680A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "866964";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "866A0A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "866B64";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "866C0A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "866D64";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "866E0A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "866F64";  
           }
        }
           
           if(registro.matches("DH|dh") && num.matches("acc_memoria")){
           if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8630";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8631";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "8632";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "8633";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "8634";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "8635";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "8637";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "86700A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "867164";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "86720A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "867364";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "86740A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "867564";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "86760A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "867764";  
           }
        }
           
           if(registro.matches("BH|bh") && num.matches("acc_memoria")){
           if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
              codificacion = "8638";  
           }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
              codificacion = "8639";  
           }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
              codificacion = "863A";  
           }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
              codificacion = "863B";  
           }if(registro2.equals("[SI]") || registro2.equals("[si]")){
              codificacion = "863C";  
           }if(registro2.equals("[DI]") || registro2.equals("[di]")){
              codificacion = "863D";  
           }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
              codificacion = "863F";  
           }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
              codificacion = "86780A";  
           }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
              codificacion = "867964";  
           }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+100]")){
              codificacion = "867A0A";  
           }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+di+100]")){
              codificacion = "867B64";  
           }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
              codificacion = "867C0A";  
           }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
              codificacion = "867D64";  
           }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
              codificacion = "867E0A";  
           }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
              codificacion = "867F64";  
           }
        }
      }
       return codificacion; 
    }
    
    
    public String codifSHLRegWithUno(String instruccion, String registro, String dec, String num, String tipoIns, String variable){
        String codificacion = "";
        String var = "";
        
         if(instruccion.matches("SHL|shl")){
            if(registro.matches("AL|al") && dec.matches("1")){
                codificacion = "D0E0";
           }if(registro.matches("AX|ax") && dec.matches("1")){
                codificacion = "D1E0";
           }if(registro.matches("CX|cx") && dec.matches("1")){
                codificacion = "D1E1";
           }if(registro.matches("CL|cl") && dec.matches("1")){
                codificacion = "D0E1";
           }if(registro.matches("DX|dx") && dec.matches("1")){
                codificacion = "D1E2";
           }if(registro.matches("DL|dl") && dec.matches("1")){
                codificacion = "D0E2";
           }if(registro.matches("BX|bx") && dec.matches("1")){
                codificacion = "D1E3";
           }if(registro.matches("BL|bl") && dec.matches("1")){
                codificacion = "D0E3";
           }if(registro.matches("SP|sp") && dec.matches("1")){
                codificacion = "D1E4";
           }if(registro.matches("AH|ah") && dec.matches("1")){
                codificacion = "D0E4";
           }if(registro.matches("BP|bp") && dec.matches("1")){
                codificacion = "D1E5";
           }if(registro.matches("CH|ch") && dec.matches("1")){
                codificacion = "D0E5";
           }if(registro.matches("SI|si") && dec.matches("1")){
                codificacion = "D1E6";
           }if(registro.matches("DH|dh") && dec.matches("1")){
                codificacion = "D0E6";
           }if(registro.matches("DI|di") && dec.matches("1")){
                codificacion = "D1E7";
           }if(registro.matches("BH|bh") && dec.matches("1")){/////////
                codificacion = "D0E7";
           }if(tipoIns.matches("acc_memoria") && dec.matches("CL|cl")){
               if(registro.equals("[SI+100]") || registro.equals("[si+100]")){
                System.out.println("IMPRESION DE registro "+registro);
                codificacion = "D264";   
               }
               
               
           } 
           if(tipoIns.matches("simbolo") && dec.matches("1")){
               
             TableModel table2 = tabsimbolos.getModel();
             int filas2 = table2.getRowCount();
             
            variable = variable;
             
             
            for (int i = 0; i < filas2; i++) {
            
            String e = (String) table2.getValueAt(i, 0);
            
            String may = e.toUpperCase();
            String min = e.toLowerCase();
            
            if (may.equals(variable) || min.equals(variable)) {
                var = (String) table2.getValueAt(i, 4);
                
                Integer n = Integer.parseInt(var);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                                
                var = resultado.toUpperCase();
            }
           }
              codificacion = "D026 "+var;
              
        }if(registro.matches("AL|al") && dec.matches("CL|cl")){
                codificacion = "D2E0";
           }if(registro.matches("AX|ax") && dec.matches("CL|cl")){
                codificacion = "D3E0";
           }if(registro.matches("CX|cx") && dec.matches("CL|cl")){
                codificacion = "D3E1";
           }if(registro.matches("CL|cl") && dec.matches("CL|cl")){
                codificacion = "D2E1";
           }if(registro.matches("DX|dx") && dec.matches("CL|cl")){
                codificacion = "D3E2";
           }if(registro.matches("DL|dl") && dec.matches("CL|cl")){
                codificacion = "D2E2";
           }if(registro.matches("BX|bx") && dec.matches("CL|cl")){
                codificacion = "D3E3";
           }if(registro.matches("BL|bl") && dec.matches("CL|cl")){
                codificacion = "D2E3";
           }if(registro.matches("SP|sp") && dec.matches("CL|cl")){
                codificacion = "D3E4";
           }if(registro.matches("AH|ah") && dec.matches("CL|cl")){
                codificacion = "D2E4";
           }if(registro.matches("BP|bp") && dec.matches("CL|cl")){
                codificacion = "D3E5";
           }if(registro.matches("CH|ch") && dec.matches("CL|cl")){
                codificacion = "D2E5";
           }if(registro.matches("SI|si") && dec.matches("CL|cl")){
                codificacion = "D3E6";
           }if(registro.matches("DH|dh") && dec.matches("CL|cl")){
                codificacion = "D2E6";
           }if(registro.matches("DI|di") && dec.matches("CL|cl")){
                codificacion = "D3E7";
           }if(registro.matches("BH|bh") && dec.matches("CL|cl")){
                codificacion = "D2E7";
           }if(registro.matches("AL|al") && num.matches("num_dec")){
           
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C0 E0 "+hxd;
           }if(registro.matches("AX|ax") && num.matches("num_dec")){
                    
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C1 E0 "+hxd;
           }if(registro.matches("CX|cx") && num.matches("num_dec")){
                     
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C1 E1 "+hxd;
           }if(registro.matches("CL|cl") && num.matches("num_dec")){
                      
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C0 E1 "+hxd;
           }if(registro.matches("DX|dx") && num.matches("num_dec")){
                        
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C1 E2 "+hxd;
           }if(registro.matches("DL|dl") && num.matches("num_dec")){
                      
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C0 E2 "+hxd;
           }if(registro.matches("BX|bx") && num.matches("num_dec")){
                      
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C1 E2 "+hxd;
           }if(registro.matches("BL|bl") && num.matches("num_dec")){
                     
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C0 E3 "+hxd;
           }if(registro.matches("SP|sp") && num.matches("num_dec")){
                      
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C1 E4 "+hxd;
           }if(registro.matches("AH|ah") && num.matches("num_dec")){
                      
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C0 E4 "+hxd;
           }if(registro.matches("BP|bp") && num.matches("num_dec")){
                      
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C1 E5 "+hxd;
           }if(registro.matches("CH|ch") && num.matches("num_dec")){
                     
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C0 E5 "+hxd;
           }if(registro.matches("SI|si") && num.matches("num_dec")){
                      
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C1 E6 "+hxd;
           }if(registro.matches("DH|dh") && num.matches("num_dec")){
                     
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C0 E6 "+hxd;
           }if(registro.matches("DI|di") && num.matches("num_dec")){
                     
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C1 E7 "+hxd;
           }if(registro.matches("BH|bh") && num.matches("num_dec")){
                      
               int numDec = Integer.parseInt(dec);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "C0 E7 "+hxd;
           }
          }
           
      return codificacion;  
    }
     
    public String codificacionADDregwithreg1(String instruccion, String registro1, String registro2, String inm){
        String codificacion = "";
        
        if(instruccion.matches("ADD|add")){
            if(registro1.matches("AX|ax") && registro2.matches("AX|ax")){
                codificacion = "03C0";
           }if(registro1.matches("AX|ax") && registro2.matches("CX|cx")){
               codificacion = "03C1";
           }if(registro1.matches("AX|ax") && registro2.matches("DX|dx")){
               codificacion = "03C2";
           }if(registro1.matches("AX|ax") && registro2.matches("BX|bx")){
               codificacion = "03C3";
           }if(registro1.matches("AX|ax") && registro2.matches("SP|sp")){
               codificacion = "03C4";
           }if(registro1.matches("AX|ax") && registro2.matches("BP|bp")){
               codificacion = "03C5";
           }if(registro1.matches("AX|ax") && registro2.matches("SI|si")){
               codificacion = "03C6";
           }if(registro1.matches("AX|ax") && registro2.matches("DI|di")){
               codificacion = "03C7";
           }
           
            if(registro1.matches("CX|cx") && registro2.matches("AX|ax")){
                codificacion = "03C8";
           }if(registro1.matches("CX|cx") && registro2.matches("CX|cx")){
               codificacion = "03C9";
           }if(registro1.matches("CX|cx") && registro2.matches("DX|dx")){
               codificacion = "03CA";
           }if(registro1.matches("CX|cx") && registro2.matches("BX|bx")){
               codificacion = "03CB";
           }if(registro1.matches("CX|cx") && registro2.matches("SP|sp")){
               codificacion = "03CC";
           }if(registro1.matches("CX|cx") && registro2.matches("BP|bp")){
               codificacion = "03CD";
           }if(registro1.matches("CX|cx") && registro2.matches("SI|si")){
               codificacion = "03CE";
           }if(registro1.matches("CX|cx") && registro2.matches("DI|di")){
               codificacion = "03CF";
           }
           
            if(registro1.matches("DX|dx") && registro2.matches("AX|ax")){
                codificacion = "03D0";
           }if(registro1.matches("DX|dx") && registro2.matches("CX|cx")){
               codificacion = "03D1";
           }if(registro1.matches("DX|dx") && registro2.matches("DX|dx")){
               codificacion = "03D2";
           }if(registro1.matches("DX|dx") && registro2.matches("BX|bx")){
               codificacion = "03D3";
           }if(registro1.matches("DX|dx") && registro2.matches("SP|sp")){
               codificacion = "03D4";
           }if(registro1.matches("DX|dx") && registro2.matches("BP|bp")){
               codificacion = "03D5";
           }if(registro1.matches("DX|dx") && registro2.matches("SI|si")){
               codificacion = "03D6";
           }if(registro1.matches("DX|dx") && registro2.matches("DI|di")){
               codificacion = "03D7";
           }
           
            if(registro1.matches("BX|bx") && registro2.matches("AX|ax")){
               codificacion = "03D8";
           }if(registro1.matches("BX|bx") && registro2.matches("CX|cx")){
               codificacion = "03D9";
           }if(registro1.matches("BX|bx") && registro2.matches("DX|dx")){
               codificacion = "03DA";
           }if(registro1.matches("BX|bx") && registro2.matches("BX|bx")){
               codificacion = "03DB";
           }if(registro1.matches("BX|bx") && registro2.matches("SP|sp")){
               codificacion = "03DC";
           }if(registro1.matches("BX|bx") && registro2.matches("BP|bp")){
               codificacion = "03DD";
           }if(registro1.matches("BX|bx") && registro2.matches("SI|si")){
               codificacion = "03DE";
           }if(registro1.matches("BX|bx") && registro2.matches("DI|di")){
               codificacion = "03DF";
           }
           
            if(registro1.matches("SP|sp") && registro2.matches("AX|ax")){
               codificacion = "03E0";
           }if(registro1.matches("SP|sp") && registro2.matches("CX|cx")){
               codificacion = "03E1";
           }if(registro1.matches("SP|sp") && registro2.matches("DX|dx")){
               codificacion = "03E2";
           }if(registro1.matches("SP|sp") && registro2.matches("BX|bx")){
               codificacion = "03E3";
           }if(registro1.matches("SP|sp") && registro2.matches("SP|sp")){
               codificacion = "03E4";
           }if(registro1.matches("SP|sp") && registro2.matches("BP|bp")){
               codificacion = "03E5";
           }if(registro1.matches("SP|sp") && registro2.matches("SI|si")){
               codificacion = "03E6";
           }if(registro1.matches("SP|sp") && registro2.matches("DI|di")){
               codificacion = "03E7";
           }
           
            if(registro1.matches("BP|bp") && registro2.matches("AX|ax")){
               codificacion = "03E8";
           }if(registro1.matches("BP|bp") && registro2.matches("CX|cx")){
               codificacion = "03E9";
           }if(registro1.matches("BP|bp") && registro2.matches("DX|dx")){
               codificacion = "03EA";
           }if(registro1.matches("BP|bp") && registro2.matches("BX|bx")){
               codificacion = "03EB";
           }if(registro1.matches("BP|bp") && registro2.matches("SP|sp")){
               codificacion = "03EC";
           }if(registro1.matches("BP|bp") && registro2.matches("BP|bp")){
               codificacion = "03ED";
           }if(registro1.matches("BP|bp") && registro2.matches("SI|si")){
               codificacion = "03EE";
           }if(registro1.matches("BP|bp") && registro2.matches("DI|di")){
               codificacion = "03EF";
           }
           
            if(registro1.matches("SI|si") && registro2.matches("AX|ax")){
               codificacion = "03F0";
           }if(registro1.matches("SI|si") && registro2.matches("CX|cx")){
               codificacion = "03F1";
           }if(registro1.matches("SI|si") && registro2.matches("DX|dx")){
               codificacion = "03F2";
           }if(registro1.matches("SI|si") && registro2.matches("BX|bx")){
               codificacion = "03F3";
           }if(registro1.matches("SI|si") && registro2.matches("SP|sp")){
               codificacion = "03F4";
           }if(registro1.matches("SI|si") && registro2.matches("BP|bp")){
               codificacion = "03F5";
           }if(registro1.matches("SI|si") && registro2.matches("SI|si")){
               codificacion = "03F6";
           }if(registro1.matches("SI|si") && registro2.matches("DI|di")){
               codificacion = "03F7";
           }
           
            if(registro1.matches("DI|di") && registro2.matches("AX|ax")){
               codificacion = "03F8";
           }if(registro1.matches("DI|di") && registro2.matches("CX|cx")){
               codificacion = "03F9";
           }if(registro1.matches("DI|di") && registro2.matches("DX|dx")){
               codificacion = "03FA";
           }if(registro1.matches("DI|di") && registro2.matches("BX|bx")){
               codificacion = "03FB";
           }if(registro1.matches("DI|di") && registro2.matches("SP|sp")){
               codificacion = "03FC";
           }if(registro1.matches("DI|di") && registro2.matches("BP|bp")){
               codificacion = "03FD";
           }if(registro1.matches("DI|di") && registro2.matches("SI|si")){
               codificacion = "03FE";
           }if(registro1.matches("DI|di") && registro2.matches("DI|di")){
               codificacion = "03FF";
           }if(registro1.matches("AL|al") && registro2.matches("AL|al")){
               codificacion = "02C0";
           }if(registro1.matches("AL|al") && registro2.matches("CL|cl")){
               codificacion = "02C1";
           }if(registro1.matches("AL|al") && registro2.matches("DL|dl")){
               codificacion = "02C2";
           }if(registro1.matches("AL|al") && registro2.matches("BL|bl")){
               codificacion = "02C3";
           }if(registro1.matches("AL|al") && registro2.matches("AH|ah")){
               codificacion = "02C4";
           }if(registro1.matches("AL|al") && registro2.matches("CH|ch")){
               codificacion = "02C5";
           }if(registro1.matches("AL|al") && registro2.matches("DH|dh")){
               codificacion = "02C6";
           }if(registro1.matches("AL|al") && registro2.matches("BH|bh")){
               codificacion = "02C7";
           }
           
            if(registro1.matches("CL|cl") && registro2.matches("AL|al")){
               codificacion = "02C8";
           }if(registro1.matches("CL|cl") && registro2.matches("CL|cl")){
               codificacion = "02C9";
           }if(registro1.matches("CL|cl") && registro2.matches("DL|dl")){
               codificacion = "02CA";
           }if(registro1.matches("CL|cl") && registro2.matches("BL|bl")){
               codificacion = "02CB";
           }if(registro1.matches("CL|cl") && registro2.matches("AH|ah")){
               codificacion = "02CC";
           }if(registro1.matches("CL|cl") && registro2.matches("CH|ch")){
               codificacion = "02CD";
           }if(registro1.matches("CL|cl") && registro2.matches("DH|dh")){
               codificacion = "02CE";
           }if(registro1.matches("CL|cl") && registro2.matches("BH|bh")){
               codificacion = "02CF";
           }
           
            if(registro1.matches("DL|dl") && registro2.matches("AL|al")){
               codificacion = "02D0";
           }if(registro1.matches("DL|dl") && registro2.matches("CL|cl")){
               codificacion = "02D1";
           }if(registro1.matches("DL|dl") && registro2.matches("DL|dl")){
               codificacion = "02D2";
           }if(registro1.matches("DL|dl") && registro2.matches("BL|bl")){
               codificacion = "02D3";
           }if(registro1.matches("DL|dl") && registro2.matches("AH|ah")){
               codificacion = "02D4";
           }if(registro1.matches("DL|dl") && registro2.matches("CH|ch")){
               codificacion = "02D5";
           }if(registro1.matches("DL|dl") && registro2.matches("DH|dh")){
               codificacion = "02D6";
           }if(registro1.matches("DL|dl") && registro2.matches("BH|bh")){
               codificacion = "02D7";
           }
           
            if(registro1.matches("BL|bl") && registro2.matches("AL|al")){
               codificacion = "02D8";
           }if(registro1.matches("BL|bl") && registro2.matches("CL|cl")){
               codificacion = "02D9";
           }if(registro1.matches("BL|bl") && registro2.matches("DL|dl")){
               codificacion = "02DA";
           }if(registro1.matches("BL|bl") && registro2.matches("BL|bl")){
               codificacion = "02DB";
           }if(registro1.matches("BL|bl") && registro2.matches("AH|ah")){
               codificacion = "02DC";
           }if(registro1.matches("BL|bl") && registro2.matches("CH|ch")){
               codificacion = "02DD";
           }if(registro1.matches("BL|bl") && registro2.matches("DH|dh")){
               codificacion = "02DE";
           }if(registro1.matches("BL|bl") && registro2.matches("BH|bh")){
               codificacion = "02DF";
           }
           
            if(registro1.matches("AH|ah") && registro2.matches("AL|al")){
               codificacion = "02E0";
           }if(registro1.matches("AH|ah") && registro2.matches("CL|cl")){
               codificacion = "02E1";
           }if(registro1.matches("AH|ah") && registro2.matches("DL|dl")){
               codificacion = "02E2";
           }if(registro1.matches("AH|ah") && registro2.matches("BL|bl")){
               codificacion = "02E3";
           }if(registro1.matches("AH|ah") && registro2.matches("AH|ah")){
               codificacion = "02E4";
           }if(registro1.matches("AH|ah") && registro2.matches("CH|ch")){
               codificacion = "02E5";
           }if(registro1.matches("AH|ah") && registro2.matches("DH|dh")){
               codificacion = "02E6";
           }if(registro1.matches("AH|ah") && registro2.matches("BH|bh")){
               codificacion = "02E7";
           }
           
            if(registro1.matches("CH|ch") && registro2.matches("AL|al")){
               codificacion = "02E8";
           }if(registro1.matches("CH|ch") && registro2.matches("CL|cl")){
               codificacion = "02E9";
           }if(registro1.matches("CH|ch") && registro2.matches("DL|dl")){
               codificacion = "02EA";
           }if(registro1.matches("CH|ch") && registro2.matches("BL|bl")){
               codificacion = "02EB";
           }if(registro1.matches("CH|ch") && registro2.matches("AH|ah")){
               codificacion = "02EC";
           }if(registro1.matches("CH|ch") && registro2.matches("CH|ch")){
               codificacion = "02ED";
           }if(registro1.matches("CH|ch") && registro2.matches("DH|dh")){
               codificacion = "02EE";
           }if(registro1.matches("CH|ch") && registro2.matches("BH|bh")){
               codificacion = "02EF";
           }
           
            if(registro1.matches("DH|dh") && registro2.matches("AL|al")){
               codificacion = "02F0";
           }if(registro1.matches("DH|dh") && registro2.matches("CL|cl")){
               codificacion = "02F1";
           }if(registro1.matches("DH|dh") && registro2.matches("DL|dl")){
               codificacion = "02F2";
           }if(registro1.matches("DH|dh") && registro2.matches("BL|bl")){
               codificacion = "02F3";
           }if(registro1.matches("DH|dh") && registro2.matches("AH|ah")){
               codificacion = "02F4";
           }if(registro1.matches("DH|dh") && registro2.matches("CH|ch")){
               codificacion = "02F5";
           }if(registro1.matches("DH|dh") && registro2.matches("DH|dh")){
               codificacion = "02F6";
           }if(registro1.matches("DH|dh") && registro2.matches("BH|bh")){
               codificacion = "02F7";
           }
           
            if(registro1.matches("BH|bh") && registro2.matches("AL|al")){
               codificacion = "02F8";
           }if(registro1.matches("BH|bh") && registro2.matches("CL|cl")){
               codificacion = "02F9";
           }if(registro1.matches("BH|bh") && registro2.matches("DL|dl")){
               codificacion = "02FA";
           }if(registro1.matches("BH|bh") && registro2.matches("BL|bl")){
               codificacion = "02FB";
           }if(registro1.matches("BH|bh") && registro2.matches("AH|ah")){
               codificacion = "02FC";
           }if(registro1.matches("BH|bh") && registro2.matches("CH|ch")){
               codificacion = "02FD";
           }if(registro1.matches("BH|bh") && registro2.matches("DH|dh")){
               codificacion = "02FE";
           }if(registro1.matches("BH|bh") && registro2.matches("BH|bh")){
               codificacion = "02FF";
           }if(registro1.matches("AL|al") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "80 C0 "+hxd;
           }if(registro1.matches("CL|cl") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "80 C1 "+hxd;
           }if(registro1.matches("CX|cx") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "81 C1 "+hxd;
           }if(registro1.matches("DL|dl") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "80 C2 "+hxd;
           }if(registro1.matches("DX|dx") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "81 C2 "+hxd;
           }if(registro1.matches("BL|bl") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "80 C3 "+hxd;
           }if(registro1.matches("BX|bx") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "81 C3 "+hxd;
           }if(registro1.matches("AH|ah") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "80 C4 "+hxd;
           }if(registro1.matches("SP|sp") && inm.matches("num_dec")){
               
               
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "81 C4 "+hxd;
           }if(registro1.matches("CH|ch") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "80 C5 "+hxd;
           }if(registro1.matches("BP|bp") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "81 C5 "+hxd;
           }if(registro1.matches("DH|dh") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "80 C6 "+hxd;
           }if(registro1.matches("SI|si") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "81 C6 "+hxd;
           }if(registro1.matches("BH|bh") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "80 C7 "+hxd;
           }if(registro1.matches("DI|di") && inm.matches("num_dec")){
                              
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "83 C7 "+hxd;
           }
          if(registro1.matches("AX|ax") && inm.matches("num_dec")){
                                
               int numDec = Integer.parseInt(registro2);
               char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = numDec;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

               
                     
                codificacion = "00 05 "+hxd; 
          }if(registro1.matches("CX|cx") && registro2.matches("101010B")){
              codificacion = "83 C1 2A";
          }
          
          if(registro1.matches("AX|ax") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0300";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0301";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0302";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0303";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0304";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0305";
             }if(registro2.equals("") || registro2.equals("")){
                 codificacion = "03060100";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0307";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "03400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "03410A";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "03420A";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "03430A";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "03440A";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "03450A";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "03460A";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "03470A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "034064";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "034164";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "034264";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "034364";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "034464";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "034564";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "034664";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "034764";
             }
          }
          
           if(registro1.matches("CX|cx") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0200";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0201";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0205";
             }if(registro2.equals("") || registro2.equals("")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "0205";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "0207";
             }
          }
           
           if(registro1.matches("DX|dx") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0200";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0201";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0205";
             }if(registro2.equals("") || registro2.equals("")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "0205";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "0207";
             }
          }
           
           if(registro1.matches("BX|bx") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0200";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0201";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0205";
             }if(registro2.equals("") || registro2.equals("")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "0205";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "0207";
             }
          }
           
           if(registro1.matches("SP|sp") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0200";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0201";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0205";
             }if(registro2.equals("") || registro2.equals("")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "0205";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "0207";
             }
          }
           
           if(registro1.matches("BP|bp") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0200";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0201";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0205";
             }if(registro2.equals("") || registro2.equals("")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "0205";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "0207";
             }
          }
           
           if(registro1.matches("SI|si") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0200";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0201";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0205";
             }if(registro2.equals("") || registro2.equals("")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "0205";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "0207";
             }
          }
           
           if(registro1.matches("DI|di") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0200";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0201";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0205";
             }if(registro2.equals("") || registro2.equals("")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "0205";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "0207";
             }
          }
           
           if(registro1.matches("AL|al") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0200";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0201";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0205";
             }if(inm.matches("simbolo") || inm.matches("simbolo")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0207";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02400A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "0203";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "0202";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "0203";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "0204";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "0205";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02060000";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "02 47 0A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "02 40 64";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "02 41 64";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 42 64";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 43 64";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "02 44 64";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "02 45 64";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "02 46 64";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "02 47 64";
             }
          }
           
           if(registro1.matches("CL|cl") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0208";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0209";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "020A";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "020B";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "020C";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "020D";
             }if(inm.matches("simbolo")){
                 codificacion = "020E0000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "020F";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02480A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "02490A";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "024A0A";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "024B0A";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "024C0A";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "024D0A";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "024E0A";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "024F0A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "024864";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "024964";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "024A64";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "024B64";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "024C64";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "024D64";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "024E64";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "024F64";
             }
          }
           
           if(registro1.matches("DL|dl") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0210";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0211";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0212";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0213";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0214";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0215";
             }if(inm.matches("simbolo")){
                 codificacion = "02160000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0217";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02500A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "02510A";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "02520A";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "02530A";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "02540A";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "02550A";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02560A";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "02570A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "025064";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "025164";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "025264";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "025364";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "025464";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "025564";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "025664";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "025764";
             }
          }
           
           if(registro1.matches("BL|bl") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "02 18";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "02 19";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "02 1A";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "02 1B";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "02 1C";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "02 1D";
             }if(inm.matches("simbolo")){
                 codificacion = "021E0000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "02 1F";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02 58 0A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "02 59 0A";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "02 5A 0A";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "02 5B 0A";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "02 5C 0A";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "02 5D 0A";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02 5E 0A";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "02 5F 0A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "02 58 64";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "02 59 64";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 5A 64";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 5B 64";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "02 5C 64";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "02 5D 64";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "02 5E 64";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "02 5F 64";
             }
          }
           
           if(registro1.matches("AH|ah") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "02 20";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "02 21";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "02 22";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "02 23";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "02 24";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "02 25";
             }if(inm.matches("simbolo")){
                 codificacion = "02 26 00 00";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "02 27";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02 60 0A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "02 61 0A";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "02 62 0A";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "02 63 0A";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "02 64 0A ";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "02 65 0A";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02 66 0A";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "02 67 0A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "02 60 64";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "02 61 64";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 62 64";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 63 64";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "02 64 64";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "02 65 64";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "02 66 64";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "02 67 64";
             }
          }
           
           if(registro1.matches("CH|ch") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0228";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0229";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "022A";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "022B";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "022C";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "022D";
             }if(inm.matches("simbolo")){
                 codificacion = "022E0000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "02 2F";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02 68 0A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "02 69 0A";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "02 6A 0A";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "02 6B 0A";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "02 6C 0A";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "02 6D 0A";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02 6E 0A";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "02 6F 0A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "02 68 64";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "02 69 64";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 6A 64";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 6B 64";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "02 6C 64";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "02 6D 64";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "02 6E 64";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "02 6F 64";
             }
          }
           
           if(registro1.matches("DH|dh") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "0230";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "0231";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "0232";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "0233";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "0234";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "0235";
             }if(inm.matches("simbolo")){
                 codificacion = "02360000";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "0237";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02 70 0A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "02 71 0A";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "02 72 0A";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "02 73 0A";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "02 74 0A";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "02 75 0A";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02 76 0A";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "02 77 0A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "02 70 64";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "02 71 64";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 72 64";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 73 64";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "02 74 64";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "02 75 64";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "02 76 64";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "02 77 64";
             }
          }
           
           if(registro1.matches("BH|bh") && inm.matches("acc_memoria")){
              if(registro2.equals("[BX+SI]") || registro2.equals("[bx+si]")){
                  codificacion = "02 38";
             }if(registro2.equals("[BX+DI]") || registro2.equals("[bx+di]")){
                  codificacion = "02 39";
             }if(registro2.equals("[BP+SI]") || registro2.equals("[bp+si]")){
                  codificacion = "02 3A";
             }if(registro2.equals("[BP+DI]") || registro2.equals("[bp+di]")){
                 codificacion = "02 3B";
             }if(registro2.equals("[SI]") || registro2.equals("[si]")){
                 codificacion = "02 3C";
             }if(registro2.equals("[DI]") || registro2.equals("[di]")){
                 codificacion = "02 3D";
             }if(inm.matches("simbolo")){
                 codificacion = "02 3E 00 00";
             }if(registro2.equals("[BX]") || registro2.equals("[bx]")){
                 codificacion = "02 3F";
             }if(registro2.equals("[BX+SI+10]") || registro2.equals("[bx+si+10]")){
                 codificacion = "02 78 0A"; 
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di]")){
                 codificacion = "02 79 0A";
             }if(registro2.equals("[BP+SI+10]") || registro2.equals("[bp+si+10]")){
                  codificacion = "02 7A 0A";
             }if(registro2.equals("[BP+DI+10]") || registro2.equals("[bp+di+10]")){
                 codificacion = "02 7B 0A";
             }if(registro2.equals("[SI+10]") || registro2.equals("[si+10]")){
                 codificacion = "02 7C 0A";
             }if(registro2.equals("[DI+10]") || registro2.equals("[di+10]")){
                 codificacion = "02 7D 0A";
             }if(registro2.equals("[BP+10]") || registro2.equals("[bp+10]")){
                 codificacion = "02 7E 0A";
             }if(registro2.equals("[BX+10]") || registro2.equals("[bx+10]")){
                 codificacion = "02 7F 0A";
             }if(registro2.equals("[BX+SI+100]") || registro2.equals("[bx+si+100]")){
                 codificacion = "02 78 64";
             }if(registro2.equals("[BX+DI+100]") || registro2.equals("[bx+di+100]")){
                 codificacion = "02 79 64";
             }if(registro2.equals("[BP+SI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 7A 64";
             }if(registro2.equals("[BP+DI+100]") || registro2.equals("[bp+si+100]")){
                 codificacion = "02 7B 64";
             }if(registro2.equals("[SI+100]") || registro2.equals("[si+100]")){
                 codificacion = "02 7C 64";
             }if(registro2.equals("[DI+100]") || registro2.equals("[di+100]")){
                 codificacion = "02 7D 64";
             }if(registro2.equals("[BP+100]") || registro2.equals("[bp+100]")){
                 codificacion = "02 7E 64";
             }if(registro2.equals("[BX+100]") || registro2.equals("[bx+100]")){
                 codificacion = "02 7F 64";
             }
          }
           
           if(registro1.equals("WORD PTR[BX+SI+100]") || registro1.matches("word ptr[bx+si+100]")){
               if(inm.equals("num_dec")){
                   codificacion = "814064F401";
                           
               }              
           }
        }
        return codificacion;
    }
    
    public String codificacionImulDivIdiv(String instruccion, String registro, String simbolo, String variable){
        String codificacion = " ";
        String var = "";
        
        if(instruccion.matches("IMUL|imul")){
            if(registro.matches("CL|cl")){
                codificacion = "F6E9";
           }if(registro.equals("[BP+10]")){
                codificacion = "F66E0A"; 
           }if(registro.matches("CX|cx")){
                codificacion = "F7E9";
           }if(registro.matches("DL|dl")){
                codificacion = "F6EA";
           }if(registro.matches("DX|dx")){
                codificacion = "F7EA";
           }if(registro.matches("BL|bl")){
                codificacion = "F6EB";
           }if(registro.matches("BX|bx")){
                codificacion = "F7EB";
           }if(registro.matches("AH|ah")){
                codificacion = "F6EC";
           }if(registro.matches("SP|sp")){
                codificacion = "F7EC";
           }if(registro.matches("CH|ch")){
                codificacion = "F6ED";
           }if(registro.matches("BP|bp")){
                codificacion = "F7ED";
           }if(registro.matches("DH|dh")){
                codificacion = "F6EE";
           }if(registro.matches("SI|si")){
                codificacion = "F7EE";
           }if(registro.matches("BH|bh")){
                codificacion = "F6EF";
           }if(registro.matches("DI|di")){
                codificacion = "F7EF";
           }if(simbolo.matches("simbolo")){
               
             TableModel table2 = tabsimbolos.getModel();
             int filas2 = table2.getRowCount();
             
            variable = variable;
             
             
            for (int i = 0; i < filas2; i++) {
            
            String e = (String) table2.getValueAt(i, 0);
            
            String may = e.toUpperCase();
            String min = e.toLowerCase();
            
            if (may.equals(variable) || min.equals(variable)) {
                var = (String) table2.getValueAt(i, 4);
                
                Integer n = Integer.parseInt(var);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                                
                var = resultado.toUpperCase();
            }
            
            codificacion = "F72E " + var;
        }
             
        }  
        }if(instruccion.matches("DIV|div")){
            if(registro.matches("AL|al")){
                codificacion = "F6F0";
           }if(registro.matches("AX|ax")){
                codificacion = "F7F0";
           }if(registro.matches("CL|cl")){
                codificacion = "F6F1";
           }if(registro.matches("CX|cx")){
                codificacion = "F7F1";
           }if(registro.matches("DL|dl")){
                codificacion = "F6F2";
           }if(registro.matches("DX|dx")){
                codificacion = "F7F2";
           }if(registro.matches("BL|bl")){
                codificacion = "F6F3";
           }if(registro.matches("BX|bx")){
                codificacion = "F7F3";
           }if(registro.matches("AH|ah")){
                codificacion = "F6F4";
           }if(registro.matches("SP|sp")){
                codificacion = "F7F4";
           }if(registro.matches("CH|ch")){
                codificacion = "F6F5";
           }if(registro.matches("BP|bp")){
                codificacion = "F7F5";
           }if(registro.matches("DH|dh")){
                codificacion = "F6F6";
           }if(registro.matches("SI|si")){
                codificacion = "F7F6";
           }if(registro.matches("BH|bh")){//
                codificacion = "F6F7";
           }if(registro.matches("DI|di")){
                codificacion = "F7F7";
           }if(simbolo.matches("simbolo")){
                     
             TableModel table2 = tabsimbolos.getModel();
             int filas2 = table2.getRowCount();
             
             variable = variable;
             
             System.out.println(" Si se llego a variable "+ variable);
             
            for (int i = 0; i < filas2; i++) {
            
            String e = (String) table2.getValueAt(i, 0);
            
            String may = e.toUpperCase();
            String min = e.toLowerCase();
            
            if (may.equals(variable) || min.equals(variable)) {
                var = (String) table2.getValueAt(i, 4);
                
                Integer n = Integer.parseInt(var);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                                
                var = resultado.toUpperCase();
            }
            
            codificacion = "F72E " + var;
        }  
        }}
        
        if(instruccion.matches("IDIV|idiv")){
            if(registro.matches("AL|al")){
                codificacion = "F6F8";
           }if(registro.matches("AX|ax")){
                codificacion = "F7F8";
           }if(registro.matches("CL|cl")){
                codificacion = "F6F9";
           }if(registro.matches("CX|cx")){
                codificacion = "F7F9";
           }if(registro.matches("DL|dl")){
                codificacion = "F6FA";
           }if(registro.matches("DX|dx")){
                codificacion = "F7FA";
           }if(registro.matches("BL|bl")){
                codificacion = "F6FB";
           }if(registro.matches("BX|bx")){
                codificacion = "F7FB";
           }if(registro.matches("AH|ah")){
                codificacion = "F6FC";
           }if(registro.matches("SP|sp")){
                codificacion = "F7FC";
           }if(registro.matches("CH|ch")){
                codificacion = "F6FD";
           }if(registro.matches("BP|bp")){
                codificacion = "F7FD";
           }if(registro.matches("DH|dh")){
                codificacion = "F6FE";
           }if(registro.matches("SI|si")){
                codificacion = "F7FE";
           }if(registro.matches("BH|bh")){//
                codificacion = "F6FF";
           }if(registro.matches("DI|di")){
                codificacion = "F7FF";
           }if(simbolo.matches("simbolo")){
              TableModel table2 = tabsimbolos.getModel();
             int filas2 = table2.getRowCount();
             
             variable = variable;
             
             System.out.println(" Si se llego a variable "+ variable);
             
            for (int i = 0; i < filas2; i++) {
            
            String e = (String) table2.getValueAt(i, 0);
            
            String may = e.toUpperCase();
            String min = e.toLowerCase();
            
            if (may.equals(variable) || min.equals(variable)) {
                var = (String) table2.getValueAt(i, 4);
                
                Integer n = Integer.parseInt(var);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                                
                var = resultado.toUpperCase();
            }
            
            codificacion = "F72E " + var;
        }  
        }
        }
          
        return codificacion;
    }
    
    public String codificacion2(String instruccion, String etiq){ //tabla de simbolos
        String codif = "";
        String etiqueta = "";
        int ress = 0;
        
        TableModel table2 = tabsimbolos.getModel();
        int filas2 = table2.getRowCount();
        
        etiq = etiq + ":";
        
        System.out.println("Se llego a etiqueta: "+etiq);
                
        for (int i = 0; i < filas2; i++) {
            
            String e = (String) table2.getValueAt(i, 0);
            
            String may = e.toUpperCase();
            String min = e.toLowerCase();
            
            if (may.equals(etiq) || min.equals(etiq)) {
                etiqueta = (String) table2.getValueAt(i, 4);
                
                Integer n = Integer.parseInt(etiqueta);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                ress = n;
                etiqueta = resultado.toUpperCase();
            }
        }
                        
        if (instruccion.matches("JS|js")) {
            codif = "0F88" + " " + etiqueta;
        }else if (instruccion.matches("JNS|jns")) {
            codif = "0F89" + " " + etiqueta;
        }else if (instruccion.matches("JL|jl")) {
            codif = "0F8C" + " " + etiqueta;
        }else if (instruccion.matches("JAE|jae")) {
            codif = "0F82" + " " + etiqueta;
        }else if (instruccion.matches("JCXZ|jcxz")) {
            int memory = memoria - 2;
            int ress2 = ress;
            
            int calc = (memory - ress2)+ 2;
            
        char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = calc;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }

        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

            codif = "E3 "+ hxd;
        }else if (instruccion.matches("LOOPNE|loopne")) {
                int memory = memoria - 2;
            int ress2 = ress;
            
            int calc = (memory - ress2)+ 2;
   
        char digitosH[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";
        int resto, aux = calc;
         
        while(aux>0){
            resto = aux % 16;
            hexadecimal = digitosH[resto] + hexadecimal;
            aux /= 16; 
        }
        
        String aux2 = hexadecimal;
        
        int aux3 = aux2.length();
        
        if (aux3 == 1) {
                    aux2 = "0" + aux2;
                    aux2 = aux2.toUpperCase();
                }
        
        String hxd = aux2.toUpperCase();

            codif = "E0 "+ hxd;
   
        }
        
        return codif;
    }
    
    public String codificacion1(String instruccion){
        String codif = "";
        
              if(instruccion.matches("MOVSW|movsw")) {
            codif = "A5"; 
        }else if(instruccion.matches("AAD|aad")){
            codif = "D50A"; 
        }else if(instruccion.matches("CWD|cwd")){
            codif = "99";
        }else if(instruccion.matches("IRET|iret")){
            codif = "CF";
        }else if(instruccion.matches("CLD|cld")){
            codif = "FC";
        }else if(instruccion.matches("STD|std")){
            codif = "FD";
            }
        
        return codif;
    }
    
    public String codificacionLDS(String instruccion, String registro, String simbolo, String variable){
        String codificacion = " ";
        String var = "";
        
               
             TableModel table2 = tabsimbolos.getModel();
             int filas2 = table2.getRowCount();
             
             variable = variable;
             
             System.out.println(" Si se llego a variable "+ variable );
             
            for (int i = 0; i < filas2; i++) {
            
            String e = (String) table2.getValueAt(i, 0);
            
            String may = e.toUpperCase();
            String min = e.toLowerCase();
            
            if (may.equals(variable) || min.equals(variable)) {
                var = (String) table2.getValueAt(i, 4);
                
                Integer n = Integer.parseInt(var);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                                
                var = resultado.toUpperCase();
            }
                       
        }
        
         if(instruccion.matches("LDS|lds")){
            if(registro.matches("AL|al") && simbolo.matches("simbolo")){       
               codificacion = "C5C0 " + var;
           }if(registro.matches("AX|ax") ){
               codificacion = "C5C0 " + var;           
           }if(registro.matches("CL|cl")){
                codificacion = "C5C9 "+var;
           }if(registro.matches("CX|cx")){
                codificacion = "C5C9 "+var;
           }if(registro.matches("DL|dl")){
                codificacion = "C5D2 "+var;
           }if(registro.matches("DX|dx")){
                codificacion = "C5D2 "+var;
           }if(registro.matches("BL|bl")){
                codificacion = "C5DB "+var;
           }if(registro.matches("BX|bx")){
                codificacion = "C5DB "+var;
           }if(registro.matches("AH|ah")){
                codificacion = "C5E4 "+var;
           }if(registro.matches("SP|sp")){
                codificacion = "C5E4 "+var;
           }if(registro.matches("CH|ch")){
                codificacion = "C5ED "+var;
           }if(registro.matches("BP|bp")){
                codificacion = "C5ED "+var;
           }if(registro.matches("DH|dh")){
                codificacion = "C5F6 "+var;
           }if(registro.matches("SI|si")){
                codificacion = "C5F6 "+var;
           }if(registro.matches("BH|bh")){
                codificacion = "C5FF "+var;
           }if(registro.matches("DI|di")){
                codificacion = "C5FF "+var;
           }
    }
        return codificacion;
        
    }
    
    public String codificacion3(String instruccion, String registro, String simbolo, String variable){
       String codificacion = " ";
        String var = "";
        
        if(instruccion.matches("POP|pop")){
            if(registro.matches("AL|al")){
                codificacion = "8FC0";
           }if(registro.equals("WORD PTR[SI]")){
                codificacion = "8F04";
           }if(registro.matches("AX|ax")){
                codificacion = "0058";
           }if(registro.matches("CL|cl")){
                codificacion = "8FC1";
           }if(registro.matches("CX|cx")){
                codificacion = "0059";
           }if(registro.matches("DL|dl")){
                codificacion = "8FC2";
           }if(registro.matches("DX|dx")){
                codificacion = "005A";
           }if(registro.matches("BL|bl")){
                codificacion = "8FC3";
           }if(registro.matches("BX|bx")){
                codificacion = "005B";
           }if(registro.matches("AH|ah")){
                codificacion = "8FC4";
           }if(registro.matches("SP|sp")){
                codificacion = "005C";
           }if(registro.matches("CH|ch")){
                codificacion = "8FC5";
           }if(registro.matches("BP|bp")){
                codificacion = "005D";
           }if(registro.matches("DH|dh")){
                codificacion = "8FC6";
           }if(registro.matches("SI|si")){
                codificacion = "005E";
           }if(registro.matches("BH|bh")){
                codificacion = "8FC7";
           }if(registro.matches("DI|di")){
                codificacion = "005F";
           }if(registro.matches("ES|es")){//
                codificacion = "7";
           }if(registro.matches("CS|cs")){
                codificacion = "F";
           }if(registro.matches("SS|ss")){
                codificacion = "17";
           }if(registro.matches("DS|ds")){
                codificacion = "1F";
           }if(simbolo.matches("simbolo")){
               
             TableModel table2 = tabsimbolos.getModel();
             int filas2 = table2.getRowCount();
             
             variable = variable;
             
             System.out.println(" Si se llego a variable "+ variable);
             
            for (int i = 0; i < filas2; i++) {
            
            String e = (String) table2.getValueAt(i, 0);
            
            String may = e.toUpperCase();
            String min = e.toLowerCase();
            
            if (may.equals(variable) || min.equals(variable)) {
                var = (String) table2.getValueAt(i, 4);
                
                Integer n = Integer.parseInt(var);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                                
                var = resultado.toUpperCase();
            }
            
            codificacion = "8F06 " + var;
        }
             
        }  
    }
        return codificacion;
    }
    
    public void MemHexa(){ //hexadecimal
        TableModel table = tabfasedos.getModel();
        
        int filas = table.getRowCount();
        
        for (int i = 0; i < filas; i++) {
            String num = (String) table.getValueAt(i, 0);
            if (num != "") {
                Integer n = Integer.parseInt(num);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                
                tabfasedos.setValueAt(resultado, i, 0);
            }        
        }
        
        TableModel table2 = tabsimbolos.getModel();
        
        int filas2 = table2.getRowCount();
        
        for (int i = 0; i < filas2; i++) {
            String num = (String) table2.getValueAt(i, 4);
            if (num != "") {
                Integer n = Integer.parseInt(num);
                String resultado = Integer.toHexString(n);
                
                int t = resultado.length();
                
                if (t == 1) {
                    resultado = "000" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==2){
                    resultado = "00" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==3){
                    resultado = "0" + resultado + "H";
                    resultado = resultado.toUpperCase();
                }else if(t==4){
                    resultado = resultado + "H";
                    resultado = resultado.toUpperCase();
                }
                
                tabsimbolos.setValueAt(resultado, i, 4);
            }        
        }
    }
    
    public void Instrucciones5(String token2, String elemento2){
        if (token2.matches("acc_memoria")) {
                
            int n = elemento2.indexOf("[");

            String str = elemento2.substring(n+1, elemento2.length()-1);

            String[] el = str.split("\\+");

            if (el.length == 2) {
                try {
                    Integer num = Integer.parseInt(el[1]);
                    if (num >= -127 && num <=128){
                        memoria = memoria + 3;
                    }else if(num >= -32768 && num <= 32767){
                        memoria = memoria + 4;
                    }
                } catch (Exception e) {
                }
            }else if(el.length == 3){
                try {
                    Integer num = Integer.parseInt(el[2]);
                    if (num >= -127 && num <=128){
                        memoria = memoria + 3;
                    }else if(num >= -32768 && num <= 32767){
                        memoria = memoria + 4;
                    }
                } catch (Exception e) {
                }
            }else{
                memoria = memoria + 2;
            }
        }else if(token2.matches("simbolo")){
            memoria = memoria + 4;
        }
    }
   
    public void InstSHL (String token1, String elemento1, String token2, String elemento2){
        
        if(token1.matches("registro") && token2.matches("num_dec")){
            if(token2.matches("num_dec")){
                int numDec = Integer.parseInt(elemento2);
                if (numDec ==  1){
                    memoria = memoria + 2 ;
                }
            }
    }
      if(token1.matches("simbolo") && token2.matches("num_dec")){
          if(token2.matches("num_dec")){
                int numDec = Integer.parseInt(elemento2);
                if (numDec ==  1){
                    memoria = memoria + 3 ;
                }
            }
      }
      
      if(token1.matches("acc_memoria") && token2.matches("num_dec")){
          if(token2.matches("num_dec")){
                int numDec = Integer.parseInt(elemento2);
                if (numDec ==  1){
                    memoria = memoria + 4 ;
                }
            }
      }
      
        if(token1.matches("registro") && token2.matches("registro")){
        if(token2.matches("registro")){
            
            String regCL = elemento2;
           if (regCL.equals("CL")){
            memoria = memoria + 2;
        }
        }
    }
        if(token1.matches("simbolo") && token2.matches("registro")){
           if(token2.matches("registro")){
            
            String regCL = elemento2;
           if (regCL.equals("CL")){
            memoria = memoria + 3;
        }
       } 
      }
        if(token1.matches("acc_memoria") && token2.matches("registro")){
           if(token2.matches("registro")){
            
            String regCL = elemento2;
           if (regCL.equals("CL")){
            memoria = memoria + 4;
           }
          }  
         }
        if(token1.matches("registro") && token2.matches("num_dec")){
            memoria = memoria + 2;
        }
        if(token1.matches("simbolo") && token2.matches("num_dec")){
            memoria = memoria + 3;
        }
        if(token1.matches("acc_memoria") && token2.matches("num_dec")){
            memoria = memoria + 4;
        }
    
    }
    
    public void Instrucciones4(String token1, String elemento1, String token2, String elemento2){
        if (token1.matches("registro") && token2.matches("registro")) {
            memoria = memoria + 2;
        }else if(token1.matches("simbolo|acc_memoria") && token2.matches("registro")){
            if (token1.matches("acc_memoria")) {
                
                int n = elemento1.indexOf("[");
        
                String str = elemento1.substring(n+1, elemento1.length()-1);
                
                String[] el = str.split("\\+");
                
                if (el.length == 2) {
                    try {
                        Integer num = Integer.parseInt(el[1]);
                        if (num >= 0 && num <= 255){
                            memoria = memoria + 3;
                        }else if(num >= 0 && num <= 65535){
                            memoria = memoria + 4;
                        }
                    } catch (Exception e) {
                    }
                }else if(el.length == 3){
                    try {
                        Integer num = Integer.parseInt(el[2]);
                        if (num >= 0 && num <= 255){
                            memoria = memoria + 3;
                        }else if(num >= 0 && num <= 65535){
                            memoria = memoria + 4;
                        }
                    } catch (Exception e) {
                    }
                }else{
                    memoria = memoria + 2;
                }
            }else if(token1.matches("simbolo")){
                memoria = memoria + 4;
            }
        }else if(token1.matches("registro") && token2.matches("simbolo|acc_memoria")){
            if (token2.matches("acc_memoria")) {
                
                int n = elemento2.indexOf("[");
        
                String str = elemento2.substring(n+1, elemento2.length()-1);
                
                String[] el = str.split("\\+");
                
                if (el.length == 2) {
                    try {
                        Integer num = Integer.parseInt(el[1]);
                        if (num >= 0 && num <= 255){
                            memoria = memoria + 3;
                        }else if(num >= 0 && num <= 65535){
                            memoria = memoria + 4;
                        }
                    } catch (Exception e) {
                    }
                }else if(el.length == 3){
                    try {
                        Integer num = Integer.parseInt(el[2]);
                        if (num >= 0 && num <= 255){
                            memoria = memoria + 3;
                        }else if(num >= 0 && num <= 65535){
                            memoria = memoria + 4;
                        }
                    } catch (Exception e) {
                    }
                }else{
                    memoria = memoria + 2;
                }
            }else if(token2.matches("simbolo")){
                memoria = memoria + 4;
            }
        }else if(token1.matches("simbolo|acc_memoria") && token2.matches("num_dec|num_exa|num_bin")){
            if (token1.matches("simbolo")) {
                if (token2.matches("num_exa")) {
                    String numHexa = elemento2.substring(0, elemento2.length()-1);
                    int numDec = Integer.parseInt(numHexa,16);

                    if (numDec >= 0 && numDec <= 255) {
                        memoria = memoria + 5;
                    }else if(numDec >= 0 && numDec <= 65535){
                        memoria = memoria + 6;
                    }
                }else if(token2.matches("num_bin")){    
                    String numBin = elemento2.substring(0, elemento2.length()-1);
                    int numDec = Integer.parseInt(numBin,2);

                    if (numDec >= 0 && numDec <= 255) {
                        memoria = memoria + 5;
                    }else if(numDec >= 0 && numDec <= 65535){
                        memoria = memoria + 6;
                    }
                }else if(token2.matches("num_dec")){
                    int numDec = Integer.parseInt(elemento2);

                    if (numDec >= 0 && numDec <= 255) {
                        memoria = memoria + 5;  
                    }else if(numDec >= 0 && numDec <= 65535){
                        memoria = memoria + 6;
                    }
                }
            }else if(token1.matches("acc_memoria")){
                int n = elemento1.indexOf("[");
        
                String str = elemento1.substring(n+1, elemento1.length()-1);
                
                String[] el = str.split("\\+");
                
                if (el.length == 2) {
                    try {
                        Integer num = Integer.parseInt(el[1]);
                        if (num >= 0 && num <=255){
                            if (token2.matches("num_exa")) {
                                String numHexa = elemento2.substring(0, elemento2.length()-1);
                                int numDec = Integer.parseInt(numHexa,16);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 4;
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 5;
                                }
                            }else if(token2.matches("num_bin")){    
                                String numBin = elemento2.substring(0, elemento2.length()-1);
                                int numDec = Integer.parseInt(numBin,2);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 4;
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 5;
                                }
                            }else if(token2.matches("num_dec")){
                                int numDec = Integer.parseInt(elemento2);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 4;  
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 5;
                                }
                            }
                        }else if(num >= 0 && num <= 65535){
                            if (token2.matches("num_exa")) {
                                String numHexa = elemento2.substring(0, elemento2.length()-1);
                                int numDec = Integer.parseInt(numHexa,16);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 5;
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 6;
                                }
                            }else if(token2.matches("num_bin")){    
                                String numBin = elemento2.substring(0, elemento2.length()-1);
                                int numDec = Integer.parseInt(numBin,2);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 5;
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 6;
                                }
                            }else if(token2.matches("num_dec")){
                                int numDec = Integer.parseInt(elemento2);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 5;  
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 6;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }else if(el.length == 3){
                    try {
                        Integer num = Integer.parseInt(el[2]);
                        if (num >= 0 && num <= 255){
                            if (token2.matches("num_exa")) {
                                String numHexa = elemento2.substring(0, elemento2.length()-1);
                                int numDec = Integer.parseInt(numHexa,16);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 4;
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 5;
                                }
                            }else if(token2.matches("num_bin")){    
                                String numBin = elemento2.substring(0, elemento2.length()-1);
                                int numDec = Integer.parseInt(numBin,2);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 4;
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 5;
                                }
                            }else if(token2.matches("num_dec")){
                                int numDec = Integer.parseInt(elemento2);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 4;  
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 5;
                                }
                            }
                        }else if(num >= 0 && num <= 65535){
                            if (token2.matches("num_exa")) {
                                String numHexa = elemento2.substring(0, elemento2.length()-1);
                                int numDec = Integer.parseInt(numHexa,16);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 5;
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 6;
                                }
                            }else if(token2.matches("num_bin")){    
                                String numBin = elemento2.substring(0, elemento2.length()-1);
                                int numDec = Integer.parseInt(numBin,2);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 5;
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 6;
                                }
                            }else if(token2.matches("num_dec")){
                                int numDec = Integer.parseInt(elemento2);

                                if (numDec >= 0 && numDec <= 255) {
                                    memoria = memoria + 5;  
                                }else if(numDec >= 0 && numDec <= 65535){
                                    memoria = memoria + 6;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }else{
                    if (token2.matches("num_exa")) {
                        String numHexa = elemento2.substring(0, elemento2.length()-1);
                        int numDec = Integer.parseInt(numHexa,16);

                        if (numDec >= 0 && numDec <= 255) {
                            memoria = memoria + 3;
                        }else if(numDec >= 0 && numDec <= 65535){
                            memoria = memoria + 4;
                        }
                    }else if(token2.matches("num_bin")){    
                        String numBin = elemento2.substring(0, elemento2.length()-1);
                        int numDec = Integer.parseInt(numBin,2);

                        if (numDec >= 0 && numDec <= 255) {
                            memoria = memoria + 3;
                        }else if(numDec >= 0 && numDec <= 65535){
                            memoria = memoria + 4;
                        }
                    }else if(token2.matches("num_dec")){
                        int numDec = Integer.parseInt(elemento2);

                        if (numDec >= 0 && numDec <= 255) {
                            memoria = memoria + 3;  
                        }else if(numDec >= 0 && numDec <= 65535){
                            memoria = memoria + 4;
                        }
                    }
                }
            }
        }else if(token1.matches("registro") && token2.matches("num_dec|num_exa|num_bin")){
            if (token2.matches("num_exa")) {
                String numHexa = elemento2.substring(0, elemento2.length()-1);
                int numDec = Integer.parseInt(numHexa,16);

                if (numDec >= 0 && numDec <= 255) {
                    memoria = memoria + 3;
                }else if(numDec >= 0 && numDec <= 65535){
                    memoria = memoria + 4;
                }
            }else if(token2.matches("num_bin")){    
                String numBin = elemento2.substring(0, elemento2.length()-1);
                
                int numDec = Integer.parseInt(numBin,2);             

                if (numDec >= 0 && numDec <= 255) {
                    memoria = memoria + 3;
                }else if(numDec >= 0 && numDec <= 65535){
                    memoria = memoria + 4;
                }
            }else if(token2.matches("num_dec")){
                int numDec = Integer.parseInt(elemento2);

                if (numDec >= 0 && numDec <= 255) {
                    memoria = memoria + 3;  
                }else if(numDec >= 0 && numDec <= 65535){
                    memoria = memoria + 4;
                }
            }
        }
    }

    public void InsLDS(String instruccion, String tipo, String mem, String accmemo, String accmemo2){
       if(instruccion.matches("LDS|lds")){
           if(tipo.matches("registro")){
               memoria = memoria + 2;
           }} 
    }
    public void Instrucciones3(String instruccion, String tipo, String mem){
        if(instruccion.matches("IDIV|DIV|IMUL|POP|idiv|div|imul|pop")){
            if(tipo.matches("registro")){
                memoria = memoria + 2;
            }else if(tipo.matches("simbolo")){
                memoria = memoria + 4;
            }else if(tipo.matches("acc_memoria")){
                int n = mem.indexOf("[");
        
                String str = mem.substring(n+1, mem.length()-1);
                
                String[] el = str.split("\\+");
                
                if (el.length == 2) {
                    try {
                        Integer num = Integer.parseInt(el[1]);
                        if (num >= 0 && num <=255){
                            memoria = memoria + 3;
                        }else if(num >= 0 && num <= 65535){
                            memoria = memoria + 4;
                        }
                    } catch (Exception e) {
                    }
                }else if(el.length == 3){
                    try {
                        Integer num = Integer.parseInt(el[2]);
                        if (num >= 0 && num <=255){
                            memoria = memoria + 3;
                        }else if(num >= 0 && num <= 65535){
                            memoria = memoria + 4;
                        }
                    } catch (Exception e) {
                    }
                }else{
                    memoria = memoria + 2;
                }   
            }
        }
    }
    
    public void Instrucciones2(String instruccion){
        
        if(instruccion.matches("JS|JAE|JNS|JL|js|jae|jns|jl")){
                               
            memoria = memoria + 4;
        }else if(instruccion.matches("LOOPNE|loopne|JCXZ|jcxz")){
           memoria = memoria + 2;
        }
    }
  
    public void Instrucciones1(String instruccion){
        if (instruccion.matches("STD|CLD|CWD|IRET|MOVSW|std|cld|cwd|iret|movsw")) {
            memoria = memoria + 1;
        }else if(instruccion.matches("AAD|aad")){
            memoria = memoria + 2;
        }
        
    }
    
    
    
    public void Etiqueta(String etiqueta){
        datos3[0] = etiqueta;
        datos3[1] = "ETIQUETA";
        datos3[2] = "";
        datos3[3] = "";
        datos3[4] = memoria.toString();
        modelo3.addRow(datos3);
    }
    
    public void DataSegment(String num_tipo, String num){
        if (num_tipo.matches("num_exa")) {
            String numHexa = num.substring(0, num.length()-1);
            int numDec = Integer.parseInt(numHexa,16);
            
            memoria = memoria + 2*(numDec);
            
        }else if(num_tipo.matches("num_bin")){
            String numBin = num.substring(0, num.length()-1);
            int numDec = Integer.parseInt(numBin,2);
            
            memoria = memoria + 2*(numDec);
            
        }else if(num_tipo.matches("num_dec")){
            int numDec = Integer.parseInt(num);
            
            memoria = memoria + 2*(numDec);
        }
    }

    public void IniFinSegmento(String elemento){
        if (elemento.matches("stack_segment|Data_Segment|data_segment|code_segment|ends")) {
            memoria = 0;
        }
    }
    
    public void Constante(String simbolo, String tamanio, String valor){
        datos3[0] = simbolo;
        datos3[1] = "CONSTANTE";
        datos3[2] = tamanio;
        datos3[3] = valor;
        datos3[4] = "";
        modelo3.addRow(datos3);
                }
    
    public void Memoria3(String simbolo, String tamanio, String valor1, String valor2, String num_tipo){
          datos3[0] = simbolo;
          datos3[1] = "VARIABLE";
          datos3[2] = tamanio;
          datos3[3] = valor1 + " " + valor2;
          datos3[4] = memoria.toString();
          modelo3.addRow(datos3);
        
        if (num_tipo.matches("num_exa")) {
            String numHexa = valor1.substring(0, valor1.length()-1);
            int numDec = Integer.parseInt(numHexa,16);
            
            if (tamanio.equals("db")) {
                memoria = memoria + 1*(numDec);
            }

            if(tamanio.equals("dw")){
                memoria = memoria + 2*(numDec);
            }
            
        }else if(num_tipo.matches("num_bin")){
            String numBin = valor1.substring(0, valor1.length()-1);
            int numDec = Integer.parseInt(numBin,2);
            
            if (tamanio.equals("db")) {
                memoria = memoria + 1*(numDec);
            }

            if(tamanio.equals("dw")){
                memoria = memoria + 2*(numDec);
            }
            
        }else if(num_tipo.matches("num_dec")){
            int numDec = Integer.parseInt(valor1);
            
            if (tamanio.equals("db")) {
                memoria = memoria + 1*(numDec);
            }

            if(tamanio.equals("dw")){
                memoria = memoria + 2*(numDec);
            }
        } 
    }
    
    public void Memoria2(String simbolo, String tamanio, String valor){
 
        datos3[0] = simbolo;
        datos3[1] = "VARIABLE";
        datos3[2] = tamanio;
        datos3[3] = valor;
        datos3[4] = memoria.toString();
        modelo3.addRow(datos3);
        
        int n = valor.indexOf("\"");
        String str = valor.substring(n+1, valor.length()-1);
        
        memoria = memoria + str.length();
    }
    
    public void Memoria1(String simbolo, String tamanio, String valor){
 
        datos3[0] = simbolo;
        datos3[1] = "VARIABLE";
        datos3[2] = tamanio;
        datos3[3] = valor;
        datos3[4] = memoria.toString();
        modelo3.addRow(datos3);
        
        if (tamanio.equals("db")) {
            memoria = memoria + 1;
        }
            
        if(tamanio.equals("dw")){
            memoria = memoria + 2;
        }
    }
 
    public String convertirMemoria(){
        String memoria = "";
        
        return memoria;
    }
    
    public boolean regMemoria(String reg, String mem){
        boolean correcto = false;
        
        if (reg.matches("AX|BX|CX|DX") && mem.matches("dw")) {
            correcto = true;
        }else{
            correcto = false;
        }
        
        return correcto;
    }
    
    public boolean verifMemoria(String mem){
        boolean correcto = false;
        if (verifACCMemoria(mem) == true) {
            correcto = true;
        }else if(verifVar(mem) == true){
            correcto = true;
        }else{
            correcto = false;
        }
        
        return correcto;
    }
    
    public boolean verifVar(String cadena){
        
        boolean correcto = false;
        
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).equals(cadena)) {
                correcto = true;
                break;
            }
        }
        return correcto;
    }
    
    public boolean verifACCMemoria(String memoria){
        boolean correcto = false;
        
        int n = memoria.indexOf("[");
        
        String str = memoria.substring(n+1, memoria.length()-1);
        str = str.toUpperCase();
        
        if (str.length() == 2) {
            if (str.matches("SI|DI|BX")) {
                correcto = true;
            }
        }else if(str.length() > 2){
            String[] elementos = str.split("\\+");        

            if (elementos.length == 2) {
                if (elementos[0].matches("BX|BP") && elementos[1].matches("SI|DI")) {
                    correcto = true;
                }else if(elementos[0].matches("SI|DI") && elementos[1].matches("BX|BP")){
                   correcto = true;
                }else if(elementos[0].matches("SI|DI|BP|BX")){
                    boolean c = verifNum(elementos[1]);
                    if (c == true) {
                        correcto = true;
                    }else{
                        correcto = false;
                    }
                }else{
                    correcto = false;
                }
            }else if(elementos.length == 3){
                if (elementos[0].matches("BX|BP") && elementos[1].matches("SI|DI")) {
                    boolean c = verifNum(elementos[2]);
                    if (c == true) {
                        correcto = true;
                    }else{
                        correcto = false;
                    }
                }else if (elementos[0].matches("SI|DI") && elementos[1].matches("BX|BP")) {
                    boolean c = verifNum(elementos[2]);
                    if (c == true) {
                        correcto = true;
                    }else{
                        correcto = false;
                    }
                }
                    
            }
        }

        return correcto;
    }
    
    public boolean verifNum(String num){
        boolean correcto = false;
        num = num.toUpperCase();
        
        try {
            int numEntero = Integer.parseInt(num);
            correcto = true;
        } catch (Exception e) {
        }
        
        try {
            if (num.endsWith("H")){
                int n = num.indexOf("H");
                String numero = num.substring(0, n);
                
                int numHexa = Integer.parseInt(numero,16);
                correcto = true;
            }
        } catch (Exception e) {
        }
        
        try {
            if (num.endsWith("B")){
                int n = num.indexOf("B");
                String numero = num.substring(0, n);
                
                int numBin = Integer.parseInt(numero,2);
                correcto = true;
            }
        } catch (Exception e) {
        }
        
        return correcto;
    }
        
    public void Separador() throws IOException{

        String expr = (String) PanelParaCodigoFuente.getText();
        String[] str = expr.split("\n");
        
        for (int i = 0; i < str.length; i++) {
            Elementos elementos = new Elementos();
            elementos.setLinea(str[i]);

            Lexer lexer = new Lexer(new StringReader(str[i]));
            
            boolean repetir = true;

            while (repetir == true) {  
                Tokens tokens = lexer.yylex();
                String cadena = lexer.yytext();
                
                if (tokens != null) {
                    elementos.setElemento(cadena);
                    elementos.setToken(tokens.toString());
                }else{
                    repetir = false;
                }
            }
            
          modeloLista.add(elementos);
            
            
        }
        
        Identificacion();
       
    }
    
    public String compInmByte(String num_tipo, String num){
        String correcto = "";
        if(num_tipo.matches("num_dec")){
                    int numDec = Integer.parseInt(num);
                    
                    if (numDec >= 0 && numDec <= 255) {
                        correcto = "correcto";
                    }
        
        
    }
        return correcto;
    }
    
    public String comprobarVariable1(String simbolo, String tipo, String num_tipo, String num){
        String correcto = "";

        if (simbolo.length() <= 10) {
            if (tipo.matches("db")) {
                if (num_tipo.matches("num_exa")) {
                    String numHexa = num.substring(0, num.length()-1);
                    int numDec = Integer.parseInt(numHexa,16);
                    
                    if (numDec >= 0 && numDec <= 255) {
                        correcto = "correcto";
                    }else{
                        correcto = "const_num_db_inc";
                    }
                }else if(num_tipo.matches("num_bin")){    
                    String numBin = num.substring(0, num.length()-1);
                    System.out.println("IMPRIMIR RESULTADO DE numBin: "+numBin);
                    int numDec = Integer.parseInt(numBin,2);
                    System.out.println("IMPRIMIR RESULTADO DE numDec: "+numDec);
                    
                    if (numDec >= 0 && numDec <= 255) {
                        correcto = "correcto";
                    }else{
                        correcto = "const_num_db_inc";
                    }
                }else if(num_tipo.matches("num_dec")){
                    int numDec = Integer.parseInt(num);
                    
                    if (numDec >= 0 && numDec <= 255) {
                        correcto = "correcto";
                    }else{
                        correcto = "const_num_db_inc";
                    }
                }
            }else if (tipo.matches("dw")) {
                if (num_tipo.matches("num_exa")) {
                    String numHexa = num.substring(0, num.length()-1);
                    int numDec = Integer.parseInt(numHexa,16);

                    if (numDec >= 0 && numDec <= 65535) {
                        correcto = "correcto";
                    }else{
                        correcto = "const_num_dw_inc";
                    }
                }else if(num_tipo.matches("num_bin")){
                    String numBin = num.substring(0, num.length()-1);
                    int numDec = Integer.parseInt(numBin,2);
                    
                    if (numDec >= 0 && numDec <= 65535) {
                        correcto = "correcto";
                    }else{
                        correcto = "const_num_dw_inc";
                    }
                }else if(num_tipo.matches("num_dec")){
                    int numDec = Integer.parseInt(num);
                    
                    if (numDec >= 0 && numDec <= 65535) {
                        correcto = "correcto";
                    }else{
                        correcto = "const_num_dw_inc";
                    }
                }
            }
        }else{
            correcto = "simbolo_invalido";
        }
        
        return correcto;
    }
    
    public String comprobarVariable2(String simbolo, String tipo, String num_tipo, String num, String dup_tipo, String dup){
        String correcto = "error";
        
        boolean c1 = false;
        boolean c2 = false;
        boolean c3 = false;
        
        if (simbolo.length() <= 10) {
            c1 = true;
        }else{
            c1 = false;
        }
        
        if (num_tipo.matches("num_exa")) {
            String numHexa = num.substring(0, num.length()-1);
            int numDec = Integer.parseInt(numHexa,16);

            if (numDec >= 0 && numDec <= 65535) {
                c2 = true;
            }else{
                c2 = false;
            }
        }else if(num_tipo.matches("num_bin")){
            String numBin = num.substring(0, num.length()-1);
            int numDec = Integer.parseInt(numBin,2);

            if (numDec >= 0 && numDec <= 65535) {
                c2 = true;
            }else{
                c2 = false;
            }
        }else if(num_tipo.matches("num_dec")){
            int numDec = Integer.parseInt(num);

            if (numDec >= 0 && numDec <= 65535) {
                c2 = true;
            }else{
                c2 = false;
            }
        }
        
        if (tipo.equals("db")) {
            if (dup_tipo.equals("pseudo_const_carac")) {
                String str = dup.substring(dup.indexOf("(")+1, dup.indexOf(")"));
                if (str.length() == 3) {
                    c3 = true;
                }else{
                    c3 = false;
                }
            }else if(dup_tipo.equals("pseudo_const_num")){
                String str = dup.substring(dup.indexOf("(")+1, dup.indexOf(")"));
                int numDec = Integer.parseInt(str);

                if (numDec >= 0 && numDec <= 255) {
                    c3 = true;
                }else{
                    c3 = false;
                }
            }else if(dup_tipo.equals("pseudo_const_hexa")){
                String numBin = dup.substring(dup.indexOf("(")+1, dup.indexOf(")"));
                numBin = numBin.substring(0, numBin.length()-1);
                int numDec = Integer.parseInt(numBin,16);

                if (numDec >= 0 && numDec <= 255) {
                    c3 = true;
                }else{
                    c3 = false;
                }
            }else if(dup_tipo.equals("pseudo_const_bin")){
                String numBin = dup.substring(dup.indexOf("(")+1, dup.indexOf(")"));
                numBin = numBin.substring(0, numBin.length()-1);
                int numDec = Integer.parseInt(numBin,2);

                if (numDec >= 0 && numDec <= 255) {
                    c3 = true;
                }else{
                    c3 = false;
                }
            }
        }
        
        if (tipo.equals("dw")) {
            if(dup_tipo.equals("pseudo_const_num")){
                String str = dup.substring(dup.indexOf("(")+1, dup.indexOf(")"));
                int numDec = Integer.parseInt(str);

                if (numDec >= 0 && numDec <= 65535) {
                    c3 = true;
                }else{
                    c3 = false;
                }
            }else if(dup_tipo.equals("pseudo_const_hexa")){
                String numBin = dup.substring(dup.indexOf("(")+1, dup.indexOf(")"));
                numBin = numBin.substring(0, numBin.length()-1);
                int numDec = Integer.parseInt(numBin,16);

                if (numDec >= 0 && numDec <= 65535) {
                    c3 = true;
                }else{
                    c3 = false;
                }
            }else if(dup_tipo.equals("pseudo_const_bin")){
                String numBin = dup.substring(dup.indexOf("(")+1, dup.indexOf(")"));
                numBin = numBin.substring(0, numBin.length()-1);
                int numDec = Integer.parseInt(numBin,2);

                if (numDec >= 0 && numDec <= 65535) {
                    c3 = true;
                }else{
                    c3 = false;
                }
            }
        }
        
        if (c1 == true) {
            if(c2 == true){
                if (c3 == true) {
                    correcto = "correcto";
                }else{
                    correcto = "const_inc";
                }
            }else{
                correcto = "const_num_inc";
            }
        }else{
            correcto = "simbolo_invalido";
        }
        
        return correcto; 
    }
    
    public String instruccionesEtiquetas(String cad){
        String correcto = "incorrecto";
        
        String etiqueta = cad + ":";
        
        String may = etiqueta.toUpperCase();
        String min = etiqueta.toLowerCase();
        
        for (int i = 0; i < etiquetas.size(); i++) {
            if (etiquetas.get(i).equals(may)) {
                correcto = "correcto";
                break;
            }else if(etiquetas.get(i).equals(min)){
                correcto = "correcto";
                break;
            }
        }

        return correcto;
    }
    
   
    public String instruccionRegistroMemoria(String tipo_operador, String operador){
        String correcto = "incorrecto";
        
        if (tipo_operador.equals("registro")) {
            correcto = "correcto";
        }else if(tipo_operador.matches("acc_memoria|simbolo")){
            String c = verifMemReg(tipo_operador, operador);
            
            if (c.equals("correcto")) {
                correcto = "correcto";
            }
        }
        
        return correcto;
    }
    
    public String verifRegReg(String reg1, String reg2){
        String correcto = "incorrecto";
        
        if (reg1.matches("AX|BX|CX|DX|DI|SI|BP|SP") && reg2.matches("AX|BX|CX|DX|DI|SI|BP|SP") ) {
            correcto = "correcto";
        }else if (reg1.matches("AH|AL|BL|BH|CH|CL|DH|DL") && reg2.matches("AH|AL|BL|BH|CH|CL|DH|DL")) {
            correcto = "correcto";
        }
        
        return correcto;
    }
    
    public String verifyRegisterWithOne(String reg, String dec){
        String correcto = "incorrecto";
        
        if(reg.matches("AX|BX|CX|DX|DI|SI|BP|SP") && dec.equals("1")){
            correcto = "correcto";
        }else if(reg.matches("AH|AL|BL|BH|CH|CL|DH|DL") && dec.equals("1")){
            correcto = "correcto"; 
        }
        
        return correcto;
    }
    
    public String comprobarConstante(String simbolo,String num_tipo, String num){
        String correcto = "incorrecto";

        if (simbolo.length() < 10) {
            if (num_tipo.matches("num_exa")) {
                String numHexa = num.substring(0, num.length()-1);
                int numDec = Integer.parseInt(numHexa,16);

                if (numDec >= 0 && numDec <= 65535) {
                    correcto = "correcto";
                }
            }else if(num_tipo.matches("num_bin")){
                String numBin = num.substring(0, num.length()-1);
                int numDec = Integer.parseInt(numBin,2);

                if (numDec >= 0 && numDec <= 65535) {
                    correcto = "correcto";
                }
            }else if(num_tipo.matches("num_dec")){
                int numDec = Integer.parseInt(num);

                if (numDec >= 0 && numDec <= 65535) {
                    correcto = "correcto";
                }
            }
        }else{
            correcto = "inc_simbolo";
        }
        
        return correcto;
    }
    
    public String verifMemReg(String tipo ,String reg1){
        String correcto = "incorrecto";
        
        if (tipo.matches("simbolo")) {
                        
            String may = reg1.toUpperCase();
            String min = reg1.toLowerCase();

            boolean verif1 = verifVar(may);
            boolean verif2 = verifVar(min);

            if (verif1 == true) {
                correcto = "correcto";
            }

            if(verif2 == true){
                correcto = "correcto";
            }
        }
        
        if (tipo.matches("acc_memoria")) {
            String may = reg1.toUpperCase();
            String min = reg1.toLowerCase();

            boolean verif1 = verifACCMemoria(may);
            boolean verif2 = verifACCMemoria(min);

            if (verif1 == true) {
                correcto = "correcto";
            }

            if(verif2 == true){
                correcto = "correcto";
            } 
        }

        return correcto;
    }
    
    public String verifPila(String num1_tipo, String num1, String num2_tipo, String num2){
        String correcto = "incorrecto";
        
        boolean c1 = false;
        boolean c2 = false;
        
        if (num1_tipo.matches("num_exa")) {
            String numHexa = num1.substring(0, num1.length()-1);
            int numDec = Integer.parseInt(numHexa,16);

            if (numDec >= 0 && numDec <= 65535) {
                c1 = true;
            }else{
                c1 = false;
            }
        }else if(num1_tipo.matches("num_bin")){
            String numBin = num1.substring(0, num1.length()-1);
            int numDec = Integer.parseInt(numBin,2);

            if (numDec >= 0 && numDec <= 65535) {
                c1 = true;
            }else{
                c1 = false;
            }
        }else if(num1_tipo.matches("num_dec")){
            int numDec = Integer.parseInt(num1);

            if (numDec >= 0 && numDec <= 65535) {
                c1 = true;
            }else{
                c1 = false;
            }
        }
        
        if(num2_tipo.equals("pseudo_const_num")){
            String str = num2.substring(num2.indexOf("(")+1, num2.indexOf(")"));
            int numDec = Integer.parseInt(str);

            if (numDec >= 0 && numDec <= 65535) {
                c2 = true;
            }else{
                c2 = false;
            }
        }else if(num2_tipo.equals("pseudo_const_hexa")){
            String numBin = num2.substring(num2.indexOf("(")+1, num2.indexOf(")"));
            numBin = numBin.substring(0, numBin.length()-1);
            int numDec = Integer.parseInt(numBin,16);

            if (numDec >= 0 && numDec <= 65535) {
                c2 = true;
            }else{
                c2 = false;
            }
        }else if(num2_tipo.equals("pseudo_const_bin")){
            String numBin = num2.substring(num2.indexOf("(")+1, num2.indexOf(")"));
            numBin = numBin.substring(0, numBin.length()-1);
            int numDec = Integer.parseInt(numBin,2);

            if (numDec >= 0 && numDec <= 65535) {
                c2 = true;
            }else{
                c2 = false;
            }
        }
        
        if (c1 == true) {
            if (c2 == true) {
                correcto = "correcto";
            }else{
                correcto = "num2_inc";
            }
        }else{
            correcto = "num1_inc";
        }
        
        return correcto;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnSelectFile = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarComo = new javax.swing.JButton();
        btnAcercaDe = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnCUnidades = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblRuta = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabfasedos = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabsimbolos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelParaCodigoFuente = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabfaseuno = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ANALIZADOR LEXICOGRAFICO");
        setBackground(new java.awt.Color(32, 33, 36));
        setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(32, 33, 36));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(60, 64, 67));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSelectFile.setBackground(new java.awt.Color(60, 64, 67));
        btnSelectFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/openFile.png"))); // NOI18N
        btnSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFileActionPerformed(evt);
            }
        });
        jPanel4.add(btnSelectFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 60, 60));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1635, 26, -1, -1));

        btnCompilar.setBackground(new java.awt.Color(60, 64, 67));
        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/compile (1).png"))); // NOI18N
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 60, 60));

        btnGuardar.setBackground(new java.awt.Color(60, 64, 67));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Save.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 60, 60));

        btnGuardarComo.setBackground(new java.awt.Color(60, 64, 67));
        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/SaveAs.png"))); // NOI18N
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardarComo, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 60, 60));

        btnAcercaDe.setBackground(new java.awt.Color(60, 64, 67));
        btnAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/group.png"))); // NOI18N
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });
        jPanel4.add(btnAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 60, 60));

        jPanel12.setBackground(new java.awt.Color(32, 33, 36));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(32, 33, 36));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(74, 222, 222));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("COMPILAR");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel12.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, 40));

        jPanel16.setBackground(new java.awt.Color(32, 33, 36));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(74, 222, 222));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("COMPILAR");
        jPanel16.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel17.setBackground(new java.awt.Color(32, 33, 36));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(74, 222, 222));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("COMPILAR");
        jPanel17.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, 40));

        jPanel12.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 70, 30));

        jPanel18.setBackground(new java.awt.Color(32, 33, 36));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(74, 222, 222));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("COMPILAR");
        jPanel18.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel19.setBackground(new java.awt.Color(32, 33, 36));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(74, 222, 222));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("COMPILAR");
        jPanel19.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, 40));

        jPanel20.setBackground(new java.awt.Color(32, 33, 36));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(74, 222, 222));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("COMPILAR");
        jPanel20.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel21.setBackground(new java.awt.Color(32, 33, 36));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(74, 222, 222));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("COMPILAR");
        jPanel21.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, 40));

        jPanel18.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 70, 30));

        jPanel12.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, 40));

        jLabel27.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(74, 222, 222));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("COMPILAR");
        jPanel12.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 110, 40));

        btnCUnidades.setBackground(new java.awt.Color(60, 64, 67));
        btnCUnidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/CUnidades.png"))); // NOI18N
        btnCUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCUnidadesActionPerformed(evt);
            }
        });
        jPanel4.add(btnCUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 60, 60));

        jPanel9.setBackground(new java.awt.Color(32, 33, 36));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(74, 222, 222), 2, true));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jPanel11.setBackground(new java.awt.Color(32, 33, 36));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(74, 222, 222));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SELECCIONAR ARCHIVO");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 20, 162, 40));

        jPanel22.setBackground(new java.awt.Color(32, 33, 36));

        jLabel28.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(74, 222, 222));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("LIMPIAR");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 190, 60));

        btnLimpiar.setBackground(new java.awt.Color(60, 64, 67));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Clean.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel4.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, 60));

        jPanel23.setBackground(new java.awt.Color(32, 33, 36));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(74, 222, 222));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GUARDAR");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 130, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 150, 60));

        jPanel24.setBackground(new java.awt.Color(32, 33, 36));

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(74, 222, 222));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GUARDAR COMO");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 140, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 130, 60));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 160, 60));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, -1, 80));

        lblRuta.setBackground(new java.awt.Color(60, 64, 67));
        lblRuta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));
        lblRuta.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblRuta.setForeground(new java.awt.Color(28, 167, 236));
        lblRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(lblRuta);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 1280, 30));

        tabfasedos.setBackground(new java.awt.Color(60, 64, 67));
        tabfasedos.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        tabfasedos.setForeground(new java.awt.Color(28, 167, 236));
        tabfasedos.setModel(modelo2);
        tabfasedos.setToolTipText("");
        jScrollPane3.setViewportView(tabfasedos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 840, 160));

        tabsimbolos.setBackground(new java.awt.Color(60, 64, 67));
        tabsimbolos.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        tabsimbolos.setForeground(new java.awt.Color(28, 167, 236));
        tabsimbolos.setModel(modelo3);
        tabsimbolos.setToolTipText("");
        jScrollPane7.setViewportView(tabsimbolos);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 410, 160));

        PanelParaCodigoFuente.setEditable(false);
        PanelParaCodigoFuente.setBackground(new java.awt.Color(60, 64, 67));
        PanelParaCodigoFuente.setColumns(20);
        PanelParaCodigoFuente.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        PanelParaCodigoFuente.setForeground(new java.awt.Color(28, 167, 236));
        PanelParaCodigoFuente.setRows(5);
        jScrollPane1.setViewportView(PanelParaCodigoFuente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 410, 210));

        tabfaseuno.setBackground(new java.awt.Color(60, 64, 67));
        tabfaseuno.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        tabfaseuno.setForeground(new java.awt.Color(28, 167, 236));
        tabfaseuno.setModel(modelo);
        tabfaseuno.setToolTipText("");
        jScrollPane4.setViewportView(tabfaseuno);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 840, 210));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 10, 300));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 580, 370, 10));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 450, 10));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 580, 520, 10));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 450, 10));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 520, 10));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 370, 10));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 300, 10, 290));

        jPanel26.setBackground(new java.awt.Color(32, 33, 36));

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(74, 222, 222));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TABLA DE SIMBOLOS");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 390, 30));

        jPanel27.setBackground(new java.awt.Color(32, 33, 36));

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(74, 222, 222));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ANALISIS SINTACTICO Y SEMANTICO");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 820, 30));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 840, 50));

        jPanel28.setBackground(new java.awt.Color(32, 33, 36));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(74, 222, 222));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CODIGO FUENTE");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 390, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 410, 50));

        jPanel29.setBackground(new java.awt.Color(32, 33, 36));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(74, 222, 222));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SEPARACION DE ELEMENTOS Y ANALISIS LEXICOGRAFICO");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 820, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 840, 50));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 410, 50));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 300));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 10, 300));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 10, 260));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 10, 300));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 450, 10));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, 520, 10));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto3/Vídeo-sin-título-‐-Hecho-con-Clipchamp.gif"))); // NOI18N
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, 370, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void limpiarCampos(){
      //llamar al metodo para limpiar todos los campos de la tabla de tokens
      PanelParaCodigoFuente.setText("");
      Functions.clearDataInTable(tabfaseuno); 
      Functions.clearDataInTable(tabfasedos);
      Functions.clearDataInTable(tabsimbolos);
      //limpiar los arrayList
      lblRuta.setText("");
      
      
      
    } 
    
    
    private void compilar(){
        modeloLista.clear();
         try {
            Separador();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
    private void BuildingFunction(){
    UIManager UI=new UIManager();
    //cambiar el tamaño de la fuente y la fuente
    UI.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
    //Cambiar color fondo y secundario
    UI.put("OptionPane.background", Color.decode("#202124"));
    UI.put("OptionPane.messageForeground", Color.decode("#5d7bb8"));
    UI.put("Button.background", Color.decode("#5d7bb8"));
    UI.put("Button.foreground", Color.decode("#202124"));
    JOptionPane.showMessageDialog(null, "FUNCION EN DESARROLLO, AUN NO DISPONIBLE...", "ANALIZADOR LEXICOGRAFICO", JOptionPane.INFORMATION_MESSAGE);
    }
   

    private void btnSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFileActionPerformed
    limpiarCampos();
   //Bloquea la edicion del JTextArea
   // TextPaneCodigoFuente.setEditable(false);  
    lblRuta.setEditable(false);
    //Creamos el objeto JFileChooser
   
            JFileChooser fileChooser = new JFileChooser();
            
         fileChooser.setAcceptAllFileFilterUsed(false);    
        FileFilter filtro = new FileNameExtensionFilter(".asm","asm");
        fileChooser.setFileFilter(filtro);
        int selection = fileChooser.showOpenDialog(this);
        
        
        File archivo = new File(fileChooser.getSelectedFile().getAbsolutePath());
        this.lblRuta.setText(archivo.getAbsolutePath());
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            PanelParaCodigoFuente.setText(ST);
        } catch (Exception e) {
            
        }     
        
    
    }//GEN-LAST:event_btnSelectFileActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
      compilar();
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
     limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
     BuildingFunction();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
     BuildingFunction();
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        AcercaDe acd = new AcercaDe();
        acd.setVisible(true);
    }//GEN-LAST:event_btnAcercaDeActionPerformed

    private void btnCUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCUnidadesActionPerformed
        ConversorUnidades cvu = new ConversorUnidades();
        cvu.setVisible(true);
    }//GEN-LAST:event_btnCUnidadesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
           try {
             
                   UIManager.setLookAndFeel(new FlatIntelliJLaf());
               
               new FramePrincipal().setVisible(true);
               
           } catch(UnsupportedLookAndFeelException ex){
               Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
              
           }
           

        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea PanelParaCodigoFuente;
    private javax.swing.JButton btnAcercaDe;
    private javax.swing.JButton btnCUnidades;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSelectFile;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextPane lblRuta;
    public javax.swing.JTable tabfasedos;
    public javax.swing.JTable tabfaseuno;
    public javax.swing.JTable tabsimbolos;
    // End of variables declaration//GEN-END:variables
}
