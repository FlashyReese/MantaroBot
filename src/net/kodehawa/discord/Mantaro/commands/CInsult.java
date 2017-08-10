package net.kodehawa.discord.Mantaro.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.MantaroBot;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class CInsult implements Command {

	public CInsult()
	{
		MantaroBot.commandHelp.add("| ~>insult, Insults with InsultGenerator.org");
	}
	
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		try {
	        URL url = new URL("http://www.insultgenerator.org/");
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        String str;
	        while ((str = in.readLine()) != null) {
	            str = in.readLine().toString();
	            String reg = "<.*?>(.*)<\\/.*?>";
	            Pattern p = Pattern.compile(reg);
	            Matcher m = p.matcher(str);
	            while(m.find())
	            {
	                String s1 = m.group();
	                if(s1.contains("<br><br>")){
	                	String s3 = s1.substring(8);
	                	evt.getChannel().sendMessage(s3.replace("</div>", ""));
	                }
	            }  
	        }
	        in.close();
	    } catch (MalformedURLException e) {
	    } catch (IOException e) {
	    }
		
		
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName() + ", in channel " + evt.getChannel().toString() + " (" + evt.getMessage().toString() + " )");
	}

}