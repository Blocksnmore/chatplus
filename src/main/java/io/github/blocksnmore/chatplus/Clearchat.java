package io.github.blocksnmore.chatplus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clearchat {
	static Main mainclass = Main.plugin;
	@SuppressWarnings("deprecation")
	public static void ClearChatCmd(CommandSender player, String[] silent) {
		if(player.hasPermission("chatplus.clearchat")) {
			if(silent.length == 0) {
				clearchatall(player);
			}else {
				if(silent[0].equalsIgnoreCase("-s")) {
					clearchatallsilent();
				}else {
					if(Bukkit.getPlayer(silent[1]) != null) { 
						String prefix = mainclass.getConfig().getString("prefix");
						player.sendMessage(prefix+" Coming soon!");
					}else {
						String noplayererror = mainclass.getConfig().getString("wrong-args");
						noplayererror.replace("%prefix%", mainclass.getConfig().getString("prefix"));
						player.sendMessage(noplayererror);
					}
				}
					
			}
		}else{
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', mainclass.getConfig().getString("no-perms")));
		}
	}
	
	
	
	private static void clearchatallsilent() {
		String clearedchat = mainclass.getConfig().getString("clearchat-cleared-silent");
		clearedchat.replace("%prefix%", mainclass.getConfig().getString("prefix"));
		for(Player person : Bukkit.getOnlinePlayers()) {
			if(mainclass.getConfig().getBoolean("clearchat-enable-bypass")) {
				if(!person.hasPermission("chatplus.clearchat.bypass")) {
					int i = 0;
					while(i < 200) {
						person.sendMessage(ChatColor.WHITE+" ");
						i++;
						if(i == 200) {
							person.sendMessage(ChatColor.translateAlternateColorCodes('&', clearedchat));
						}
					}
				}
			}else {
				int i = 0;
				while(i < 200) {
					person.sendMessage(ChatColor.WHITE+" ");
					i++;
					if(i == 200) {
						person.sendMessage(ChatColor.translateAlternateColorCodes('&', clearedchat));
					}
				}
			}
		}
	}
	
	private static void clearchatall(CommandSender staff) {
		String clearedchat = mainclass.getConfig().getString("clearchat-cleared");
		clearedchat.replace("%staff%", ""+staff+"");
		clearedchat.replace("%prefix%", mainclass.getConfig().getString("prefix"));
		
		for(Player person : Bukkit.getOnlinePlayers()) {
			if(mainclass.getConfig().getBoolean("clearchat-enable-bypass")) {
				if(!person.hasPermission("chatplus.clearchat.bypass")) {
					int i = 0;
					while(i < 200) {
						person.sendMessage(ChatColor.WHITE+" ");
						i++;
						if(i == 200) {
							person.sendMessage(ChatColor.translateAlternateColorCodes('&', clearedchat));
						}
					}
				}
			}else {
				int i = 0;
				while(i < 200) {
					person.sendMessage(ChatColor.WHITE+" ");
					i++;
					if(i == 200) {
						person.sendMessage(ChatColor.translateAlternateColorCodes('&', clearedchat));
					}
				}
			}
		}
	}
	
}
