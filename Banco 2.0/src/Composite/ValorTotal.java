package Composite;

public class ValorTotal implements ValorConvenios {
	
	private ValorConvenios conv1;
	private ValorConvenios conv2;
	
	public ValorTotal(ValorConvenios conv1, ValorConvenios conv2) {
		this.conv1 = conv1;
		this.conv2 = conv2;
	}

	@Override
	public double precomensal() {
		return (conv1.precomensal() + conv2.precomensal()) * 0.5;
	}

	@Override
	public double precoanual() {
		return conv1.precoanual() + conv2.precoanual() * 0.5;
	}

}
