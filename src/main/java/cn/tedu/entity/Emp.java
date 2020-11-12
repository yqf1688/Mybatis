package cn.tedu.entity;

public class Emp {

	private Integer id;
	private String name;
	private String job;
	private Double salary;
	
	
	public Emp(String name, String job, Double salary) {
		super();
		this.name = name;
		this.job = job;
		this.salary = salary;
	}
	public Emp(Integer id, String name, String job, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}
}
