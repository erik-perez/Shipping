abstract class Package {
    private int track;
    private double weight;
    private double cost;

    public int getTrack() {
        return track;
    }
    public void setTrack(int track) {
        this.track = track;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    abstract void checkPackage() throws PackageException;

    public double toOunces(double weight) {
        double w = weight*16;
        return w;
    }
    public double toPounds(double weight) {
        double w = weight/16;
        return w;
    }
    public void setCost(double cost) {
        this.cost=cost;
    }
    public double getCost() {
        return cost;
    }
    public String toString() {
        return ("Tracking number is "+getTrack()+" and weight is "+getWeight()+"\n");
    }



}
