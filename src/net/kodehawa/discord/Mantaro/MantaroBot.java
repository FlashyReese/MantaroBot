package net.kodehawa.discord.Mantaro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.kodehawa.discord.Mantaro.commands.*;
import net.kodehawa.discord.Mantaro.commands.admin.AddList;
import net.kodehawa.discord.Mantaro.commands.admin.CDisconnect;
import net.kodehawa.discord.Mantaro.commands.admin.CMaster;
import net.kodehawa.discord.Mantaro.commands.admin.CRestart;
import net.kodehawa.discord.Mantaro.commands.admin.Disable;
import net.kodehawa.discord.Mantaro.commands.eval.Eval;
import net.kodehawa.discord.Mantaro.commands.eval.Evalink;
import net.kodehawa.discord.Mantaro.commands.main.Command;
import net.kodehawa.discord.Mantaro.commands.main.Parser;
import net.kodehawa.discord.Mantaro.commands.mention.*;
import net.kodehawa.discord.Mantaro.commands.osu.Cosu;
import net.kodehawa.discord.Mantaro.commands.placeholder.CommandNotFound;
import net.kodehawa.discord.Mantaro.config.Values;
import net.kodehawa.discord.Mantaro.listeners.MessageListener;

public class MantaroBot {
	
	public static JDA jda;
	public static Parser parser = new Parser();
	public static HashMap<String, Command> mentionCommandList = new HashMap<String, Command>();
	public static HashMap<String, Command> commandList = new HashMap<String, Command>();
	public static List<String> commandHelp = new ArrayList<String>();
	public static List<String> mentionCommandHelp = new ArrayList<String>();
	private final static String gameStatus = "with Myself.";
	public final static String botPrefix = "->";
	public final static String build = "0.5.1";
	public final static String buildDate = "31th of August 2016";
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public MantaroBot(){}
	
	public static void main(String[] args)
	{
		System.out.println("MantaroBot starting...");
		try

		{
			
			jda = new JDABuilder().addListener(new MessageListener()).setBotToken("lolnope").buildBlocking();
			System.out.println("MantaroBot succefully started");
			jda.setAutoReconnect(true);
			//Default
			jda.getAccountManager().setGame(gameStatus);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		new Values();
		
		commandList.put("ping", new CPing());
		commandList.put("serverinfo", new CServerInfo());
		commandList.put("marco", new CMarco());
		commandList.put("lewd", new CLewd());
		commandList.put("meow", new CMeow());
		commandList.put("master", new CMaster());
		commandList.put("game", new CChangeGameStatus());
		commandList.put("bleach", new CBleach());
		commandList.put("disconnect", new CDisconnect());
		commandList.put("help", new CHelp());
		commandList.put("restart", new CRestart());
		commandList.put("aaaa", new CBrainPower());
		commandList.put("about", new CAbout());
		commandList.put("tsundere", new CTsundere());
		commandList.put("hi", new CHi());
		commandList.put("roasted", new CRoasted());
		commandList.put("meow2", new CMeow2());
		commandList.put("quote", new CQuotation());
		commandList.put("add", new AddList());
		commandList.put("userinf", new CUserInfo());
		commandList.put("shrug", new CShrug());
		commandList.put("konachan", new CKonachan());
		commandList.put("time", new CHour());
		commandList.put("osu", new Cosu());
		commandList.put("action", new CAction());
		commandList.put("placeholder", new CommandNotFound());
		commandList.put("bot.status", new Disable());
		commandList.put("kode.eval", new Eval());
		commandList.put("kode.evalink", new Evalink());
		commandList.put("insult", new CInsult());
		
		mentionCommandList.put("nya", new MentionMeow());
		mentionCommandList.put("wanna go to bed?", new MentionBed());
		mentionCommandList.put("welcome new", new MentionWelcomeNew());
		mentionCommandList.put("help", new MentionHelp());
		mentionCommandList.put("tell", new MentionSay());
		mentionCommandList.put("talk", new MentionCleverbot());
		mentionCommandList.put("placeholder", new CommandNotFound());
		
		int totalCommands = commandList.size()+mentionCommandList.size();
		
		System.out.println("Successfully loaded " + totalCommands + " commands.");
	}
	
	public static void onCommand(Parser.CommandContainer cmd)
	{		
		if(!MessageListener.isMention)
		{
			if(commandList.containsKey(cmd.invokeMain))
			{
				boolean isSafe = commandList.get(cmd.invokeMain).isAvaliable(cmd.argsMain, cmd.event);
				
				if(isSafe)
				{
					commandList.get(cmd.invokeMain).botAction(cmd.argsMain, cmd.rawCommand, cmd.event);
					commandList.get(cmd.invokeMain).actionResult(isSafe, cmd.event);
				}
				else
				{
					commandList.get(cmd.invokeMain).actionResult(isSafe, cmd.event);
				}
			}
		}
		else
		{
			if(mentionCommandList.containsKey(cmd.invokeMain))
			{
				boolean isSafe = mentionCommandList.get(cmd.invokeMain).isAvaliable(cmd.argsMain, cmd.event);
				
				if(isSafe)
				{
					mentionCommandList.get(cmd.invokeMain).botAction(cmd.argsMain, cmd.rawCommand, cmd.event);
						mentionCommandList.get(cmd.invokeMain).actionResult(isSafe, cmd.event);
				}
				else
				{
					mentionCommandList.get(cmd.invokeMain).actionResult(isSafe, cmd.event);
				}
			}
		}
	}
	
    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }
}
