package DataSheet;

import java.util.ArrayList;
import java.util.List;

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
        return false;
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
}
