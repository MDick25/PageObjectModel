package answer;

public class Crosser {

	private String id;
	private Integer minutesToCross;
	
	public Crosser(String id, Integer minutesToCross) {
		this.id = id;
		this.minutesToCross = minutesToCross;
	}
	public String getId() {
		return id;
	}
	public Integer getMinutesToCross() {
		return minutesToCross;
	}
}
