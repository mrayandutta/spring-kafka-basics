package springkafkabasics.model;

public class EmployeeWithAdditional extends Employee{

	public EmployeeWithAdditional(String name, String department, String salary) {
		super(name, department, salary);
		// TODO Auto-generated constructor stub
	}
	
	private int retryCount;
	private int retryThreshold;
	private int retryOn;
	

}
