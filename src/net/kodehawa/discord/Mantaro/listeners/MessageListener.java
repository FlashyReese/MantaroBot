package net.kodehawa.discord.Mantaro.listeners;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.config.Values;

public class MessageListener extends ListenerAdapter 
{
	
	public static boolean isMention = false;
	
	@Override
	public void onMessageReceived(MessageReceivedEvent evt)
	{
		boolean isPrivate = evt.isPrivate();
		
		if(!isPrivate && !Values.disabledServers.contains(evt.getGuild().getId()))
		{
			if(evt.getMessage().getContent().startsWith("@MantaroBot") || evt.getMessage().getContent().startsWith(MantaroBot.botPrefix) && evt.getMessage().getAuthor().getId() != evt.getJDA().getSelfInfo().getId())
			{
				if(evt.getMessage().getContent().startsWith("@MantaroBot")){ isMention = true; } else { isMention = false; }
				MantaroBot.onCommand(MantaroBot.parser.parse(evt.getMessage().getContent(), evt));
			}
		}
		else if(evt.getMessage().getContent().startsWith("~>bot.status "))
		{
			MantaroBot.onCommand(MantaroBot.parser.parse(evt.getMessage().getContent(), evt));
		}
	}
}

