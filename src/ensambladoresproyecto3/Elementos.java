
package ensambladoresproyecto3;

import java.util.ArrayList;

public class Elementos {
    private String linea;
    public ArrayList<String> elemento = new ArrayList<String>();
    public ArrayList<String> token = new ArrayList<String>();

    public Elementos(String linea, String elemento, String token) {
        this.linea = linea;
        this.elemento.add(elemento);
        this.token.add(token);
    }

    Elementos() {
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public ArrayList<String> getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento.add(elemento);
    }

    public ArrayList<String> getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token.add(token);
    }

}
