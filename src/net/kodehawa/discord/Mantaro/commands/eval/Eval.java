package net.kodehawa.discord.Mantaro.commands.eval;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import bsh.Interpreter;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.kodehawa.discord.Mantaro.commands.main.Command;

public class Eval implements Command {
	
	@Override
	public boolean isAvaliable(String[] argsMain, MessageReceivedEvent evt) {
		return true;
	}

	@Override
	public void botAction(String[] msg, String whole, MessageReceivedEvent evt) {
		if(evt.getAuthor().getId().equals("155867458203287552") || evt.getAuthor().getId().equals("141594071033577472"))
		{
			try {
		    	Interpreter interpreter = new Interpreter();
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        PrintStream ps = new PrintStream(baos);
		        PrintStream old = System.out;
		        System.setOut(ps);
		    	interpreter.eval(whole.replace("->kode.eval ", ""));
		        System.out.flush();
		        System.setOut(old);
		        evt.getChannel().sendMessage(baos.toString());
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
