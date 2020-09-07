package answer;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Positions {

	private Set<Position> positions;
	
	public Positions(Set<Position> positions) {
		this.positions = Collections.unmodifiableSet(positions);
	}
	public Integer minimumTime() {
		Positions finalPositions = finalPositions();
		return finalPositions.positions.stream().mapToInt((position)-> position.getTimePassed()).min().getAsInt();
	}
	private Positions finalPositions() {
		Positions currentPositions = this;
		
		while(true) {
			if(currentPositions.allFinished()) {
				return currentPositions;
			}
			currentPositions.nextPossiblePositions();
		}
	}
	private boolean allFinished() {
		return positions.stream().allMatch((position)-> position.finished());
	}
	private Positions nextPossiblePositions() {
		Stream<Position> nextPossiblePositionsStream = positions.stream().flatMap((position)->position.nextPotentialPositions().stream());
		Set<Position> nextPossiblePositionsSet = nextPossiblePositionsStream.collect(Collectors.toSet());
		
		return new Positions(nextPossiblePositionsSet);
	}
	public Set<Position> getPositions(){
		return Collections.unmodifiableSet(positions);
	}
}
