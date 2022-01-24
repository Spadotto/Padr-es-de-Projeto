package Flyweight;

import java.util.ArrayList;
import java.util.List;

public class ListaParcerias implements MyString {
	private List<MyString> myStrings;
	
	public ListaParcerias() {
		this.myStrings = new ArrayList<MyString>();
	}
	
	public void add(MyString m ) {
		myStrings.add(m);
	}
	
	public String getString() {
		String string = new String();
		for (MyString m : myStrings)
			string = string.concat(m.getString() + " \n");
		return string;
	}

}
