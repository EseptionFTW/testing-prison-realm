package net.eseption.prisonrealm.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_PRISON_REALM = "key.category.prisonrealm.prisonrealm";
    public static final String KEY_OPEN_CLOSE_PRISON_REALM = "key.prisonrealm.open_close_prison_realm";

    public static final KeyMapping PRISON_REALM =
            new KeyMapping(KEY_OPEN_CLOSE_PRISON_REALM, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_P, KEY_CATEGORY_PRISON_REALM);
}
