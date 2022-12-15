package dat.backend.model.services;

import dat.backend.model.entities.BuildingMaterial;
import sun.awt.image.BufferedImageDevice;

import java.util.List;

public class Calculator {

//visual amount of beams
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
            if (svgWidth % i == 0) {
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
    //bill of materials price * 15% for 15% income
    public static int priceCalc (List<BuildingMaterial> billOfMaterials) {
        int totalPrice=0;
        for (BuildingMaterial buildingMaterial : billOfMaterials) {
            totalPrice+=buildingMaterial.getPrice()*buildingMaterial.getQuantity();

        }
        return (totalPrice*115)/100;
    }
    //ikke færdig
    public static void addMaterialsToList(List<BuildingMaterial> materials) {
        for (BuildingMaterial buildingMaterial : materials) {
            if (buildingMaterial.getMaterial_id() == 5) {

            }
        }
    }

    public static int amountOfCladdingCalc(int shedWidth, int shedLength){
     int claddingAmount=0;
     int shedCircumference=(shedLength*2)+(shedWidth*2);
     claddingAmount=((shedCircumference/100)*136)/10;

     return claddingAmount;
    }
}