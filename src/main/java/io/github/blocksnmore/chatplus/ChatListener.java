package io.github.blocksnmore.chatplus;

import org.bukkit.configuration.file.FileConfiguration; // Bukkit imports
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import io.github.blocksnmore.chatplus.*; // File imports

@SuppressWarnings({ "unused"})
public class ChatListener implements Listener{
	private Main plugin;
	public ChatListener(Main plugin){
	this.plugin=plugin;
	}
	@EventHandler(priority=EventPriority.NORMAL)
	public void onChat(AsyncPlayerChatEvent e) {
		FileConfiguration mainclass = plugin.getConfig();
		e.setCancelled(true);
		String prefix = mainclass.getString("prefix");
		if(true/*Mutechat.muted && !e.getPlayer().hasPermission("chatplus.mutechat.bypass") || !Mutechat.muted*/) {
			String error;
			error = mainclass.getString("mutechat-currently-muted");
			error.replace("%prefix%", prefix);
			e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', error));
		}else {
			String message = e.getMessage();
			String formatting = ChatColor.translateAlternateColorCodes('&', mainclass.getString("chat-formatting"));
			formatting.replace("%player%", ""+e.getPlayer()+"");
			if(mainclass.getBoolean("chat-enable-colorcodes")) {
				if(mainclass.getBoolean("chat-require-perm")) {
					if(e.getPlayer().hasPermission("chatplus.colorchat")) {
						formatting.replace("%message%", ChatColor.translateAlternateColorCodes('&', message));
						chat(formatting);
					}else {
						formatting.replace("%message%", message);
						chat(formatting);
					}
				}else {
					formatting.replace("%message%", ChatColor.translateAlternateColorCodes('&', message));
					chat(formatting);
				}
			}else {
				formatting.replace("%message%", message);
				chat(formatting);
			}
		}
	}
	
	
	
	
	private static void chat(String msg) {
		Bukkit.broadcastMessage(msg);
	}
}
