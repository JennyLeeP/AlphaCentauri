package com.cyborgJenn.alphaCentauri.module.dimension.command;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.google.common.collect.Lists;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class TeleportCommand extends CommandBase{

	public TeleportCommand(){
        aliases = Lists.newArrayList(Reference.MODID, "TP", "tp");
    }

    private final List<String> aliases;

    @Override
    @Nonnull
    public String getCommandName() {
        return "tpd";
    }

    @Override
    @Nonnull
    public String getCommandUsage(@Nonnull ICommandSender sender) {
        return "tpd <id>";
    }

    @Override
    @Nonnull
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args) throws CommandException {
        if (args.length < 1) {
            return;
        }
        String s = args[0];
        int dim;
        try {
            dim = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            sender.addChatMessage(new TextComponentString(TextFormatting.RED + "Error parsing dimension!"));
            return;
        }

        if (sender instanceof EntityPlayer) {
        	//TODO send to current player coords, in new dim. Maybe check ground height there.
            CustomTeleporter.teleportToDimension((EntityPlayer) sender, dim, 0, 100, 0);
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    @Nonnull
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return Collections.emptyList();
    }
}
