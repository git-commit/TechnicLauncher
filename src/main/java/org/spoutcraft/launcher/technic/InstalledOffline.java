/*
 * This file is part of Technic Launcher.
 *
 * Copyright (c) 2013-2013, Technic <http://www.technicpack.net/>
 * Technic Launcher is licensed under the Spout License Version 1.
 *
 * Technic Launcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Technic Launcher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spoutcraft.launcher.technic;

import java.awt.Image;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;

import org.spoutcraft.launcher.technic.rest.Modpack;
import org.spoutcraft.launcher.technic.rest.info.OfflineInfo;
import org.spoutcraft.launcher.technic.rest.pack.FallbackModpack;

public class InstalledOffline extends InstalledPack {
	private final OfflineInfo info;

	public InstalledOffline(OfflineInfo info) throws IOException {
		super(info.getIcon(), info.getLogo(), new ImageIcon(info.getBackground().getScaledInstance(880, 520, Image.SCALE_SMOOTH)));
		this.info = info;
		init();
	}

	@Override
	public String getLogoURL() {
		return "";
	}

	@Override
	public String getName() {
		return info.getName();
	}

	@Override
	public String getDisplayName() {
		return info.getName();
	}

	@Override
	public String getRecommended() {
		return info.getVersion();
	}

	@Override
	public String getLatest() {
		return info.getVersion();
	}

	@Override
	public List<String> getBuilds() {
		String[] builds = {info.getVersion()};
		return Arrays.asList(builds);
	}

	@Override
	public Modpack getModpack() {
		return new FallbackModpack(info.getName(), info.getVersion());
	}

}