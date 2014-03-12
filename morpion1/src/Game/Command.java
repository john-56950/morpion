package Game;

public enum Command {

	JOUER("jouer"), REGLES("régles"), QUITTER("quitter");
	
	private final String cmd;
	
	private Command(final String cmd){
		this.cmd = cmd;
	}
	
	public String getCmd() {
		return cmd;
	}

	public static Command getCommand(String cmd){
		for(Command c:Command.values()){
			if(c.getCmd().equals(cmd)){
				return c;
			}
		}
		return null;
	}

	public static void allCommand(){
		for(Command c:Command.values()){
			System.out.println(c);
		}
	}
}
