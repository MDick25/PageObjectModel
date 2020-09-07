package answer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Position {

	private Set<Crosser> leftSide;
	private Set<Crosser> rightSide;
	private TorchPosition torchPosition;
	private Integer timePassed;
	
	public Position(Set<Crosser> leftSide, Set<Crosser> rightSide, TorchPosition torchPosition, Integer timePassed) {
		this.leftSide = Collections.unmodifiableSet(leftSide);
		this.rightSide = Collections.unmodifiableSet(rightSide);
		this.torchPosition = torchPosition;
		this.timePassed = timePassed;
	}
	public Set<Position> nextPotentialPositions(){
		return torchPosition.accept(new TorchTravelor<Set<Position>>() {
			@Override
			public Set<Position> travelLeft(){
				return nextPotentialPositionsViaLeft();
			}
			public Set<Position> travelRight(){
				return nextPotentialPositionsViaRight();
			}
		});
	}
	public boolean finished() {
		return leftSide.isEmpty();
		
	}
	private Set<Position> nextPotentialPositionsViaLeft(){
		Set<CrossersRemaining> potentialMoves = potentialMovesViaLeft();
		Stream<CrossersRemaining> potentialMovesStream = potentialMoves.stream();
		Stream<Position> nextPotentialPositionsStream = potentialMovesStream.map(this::nextPositionFromLeft);
		return nextPotentialPositionsStream.collect(Collectors.toSet());
	}
	private Set<Position> nextPotentialPositionsViaRight(){
		Set<CrossersRemaining> potentialMoves = potentialMovesViaRight();
		Stream<CrossersRemaining> potentialMovesStream = potentialMoves.stream();
		Stream<Position> nextPotentialPositionsStream = potentialMovesStream.map(this::nextPositionFromRight);
		
		return nextPotentialPositionsStream.collect(Collectors.toSet());
	}
	private Set<CrossersRemaining> potentialMovesViaLeft(){
		Stream<CrossersRemaining> crossersRemainingStream = leftSide.stream().flatMap((crosser1)->{
			Stream<Crosser> crosser2Stream = leftSide.stream().filter((crosser2)-> !crosser2.equals(crosser1));
			return crosser2Stream.map((crosser2)->{
				Set<Crosser> crossersPendingSet = new HashSet<>();
				crossersPendingSet.add(crosser1);
				crossersPendingSet.add(crosser2);
				return new CrossersRemaining(crossersPendingSet);
				
			});
		});
		return crossersRemainingStream.collect(Collectors.toSet());
	}
	private Set<CrossersRemaining> potentialMovesViaRight(){
		Stream<CrossersRemaining> potentialMovesStream = rightSide.stream().map((crosser)->{
			Set<Crosser> crosserPendingSet = new HashSet<>();
			crosserPendingSet.add(crosser);
			return new CrossersRemaining(crosserPendingSet);
		});
		return potentialMovesStream.collect(Collectors.toSet());
	}
	private Position nextPositionFromLeft(final CrossersRemaining crossersRemaining) {
		Set<Crosser> nextLeftSide = leftSide.stream().filter((crosser)-> !crossersRemaining.containsCrosser(crosser)).collect(Collectors.toSet());
		Set<Crosser> nextRightSide = Stream.concat(rightSide.stream(), crossersRemaining.toStream()).collect(Collectors.toSet());
		TorchPosition nextTorchPosition = torchPosition.turn();
		Integer newMinutesPassed = timePassed + crossersRemaining.minutesToCross();
		
		return new Position(nextLeftSide, nextRightSide, nextTorchPosition, newMinutesPassed);
		
		
	}
	private Position nextPositionFromRight(final CrossersRemaining crossersRemaining) {
		Set<Crosser> nextLeftSide = leftSide.stream().filter((crosser)-> !crossersRemaining.containsCrosser(crosser)).collect(Collectors.toSet());
		Set<Crosser> nextRightSide = Stream.concat(rightSide.stream(), crossersRemaining.toStream()).collect(Collectors.toSet());
		TorchPosition nextTorchPosition = torchPosition.turn();
		Integer newMinutesPassed = timePassed + crossersRemaining.minutesToCross();
		
		return new Position(nextLeftSide, nextRightSide, nextTorchPosition, newMinutesPassed);
		
		
	}
	
	public Set<Crosser> getLeftSide(){
		return Collections.unmodifiableSet(leftSide);
	}
	public Set<Crosser> getRightSide(){
		return Collections.unmodifiableSet(rightSide);
	}
	public TorchPosition getTorchPosition() {
		return torchPosition;
	}
	public Integer getTimePassed() {
		return timePassed;
	}
	
}
