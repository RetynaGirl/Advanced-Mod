package com.teknoserval.advancedmod.handler;

import com.teknoserval.advancedmod.client.settings.Keybindings;
import com.teknoserval.advancedmod.reference.Key;
import com.teknoserval.advancedmod.utility.LogHelper;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {

	private static Key getPressedKeybinding() {

		if (Keybindings.charge.isPressed()) {

			return Key.CHARGE;

		} else if (Keybindings.release.isPressed()) {

			return Key.RELEASE;

		} else {

			return Key.UNKNOWN;

		}

	}

	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {

		Key input = getPressedKeybinding();

		if (input != Key.UNKNOWN) {

			LogHelper.info(input);

		}

	}

}