public class Box extends Package {

    public Box(int track,double weight) {
        setCost(weight*2.0);
        setWeight(weight);
        setTrack(track);
    }
    public void checkPackage() throws PackageException{


        if (getWeight()>40.0) throw new PackageException();
        if (getTrack()%10 != 1) throw new PackageException();
    }
}
