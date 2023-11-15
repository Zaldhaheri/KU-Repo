public class oven {
    public static void main(String[] args){
        Oven oven1 = new Oven(900,120);
    }
}

class Oven{
    private int wattPower,heatTime;
    private final int wattMax = 1200,heatMax = 900;
    public Oven(){
        wattPower = 0;
        heatTime = 0;
    }
    public Oven(int w,int h){
        wattPower = w;
        heatTime = h;
    }
    public Oven(Oven otherOven){
        otherOven.wattPower = wattPower;
        otherOven.heatTime = heatTime;
    }

    public void setWattPower(int w){wattPower = w;}
    public void setHeatTime(int h){heatTime = h;}
    public int getWattPower(){return wattPower;}
    public int getHeatTime(){return heatTime;}


}
