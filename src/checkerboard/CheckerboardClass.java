/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Jonathan
 */
public class CheckerboardClass {
    private AnchorPane anchorPane;
    private double width;
    private double height;
    private int rows;
    private int columns;
    private Color lightColor;
    private Color darkColor;
    private double rectangleWidth;
    private double rectangleHeight;
    
    private final Color DEFAULT_LIGHT = Color.RED;
    private final Color DEFAULT_DARK = Color.BLACK;
   
    
    
    
    public CheckerboardClass(double width, double height, int rows, int columns){
        /*CheckerboardClass colorCheckerboard = new CheckerboardClass(width, height, rows, columns);
        colorCheckerboard.lightColor = lightColor;
        colorCheckerboard.darkColor = darkColor;*/
        this(width, height, rows, columns, Color.RED, Color.BLACK);
    }
    
    public CheckerboardClass(double width, double height, int rows, int columns, Color lightColor, Color darkColor){
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.columns = columns;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        this.rectangleWidth = Math.ceil(width / columns);
        this.rectangleHeight = Math.ceil(height / rows);
        
        
    }
    
    
    public AnchorPane build(){
        AnchorPane anchorPane = new AnchorPane();
        Rectangle rectangle;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                if((row + col) % 2 == 0){
                    rectangle = new Rectangle(rectangleWidth, rectangleHeight, lightColor);
                }
                else{
                    rectangle = new Rectangle(rectangleWidth, rectangleHeight, darkColor);
                }
                
                AnchorPane.setTopAnchor(rectangle, rectangleHeight * row);
                AnchorPane.setLeftAnchor(rectangle, rectangleWidth * col);
                
                anchorPane.getChildren().add(rectangle);
            }
        }
        
        this.anchorPane = anchorPane;
        
        return anchorPane;
    }
    
    public AnchorPane getBoard(){
        if(anchorPane != null){
            return anchorPane;
        }
        else {
            return null;
        }
    }
    
    public int getNumRows(){
        return rows;
    }
    
    public int getNumCols(){
        return columns;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    
    public double getRectangleWidth(){
        return rectangleWidth;
    }
    
    public double getRectangleHeight(){
        return rectangleHeight;
    }
}
