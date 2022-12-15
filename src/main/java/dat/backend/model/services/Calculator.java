package dat.backend.model.services;

import dat.backend.model.entities.BuildingMaterial;

import java.util.List;

public class Calculator {


    public static int calcDrawingBeams(int length) {
        int beamDist = 0;
        int totalAmountOfBeams = 0;
        for (int i = 1; i <= 40; i++) {
            beamDist = length / i;
            if (beamDist >= 50 && beamDist <= 55) {
                totalAmountOfBeams = i;
                break;
            }
        }
        return totalAmountOfBeams;

        //calcPoles(){}
    }

    /*
    public static int calcBeamDist(int amountOfBeams, int length) {

        int beamDist = length / amountOfBeams;
        return beamDist;
        //calcPoles(){}
    }
    */
    public static int calcBeamDist(int svgWidth) {
        int beamDistance = 53;
        for (int i = 55; i > 50; i--) {
            if (svgWidth % i <= 5) {
                beamDistance = i;
                break;
            }
        }
        return beamDistance;
    }


    public static int findMyBeams(int svgWidth) {
        int material_id = 0;

        if (svgWidth <= 480) {
            material_id = 9;
        } else if (svgWidth > 480 && svgWidth <= 600) {
            material_id = 10;
        } else {
            material_id = 9;
        }
        return material_id;
    }


    public static int amountOfBeams(int width, int length) {
        int neededBeams = 0;
        if (width <= 480) {
            neededBeams = calcDrawingBeams(length);
        } else if (width > 480 && width <= 600) {
            neededBeams = calcDrawingBeams(length);
        } else {
            neededBeams = calcDrawingBeams(length) * 2;
        }
        return neededBeams;
    }
}