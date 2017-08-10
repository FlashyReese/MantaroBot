package net.kodehawa.discord.Mantaro.commands;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;
import net.kodehawa.discord.Mantaro.file.StringArrayFile;

public class CTsundere implements Command {

	public static CopyOnWriteArrayList<String> tsunLines = new CopyOnWriteArrayList<String>();
	
	public CTsundere()
	{
		MantaroBot.commandHelp.add("| ~>tsundere, W-WHO DO YOU THINK YOU ARE, B-BAKA.");
		new StringArrayFile("tsunderelines", "mantaro", tsunLines, false);
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		Random rd = new Random();
        int tsundereRandomizer = rd.nextInt(tsunLines.size());
		evt.getChannel().sendMessage(tsunLines.get(tsundereRandomizer));
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ", in channel " + evt.getChannel().toString() + " (" + evt.getMessage().toString() + " )");
	}

}
