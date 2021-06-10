package pl.paweu.safes.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public final class ChatUtil {

    public static String fixColor(String text){
        if(text == null || text.isEmpty()) return "";
        return ChatColor.translateAlternateColorCodes('&', text
                .replace("%>", "\u00bb")
                .replace("%O", "\u25cf"));
    }

    public static List<String> fixColor(List<String> list) {
        if (list == null || list.isEmpty()) return new ArrayList<>();
        for(int i = 0; i < list.size(); i++) list.set(i, fixColor(list.get(i)));
        return list;
    }

    public static boolean sendMessage(CommandSender sender, String message){
        if(sender == null || message == null || message.isEmpty()) return false;
        sender.sendMessage(fixColor(message));
        return true;
    }

    public static boolean sendMessage(Player player, String message){
        if(player == null || message == null || message.isEmpty()) return false;
        player.sendMessage(fixColor(message));
        return true;
    }
}
