package Flyweight;

public class Parceiros implements MyString {
	private final String parceiro;
	
	protected Parceiros (String parceiro) {
		this.parceiro = parceiro;
	}
	
	public String getString() {
		return parceiro;
	}

}
