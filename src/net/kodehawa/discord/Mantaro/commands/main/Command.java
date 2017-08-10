package net.kodehawa.discord.Mantaro.commands.main;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

public interface Command {

	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt);
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt);
	public void actionResult(boolean result, MessageReceivedEvent evt);
	
}
