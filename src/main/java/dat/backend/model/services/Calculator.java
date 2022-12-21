package dat.backend.model.services;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.persistence.BuildingMaterial.BuildingMaterialFacade;
import dat.backend.model.persistence.ConnectionPool;


import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static ConnectionPool connectionPool = new ConnectionPool();

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
        int beamDistance = 50;
        for (int i = 50; i <= 60; i++) {
            if ((svgWidth) % i == 0) {
                beamDistance = i;
                break;
            }
        }
        return beamDistance;
    }


    public static int findMyBeams(int width) {
        int material_id = 0;

        if (width <= 480) {
            material_id = 30;
        } else if (width > 480 && width <= 600) {
            material_id = 10;
        } else {
            material_id = 30;
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
    public static int priceCalc(List<BuildingMaterial> billOfMaterials) {
        int totalPrice = 0;
        for (BuildingMaterial buildingMaterial : billOfMaterials) {
            totalPrice += buildingMaterial.getPrice() * buildingMaterial.getQuantity();

        }
        return (totalPrice * 115) / 100;
    }

    //ikke færdig
    public static void addMaterialsToList(List<BuildingMaterial> materials) {
        for (BuildingMaterial buildingMaterial : materials) {
            if (buildingMaterial.getMaterial_id() == 5) {

            }
        }
    }

    public static int amountOfCladdingCalc(int shedWidth, int shedLength) {
        int claddingAmount = 0;
        int shedCircumference = (shedLength * 2) + (shedWidth * 2);
        claddingAmount = ((shedCircumference / 100) * 136) / 10;

        return claddingAmount;
    }

    public static int amountOfPolesCalc(int length, int width, int shed, int shedWidth) {
        int poleAmount = 0;
        if (length <= 400 && shed == 0) {
            poleAmount = 4;
        } else if (length > 400 && shed == 0) {
            poleAmount = 6;
        } else if (length <= 400 && shed == 1 && width == shedWidth) {
            poleAmount = 9;
        } else if (length > 400 && shed == 1 && width == shedWidth) {
            poleAmount = 11;
        } else if (length <= 400 && shed == 1 && width != shedWidth) {
            poleAmount = 10;
        } else if (length > 400 && shed == 1 && width != shedWidth) {
            poleAmount = 12;
        }
        return poleAmount;
    }

    // FRAME TIME
    public static int whichShedFrames(int shedLength) {
        int frame_id = 0;
        if (shedLength <= 240 || shedLength > 300) {
            frame_id = 9;
        } else {
            frame_id = 8;
        }
        return frame_id;
    }

    public static int amountOfShedFrames(int shedLength) {
        int amountOfFrames = 0;
        if (shedLength <= 300) {
            amountOfFrames = 1;
        } else {
            amountOfFrames = 2;
        }
        return amountOfFrames;
    }

    public static int whichCarportFrames(int length) {
        int frame_id = 0;
        if (length <= 480 || length > 600) {
            frame_id = 9;
        } else {
            frame_id = 8;
        }
        return frame_id;
    }

    public static int amountOfCarportFrames(int length) {

        int amountOfFrames = 0;
        if (length <= 600) {
            amountOfFrames = 2;
        } else {
            amountOfFrames = 4;
        }
        return amountOfFrames;
    }

    public static ArrayList<ArrayList<Integer>> amountAndWhichFrames(int length, int shed, int shedLength) {
        ArrayList<ArrayList<Integer>> frames = new ArrayList<>();
        ArrayList<Integer> whichFrames = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();


        whichFrames.add(whichCarportFrames(length));
        quantity.add(amountOfCarportFrames(length));
        if (shed == 1) {
            whichFrames.add(whichShedFrames(shedLength));
            quantity.add(amountOfShedFrames(shedLength));
        }
        frames.add(whichFrames);
        frames.add(quantity);
        
        return frames;
    }
    public static ArrayList<BuildingMaterial> billOfMaterialListCreater(int length, int width, int shed, int shedLength, int shedWidth){
        ArrayList<BuildingMaterial> billOfMaterials = new ArrayList<>();
        //all static materials.
        billOfMaterials= (ArrayList<BuildingMaterial>) BuildingMaterialFacade.getStaticMaterials(connectionPool);
        for(BuildingMaterial material: BuildingMaterialFacade.getDynamicMaterials(connectionPool)){
            if(material.getMaterial_id()<3 ||material.getMaterial_id()==4|| material.getMaterial_id()==13){
                material.setQuantity(4);
                billOfMaterials.add(material);
            }else if(material.getMaterial_id()==5 && shed ==1) {
                material.setQuantity(1);
                billOfMaterials.add(material);
            }else if (material.getMaterial_id()==7 && shed ==1){
                material.setQuantity(4);
                billOfMaterials.add(material);

            }else if(material.getMaterial_id()==6 && shed ==1){
                material.setQuantity(12);
                billOfMaterials.add(material);
            }else if(material.getMaterial_id()==3 ||material.getMaterial_id()==14){
                material.setQuantity(2);
                billOfMaterials.add(material);
            }else if (material.getType_id()==2){
                material.setQuantity(6);
                billOfMaterials.add(material);
                //dynamic starts here
                //beams
            }else if (material.getType_id()==findMyBeams(width)){
                material.setQuantity(amountOfBeams(width, length));
                billOfMaterials.add(material);
                //cladding
            }else if(material.getMaterial_id()==12 && shed==1){
                material.setQuantity(amountOfCladdingCalc(shedWidth,shedLength));
                billOfMaterials.add(material);
                //poles
            }else if(material.getMaterial_id()==11){
                material.setQuantity(amountOfPolesCalc(length,width,shed,shedWidth));
                billOfMaterials.add(material);
                //frames
            }else if(material.getMaterial_id()==whichCarportFrames(length)){
                if (shed==1 && whichShedFrames(shedLength)==whichCarportFrames(length)){
                material.setQuantity(amountOfShedFrames(shedLength)+amountOfCarportFrames(length));
                billOfMaterials.add(material);
                }else{
                    material.setQuantity(amountOfCarportFrames(length));
                    billOfMaterials.add(material);
                }
            }
        }

        return billOfMaterials;
    }

}
