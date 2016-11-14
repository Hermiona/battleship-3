import java.io.*;
import java.util.*;

public class ShipSetup {

	static int playernumber;
	static int playernumberdatabase;
	static String cxy,bxy,sxy,crxy,dxy;
	static ArrayList<Integer> intList = new ArrayList<>();
	static ArrayList<Integer> intListEnemy = new ArrayList<>();
	
	
	
	 static void setUserShips(String shiplocations){
		String ships = "";
		if(playernumberdatabase == 0){
			ships = "player_one's_ships";
			playernumberdatabase++;
		}else if(playernumberdatabase == 1){
			ships = "player_two's_ships";
			playernumberdatabase++;
		}	
		

		
        String fleet[] = shiplocations.split(" ");
        cxy = fleet[1];
        bxy = fleet[3];
        sxy = fleet[5];
        crxy = fleet[7];
        dxy = fleet[9];

        setCarrier(cxy);
        setBattleship(bxy);
        setSubmarine(sxy);
        setCruiser(crxy);
        setDestroyer(dxy);        
        
		try {
			PrintWriter printer = new PrintWriter(new FileWriter(new File(ships)));
			if(playernumber == 0){
		        System.out.println("Here " + Arrays.toString(intList.toArray()));

			printer.write(Arrays.toString(intList.toArray()));
			}else if(playernumber == 1){
		        System.out.println("Enemy " + Arrays.toString(intListEnemy.toArray()));
				printer.write(Arrays.toString(intListEnemy.toArray()));
			}
			printer.flush();
			printer.close();
	        playernumber++;

		}catch (IOException e){
			e.printStackTrace();
		}

	}
	
public static void setCarrier(String xy){//start setCarrier()
		
	String coordinates = xy;
		int xi = Character.getNumericValue(coordinates.charAt(0));
		int yi = Character.getNumericValue(coordinates.charAt(1));
		int xf = Character.getNumericValue(coordinates.charAt(2));
		int yf = Character.getNumericValue(coordinates.charAt(3));


		int x1y1=0,x2y2=0,x3y3=0,x4y4=0,x5y5=0;

	 if (xi==xf){
			if(yi<yf){
				x1y1 = (xi*10) + yi;
				x2y2 = (xi*10) + (yi+1);
				x3y3 = (xi*10) + (yi+2);
				x4y4 = (xi*10) + (yi+3);
				x5y5 = (xi*10) + (yf);
			}else{
				x1y1 = (xi*10) + yf;
				x2y2 = (xi*10) + (yf+1);
				x3y3 = (xi*10) + (yf+2);
				x4y4 = (xi*10) + (yf+3);
				x5y5 = (xi*10) + (yi);
			}
	 }else if (yi==yf){
		 	if(xi<xf){
		 		x1y1 = (xi*10) + yi;
		 		x2y2 = ((xi + 1)*10) + (yi);
		 		x3y3 = ((xi+2) *10) + (yi);
		 		x4y4 = ((xi+3)*10) + (yi);
		 		x5y5 = (xf*10) + (yi);
			
		 	}else{
		 		x1y1 = (xf*10) + yi;
		 		x2y2 = ((xf + 1)*10) + (yi);
		 		x3y3 = ((xf+2) *10) + (yi);
		 		x4y4 = ((xf+3)*10) + (yi);
		 		x5y5 = (xi*10) + (yi);
		 	}
	 	}		
	 
	// String carriercoordinates = ""+x1y1+"\n"+x2y2+"\n"+x3y3+"\n"+x4y4+"\n"+x5y5;
	
	 if(playernumber == 0){
	 intList.add(x1y1);
	 intList.add(x2y2);
	 intList.add(x3y3);
	 intList.add(x4y4);
	 intList.add(x5y5);
	 }else if(playernumber == 1){
		 intListEnemy.add(x1y1);
		 intListEnemy.add(x2y2);
		 intListEnemy.add(x3y3);
		 intListEnemy.add(x4y4);
		 intListEnemy.add(x5y5);
	 }

	}

public static void setBattleship(String xy){//start battleship()
	String coordinates = xy;
	int xi = Character.getNumericValue(coordinates.charAt(0));
	int yi = Character.getNumericValue(coordinates.charAt(1));
	int xf = Character.getNumericValue(coordinates.charAt(2));
	int yf = Character.getNumericValue(coordinates.charAt(3));

	int x1y1=0,x2y2=0,x3y3=0,x4y4=0;

 if (xi==xf){
		if(yi<yf){
			x1y1 = (xi*10) + yi;
			x2y2 = (xi*10) + (yi+1);
			x3y3 = (xi*10) + (yi+2);
			x4y4 = (xi*10) + (yf);
		}else{
			x1y1 = (xi*10) + yf;
			x2y2 = (xi*10) + (yf+1);
			x3y3 = (xi*10) + (yf+2);
			x4y4 = (xi*10) + (yi);
		}
 }else if (yi==yf){
	 	if(xi<xf){
	 		x1y1 = (xi*10) + yi;
	 		x2y2 = ((xi + 1)*10) + (yi);
	 		x3y3 = ((xi+2) *10) + (yi);
	 		x4y4 = (xf*10) + (yi);
		
	 	}else{
	 		x1y1 = (xf*10) + yi;
	 		x2y2 = ((xf + 1)*10) + (yi);
	 		x3y3 = ((xf+2) *10) + (yi);
	 		x4y4 = (xi*10) + (yi);
	 	}
 	}		
 

 if(playernumber == 0){
 intList.add(x1y1);
 intList.add(x2y2);
 intList.add(x3y3);
 intList.add(x4y4);
 }else if(playernumber == 1){
	 intListEnemy.add(x1y1);
	 intListEnemy.add(x2y2);
	 intListEnemy.add(x3y3);
	 intListEnemy.add(x4y4);
 }

}

public static void setSubmarine(String xy){//start setSubmarine()
	String coordinates = xy;
	int xi = Character.getNumericValue(coordinates.charAt(0));
	int yi = Character.getNumericValue(coordinates.charAt(1));
	int xf = Character.getNumericValue(coordinates.charAt(2));
	int yf = Character.getNumericValue(coordinates.charAt(3));

	int x1y1=0,x2y2=0,x3y3=0;

 if (xi==xf){
		if(yi<yf){
			x1y1 = (xi*10) + yi;
			x2y2 = (xi*10) + (yi+1);
			x3y3 = (xi*10) + (yf);
		}else{
			x1y1 = (xi*10) + yf;
			x2y2 = (xi*10) + (yf+1);
			x3y3 = (xi*10) + (yi);
		}
 }else if (yi==yf){
	 	if(xi<xf){
	 		x1y1 = (xi*10) + yi;
	 		x2y2 = ((xi + 1)*10) + (yi);
	 		x3y3 = (xf*10) + (yi);
		
	 	}else{
	 		x1y1 = (xf*10) + yi;
	 		x2y2 = ((xf + 1)*10) + (yi);
	 		x3y3 = (xi*10) + (yi);
	 	}
 	}		
 
// String carriercoordinates = ""+x1y1+"\n"+x2y2+"\n"+x3y3+"\n"+x4y4+"\n"+x5y5;
 
 if(playernumber == 0){
 intList.add(x1y1);
 intList.add(x2y2);
 intList.add(x3y3);
 }else if(playernumber == 1){
	 intListEnemy.add(x1y1);
	 intListEnemy.add(x2y2);
	 intListEnemy.add(x3y3);
 }
}

public static void setCruiser(String xy){//start setSubmarine()
	String coordinates = xy;
	int xi = Character.getNumericValue(coordinates.charAt(0));
	int yi = Character.getNumericValue(coordinates.charAt(1));
	int xf = Character.getNumericValue(coordinates.charAt(2));
	int yf = Character.getNumericValue(coordinates.charAt(3));

	int x1y1=0,x2y2=0,x3y3=0;

 if (xi==xf){
		if(yi<yf){
			x1y1 = (xi*10) + yi;
			x2y2 = (xi*10) + (yi+1);
			x3y3 = (xi*10) + (yf);
		}else{
			x1y1 = (xi*10) + yf;
			x2y2 = (xi*10) + (yf+1);
			x3y3 = (xi*10) + (yi);
		}
 }else if (yi==yf){
	 	if(xi<xf){
	 		x1y1 = (xi*10) + yi;
	 		x2y2 = ((xi + 1)*10) + (yi);
	 		x3y3 = (xf*10) + (yi);
		
	 	}else{
	 		x1y1 = (xf*10) + yi;
	 		x2y2 = ((xf + 1)*10) + (yi);
	 		x3y3 = (xi*10) + (yi);
	 	}
 	}		
 
// String carriercoordinates = ""+x1y1+"\n"+x2y2+"\n"+x3y3+"\n"+x4y4+"\n"+x5y5;

 if(playernumber == 0){
 intList.add(x1y1);
 intList.add(x2y2);
 intList.add(x3y3);
 }else if(playernumber == 1){
	 intListEnemy.add(x1y1);
	 intListEnemy.add(x2y2);
	 intListEnemy.add(x3y3);
 }

}

public static void setDestroyer(String xy){//start setDestroyer()
	String coordinates = xy;
	int xi = Character.getNumericValue(coordinates.charAt(0));
	int yi = Character.getNumericValue(coordinates.charAt(1));
	int xf = Character.getNumericValue(coordinates.charAt(2));
	int yf = Character.getNumericValue(coordinates.charAt(3));

	int x1y1=0,x2y2=0;

 if (xi==xf){
		if(yi<yf){
			x1y1 = (xi*10) + yi;
			x2y2 = (xi*10) + (yf);
		}else{
			x1y1 = (xi*10) + yf;
			x2y2 = (xi*10) + (yi);
		}
 }else if (yi==yf){
	 	if(xi<xf){
	 		x1y1 = (xi*10) + yi;
	 		x2y2 = (xf*10) + (yi);
		
	 	}else{
	 		x1y1 = (xf*10) + yi;
	 		x2y2 = (xi*10) + (yi);
	 	}
 	}		
 

 if(playernumber == 0){
 intList.add(x1y1);
 intList.add(x2y2);
 }else if(playernumber == 1){
	 intListEnemy.add(x1y1);
	 intListEnemy.add(x2y2);
 }

}

}
