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
public abstract class Square extends Shape {
   
    double x;
    
    public Square(){
        this(10);
    }
    
     public Square(double x){
        this.x = x;
    }
    
    @Override
    public double getArea(){
        return x * x ;
    }
    
    @Override
    public double getPerimeter(){
        return x + x + x + x;
    }
}
