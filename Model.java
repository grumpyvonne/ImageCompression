import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private int rectangleWidth;
    private int rectangleHeight;
    private double error;
    private int p;
    private BufferedImage image;
    private List<Rectangle> rectangles;
    private Matrix W;
    private Matrix W_;

    public void start() {
        splitImageIntoRectangles();
        createFirstLayerWeightsMatrix();
        createSecondLayerWeightsMatrix();
        System.out.println(W.getMatrix()[1][2]);
    }

    public void setRectangleWidth(int width) {
        this.rectangleWidth = width;
    }

    public void setRectangleHeight(int rectangleHeight) {
        this.rectangleHeight = rectangleHeight;
    }

    public void setError(double error) {
        this.error = error;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setP(int p) {
        this.p = p;
    }

    private void splitImageIntoRectangles() {
        rectangles = new ArrayList<>();
        int x = 0;
        while (x < image.getWidth()) {
            int y = 0;
            while (y < image.getHeight()) {
                Rectangle rectangle = new Rectangle(x, y);
                for (int i = x; i < x + rectangleWidth; i++) {
                    for (int j = y; j < y + rectangleHeight; j++) {
                        if (i < image.getWidth()) {
                            if (j < image.getHeight()) {
                                Color color = new Color(image.getRGB(i, j));
                                rectangle.addPixel(color);
                            }
//                            else {
//                                rectangle.addElement(-1);
//                                rectangle.addElement(-1);
//                                rectangle.addElement(-1);
//                            }
                        }
                    }
                }
                rectangle.createVectorX0();
                rectangles.add(rectangle);
                y = y + rectangleHeight;
            }
            x = x + rectangleWidth;
        }

    }

    private void createFirstLayerWeightsMatrix() {
        double randomWeights[][] = new double[rectangleWidth * rectangleHeight * 3][p];
        for (int row = 0; row < rectangleWidth * rectangleHeight * 3; row++) {
            for (int column = 0; column < p; column++) {
                randomWeights[row][column] = Math.random() * 2 - 1;
            }
        }
        W = new Matrix(randomWeights);
    }
    private void createSecondLayerWeightsMatrix(){
        W_ = W.transpose();
    }

    private void learn(){

    }

    public int getNumOfRectangles() {
        return rectangles.size();
    }
}
