/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.superheroesjpa;

import dao.ISuperHeroeDAO;
import dao.SuperHeroeDAO;
import entity.IdentidadSecreta;
import entity.SuperHeroe;
import entity.Universo;

/**
 *
 * @author demib
 */
public class SuperheroesJPA {

    public static void main(String[] args) {
        ISuperHeroeDAO dao = new SuperHeroeDAO();
        
//        //INSERTAR
        SuperHeroe spiderman = new SuperHeroe(
                "Spider-Man",
                Universo.MARVEL,
                new IdentidadSecreta("Peter Parker", "New York", "Fotografo"),
                "Con gran poder viene gran responsabilidad"
        );
        
        SuperHeroe batman = new SuperHeroe(
                "Batman",
                Universo.DC,
                new IdentidadSecreta("Bruce Wayne", "Gotham", "Empresario"),
                "Soy la venganza"
        );
        
        SuperHeroe goku = new SuperHeroe(
                "goku",
                Universo.INDEPENDIENTE,
                new IdentidadSecreta("Kakarotto", "Planeta Tierra", "Guerrero"),
                "KAMEHAMEHA!"   
        );
//        
        dao.insertar(spiderman);
        dao.insertar(batman);
        dao.insertar(goku);
        
        //LISTAR
        System.out.println("Lista Inicial de SuperHeroes:");
        dao.listar().forEach(h -> System.out.println(h.getId() + " - " + h.getNombre() + " (" + h.getUniverso() + ") "));
    
//        //MODIFICAR SUPERHEROE
        SuperHeroe batmanBD = dao.buscar(batman.getId());
        batmanBD.getIdentidadSecreta().setCiudad("Ciudad Gotica");
        dao.actualizar(batmanBD);
        
        System.out.println("Lista despues de modificar a Batman");
        dao.listar().forEach(h -> System.out.println(h.getId() + " - " + h.getNombre() + " ( " + h.getIdentidadSecreta().getCiudad() + ")"));
        
        
        //Eliminar Superheroe
        dao.eliminar(batman.getId());
        System.out.println("Lista despues de eliminar a batman");
        dao.listar().forEach(h -> System.out.println(h.getId() + " - " + h.getNombre()));
    
    }
    
    
}
