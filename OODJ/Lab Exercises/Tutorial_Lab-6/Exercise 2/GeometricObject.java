public class GeometricObject implements Comparable{
    protected int radius;
    public void setRadius(int radius) {
        this.radius = radius;        
    }
    // assume that it find the maximum radius
    public int max(GeometricObject 0) {
        if (this.radius > o.radius){
            return 1;
        }else if(this.radius < o.radius){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public int CompareTo(Object t) {
        GeometricObject geo = (GeometricObject)t;
        return this.max(geo);
    }
}