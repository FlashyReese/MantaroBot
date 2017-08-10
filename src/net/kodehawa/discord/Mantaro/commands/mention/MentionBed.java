package net.kodehawa.discord.Mantaro.commands.mention;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class MentionBed implements Command {

	public MentionBed()
	{
		MantaroBot.mentionCommandHelp.add("| @MantaroBot bed, Wanna do lewd? <3.");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		evt.getChannel().sendMessage("W-What are you gonna do to me?! L-Lewd!");
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}

}
