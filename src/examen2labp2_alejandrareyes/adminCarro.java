/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2labp2_alejandrareyes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class adminCarro {
    private ArrayList<Carro> carros = new ArrayList();
    private File archivo = null;
    
    public adminCarro(String path) {
        archivo = new File(path);
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    
    public void setCarro(Carro c) {
        this.carros.add(c);
    }
    
    public void cargarArchivo() {
        try {            
            carros = new ArrayList();
            Carro temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream obj = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Carro) obj.readObject()) != null) {
                        carros.add(temp);
                    }
                } catch (EOFException e) {
                   e.printStackTrace();
                }
                obj.close();
                entrada.close();
            }         
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void escribir () {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Carro c : carros) {
                bw.writeObject(c);
            }
            bw.flush();
            
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }    
}
