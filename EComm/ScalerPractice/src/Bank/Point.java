package Bank;

public class Point {
    int x;
    int y;

    private int N;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point point)
    {
        this.x = point.x;
        this.y = point.y;
        this.N = point.N;
    }

    public void display()
    {
        System.out.printf("[<<%>>, <<%s>>]", x, y);
        System.out.println();
    }
}

