package com.luke.makename.name;

/**
 * Created by olivia on 2016/12/24.
 */
public abstract class NameItem {
    public abstract String getName();

    public abstract String getKxName();

    public abstract String getPinyin();

    public abstract int getPeopleGrid();

    public abstract int getGroundGrid();

    public int getAllGrid() {
        return 15 + getGroundGrid();
    }

    public String getThree(int grid) {
        int mod = grid % 10;
        switch (mod) {
            case 1:
            case 2:
                return "木";
            case 3:
            case 4:
                return "火";
            case 5:
            case 6:
                return "土";
            case 7:
            case 8:
                return "金";
            case 9:
            case 0:
                return "水";
        }
        return "";
    }

    public String getTotalThree() {
        return "(土" + getThree(getPeopleGrid()) + getPeopleGrid() + getThree(getGroundGrid()) + getGroundGrid() + ")"
                + getThree(getAllGrid()) + getAllGrid();
    }

    public abstract String getTotalFive();
}
