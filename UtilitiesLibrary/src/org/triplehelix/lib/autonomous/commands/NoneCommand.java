/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.triplehelix.lib.autonomous.commands;

/**
 * A command that does nothing and displays "NONE" as the command name
 * @author robotics
 */
public class NoneCommand extends SelectableCommand {

    /**
     * 
     * @return "NONE"
     */
    public String getName() {
        return "NONE";
    }
}
