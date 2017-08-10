package net.kodehawa.discord.Mantaro.commands;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CUserInfo implements Command {


	public CUserInfo()
	{
		MantaroBot.commandHelp.add("| ~>userinf, shows info about any user you want... or yourself.");
	}
	
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		
		//System.out.println(whole);
		
		StringBuilder user = new StringBuilder();

		if(!whole.replace("~>userinf", "").isEmpty())
		{
						
			int n = -1;
			User user1 = null;
					
			for (User users : evt.getGuild().getUsers())
			{
				n = n + 1;
				if(users.toString().startsWith(whole.replace("~>userinf ", "")))
				{
					user1 = evt.getGuild().getUsers().get(n);
					break;
				}
			}
			
			if(evt.getMessage().getMentionedUsers() != null)
			{
				user1 = evt.getMessage().getMentionedUsers().get(0);
			}
			
			if(user1 != null)
			{
				if(whole.replace("~>userinf ", "").contains(user))
				{
					        evt.getChannel().sendMessage("```ruby\n"
					        + "> Nickname: " + evt.getGuild().getNicknameForUser(user1) + "\r"
							+ "> Role: " + evt.getGuild().getColorDeterminantRoleForUser(user1).toString().replace("R:", "").replaceAll("\\([^\\(]*\\)", " ")+ "\r"
							+ "> Join Date: " + evt.getGuild().getJoinDateForUser(user1).toString()+ "```\r\n"
							);
				}
			}
			
		}
		else
		{
			
			User user1 = evt.getMessage().getAuthor();
			
			String joinDate = evt.getGuild().getJoinDateForUser(evt.getMessage().getAuthor()).toString();
			String[] split = joinDate.split("T");
			
			evt.getChannel().sendMessage("```ruby\n"
			        + "> Username: " + evt.getAuthorName() + "\r"
					+ "> ID: " + evt.getMessage().getAuthor().getId() + "\r"
					+ "> Roles: " + evt.getGuild().getRolesForUser(user1).size() + "\r"
				    + "> Main Role: " + evt.getGuild().getColorDeterminantRoleForUser(evt.getMessage().getAuthor()).toString().replace("R:", "").replaceAll("\\([^\\(]*\\)", " ")+ "\r"
					+ "> Online?: " + evt.getMessage().getAuthor().getOnlineStatus() + "\r"
					+ "> Server Join Date: " + split[0] + " " + split[1]  + "\r"
					+ "> Avatar URL: " + evt.getMessage().getAuthor().getAvatarUrl() + "```\r\n"
					);
		}
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}

}