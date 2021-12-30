public class MetalCrate extends Package{

    public MetalCrate(int track,double weight) {
        setCost(weight*3.0);
        setWeight(weight);
        setTrack(track);
    }
    public void checkPackage() throws PackageException{

        if (getWeight()>100.0) throw new PackageException();
        if (getTrack()%10 != 3) throw new PackageException();
    }
}