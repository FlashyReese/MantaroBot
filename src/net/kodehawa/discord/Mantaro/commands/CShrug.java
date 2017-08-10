package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CShrug implements Command {

	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		evt.getChannel().sendMessageAsync("http://www.wired.com/wp-content/uploads/2015/01/shrug1-1024x768.jpg", null);
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub

	}

}
