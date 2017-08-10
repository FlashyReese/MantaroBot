package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CMarco implements Command {

	public CMarco()
	{
		MantaroBot.commandHelp.add("| ~>marco, Polo.");
	}	
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		evt.getTextChannel().sendMessage("Polo!");
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) 
	{
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}

}
