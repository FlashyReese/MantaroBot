package net.kodehawa.discord.Mantaro.commands;

import java.util.ArrayList;
import java.util.Random;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CBleach implements Command {

	private ArrayList<String> bleach = new ArrayList<String>();
	
	public CBleach()
	{
		MantaroBot.commandHelp.add("| ~>bleach, Gets a random image of someone drinking bleach.");
		bleach.add("http://puu.sh/qyoDQ/9df29f6b30.jpg");
		bleach.add("http://data.whicdn.com/images/13651431/superthumb.jpg");
		bleach.add("https://i.ytimg.com/vi/IjgPHJTbfK4/maxresdefault.jpg");
		bleach.add("https://media0.giphy.com/media/fN96l0NwjjOGQ/200_s.gif");
		bleach.add("https://www.youtube.com/watch?v=5PIx19ha9MY");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		Random rand = new Random();
        int bleachRandomizer = rand.nextInt(bleach.size());

		evt.getChannel().sendMessage(bleach.get(bleachRandomizer));
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("Command executed " + this.getClass().getName() + ", in channel " + evt.getChannel().toString() + " (" + evt.getMessage().toString() + " )");
	}

}
