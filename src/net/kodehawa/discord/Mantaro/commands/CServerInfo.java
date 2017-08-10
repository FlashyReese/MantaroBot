package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CServerInfo implements Command {

	
	public CServerInfo()
	{
		MantaroBot.commandHelp.add("| ~>serverinfo, shows info about the server.");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
	
		
		evt.getChannel().sendMessage(
				"```ruby\n Server info for: " + evt.getGuild().getName() + "\r \r" 
				
				
				+ "> Owner: " + evt.getGuild().getOwner().getUsername() + " \r"
				+ "> ID: " + evt.getGuild().getId() + "\r"
				+ "> Roles: " + evt.getGuild().getRoles().size() + "\r"
				+ "> Channels: " + evt.getGuild().getTextChannels().size()+ "\r"
				+ "> Voice Channels: " + evt.getGuild().getVoiceChannels().size() + "\r"
				+ "> Region: " + evt.getGuild().getRegion() + "\r"
				+ "> Icon URL: " + evt.getGuild().getIconUrl() + "```\r \r\n"
				);
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}

}
