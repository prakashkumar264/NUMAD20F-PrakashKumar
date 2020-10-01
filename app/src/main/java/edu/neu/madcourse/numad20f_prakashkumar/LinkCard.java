package edu.neu.madcourse.numad20f_prakashkumar;

public class LinkCard {
    private String itemName;
    private String itemURL;
    //Constructor
    public LinkCard( String itemName, String itemURL) {

        this.itemName = itemName;
        this.itemURL = itemURL;
    }

    public String getItemURL() {
        return itemURL;
    }

    public String getItemName() {
        return itemName;
    }
}
