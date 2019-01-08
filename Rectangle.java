import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Rectangle {
    private int x;
    private int y;
    private List<Double> pixels;
    private Matrix vectorX0;

    public Rectangle(int x, int y) {
        pixels = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    //    public Matrix createVectorX0() {
//        double newMatrix[][] = new double[1][pixels.size()];
//        for (int i = 0; i < pixels.size(); i++) {
//            newMatrix[0][i] = pixels.get(i);
//        }
//        return new Matrix(newMatrix);
//    }

    public void createVectorX0() {
        double vector[][] = new double[1][pixels.size()];
        for (int i = 0; i < pixels.size(); i++) {
            vector[0][i] = pixels.get(i);
        }
        this.vectorX0 = new Matrix(vector);
    }

    public void addElement(double element) {
        pixels.add(element);
    }

    public void addPixel(Color color) {
        double red = color.getRed();
        double blue = color.getBlue();
        double green = color.getGreen();
        double pixelColorValueRed = 2 * red / 255 - 1;
        double pixelColorValueBlue = 2 * blue / 255 - 1;
        double pixelColorValueGreen = 2 * green / 255 - 1;
        this.pixels.add(pixelColorValueRed);
        this.pixels.add(pixelColorValueBlue);
        this.pixels.add(pixelColorValueGreen);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Matrix getVectorX0(){
        return vectorX0;
    }
}
