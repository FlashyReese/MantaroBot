package net.kodehawa.discord.Mantaro.commands.mention;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class MentionSay implements Command {

	public MentionSay()
	{
		MantaroBot.mentionCommandHelp.add("| @MantaroBot tell, It will just repeat what you said, or answer you 3 questions.");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		String args = whole.replace("@MantaroBot tell ", "");
		String[] possiblities = {"lewd", "Are you lewd?", "Do you love me?"};
		if(args.startsWith(possiblities[0]))
		{
			evt.getChannel().sendMessageAsync("Too lewd!", null);
		}
		else if(args.startsWith(possiblities[1]))
		{
			evt.getChannel().sendMessageAsync("Yes, I'm the lewdest.", null);
		}
		else if(args.startsWith(possiblities[2]))
		{
			evt.getChannel().sendMessageAsync("I-I do...", null);
		}
		
		else
		{
			evt.getChannel().sendMessageAsync(args, null);
		}
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}

}
