public class WoodCrate extends Package {

    public WoodCrate(int track,double weight) {
        setCost(weight*2.5);
        setWeight(weight);
        setTrack(track);
    }
    public void checkPackage() throws PackageException{

        if (getWeight()>80.0) throw new PackageException();
        if (getTrack()%10 != 2) throw new PackageException();
    }
}
