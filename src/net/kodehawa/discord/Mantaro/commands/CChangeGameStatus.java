package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CChangeGameStatus implements Command {

	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		if(evt.getAuthor().getId().equals("155867458203287552") || evt.getAuthor().getId().equals("141594071033577472"))
		{
			String newStatus;
			newStatus = String.join(" ", msg);
			MantaroBot.jda.getAccountManager().setGame(newStatus);
			evt.getChannel().sendMessage("Master! I've set my status to: " + newStatus + ".");
			System.out.println("I wanna do lewd stuff to Illya -Phizo 2016.");
		}
		else
		{
			evt.getChannel().sendMessage("O-Only my master is allowed to do that, silly");
		}
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ", in channel " + evt.getChannel().toString() + " (" + evt.getMessage().toString() + " )");
	}

}
