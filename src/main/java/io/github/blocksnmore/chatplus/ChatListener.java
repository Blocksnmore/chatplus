package io.github.blocksnmore.chatplus;

import org.bukkit.configuration.file.FileConfiguration; // Bukkit imports
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import io.github.blocksnmore.chatplus.*; // File imports

@SuppressWarnings("unused")
public class ChatListener implements Listener{
	static Main mainclass = Main.plugin;
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		e.setCancelled(true);
		if(Mutechat.muted && !e.getPlayer().hasPermission("chatplus.mutechat.bypass") || !Mutechat.muted) {
			String error = mainclass.getConfig().getString("mutechat-currently-muted");
			error.replace("%prefix%", mainclass.getConfig().getString("prefix"));
			e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', error));
		}else {
			String message = e.getMessage();
			String formatting = ChatColor.translateAlternateColorCodes('&', mainclass.getConfig().getString("chat-formatting"));
			formatting.replace("%player%", ""+e.getPlayer()+"");
			if(mainclass.getConfig().getBoolean("chat-enable-colorcodes")) {
				if(mainclass.getConfig().getBoolean("chat-require-perm")) {
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
