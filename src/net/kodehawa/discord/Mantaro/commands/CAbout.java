package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CAbout implements Command {

	public CAbout()
	{
		MantaroBot.commandHelp.add("| ~>about, Tells info about the bot.");
	}
	
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		evt.getChannel().sendMessage("Bot made by Kodehawa. Latest build is: " + MantaroBot.build + " " +  "With date: " + MantaroBot.buildDate + ", running on JDA.");
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ", in channel " + evt.getChannel().toString() + " (" + evt.getMessage().toString() + " )");
	}

}
