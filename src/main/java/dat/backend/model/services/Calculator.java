package dat.backend.model.services;

public class Calculator {


    public static int calcBeams(int length) {
        int beamDist =0;
       int totalAmountOfBeams = 0;
        for(int i =1; i<1000; i++){
            beamDist=length/i;
            if(beamDist>=50 && beamDist<=55){
                totalAmountOfBeams=i;
                break;
            }
        }
        return totalAmountOfBeams;

        //calcPoles(){}
    }
    public static int calcBeamDist(int amountOfBeams, int length) {

    int beamDist=length/amountOfBeams;
    return beamDist;
        //calcPoles(){}
    }
}