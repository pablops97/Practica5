/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author ConoMaster
 */
public class Imagen {

    private String directorio;

    public Imagen(String directorio) {
        this.directorio = directorio;
    }

    public ArrayList<BufferedImage> cargarImagenes() {
        ArrayList<BufferedImage> imagenes = new ArrayList<>();

        File carpeta = new File(directorio);
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                try {
                    BufferedImage imagen = ImageIO.read(archivo);
                    imagenes.add(imagen);
                } catch (IOException e) {
                    System.err.println("Error al cargar la imagen: " + archivo.getName());
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("El directorio no contiene archivos.");
        }

        return imagenes;
    }
    
    public ImageIcon obtenerIconoPorNombre(String nombreImagen) {
        File carpeta = new File(directorio);
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().equals(nombreImagen)) {
                    try {
                        BufferedImage imagen = ImageIO.read(archivo);
                        return new ImageIcon(imagen);
                    } catch (IOException e) {
                        System.err.println("Error al cargar la imagen: " + archivo.getName());
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.err.println("El directorio no contiene archivos.");
        }

        System.err.println("Imagen no encontrada: " + nombreImagen);
        return null;
    }
}
