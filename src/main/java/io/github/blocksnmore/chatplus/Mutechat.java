package io.github.blocksnmore.chatplus;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class Mutechat {
	public static boolean muted;
	static FileConfiguration mainclass = Main.plugin.getConfig();
	public static void MuteChatCmd(CommandSender player, String silent) {
		if(player.hasPermission("chatplus.mutechat"))
		if(silent == "") {
			if(muted) {
				muted = false;
				String message;
				message = mainclass.getString("mutechat-mute-silent");
				message.replace("%prefix%", mainclass.getString("prefix"));
				Bukkit.broadcastMessage(message);
			}else {
				muted = true;
				String message;
				message = mainclass.getString("mutechat-unmute-silent");
				message.replace("%prefix%", mainclass.getString("prefix"));
				Bukkit.broadcastMessage(message);
			}
		}else {
			
			if(muted) {
				muted = false;
				String message;
				message = mainclass.getString("mutechat-mute");
				message.replace("%staff%", ""+player+"");
				message.replace("%prefix%", mainclass.getString("prefix"));
				Bukkit.broadcastMessage(message);
			}else {
				muted = true;
				String message;
				message = mainclass.getString("mutechat-unmute");
				message.replace("%staff%", ""+player+"");
				message.replace("%prefix%", mainclass.getString("prefix"));
				Bukkit.broadcastMessage(message);
			}
			
		}
	}
}
