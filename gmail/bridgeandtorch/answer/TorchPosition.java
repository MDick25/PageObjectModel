package answer;

public enum TorchPosition {

	LEFT{
		@Override
		public <T> T accept(TorchTravelor<T> travelor) {
			return travelor.travelLeft();
		}
		@Override
		public TorchPosition turn() {
			return RIGHT;
		}
	},
	RIGHT{
		
		@Override
		public <T> T accept(TorchTravelor<T> travelor) {
			return travelor.travelRight();
		}
		@Override
		public TorchPosition turn() {
			return LEFT;
		}
	};
	public abstract <T> T accept(TorchTravelor<T> travelor);
	
	public abstract TorchPosition turn();
}
