package me.d1ksu.onehard.megadrop.helper;

import org.bukkit.ChatColor;


import java.util.ArrayList;
import java.util.List;

/**
 * @author d1ksu
 * @Date 15.07.2022
 */
public class ChatHelper {

    public static String fixColor(String text){
        return ChatColor.translateAlternateColorCodes('&', text.replace(">>", "»"));
    }

    public static List<String> fixColor(final List<String> messages) {
        List<String> list = new ArrayList<>();
        for (String message : messages) {
            list.add(fixColor(message));
        }
        return list;
    }


}
