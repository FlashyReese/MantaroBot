package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CHelp implements Command {

	public CHelp()
	{
		MantaroBot.commandHelp.add("| ~>help, Gets this message.");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		StringBuilder listString = new StringBuilder();

		for (String help : MantaroBot.commandHelp)
		{
		    listString.append(help+"\r\n");
		}
		
		evt.getAuthor().getPrivateChannel().sendMessage("```ruby\nWelcome." + "\r" + "MantaroBot version: " + MantaroBot.build + " running on JDA. Here is a list of useful commands you can use with this bot. The commands listed here are only avaliable using ~> and not via mentioning the bot. CleverBot talk is avaliable via @Mantarobot talk *message here*\n" + "\r" + "\r" + listString.toString() + "``` \n");;
				
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ", in channel " + evt.getChannel().toString() + " (" + evt.getMessage().toString() + " )");
	}

}
