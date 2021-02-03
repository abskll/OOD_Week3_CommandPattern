
public class RobotControl {
	Command[] activateCommands;
	Command[] disableCommands;
	
	public RobotControl() {
		activateCommands = new Command[7];
		disableCommands = new Command[7];
		
		for(int i = 0; i< 7; i++) {
			activateCommands[i] = () -> {};
			disableCommands[i] = () -> {};
		}
	}
	
	public void setCommand(int slot, Command activateCommand, Command disableCommand) {
		activateCommands[slot] = activateCommand;
		disableCommands[slot] = disableCommand;
	}
 
	public void activateButtonWasPushed(int slot) {
		activateCommands[slot].execute();
	}
 
	public void disableButtonWasPushed(int slot) {
		disableCommands[slot].execute();
	}

	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < activateCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + activateCommands[i].getClass().getName()
				+ "    " + disableCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}
}
