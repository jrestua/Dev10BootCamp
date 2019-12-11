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
public class TestShape {

    public static void main(String[] args) {
        //Square
        Square squareObject = new Square(7) {
        };

        System.out.println("The area for the square is: " + squareObject.getArea());
        System.out.println("The perimeter for the square is: " + squareObject.getPerimeter());
        System.out.println("");

        //Circle
        Circle circleObject = new Circle(5) {
        };

        System.out.println("The area for the circle is: " + circleObject.getArea());
        System.out.println("The perimeter for the cirlce is: " + circleObject.getPerimeter());
        System.out.println("");

        //Triangle
        Triangle triangleObject = new Triangle(10, 5, 5) {
        };

        System.out.println("The area for the triangle is: " + triangleObject.getArea());
        System.out.println("The perimeter for the triangle is: " + triangleObject.getPerimeter());
        System.out.println("");

    }
}
