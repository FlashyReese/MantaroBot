package net.kodehawa.discord.Mantaro.commands.main;

import java.util.ArrayList;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;

public class Parser {	
	
	public CommandContainer parse(String rw, MessageReceivedEvent evt)
	{
		if(rw.startsWith(MantaroBot.botPrefix))
		{
			ArrayList<String> split = new ArrayList<String>();
			String raw = rw;
			String beheaded = raw.replaceFirst(MantaroBot.botPrefix, "");
			String[] splitBeheaded = beheaded.split(" ");
			for(String s : splitBeheaded)
			{
				split.add(s);
			}
			
			String invoke = split.get(0);
			String[] args = new String[split.size() - 1];
			split.subList(1, split.size()).toArray(args);
			return new CommandContainer(raw, beheaded, splitBeheaded, invoke, args, evt);
		}
		
		else if(rw.startsWith("@MantaroBot"))
		{
			//System.out.println(rw);
			ArrayList<String> split = new ArrayList<String>();
			String raw = rw;
			String beheaded = raw.replaceFirst("@MantaroBot ", "");
			String[] splitBeheaded = beheaded.split(" ");
			for(String s : splitBeheaded)
			{
				split.add(s);
			}
			
			String invoke = split.get(0);
			String[] args = new String[split.size() - 1];
			split.subList(1, split.size()).toArray(args);
			return new CommandContainer(raw, beheaded, splitBeheaded, invoke, args, evt);
		}
		
		return null;
		
		
	}
	
	public class CommandContainer
	{
		public final String rawCommand;
		public final String beheadedMain;
		public final String[] splitBeheadedMain;
		public final String invokeMain;
		public final String[] argsMain;
		public final MessageReceivedEvent event;

	
		
		public CommandContainer(String raw, String beheaded, String[] splitBeheaded, String invoke, String[]args, MessageReceivedEvent evt)
		{
			rawCommand = raw;
			beheadedMain = beheaded;
			splitBeheadedMain = splitBeheaded;
			invokeMain = invoke;
			argsMain = args;
			event = evt;
		}
	 }
		
}
