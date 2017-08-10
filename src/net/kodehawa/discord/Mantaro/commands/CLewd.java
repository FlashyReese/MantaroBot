package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CLewd implements Command {

	public CLewd()
	{
		MantaroBot.commandHelp.add("| ~>lewd, Sends a pic with an anime girl saying lewd.");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		evt.getChannel().sendMessage("Y-You lewdie!" + "\r\n" 
		 + "http://i.stack.imgur.com/MKMpFm.jpg");
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ", in channel " + evt.getChannel().toString() + " (" + evt.getMessage().toString() + " )");
	}

}
