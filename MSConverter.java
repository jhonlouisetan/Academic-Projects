public class MSConverter{
    private double km,miles;
    private double kg,lbs;
    private double cels,fahr;

    public MSConverter(){
    }

    public double kmToMiles(double value){
        miles=(double)value*0.62137119;
        return miles;
    }

    public double milesToKm(double value){
        km=(double)value*1.60934;
        return km;
    }

    public double kgToLbs(double value){
        lbs=(double)value*2.2046226218;
        return lbs;
    }

    public double lbsToKg(double value){
        kg=(double)value*0.45359237;
        return kg;
    }

    public double celsToFahr(double value){
        fahr=(double)((value*1.8)+32);
        return fahr;
    }

    public double fahrToCels(double value){
        cels=(double)((value-32)*0.5556);
        return cels;
    }
}