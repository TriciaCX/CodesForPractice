package struct;
public class Car {
   String CarID;
   int maxVelocity;
   
   public boolean equals(Car car) {
		if(this.CarID.equals(car.getCarID())) return true;
		else return false;
	}
   
   public Car(String string, int i) {
	  CarID=string;
	  maxVelocity=i;
   }
   public Car()
{
	// TODO �Զ����ɵĹ��캯�����
}

public String getCarID() {
	  return CarID;
   }
   public void setCarID(String carID) {
	  CarID = carID;
   }
   public int getMaxVelocity() {
	  return maxVelocity;
   }
   public void setMaxVelocity(int maxVelocity) {
	  this.maxVelocity = maxVelocity;
   }
   
}

