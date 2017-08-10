package net.kodehawa.discord.Mantaro.commands.eval;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

import bsh.Interpreter;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class Evalink implements Command {
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		if(evt.getAuthor().getId().equals("155867458203287552") || evt.getAuthor().getId().equals("141594071033577472"))
		{
			try {
				try {
			        URL url = new URL(whole.replace("->kode.evalink ", ""));
			        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			        String str;
			        while ((str = in.readLine()) != null) {
			            str = in.readLine().toString();
			            Interpreter interpreter = new Interpreter();
				        ByteArrayOutputStream baos = new ByteArrayOutputStream();
				        PrintStream ps = new PrintStream(baos);
				        PrintStream old = System.out;
				        System.setOut(ps);
				    	interpreter.eval(str);
				        System.out.flush();
				        System.setOut(old);
				        evt.getChannel().sendMessage(baos.toString());
			        }
			        in.close();
			    } catch (MalformedURLException e) {
			    } catch (IOException e) {
			    }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionResult(boolean result, MessageReceivedEvent evt) {
		System.out.println("Command executed " + this.getClass().getName());
	}

}
