package io.github.blocksnmore.chatplus;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Mutechat {
	public static boolean muted;
	static Main mainclass = new Main();
	public static void MuteChatCmd(CommandSender player, String silent) {
		if(player.hasPermission("chatplus.mutechat"))
		if(silent  != null) {
			if(muted) {
				muted = false;
				String message;
				message = mainclass.getConfig().getString("mutechat-mute");
				message.replace("%staff%", ""+player+"");
				message.replace("%prefix", mainclass.getConfig().getString("prefix"));
				Bukkit.broadcastMessage(message);
			}else {
				muted = true;
				String message;
				message = mainclass.getConfig().getString("mutechat-unmute");
				message.replace("%staff%", ""+player+"");
				message.replace("%prefix", mainclass.getConfig().getString("prefix"));
				Bukkit.broadcastMessage(message);
			}
		}else {
			if(muted) {
				muted = false;
				String message;
				message = mainclass.getConfig().getString("mutechat-mute-silent");
				message.replace("%prefix", mainclass.getConfig().getString("prefix"));
				Bukkit.broadcastMessage(message);
			}else {
				muted = true;
				String message;
				message = mainclass.getConfig().getString("mutechat-unmute-silent");
				message.replace("%prefix", mainclass.getConfig().getString("prefix"));
				Bukkit.broadcastMessage(message);
			}
		}
	}
}
