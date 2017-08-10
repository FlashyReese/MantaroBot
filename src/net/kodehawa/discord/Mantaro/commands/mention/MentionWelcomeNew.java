package net.kodehawa.discord.Mantaro.commands.mention;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class MentionWelcomeNew implements Command {

	public MentionWelcomeNew()
	{
		MantaroBot.mentionCommandHelp.add("| @MantaroBot welcome new, Welcomes new people and shows useful information.");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		evt.getChannel().sendMessage("Welcome to NekoParadise! I hope you have a nice stay in here. \r\n Remember to read #rules. Announcements are made in #saisoku-news. \r\n This bot was made by Kodehawa, to know its commands please use ~>help or @MantaroBot help");
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName());
	}

}
