package sm;

public class HUmen implements Cloneable{

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dto [name=" + name + ", age=" + age + "]";
	}
	@Override
	public boolean equals(Object obj) {
		HUmen target=(HUmen) obj;
		if(this.age==target.age) {
			return true;
		};
		return false;
	}

	public  HUmen clone() throws CloneNotSupportedException {
		return (HUmen) super.clone();
	}
}
