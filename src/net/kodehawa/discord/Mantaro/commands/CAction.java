package net.kodehawa.discord.Mantaro.commands;

import java.util.List;

import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CAction implements Command {

	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		String beheaded = whole.replace("->action ", "");
		if(beheaded.startsWith("pat"))
		{
			List<User> menctions = evt.getMessage().getMentionedUsers();
			StringBuilder listString = new StringBuilder();

			for(User s : menctions)
			{
				listString.append(s.getAsMention());
			}

			evt.getChannel().sendMessageAsync(listString + " you have been patted by " + "" + evt.getAuthor().getAsMention() + "\r http://pa1.narvii.com/5947/f14b1451afa2fa16a6b9e6446d6039ee86db5641_hq.gif", null);
		}
		else if(beheaded.startsWith("hug"))
		{
			List<User> menctions = evt.getMessage().getMentionedUsers();
			StringBuilder listString = new StringBuilder();

			for(User s : menctions)
			{
				listString.append(s.getAsMention());
			}

			evt.getChannel().sendMessageAsync(listString + " you have been hugged by " + "" + evt.getAuthor().getAsMention() + "\r http://puu.sh/qUy1d/2e00556636.gif", null);
		}
		else if(beheaded.startsWith("bloodsuck"))
		{
			if(evt.getMessage().getMentionedUsers().isEmpty())
			{
				evt.getChannel().sendMessageAsync("http://puu.sh/qEYYH/e5094405a5.jpg", null);
			}
			else
			{
				StringBuilder listString = new StringBuilder();

				for(User s : evt.getMessage().getMentionedUsers())
				{
					listString.append(s.getAsMention());
				}
				evt.getChannel().sendMessageAsync("http://puu.sh/qEYYH/e5094405a5.jpg \r Sucks the blood of " + listString.toString(), null);
			}
		}
		else if(beheaded.startsWith("goaway"))
		{
			if(evt.getMessage().getMentionedUsers().isEmpty())
			{
				evt.getChannel().sendMessageAsync("http://s2.quickmeme.com/img/49/49c2ee6a615be9580be1aa4356c99b354cc0e73f408a9db829a0c4d18d55c3b4.jpg", null);
			}
			else
			{
				StringBuilder listString = new StringBuilder();

				for(User s : evt.getMessage().getMentionedUsers())
				{
					listString.append(s.getAsMention());
				}
				evt.getChannel().sendMessageAsync("http://s2.quickmeme.com/img/49/49c2ee6a615be9580be1aa4356c99b354cc0e73f408a9db829a0c4d18d55c3b4.jpg \r Serious, go away " + listString.toString(), null);
			}
		}
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		// TODO Auto-generated method stub

	}

}
