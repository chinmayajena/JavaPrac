
public class TestBeanMethod {

  private int pickRate;
  private int prevPickRate;
  
  
  
  
  public int getPickRate() {
    return pickRate;
  }


  public void setPickRate(int pickRate) {
    this.pickRate = pickRate;
  }




  public int getPrevPickRate() {
    return prevPickRate;
  }




  public void setPrevPickRate(int prevPickRate) {
    this.prevPickRate = prevPickRate;
  }



  public int getDiff(){
    return this.pickRate-this.prevPickRate;
  }
  
  

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    TestBeanMethod tb = new TestBeanMethod();
    tb.setPickRate(50);
    tb.setPrevPickRate(30);
    System.out.println(tb.getDiff());
    
    
  }

}
