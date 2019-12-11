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
public class Triangle extends Shape {
    
    double x;
    double y;
    double z;
    
    public Triangle(){
        this(10, 6, 6);
    }
    
     public Triangle(double x, double y, double z){
        this.x = x;
        this.x = y;
        this.x = z;
    }
     
    @Override
    public double getArea(){
        double s = (x + y + z) / 2;
        return Math.sqrt(s * (s - z) * (s - y) * (s - z));
    }
    
    @Override
    public double getPerimeter(){
        return x + y + z;
    }
}
