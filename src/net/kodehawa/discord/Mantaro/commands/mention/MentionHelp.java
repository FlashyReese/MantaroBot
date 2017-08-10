package net.kodehawa.discord.Mantaro.commands.mention;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class MentionHelp implements Command {

	public MentionHelp()
	{
		MantaroBot.mentionCommandHelp.add("| @MantaroBot help, shows this help screen.");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		StringBuilder listString = new StringBuilder();

		for (String help : MantaroBot.mentionCommandHelp)
		{
		    listString.append(help+"\r\n");
		}
		
		evt.getAuthor().getPrivateChannel().sendMessage("```" + listString.toString() + "``` \n");
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}

}
