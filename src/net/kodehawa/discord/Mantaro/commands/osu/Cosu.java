package net.kodehawa.discord.Mantaro.commands.osu;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import com.osu.api.ciyfhx.OsuClient;
import com.osu.api.ciyfhx.User;
import com.osu.api.ciyfhx.UserScore;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class Cosu implements Command {

	private OsuClient osuClient = null;
	public Map<String, Object> map = new HashMap<String, Object>();
	
	public Cosu()
	{
		MantaroBot.commandHelp.add("~>osu | Retrieves osu! related things. Do ~>osu help to get more info");
	}
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		osuClient = new OsuClient("lolnope");
		
		String beheaded = whole.replace("~>osu ", "");

		if(beheaded.startsWith("best"))
		{
			String beheaded1 = beheaded.replace("best ", "");
			String[] args = beheaded1.split(" ");

			map.put("m", args[1]);
			
			User hey = osuClient.getUser(args[0], map);
			List<UserScore> userBest = osuClient.getUserBest(hey, map);
			StringBuilder sb = new StringBuilder();
			List<String> best = new CopyOnWriteArrayList<String>();
			
			int n = -1;
			int n1 = 0;
			DecimalFormat df = new DecimalFormat("####0.0");
			for (@SuppressWarnings("unused") UserScore u : userBest)
			{
				n = n + 1;
				n1 = n1 + 1;
				best.add("[" + n1 + "] " + "Map: \"" + userBest.get(n).getBeatMap().getTitle() + "\" (" + userBest.get(n).getBeatMap().getCreator() 
						+ ") | Date: " + userBest.get(n).getDate() + " | Max Combo: " + userBest.get(n).getMaxCombo() +
						" | PP: " + df.format(userBest.get(n).getPP()) + "\r");
				sb.append(best.get(n));
			}

		    
			evt.getChannel().sendMessageAsync("```xl\n" + sb.toString() + "```", null);
		}
		else if(beheaded.startsWith("recent"))
		{
			String beheaded1 = beheaded.replace("recent ", "");
			
			String[] args = beheaded1.split(" ");
			
			map.put("m", Integer.parseInt(args[1]));
			
			
			User hey = osuClient.getUser(args[0], map);
			List<UserScore> userRecent = osuClient.getUserRecent(hey, map);
			StringBuilder sb = new StringBuilder();
			List<String> recent = new CopyOnWriteArrayList<String>();
			
			int n = -1;
			int n1 = 0;
			DecimalFormat df = new DecimalFormat("####0.0");
			for (@SuppressWarnings("unused") UserScore u : userRecent)
			{
				n = n + 1;
				n1 = n1 + 1;
				recent.add("[" + n1 + "] " + "Map: \"" + userRecent.get(n).getBeatMap().getTitle() + "\" (" + userRecent.get(n).getBeatMap().getCreator() 
						+ ") | Date: " + userRecent.get(n).getDate() + " | Max Combo: " + userRecent.get(n).getMaxCombo() +
						" | PP: " + df.format(userRecent.get(n).getPP()) + "\r");
				sb.append(recent.get(n));
			}

		    
			evt.getChannel().sendMessageAsync("```xl\n" + sb.toString() + "```", null);
		}
		else if(beheaded.startsWith("user"))
		{
			String beheaded1 = beheaded.replace("user ", "");
			
			String[] args = beheaded1.split(" ");
			
			map.put("m", 0);
			
			User hey = osuClient.getUser(args[0], map);
			DecimalFormat df = new DecimalFormat("####0");
				evt.getChannel().sendMessageAsync("```xl\n"+ "Username: " + hey.getUsername() + " (#" + hey.getUserID() + ")" + "\rCountry: " + hey.getCountry() 
				+ "\rRank: " + df.format(hey.getPPRank()) + " | Country Rank: " + df.format(hey.getPPCountryRank()) +	
				"\rAccuracy: " + df.format(hey.getAccuracy()) + "%\rPP: " + df.format(hey.getPPRaw()) + "\r" + "Level: " + df.format(hey.getLevel())
				+ "\rRanked Score: " + hey.getRankedScore() + "\rA, S, SS: " + hey.getCountRankA() + " | " + hey.getCountRankS() + " | " + hey.getCountRankSS() 
				+ "```", null);
		}
		else if(beheaded.startsWith("help"))
		{
			evt.getChannel().sendMessageAsync("```ruby\n                          osu! Mantaro module help\r\r"
					+ "~>osu best <username> <mode> (0 = osu!, 1 = taiko, 2 = mania, 3 = ctb)\r"
					+ "~>osu recent <username> <mode> (0 = osu!, 1 = taiko, 2 = mania, 3 = ctb)\r"
					+ "~>osu user <username>  ```", null);
		}
		else
		{
			evt.getChannel().sendMessageAsync("Incorrect usage! Use ~>osu help to get help on how to use this command!", null);
		}
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ".");
	}

}
