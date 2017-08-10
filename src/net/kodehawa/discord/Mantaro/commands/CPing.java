package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CPing implements Command {

	public CPing()
	{
		MantaroBot.commandHelp.add("| ~>ping, Pong? Is this alive?.");
	}
	
	@Override
	public boolean isAvaliable(String[] message, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
	    long start = System.currentTimeMillis();
		evt.getTextChannel().sendTyping();
	    long end = System.currentTimeMillis() - start;
		evt.getTextChannel().sendMessage("Pong to " + evt.getAuthor().getAsMention() + " in " + end + " ms.");

	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt)
	{
		System.out.println("Command executed " + this.getClass().getName() + ", in channel " + evt.getChannel().toString() + " (" + evt.getMessage().toString() + " )");
	}

	
	
}
