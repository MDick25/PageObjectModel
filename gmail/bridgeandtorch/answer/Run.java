package answer;

import java.util.HashSet;
import java.util.Set;

public class Run {

	public static void main(String[] args) {
		Set<Crosser> leftSide = new HashSet<>();
		
		leftSide.add(new Crosser("A", 1));
		leftSide.add(new Crosser("B", 3));
		leftSide.add(new Crosser("C", 5));
		leftSide.add(new Crosser("D", 7));
		
		Set<Crosser> rightSide = new HashSet<>();
		
		TorchPosition torchPosition = TorchPosition.LEFT;
		
		Integer timePassed = 0;
		
		Position initialPosition = new Position(leftSide, rightSide, torchPosition, timePassed);
		
		Set<Position> initialPositionSet = new HashSet<>();
		
		initialPositionSet.add(initialPosition);	
		
		Positions initialPositions = new Positions(initialPositionSet);
		
		Integer minimumTime = initialPositions.minimumTime();
		System.out.println(minimumTime);
	}
}
