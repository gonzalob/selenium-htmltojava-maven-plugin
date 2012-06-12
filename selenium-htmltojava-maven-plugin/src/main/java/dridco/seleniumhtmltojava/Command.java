package dridco.seleniumhtmltojava;

final class Command {

	private Commands command;
	private String value;
	private String additional;

	public Command(Commands command, String value, String additional) {
		this.command = command;
		this.value = value;
		this.additional = additional;
	}

	public String build() {
		return command.build(value, additional);
	}

}
