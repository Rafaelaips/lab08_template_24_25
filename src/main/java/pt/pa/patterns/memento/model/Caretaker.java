/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.pa.patterns.memento.model;

import java.util.*;

public class Caretaker {
    private Memento memento;
    private final Originator originator;

    public Caretaker(Originator originator) {

        this.originator = originator;
        this.memento = null;
    }

    public void saveState() {
        memento = originator.createMemento();
    }

    public void restoreState() {
        if (memento == null) {
            throw new NoMementoException("No saved state found to restore!");
        }
        originator.setMemento(memento);
    }
}




