package answer;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

public class CrossersRemaining {

	private Set<Crosser> crossers;
	
	public CrossersRemaining(Set<Crosser> crossers) {
		this.crossers = Collections.unmodifiableSet(crossers);
		
		if(this.crossers.isEmpty()) {
			throw new IllegalArgumentException("Empty set, cannot create");
		}
	}
	public boolean containsCrosser(Crosser crosser) {
		return crossers.contains(crosser);
	}
	public Stream<Crosser> toStream(){
		return crossers.stream();
	}
	public Integer minutesToCross() {
		Integer minutesToCross = crossers.stream().mapToInt((crosser)-> crosser.getMinutesToCross()).max().getAsInt();
		
		return minutesToCross;
	}
	public Set<Crosser> gerCrossers(){
		return Collections.unmodifiableSet(crossers);
	}
}
