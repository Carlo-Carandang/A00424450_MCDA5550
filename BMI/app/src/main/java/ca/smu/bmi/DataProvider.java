package ca.smu.bmi;

/**
 * Created by carlocarandang on 2018-02-26.
 */

public class DataProvider {
    private String dateTxt,heightTxt,weightTxt,BMI;
/*    private Float heightTxt;
    private Float weightTxt;
    private Float BMI;
*/
    public String getDateTxt() {
        return dateTxt;
    }

    public void setDateTxt(String dateTxt) {
        this.dateTxt = dateTxt;
    }

    public String getHeightTxt() {
        return heightTxt;
    }

    public void setHeightTxt(String heightTxt) {
        this.heightTxt = heightTxt;
    }

    public String getWeightTxt() {
        return weightTxt;
    }

    public void setWeightTxt(String weightTxt) {
        this.weightTxt = weightTxt;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public DataProvider(String dateTxt,String heightTxt,String weightTxt,String BMI)
    {
        this.dateTxt=dateTxt;
        this.heightTxt=heightTxt;
        this.weightTxt=weightTxt;
        this.BMI=BMI;
    }
}
