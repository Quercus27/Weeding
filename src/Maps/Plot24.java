package Maps;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import Plants.Achillea;
import Plants.Andropogon;
import Plants.AsclepiasS;
import Plants.AsclepiasT;
import Plants.BareGround;
import Plants.Lupinus;
import Plants.Rumex;
import Plants.Taraxacum;
import Plants.Tradescantia;

public class Plot24 extends Map {

	public Plot24(GameContainer gc) throws SlickException {
		super(gc);
		
		mapID = 24;
		
		timeLimit = 132;
		time = timeLimit;
		
		numWeeds = 44;
		nonWeeds = 45;
		weedCounter = 0;
		nonWeedCounter = 0;
		
		speciesList.add(0, new AsclepiasT(2));
		speciesList.add(1, new Rumex(2));
		speciesList.add(2, new Achillea(2));
		
		//Weeds
		
		for(int i = 0; i < (tileTotal); i++){
			int roll1 = random.nextInt(10);
			int roll2 = random.nextInt(5);
			int temp = random.nextInt(tileTotal);
			
			if(plantArray[temp] == null && roll1 == 2){
				if(roll2 == 0) plantArray[temp] = new Andropogon(2);
				if(roll2 == 1) plantArray[temp] = new Lupinus(2);
				if(roll2 == 2) plantArray[temp] = new Taraxacum(2);
				if(roll2 == 3) plantArray[temp] = new Tradescantia(2);
				if(roll2 == 4) plantArray[temp] = new AsclepiasS(2);
				
				weedCounter +=1;
				
			}
			
			
			if( i == tileTotal - 1 && weedCounter < numWeeds)i = 0;
			if(weedCounter == numWeeds)i = tileTotal;
			
		}
		
		//non-weeds
		
		for(int i = 0; i < (tileTotal); i++){
			int roll1 = random.nextInt(10);
			int roll2 = random.nextInt(3);
		
			int temp = random.nextInt(tileTotal);
			
			if(plantArray[temp] == null && roll1 == 3){
				if(roll2 == 0) plantArray[temp] = new AsclepiasT(2);
				if(roll2 == 1) plantArray[temp] = new Rumex(2);		
				if(roll2 == 2) plantArray[temp] = new Achillea(2);
				
				nonWeedCounter +=1;
				
			}
			
			
			if( i == tileTotal - 1 && nonWeedCounter < nonWeeds)i = 0;
			if(nonWeedCounter == nonWeeds)i = tileTotal;
			
		}
		
		for(int i = 0; i < tileTotal; i++){
			if(plantArray[i] == null)plantArray[i] = new BareGround();
		}
		
		
	}
	


}