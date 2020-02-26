package hashCode2020.kuni;

public enum Input {

	A("a_example.txt"),
//	B("b_read_on.txt"),
//	C("c_incunabula.txt"),
	D("d_tough_choices.txt"),
	E("e_so_many_books.txt"),
	F("f_libraries_of_the_world.txt");
	
	private String name;

	Input(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
