
public abstract class Car {
	private CarType model = null;

	public Car(CarType model) {
		this.setModel(model);
		arrange_parts();
	}
	
	public void arrange_parts() {
		System.out.print("\nArranging all parts...\n");
		complete_the_process();
	}
	
	public void complete_the_process() {
		System.out.print("\nAdding engine\n");
		System.out.println("Engine is Assembled");
		System.out.println("Chassis is ready");
		System.out.println("Wheels are Assembled");
	}
	
	protected abstract void construct();

	public CarType getModel() {
		return model;
	}

	public void setModel(CarType model) {
		this.model = model;
	}
	
}
