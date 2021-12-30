public class Truck {
    private String name;
    private String origin;
    private String destination;
    private double uWeight;
    private double weight;
    private double income;
    private Package[] pArray = new Package[200];


    public Truck() {
        this.name="";
        this.origin="";
        this.destination="";
    }

    public Truck(String name, String origin, String destination, double uWeight) {
        this.name=name;
        this.origin=origin;
        this.destination=destination;
        this.uWeight=toPounds(uWeight);
        this.weight=toPounds(uWeight);
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public double getIncome() {
        return income;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDestination() {
        return destination;
    }
    public Package getaP(int i) {

        return pArray[i];
    }

    public void load(Package p) throws PackageException {

        p.checkPackage();
        for (int i=0; i<pArray.length;i++) {
            if (pArray[i]==null) {
                pArray[i] = p;
                weight=weight+p.getWeight();
                income=income+p.getCost();
                System.out.println("Success! The "+ p.getClass().getSimpleName() +" was loaded at index: "+i);
                break;
            } else if (i==pArray.length-1) throw new PackageException();

        }


    }
    public void unload(int i) {
        try {
            weight = weight-pArray[i].getWeight();
            income = income-pArray[i].getCost();
            pArray[i]=null;
            System.out.println("Package "+i+" unloaded successfully.");
        } catch (NullPointerException e) {
            System.out.println("No Package at this index.");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not a valid index.");
        }
    }
    public int getLoaded() {
        int x=0;
        for(int i=0;i<pArray.length;i++) {
            if (pArray[i] != null) x++;
        }
        return x;
    }
    public double toKilograms(double w) {
        w=w/2.205;
        return w;
    }
    public double toPounds(double w) {
        w=w*2.205;
        return w;
    }
    public String toString() {
        return ("Driver name: "+name+"\nOrigin City: "+origin+"\nDestination City: "+destination
                +"\nUnloaded Weight: "+uWeight+"\nTotal Weight: "+weight+"\nIncome: "+income);
    }




}

