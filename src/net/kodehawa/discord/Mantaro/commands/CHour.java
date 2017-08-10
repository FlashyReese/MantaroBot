package net.kodehawa.discord.Mantaro.commands;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CHour implements Command {

	public CHour()
	{
		MantaroBot.commandHelp.add("| ~>getTime GMT(- +)(number)| For example: ~>getTime GMT-3, that will print out GMT-3 time and hour. To get GMT just use GMT with no number.");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		try
		{
			evt.getChannel().sendMessageAsync("```\n" + dateGMT(whole.replace("~>time ", "")) + "```" , null);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override	
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}
	
	private String dateGMT(String timezone) throws ParseException, NullPointerException
	{
		SimpleDateFormat dateGMT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		dateGMT.setTimeZone(TimeZone.getTimeZone(timezone));
		SimpleDateFormat dateLocal = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		Date date1 = dateLocal.parse(dateGMT.format(new Date()));
		return DateFormat.getInstance().format(date1);
	}
}
