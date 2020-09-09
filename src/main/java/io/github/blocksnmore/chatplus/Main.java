package io.github.blocksnmore.chatplus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.blocksnmore.chatplus.*;
import io.github.blocksnmore.chatplus.ChatListener;



@SuppressWarnings("unused")
public class Main extends JavaPlugin {
	
	public static Main plugin;
	final FileConfiguration config = this.getConfig();
	// WorkAround for getConfig not being available in other files
	public String mutechatcurrentlymuted = config.getString("mutechat-currently-muted");
	
	
	String comment =
	"Hey! If you see this you might be using a decompiler, my code is public on my github! https://github.com/blocksnmore/chatplus"; // Comment for people decompiling
	String comment2 = 
	"Feel free to check it out and report some issues you find!"; // Comment for people decompiling x2
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) { // Command executor
		switch(cmd.getName().toLowerCase()) { // Find command
		case "chatplus": case "chat": case "cp":
			ChatPlus.ChatPlusCmd(sender, args);
			break;
		case "mutechat": case "chatmute": case "mc":
			if(args[0] != null) {
				Mutechat.MuteChatCmd(sender, "");
			}else {
			Mutechat.MuteChatCmd(sender, args[0].toLowerCase());
			}
			break;
		case "clearchat": case "chatclear": case "cc":
			Clearchat.ClearChatCmd(sender, args);
			break;
		
		
		}
		return false;
	}
	
	@Override
	public void onEnable() {
		this.log("[ChatPlus] Thanks for using ChatPlus a plugin by Blocks_n_more");
		this.log("[ChatPlus] Generating config if one is not found");
		this.config.options().copyDefaults(true);
		saveDefaultConfig();
		this.log("[ChatPlus] Registering Listener for chat");
		getServer().getPluginManager().registerEvents(new ChatListener(this) /* Listener */, this/* Main */); // Register Listener
		this.log("[ChatPlus] Tip: If ChatPlus chat is not working check if you have a diffrent chat plugin that might be taking priority");
		this.log("[ChatPlus] ChatPlus is now enabled!");
	}
	@Override
	public void onDisable() {
		this.log("[ChatPlus] Shutting down ChatPlus");
		this.log("[ChatPlus] Thanks for using ChatPlus!");
	}
	
	private void log(String content) { // Cause i'm too lazy to type out "System.out.println" every console log thing
		System.out.println(content);
	}
	
	
}
