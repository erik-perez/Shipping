
public class Letter extends Package {



    public Letter(int track,double weight) {
        setCost(weight*0.05);
        setWeight(toPounds(weight));
        setTrack(track);
    }
    public void checkPackage() throws PackageException{

        if (getWeight()>2.0) throw new PackageException();
        if (getTrack()%10 != 0) throw new PackageException();
    }


}