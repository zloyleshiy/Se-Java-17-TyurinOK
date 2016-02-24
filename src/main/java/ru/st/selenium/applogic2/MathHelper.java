package ru.st.selenium.applogic2;

public class MathHelper extends DriverBasedHelper {
	
	public MathHelper(ApplicationManager2 manager) {
		super(manager.getWebDriver());
	}


	public int getRandomInt(int a, int b){
		int min = getIntMin(a, b);
		int max = getIntMax (a, b); 
		return min + (int) (Math.random() * ((max-min) + 1));		
	}
	
	
	public int getIntMin (int a, int b){
		if (a<b) return a;
		else return b;	
	}
	
	public int getIntMax (int a, int b){
		if (a>b) return a;
		else return b;	
	}

}
