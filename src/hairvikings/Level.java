package hairvikings;

/**
 * Created by t00191729 on 05/12/2016.
 */
public enum Level {

    HOUSE(1, 1, "settlement1.png",1,9),
    TRIBE(2, 2, "settlement2.png",10,24),
    TOWN(3, 3, "settlement3.png",25,49),
    CITY(4, 4, "settlement4.png",50,99),
    CAPITAL(5, 5, "settlement5.png",100,300);

    private int levelProductivity;
    private int maxLink;
    private String imagePATH;
    private int minResources;
    private int maxResources;


    Level(int levelProductivity, int maxLink, String imagePATH, int minResources, int maxResources) {
        this.levelProductivity = levelProductivity;
        this.maxLink = maxLink;
        this.imagePATH = imagePATH;
        this.minResources = minResources;
        this.maxResources = maxResources;
    }

    public int getLevelProductivity() {
        return levelProductivity;
    }

    public int getMaxLink() {
        return maxLink;
    }

    public String getImagePATH() {
        return imagePATH;
    }

    public int getMinResources() {
        return minResources;
    }

    public int getMaxResources() {
        return maxResources;
    }

    public static Level getLevelFromResources(int cellResources){
        if (cellResources <= HOUSE.getMaxResources())
            return HOUSE;
        else if (cellResources >= TRIBE.getMinResources() && cellResources <= TRIBE.getMaxResources())
            return TRIBE;
        else if (cellResources >= TOWN.getMinResources() && cellResources <= TOWN.getMaxResources())
            return TOWN;
        else if (cellResources >= CITY.getMinResources() && cellResources <= CITY.getMaxResources())
            return CITY;
        else if (cellResources >= CAPITAL.getMinResources() && cellResources <= CAPITAL.getMaxResources())
            return CAPITAL;
        else
            return null;
    }
}
