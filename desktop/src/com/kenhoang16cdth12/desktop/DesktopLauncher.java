package com.kenhoang16cdth12.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.kenhoang16cdth12.CanyonBunnyMain;

public class DesktopLauncher {
	private static boolean rebuildAtlas = false;
	private static boolean drawDebugOutline = false;

	public static void main (String[] arg) {
		if (rebuildAtlas) {
			TexturePacker.Settings settings = new TexturePacker.Settings();
			settings.maxWidth = 2048;
			settings.maxHeight = 2048;
			settings.duplicatePadding = false;
			settings.debug = drawDebugOutline;
			//TexturePacker.process(settings, "desktop/assets-raw/images", "android/assets/images", "canyonbunny.pack");
			//TexturePacker.process(settings, "desktop/assets-raw/images-ui", "android/assets/images", "canyonbunny-ui.pack");
			TexturePacker.process(settings, "desktop/assets-raw/fgdev-images-ui", "android/assets/images", "ui");
		}
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new CanyonBunnyMain(), config);
	}
}
