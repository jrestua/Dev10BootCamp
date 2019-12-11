/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShapesAndPerimeters2;

/**
 *
 * @author joe
 */
public class Circle extends Shape{
    double radius;
    final double pi = Math.PI;
    
        public Circle(){
        this(10);
    }
    
     public Circle(double radius){
        this.radius = radius;
    }
    
         @Override
    public double getArea(){
        return pi * Math.pow(radius, 2);
    }
    
    @Override
    public double getPerimeter(){
        return 2 * pi * radius;
    }
     
}
