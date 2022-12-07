/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensambladoresproyecto3;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Principal {
 public static void main(String[] args) throws Exception {
        String ruta1 = System.getProperty("user.dir") + "/src/ensambladoresproyecto3/Lexer.flex";
        String ruta2 = System.getProperty("user.dir") + "/src/ensambladoresproyecto3/Lexer.flex";
        String[] rutaS = {"-parser", "Sintax", System.getProperty("user.dir") + "/src/ensambladoresproyecto3/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get(System.getProperty("user.dir") + "/src/ensambladoresproyecto3/sym.java");
        if(Files.exists(rutaSym)){
           Files.delete(rutaSym);
        }
        
        Files.move(
                Paths.get(System.getProperty("user.dir") + "/src/ensambladoresproyecto3/sym.java"), 
                Paths.get(System.getProperty("user.dir") + "/src/ensambladoresproyecto3/sym.java")
        );
        
        Path rutaSin = Paths.get(System.getProperty("user.dir") + "/src/ensambladoresproyecto3/sym.java");
        if(Files.exists(rutaSin)){
           Files.delete(rutaSin);
        }
        
        Files.move(
                Paths.get(System.getProperty("user.dir") + "/src/ensambladoresproyecto3/sym.java"), 
                Paths.get(System.getProperty("user.dir") + "/src/ensambladoresproyecto3/sym.java")
        );
    }
}
//C:\Users\Luis Angel Rocha\Desktop\ensambladoresdos\src\ensambladoresproyecto3
