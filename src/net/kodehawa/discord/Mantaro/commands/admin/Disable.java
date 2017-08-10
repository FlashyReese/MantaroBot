package net.kodehawa.discord.Mantaro.commands.admin;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.commands.CKonachan;
import net.kodehawa.discord.Mantaro.commands.main.Command;
import net.kodehawa.discord.Mantaro.config.Values;

public class Disable implements Command {

	public Disable()
	{
		Values.instance.read();
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		
		String beheaded = whole.replace("~>bot.status ", "");
		
		if(beheaded.startsWith("disable"))
		{
			if(evt.getAuthor().getId().equals("155867458203287552") || evt.getAuthor().getId().equals("141594071033577472")){
				
				String serverId = evt.getGuild().getId();
				Values.disabledServers.add(serverId);
				evt.getChannel().sendMessageAsync("Server will be ignored from now on.", null);
				Values.instance.check();
			}
		}
		else if(beheaded.startsWith("enable") )
		{
			if(evt.getAuthor().getId().equals("155867458203287552") && Values.disabledServers.contains(evt.getGuild().getId())){
				
				String serverId = evt.getGuild().getId();
				Values.disabledServers.remove(serverId);
				evt.getChannel().sendMessageAsync("Server won't be ignored from now on.", null);
				Values.instance.check();
			}
		}
		else if(beheaded.startsWith("konasfw"))
		{
			String[] woah = beheaded.split(" ");
			Values.values.put("kona.sfw", Boolean.parseBoolean(woah[1]));
			new CKonachan();
			System.out.println(Values.values.get("kona.sfw").booleanValue());
			evt.getChannel().sendMessageAsync("```Konachan SFW is now: " + Values.values.get("kona.sfw").booleanValue() + "```", null);
		}
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}

}
