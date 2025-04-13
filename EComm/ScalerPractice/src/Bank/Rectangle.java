package Bank;

public class Rectangle {
    Point topLeft;
    Point bottomRight;

    public Rectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY)
    {
        topLeft = new Point(topLeftX, topLeftY);
        bottomRight = new Point(bottomRightX, bottomRightY);
    }

    public Rectangle(Point topLeft, Point bottomRight)
    {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Rectangle(Rectangle rectangle)
    {
        this(rectangle.topLeft, rectangle.bottomRight);
    }
}

