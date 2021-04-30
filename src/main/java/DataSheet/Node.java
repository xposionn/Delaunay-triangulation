package DataSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node extends Triangular{
    List<Node> childs;

    public Node(Triangular triangular) {
        super(triangular);
        childs = new ArrayList<>();
    }


    public boolean isLeaf(){
        return childs==null || childs.size()==0;
    }

    public boolean isPointInside(Point p){
        return PointInTriangle(p);
    }

    public Triangular getTriangular() {
        return this;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    public List<Node> getChilds() {
        return childs;
    }

    @Override
    public String toString() {
        return "Node{" +
                "edges=" + edges +
                '}';
    }

    private float sign(Point p1, Point p2, Point p3)
    {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    private boolean PointInTriangle (Point pt)
    {
        Point v1 = this.getTriangular().getPoints().get(0);
        Point v2 = this.getTriangular().getPoints().get(1);
        Point v3 = this.getTriangular().getPoints().get(2);
        float d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = sign(pt, v1, v2);
        d2 = sign(pt, v2, v3);
        d3 = sign(pt, v3, v1);

         has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
         has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(childs, node.childs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childs);
    }
}
