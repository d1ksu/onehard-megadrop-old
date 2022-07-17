package me.d1ksu.onehard.megadrop.data.configuration.transformer;

import eu.okaeri.configs.schema.GenericsPair;
import eu.okaeri.configs.serdes.BidirectionalTransformer;
import eu.okaeri.configs.serdes.SerdesContext;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;

/**
 * @author d1ksu
 * @Date 17.07.2022
 */
public class StringToComponentTransformer extends BidirectionalTransformer<String, Component> {
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    public GenericsPair<String, Component> getPair() {
        return genericsPair(String.class, Component.class);
    }

    public Component leftToRight(@NotNull String data, @NotNull SerdesContext serdesContext) {
        return this.miniMessage.deserialize(data);
    }

    public String rightToLeft(@NotNull Component data, @NotNull SerdesContext serdesContext) {
        return (String)this.miniMessage.serialize(data);
    }
}
