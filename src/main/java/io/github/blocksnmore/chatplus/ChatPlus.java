package io.github.blocksnmore.chatplus;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import io.github.blocksnmore.chatplus.*;

@SuppressWarnings("unused")
public class ChatPlus {
	static Main mainclass = Main.plugin;
	public static void ChatPlusCmd(CommandSender player, String[] args) {
		if(args.length == 0) {
			String message = "%prefix% &fChat&cPlus&f by &bBlocks_n_more";
			message.replace("%prefix%", mainclass.getConfig().getString("prefix"));
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
		}else {
			switch(args[0].toLowerCase()) {
			case "mutechat": case "chatmute": case "mc":
				Mutechat.MuteChatCmd(player, args[1].toLowerCase());
				break;
			
		case "clearchat": case "chatclear": case "cc":
			Clearchat.ClearChatCmd(player, args);
			break;
		
		}
	}
}}
