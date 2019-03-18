package Models;

public class Skill {
    private String name;
    private int    point;

    public Skill (String name) {
        this.name = name;
        point = 0;
    }

    public Skill (String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName () {
        return name;
    }

    public int getPoint () {
        return point;
    }

    public void addPoint() {this.point += 1;}
}
