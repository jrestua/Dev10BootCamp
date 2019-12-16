/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milestone2Lesson5;

/**
 *
 * @author joe
 */
public class Capital {

    //declare variables
    String name;
    int population;
    int squareMilage;
    
    public Capital(String name, int population, int squareMilage){
        this.name = name;
        this.population = population;
        this.squareMilage = squareMilage;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getSquareMilage() {
        return squareMilage;
    }
    
    @Override
    public String toString(){
        return (" - " + name + " | Population: " +  population + " | Square Miles: " + squareMilage);
    }
    
}
