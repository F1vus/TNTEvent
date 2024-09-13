package net.fiv.tnteventborukva;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fiv.tnteventborukva.event.TNTEvent;

public class Tnteventborukva implements ModInitializer {

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register(new TNTEvent());
    }
}
