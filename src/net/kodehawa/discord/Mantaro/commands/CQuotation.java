package net.kodehawa.discord.Mantaro.commands;

import java.util.concurrent.CopyOnWriteArrayList;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;
import net.kodehawa.discord.Mantaro.file.StringArrayFile;

public class CQuotation implements Command {

	public static CopyOnWriteArrayList<String> quotes = new CopyOnWriteArrayList<String>();
	
	public CQuotation()
	{
		MantaroBot.commandHelp.add("| ~>quote, use ~>quote help to get detailed info.");
		new StringArrayFile("Quotes", "mantaro", quotes , false);
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		
		if(!whole.replace("~>quote ", "").startsWith("read") && !whole.replace("~>quote ", "").startsWith("list") && !whole.replace("~>quote ", "").startsWith("get phrase") && !whole.replace("~>quote ", "").startsWith("help"))
		{
			String quote = whole.replace("~>quote ", "");
			quotes.add(quote);
			new StringArrayFile("Quotes", "mantaro", quotes, true, false);
			evt.getChannel().sendMessage("Quote succesfully added: " + quote + " (Do ~>quote list in #spam to get the call number for now." );
		}
		else if(whole.replace("~>quote ", "").startsWith("read"))
		{
			String number = whole.replace("~>quote read ", "");
			try
			{
				int number2 = Integer.parseInt(number);
				evt.getChannel().sendMessage(quotes.get(number2));
			}
			catch(Exception e)
			{
				evt.getChannel().sendMessage("Not a number, silly you");
			}
			
		}
		else if(whole.replace("~>quote ", "").startsWith("get phrase"))
		{
			String phrase = whole.replace("~>quote get phrase ", "");
			try
			{
				int n = -1;
				for(String message : quotes)
				{
					n = n + 1;
					if(message.contains(phrase))
					{
						evt.getChannel().sendMessage(quotes.get(n));
					}
					break;
				}
			}
			catch(Exception e)
			{
				evt.getChannel().sendMessage("Not a number, silly you");
			}
			
		}
		else if(whole.replace("~>quote ", "").startsWith("list"))
		{
			StringBuilder listString = new StringBuilder();

			int n = -1;
			for (String quotes : quotes)
			{
				n = n + 1;
			    listString.append(quotes + " (Call number: " + n + ")" +"\r\n");
			}
			
			evt.getChannel().sendMessage(listString.toString());
		}
		else if(whole.replace("~>quote ", "").startsWith("help"))
		{
			evt.getChannel().sendMessage("```| MantaroBot quote module help: \r \r" 
					+ "~>quote 'example', adds a quote to the quote list. (Usage example: ~>quote I like dogs -chuchy.)  \r \r"
					+ "~>quote list, gets a list of all the quotes avaliable \r \r"
					+ "~>quote read number, gets the quote matching the number. (Usage example: ~>quote read 0) \r \r"
					+ "~>quote get phrase example, searches for the first quote which matches your search criteria and prints it. (Usage example: ~>quote get phrase dogs).``` \n"
					);
		}
		else{
			evt.getChannel().sendMessage("Silly you, this won't happen.");
		}
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName());
	}

}
