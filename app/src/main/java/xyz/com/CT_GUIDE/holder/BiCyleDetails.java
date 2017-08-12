package xyz.com.CT_GUIDE.holder;

import xyz.com.CT_GUIDE.model.BicyleTime;

import java.util.Vector;


public class BiCyleDetails {
    public static Vector<BicyleTime> allBicyleData = new Vector<BicyleTime>();

    public static Vector<BicyleTime> getAllBicyledetails() {
        return BiCyleDetails.allBicyleData;
    }

    public static void setAllBiCyleDetails(Vector<BicyleTime> allBicyleData) {
        BiCyleDetails.allBicyleData = allBicyleData;
    }

    public static BicyleTime getBicyleTime(int pos) {
        return  BiCyleDetails.allBicyleData.elementAt(pos);
    }

    public static void setBicyleTime(BicyleTime BicyleTime) {
        BiCyleDetails.allBicyleData.addElement(BicyleTime);
    }

    public static void removeAll() {
        BiCyleDetails.allBicyleData.removeAllElements();
    }
}